
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.client.ejb3;

import javax.naming.Context;
import javax.naming.InitialContext;
import ru.interfaceukc.javaee.helloejb.ejb3.Hello;

/**
 * This class is an example of client code which invokes
 * methods on a simple, remote stateless session bean.
 * 
 * @author Администратор
 */
public class HelloClient {
    
    public static void main(String[] args) throws Exception {
        /*
         * Obtain the JNDI initial context.
         *
         * The initial context is a starting point for
         * connecting to a JNDI tree.
         */
        Context ctx = new InitialContext();
        
        Hello hello = (Hello)ctx.lookup(Hello.class.getName());
        
        /*
         * Call the hello() method on the bean.
         * We then print the result to the screen.
         */
        System.out.println(hello.hello());
    }
}
