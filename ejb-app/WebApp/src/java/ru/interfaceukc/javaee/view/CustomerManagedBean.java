/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.view;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import ru.interfaceukc.javaee.model.entities.Customer;
import ru.interfaceukc.javaee.model.facades.CustomerFacadeRemote;

/**
 *
 * @author Администратор
 */
@Named(value = "customer")
@SessionScoped
public class CustomerManagedBean implements Serializable {
    
    @EJB 
    private CustomerFacadeRemote facade;
    
    public List<Customer> getCustomers() {
        return facade.findAll();
    }
    
}
