package ru.interfaceukc.javaee.helloejb.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.interfaceukc.javaee.helloejb.model.entities.DiscountCode;
import ru.interfaceukc.javaee.helloejb.model.entities.MicroMarket;
import ru.interfaceukc.javaee.helloejb.model.entities.PurchaseOrder;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-19T12:28:22")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, MicroMarket> zip;
    public static volatile SingularAttribute<Customer, String> city;
    public static volatile SingularAttribute<Customer, DiscountCode> discountCode;
    public static volatile SingularAttribute<Customer, String> phone;
    public static volatile SingularAttribute<Customer, String> name;
    public static volatile SingularAttribute<Customer, String> addressline2;
    public static volatile SingularAttribute<Customer, Integer> creditLimit;
    public static volatile SingularAttribute<Customer, String> addressline1;
    public static volatile SingularAttribute<Customer, Integer> id;
    public static volatile SingularAttribute<Customer, String> state;
    public static volatile SingularAttribute<Customer, String> fax;
    public static volatile ListAttribute<Customer, PurchaseOrder> purchaseOrders;
    public static volatile SingularAttribute<Customer, String> email;

}