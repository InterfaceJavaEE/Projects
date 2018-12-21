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
import javax.jms.TextMessage;

/**
 *
 * @author Администратор
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/MyTopicSms")
    , @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/MyTopic")
    , @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    , @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/MyTopic")
    , @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class SendSmsBean implements MessageListener {
    
    public SendSmsBean() {
        System.out.println("SendSmsBean created");
    }
    
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage tm = (TextMessage)message;
            try {
                String text = tm.getText();
                System.out.println("SendSmsBean Received text message: " + text);
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @PreDestroy
    public void remove() {
        System.out.println("SendSmsBean destroyed");
    }
    
}
