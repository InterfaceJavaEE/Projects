/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.model.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ru.interfaceukc.javaee.model.entities.PurchaseOrder;

/**
 *
 * @author Администратор
 */
@Stateless
public class PurchaseOrderFacade extends AbstractFacade<PurchaseOrder> implements PurchaseOrderFacadeLocal, ru.interfaceukc.javaee.model.facades.PurchaseOrderFacadeRemote {

    @PersistenceContext(unitName = "EJBModule1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PurchaseOrderFacade() {
        super(PurchaseOrder.class);
    }
    
}
