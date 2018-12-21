/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.helloejb.ejb3;

/**
 * This is the Hello business interface.
 * 
 * @author Администратор
 */
public interface HelloLocal {
    /**
     * The one method - hello - returns a greeting to the client.
     * @return hello string
     */
    String hello();
}
