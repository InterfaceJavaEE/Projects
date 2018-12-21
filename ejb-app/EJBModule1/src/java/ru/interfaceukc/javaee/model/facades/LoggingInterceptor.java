/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.model.facades;

import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Администратор
 */
public class LoggingInterceptor {

    private static final Logger LOG = Logger.getLogger(LoggingInterceptor.class.getName());
    
    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        LOG.entering(ic.getTarget().toString(), ic.getMethod().toString());
        System.out.println("entering " + ic.getTarget() + "." + ic.getMethod());
        try {
            return ic.proceed();
        } finally {
            LOG.exiting(ic.getTarget().toString(), ic.getMethod().toString());
            System.out.println("exiting " + "entering " + ic.getTarget() + "." + ic.getMethod());
        }
    }
    
}
