/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.model.facades;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Администратор
 */
public class CallbackInterceptor {

    private static final Logger LOG = Logger.getLogger(CallbackInterceptor.class.getName());
    
    @PostConstruct
    public void construct(InvocationContext ic) {
        System.out.println("construct " + ic.getTarget());
    }
    
    @PreDestroy
    public void destroy(InvocationContext ic) {
        System.out.println("destroy " + ic.getTarget() + "::" + ic.getMethod());
    }
    
    @PrePassivate
    public void passivate(InvocationContext ic) {
        System.out.println("passivate " + ic.getTarget() + "::" + ic.getMethod());
    }
    
    @PostActivate
    public void activate(InvocationContext ic) {
        System.out.println("activate " + ic.getTarget() + "::" + ic.getMethod());
    }
}
