package ru.interfaceukc.javaee.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.interfaceukc.javaee.model.Customer;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-21T16:27:42")
@StaticMetamodel(MicroMarket.class)
public class MicroMarket_ { 

    public static volatile SingularAttribute<MicroMarket, Double> areaLength;
    public static volatile SingularAttribute<MicroMarket, String> zipCode;
    public static volatile SingularAttribute<MicroMarket, Double> areaWidth;
    public static volatile CollectionAttribute<MicroMarket, Customer> customerCollection;
    public static volatile SingularAttribute<MicroMarket, Double> radius;

}