/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.jms;

import javax.annotation.PreDestroy;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 *
 * @author Администратор
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/MyQueue")
    , @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
    , @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "type= 'type2'")
})
public class HandlerQueueBean implements MessageListener {
    
    public HandlerQueueBean() {
        System.out.println("HandlerQueueBean created");
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage tm = (TextMessage)message;
                String text = tm.getText();
                System.out.println("HandlerQueueBean Received text message: " + text + ", type: " + tm.getStringProperty("type"));
            } else if (message instanceof ObjectMessage) {
                ObjectMessage tm = (ObjectMessage)message;
                System.out.println("HandlerQueueBean Received object message: " + tm.getObject() + ", type: " + tm.getStringProperty("type"));
            }
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
    
    @PreDestroy
    public void remove() {
        System.out.println("HandlerQueueBean destroyed");
    }
}
