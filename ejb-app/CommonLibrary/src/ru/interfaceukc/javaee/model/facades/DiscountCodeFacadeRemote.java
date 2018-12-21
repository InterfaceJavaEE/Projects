/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.model.facades;

import java.util.List;
import javax.ejb.Remote;
import ru.interfaceukc.javaee.model.entities.DiscountCode;

/**
 *
 * @author Администратор
 */
@Remote
public interface DiscountCodeFacadeRemote {

    void create(DiscountCode discountCode);

    void edit(DiscountCode discountCode);

    void remove(DiscountCode discountCode);

    DiscountCode find(Object id);

    List<DiscountCode> findAll();

    List<DiscountCode> findRange(int[] range);

    int count();
    
}
