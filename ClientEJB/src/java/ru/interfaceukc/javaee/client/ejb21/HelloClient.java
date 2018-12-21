/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.client.ejb21;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import ru.interfaceukc.javaee.helloejb.ejb21.HelloRemote;
import ru.interfaceukc.javaee.helloejb.ejb21.HelloRemoteHome;

/**
 * This class is an example of client code that invokes
 * methods on a simple stateless session bean.
 * 
 * @author Администратор
 */
public class HelloClient {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        /*
         * Setup properties for JNDI initialization.
         *
         * These properties will be read in from
         * the command line.
         */
        Properties props = System.getProperties();

        /*
         * Obtain the JNDI initial context.
         *
         * The initial context is a starting point for
         * connecting to a JNDI tree. We choose our JNDI
         * driver, the network location of the server, etc.
         * by passing in the environment properties.
         */
        Context ctx = new InitialContext(props);
        
        /*
         * Get a reference to the home object - the
         * factory for Hello EJB Objects
         */
//        Object obj = ctx.lookup("ru.interfaceukc.javaee.helloejb.ejb21.HelloRemoteHome");
        Object obj = ctx.lookup(HelloRemoteHome.class.getName());
        
        /*
         * Home objects are RMI-IIOP objects, and so
         * they must be cast into RMI-IIOP objects
         * using a special RMI-IIOP cast.
         *
         * See Appendix A for more details on this.
         */
        HelloRemoteHome home = (HelloRemoteHome)PortableRemoteObject.narrow(obj, HelloRemoteHome.class);
        
        /*
         * Use the factory to create the Hello EJB Object
         */
        HelloRemote hello = home.create();

        /*
         * Call the hello() method on the EJB object. The
         * EJB object will delegate the call to the bean,
         * receive the result, and return it to us.
         *
         * We then print the result to the screen.
         */
        System.out.println(hello.hello());

        /*
         * Done with EJB Object, so remove it.
         * The container will destroy the EJB object.
         */
        hello.remove();
    }
    
}
