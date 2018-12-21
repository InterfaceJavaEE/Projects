/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.helloejb.model.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 *
 * @author Администратор
 */
public class CustomerListener {
    
    @PrePersist
    public void beforeInsert(Customer customer) {
        System.out.println("Customer.beforeInsert()");
    }

    @PostPersist
    public void afterInsert(Customer customer) {
        System.out.println("Customer.afterInsert()");
    }

    @PreUpdate
    public void beforeUpdate(Customer customer) {
        System.out.println("Customer.beforeUpdate()");
    }

    @PostUpdate
    public void afterUpdate(Customer customer) {
        System.out.println("Customer.afterUpdate()");
    }

    @PreRemove
    public void beforeRemove(Customer customer) {
        System.out.println("Customer.beforeRemove()");
    }

    @PostRemove
    public void afterRemove(Customer customer) {
        System.out.println("Customer.beforeRemove()");
    }

    @PostLoad
    public void afterLoad(Customer customer) {
        System.out.println("Customer.afterLoad()");
    }
}
