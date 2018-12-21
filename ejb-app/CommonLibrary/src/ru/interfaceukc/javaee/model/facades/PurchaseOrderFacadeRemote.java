/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.model.facades;

import java.util.List;
import javax.ejb.Remote;
import ru.interfaceukc.javaee.model.entities.PurchaseOrder;

/**
 *
 * @author Администратор
 */
@Remote
public interface PurchaseOrderFacadeRemote {

    void create(PurchaseOrder purchaseOrder);

    void edit(PurchaseOrder purchaseOrder);

    void remove(PurchaseOrder purchaseOrder);

    PurchaseOrder find(Object id);

    List<PurchaseOrder> findAll();

    List<PurchaseOrder> findRange(int[] range);

    int count();
    
}
