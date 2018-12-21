/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.helloejb.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ru.interfaceukc.javaee.helloejb.model.CustomerPOJO;
import ru.interfaceukc.javaee.helloejb.model.entities.Customer;

/**
 *
 * @author Администратор
 */
@Stateless
//@LocalBean
@Remote(CustomerControllerRemote.class)
@WebService(endpointInterface = "ru.interfaceukc.javaee.helloejb.controller.CustomerWebService")
@Path("/customer")
@TransactionManagement(TransactionManagementType.BEAN)
public class CustomerController implements CustomerControllerRemote, CustomerWebService {

    private static final Logger LOG = Logger.getLogger(CustomerController.class.getName());
    
//    @Resource(name = "java:comp/jdbc/sample")
    @Resource(lookup = "jdbc/sample")
    DataSource dataSource;
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Override
    public CustomerPOJO findById(@PathParam("id") int id) {
        CustomerPOJO result = null;
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM customer WHERE customer_id = ?");
            ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    result = createCustomerFromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    @Override
    public List<CustomerPOJO> findByDiscountCode(String discountCode) {
        List<CustomerPOJO> list = new ArrayList<>();

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM customer WHERE discount_code = ?");
            ) {
            pstmt.setString(1, discountCode);
            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    list.add(createCustomerFromResultSet(rs));
                }
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

    @PersistenceContext(unitName = "HelloEJBPU")
    EntityManager em;
    
    @Override
    public List<Customer> findByZipCode(String zipCode) {
        Query query = em.createQuery("SELECT c FROM Customer c WHERE c.zip.zipCode = :zipCode");
        query.setParameter("zipCode", zipCode);
        return query.getResultList();
    }    
    
    private CustomerPOJO createCustomerFromResultSet(ResultSet rs) throws SQLException {
        CustomerPOJO result = new CustomerPOJO();
        
        result.setId(rs.getInt("customer_id"));
        result.setDiscountCode(rs.getString("discount_code"));
        result.setZip(rs.getString("zip"));
        result.setName(rs.getString("name"));
        result.setAddressline1(rs.getString("addressline1"));
        result.setAddressline2(rs.getString("addressline2"));
        result.setCity(rs.getString("city"));
        result.setState(rs.getString("state"));
        result.setPhone(rs.getString("phone"));
        result.setFax(rs.getString("fax"));
        result.setEmail(rs.getString("email"));
        result.setCreditLimit(rs.getInt("credit_limit"));
        
        return result;
    }
    
    @Resource
    UserTransaction transaction;
    
    public void insertCustomer(Customer customer) throws Exception {
        transaction.begin();
        em.persist(customer);
        transaction.commit();
    }
    
    @PostConstruct
    public void afterCreate() {
        System.out.println("CustomerBean created");
    }

    @PreDestroy
    public void beforeDestroy() {
        System.out.println("CustomerBean destroyed");
    }
}
