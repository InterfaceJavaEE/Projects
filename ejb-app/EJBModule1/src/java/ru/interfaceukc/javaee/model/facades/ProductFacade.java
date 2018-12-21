/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.model.facades;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ru.interfaceukc.javaee.model.entities.Product;

/**
 *
 * @author Администратор
 */
@Stateless
@Interceptors(LoggingInterceptor.class)
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal, ru.interfaceukc.javaee.model.facades.ProductFacadeRemote {

    @PersistenceContext(unitName = "EJBModule1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
}
