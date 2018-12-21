package ru.interfaceukc.javaee.helloejb.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.interfaceukc.javaee.helloejb.model.entities.Customer;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-19T12:28:22")
@StaticMetamodel(MicroMarket.class)
public class MicroMarket_ { 

    public static volatile SingularAttribute<MicroMarket, Double> areaLength;
    public static volatile SingularAttribute<MicroMarket, String> zipCode;
    public static volatile SingularAttribute<MicroMarket, Double> areaWidth;
    public static volatile ListAttribute<MicroMarket, Customer> customerList;
    public static volatile SingularAttribute<MicroMarket, Double> radius;

}