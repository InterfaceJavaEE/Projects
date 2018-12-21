/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.model.facades;

import javax.ejb.Stateless;

/**
 *
 * @author Администратор
 */
@Stateless
public class NewClass {
    public void sayHello(String message) {
        System.out.println("Hello! " + message);
    }
}
