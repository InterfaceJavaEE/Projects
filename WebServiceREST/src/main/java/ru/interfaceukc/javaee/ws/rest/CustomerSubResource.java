/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.ws.rest;

import java.util.Collection;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ru.interfaceukc.javaee.model.Customer;
import ru.interfaceukc.javaee.model.DiscountCode;

/**
 *
 * @author Администратор
 */
public class CustomerSubResource {

//    @PersistenceContext(unitName = "SimplePU")
    private final EntityManager em;
    
    private final DiscountCode discountCode;

    public CustomerSubResource(DiscountCode discountCode, EntityManager em) {
        this.discountCode = discountCode;
        this.em = em;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Customer> findAll() {
        return discountCode.getCustomerCollection();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Customer findById(@PathParam("id") Integer id) {
        for (Customer customer : discountCode.getCustomerCollection()) {
            if (customer.getCustomerId().equals(id)) {
                return customer;
            }
        }
        return null;
    }
    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String count() {
        return String.valueOf(discountCode.getCustomerCollection().size());
    }
    
}
