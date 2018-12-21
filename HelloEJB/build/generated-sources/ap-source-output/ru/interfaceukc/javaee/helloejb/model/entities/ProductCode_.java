package ru.interfaceukc.javaee.helloejb.model.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.interfaceukc.javaee.helloejb.model.entities.Product;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-19T12:28:22")
@StaticMetamodel(ProductCode.class)
public class ProductCode_ { 

    public static volatile SingularAttribute<ProductCode, String> prodCode;
    public static volatile SingularAttribute<ProductCode, Character> discountCode;
    public static volatile SingularAttribute<ProductCode, String> description;
    public static volatile ListAttribute<ProductCode, Product> productList;

}