/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.helloejb.controller;

import java.util.List;
import ru.interfaceukc.javaee.helloejb.model.CustomerPOJO;
import ru.interfaceukc.javaee.helloejb.model.entities.Customer;

/**
 *
 * @author Администратор
 */
public interface CustomerControllerRemote {
   
    CustomerPOJO findById(int id);

    List<CustomerPOJO> findByDiscountCode(String discountCode);
    
    List<Customer> findByZipCode(String zipCode);
}
