/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.helloejb.ejb3;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Stateless session bean.
 * 
 * @author Администратор
 */
@Stateless
@Remote(Hello.class)
@Local(HelloLocal.class)
public class HelloBean implements Hello, HelloLocal {

    @Override
    public String hello() {
        System.out.println("@@@HelloBean3.hello()");
        return "Hello from EJB3!";
    }
    
}
