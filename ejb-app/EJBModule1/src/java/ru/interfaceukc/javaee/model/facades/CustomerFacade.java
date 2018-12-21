/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.model.facades;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Remove;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ru.interfaceukc.javaee.model.entities.Customer;

/**
 *
 * @author Администратор
 */
@Stateless
@Interceptors({LoggingInterceptor.class, CallbackInterceptor.class})
//@TransactionManagement(TransactionManagementType.BEAN)
//@DeclareRoles({"Admin", "Customer", "Staff"})
@WebService
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal, ru.interfaceukc.javaee.model.facades.CustomerFacadeRemote {

    @Resource(mappedName = "jms/MyTopic")
    private Topic myTopic;

    @Resource(mappedName = "jms/MyQueue")
    private Queue myQueue;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext jmsContext;

    @PersistenceContext(unitName = "EJBModule1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Resource
    SessionContext ctx;
    
    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    public List<Customer> findAll() {
        System.out.println("User: " + ctx.getCallerPrincipal().getName());
        if (ctx.isCallerInRole("Admin")) {
            System.out.println("I'm Administrator");
        }

        sendJMSMessageToMyTopic("JMS Topic: Customer::findAll");
        for (int i = 0; i < 10; i++) {
            sendJMSMessageToMyQueue("JMS Queue Text: Customer::findAll " + i);
            sendJMSMessageToMyQueue(i);
        }
        nc.sayHello("Java EE 7");
        return super.findAll();
    }
    
    @Remove
    @WebMethod(exclude = true)
    public void removeCallback() {
        System.out.println("CustomerFacade::remove");
    }

    private void sendJMSMessageToMyTopic(String messageData) {
        jmsContext.createProducer().send(myTopic, messageData);
    }

    private void sendJMSMessageToMyQueue(String messageData) {
        try {
            Message message = jmsContext.createTextMessage(messageData);
            message.setStringProperty("type", "type1");
            jmsContext.createProducer().send(myQueue, message);
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

    private void sendJMSMessageToMyQueue(Serializable msg) {
        try {
            Message message = jmsContext.createObjectMessage(msg);
            message.setStringProperty("type", "type2");
            jmsContext.createProducer().send(myQueue, message);
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

    // CDI
    @Inject
    private NewClass nc;
    
//    @Resource
//    UserTransaction userTx;
//    
//    public void dddd() {
//        userTx.begin();
//        
//    }
}
