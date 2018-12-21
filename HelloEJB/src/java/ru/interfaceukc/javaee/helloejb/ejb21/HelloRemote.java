/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.helloejb.ejb21;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

/**
 * This is the HelloBean remote interface.
 *
 * This interface is what clients operate on when
 * they interact with EJB objects. The container
 * vendor will implement this interface; the
 * implemented object is the EJB object, which
 * delegates invocations to the actual bean. 
 *
 * @author Администратор
 */
public interface HelloRemote extends EJBObject {
    /**
     * The one method - hello - returns a greeting to a client
     * @return hello string
     * @throws java.rmi.RemoteException
     */
    String hello() throws RemoteException;
}
