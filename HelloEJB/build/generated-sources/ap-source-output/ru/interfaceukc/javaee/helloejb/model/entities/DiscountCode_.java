package ru.interfaceukc.javaee.helloejb.model.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.interfaceukc.javaee.helloejb.model.entities.Customer;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-19T12:28:22")
@StaticMetamodel(DiscountCode.class)
public class DiscountCode_ { 

    public static volatile SingularAttribute<DiscountCode, String> discountCode;
    public static volatile SingularAttribute<DiscountCode, BigDecimal> rate;
    public static volatile ListAttribute<DiscountCode, Customer> customers;

}