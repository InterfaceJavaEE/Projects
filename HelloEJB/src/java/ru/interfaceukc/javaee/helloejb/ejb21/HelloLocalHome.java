/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.helloejb.ejb21;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 * This is the local home interface for HelloBean.
 * This interface is implemented by the EJB Server’s
 * tools - the implemented object is called the
 * local home object, and serves as a factory for
 * EJB local objects.
 *
 * @author Администратор
 */
public interface HelloLocalHome extends EJBLocalHome {
    /**
     * This method creates the EJB Object.
     *
     * @return The newly created EJB Object.
     * @throws javax.ejb.CreateException
     */
    HelloLocal create() throws CreateException;
}
