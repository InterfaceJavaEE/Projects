/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.model.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ru.interfaceukc.javaee.model.entities.DiscountCode;

/**
 *
 * @author Администратор
 */
@Stateless
public class DiscountCodeFacade extends AbstractFacade<DiscountCode> implements DiscountCodeFacadeLocal, DiscountCodeFacadeRemote {

    @PersistenceContext(unitName = "EJBModule1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiscountCodeFacade() {
        super(DiscountCode.class);
    }
    
}
