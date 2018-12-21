/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.ws;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import ru.interfaceukc.javaee.model.entities.Customer;
import ru.interfaceukc.javaee.model.facades.CustomerFacadeRemote;

/**
 *
 * @author Администратор
 */
@WebService(serviceName = "CustomerWebService")
@Stateless()
public class CustomerWebService {

    @EJB CustomerFacadeRemote facade;
    
    @WebMethod(operationName = "find", action = "find")
    public Customer find(@WebParam(name = "id") Integer id) {
        return facade.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Customer> findAll() {
        return facade.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Customer> findRange(
                        @WebParam(name = "from")int from, 
                        @WebParam(name = "to")int to) {
        return facade.findRange(new int[] {from, to});
    }

    @WebMethod(operationName = "count")
    public int count() {
        return facade.count();
    }
}
