/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.helloejb.ejb21;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 * This is the home interface for HelloBean. This interface
 * is implemented by the EJB Server’s tools - the
 * implemented object is called the Home Object, and serves
 * as a factory for EJB Objects.
 *
 * One create() method is in this Home Interface, which
 * corresponds to the ejbCreate() method in HelloBean.
 *
 * @author Администратор
 */
public interface HelloRemoteHome extends EJBHome {

    /**
     * This method creates the EJB Object.
     *
     * @return The newly created EJB Object.
     * @throws java.rmi.RemoteException
     * @throws javax.ejb.CreateException
     */    
    HelloRemote create() throws RemoteException, CreateException;
}
