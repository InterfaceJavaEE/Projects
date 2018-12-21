/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.client.ejb3;

import java.util.Date;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Администратор
 */
public class ProducerJMS {

    public static void main(String[] args) {
        try {
            // Gets the JNDI context
            Context jndiContext = new InitialContext();
            // Looks up the administered objects
            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("java:comp/DefaultJMSConnectionFactory");
            Destination queue = (Destination) jndiContext.lookup("jms/MyQueue");
            // Creates the needed artifacts to connect to the queue
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);
            // Sends a text message to the queue
            TextMessage message = session.createTextMessage("Text message sent at " + new Date());
            message.setStringProperty("type", "handler");
            producer.send(message);
            connection.close();
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }
}
