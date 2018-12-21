/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.client.ejb3;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Администратор
 */
public class ConsumerJMS {

    public static void main(String[] args) {
        try {
            // Gets the JNDI context
            Context jndiContext = new InitialContext(); // Looks up the administered objects
            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("java:comp/DefaultJMSConnectionFactory");
            Destination queue = (Destination) jndiContext.lookup("jms/MyQueue");
            // Creates the needed artifacts to connect to the queue
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(queue);
            connection.start();
            // Loops to receive the messages
            while (true) {
                TextMessage message = (TextMessage) consumer.receive();
                System.out.println("Message received: " + message.getText());
            }
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }
}
