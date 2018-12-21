/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.helloejb.ejb21;

import java.rmi.RemoteException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
 * Demonstration stateless session bean.
 * 
 * @author Администратор
 */
public class HelloBean implements SessionBean {
    
    private SessionContext ctx;
    
    // Implements Interface SessionBean
    
    @Override
    public void setSessionContext(SessionContext ctx) throws EJBException, RemoteException {
        this.ctx = ctx;
    }

    @Override
    public void ejbRemove() throws EJBException, RemoteException {
        System.out.println("HelloBean.ejbRemove()");
    }

    @Override
    public void ejbActivate() throws EJBException, RemoteException {
        System.out.println("HelloBean.ejbActivate()");
    }

    @Override
    public void ejbPassivate() throws EJBException, RemoteException {
        System.out.println("HelloBean.ejbPassivate()");
    }

    // Business methods
    
//    @Override
    public String hello() {
        System.out.println("HelloBean.hello()");
        return "Hello, World!";
    }
}
