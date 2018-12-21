package ru.interfaceukc.javaee.helloejb.model.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.interfaceukc.javaee.helloejb.model.entities.Manufacturer;
import ru.interfaceukc.javaee.helloejb.model.entities.ProductCode;
import ru.interfaceukc.javaee.helloejb.model.entities.PurchaseOrder;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-19T12:28:22")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, BigDecimal> purchaseCost;
    public static volatile SingularAttribute<Product, ProductCode> productCode;
    public static volatile SingularAttribute<Product, Integer> productId;
    public static volatile SingularAttribute<Product, BigDecimal> markup;
    public static volatile ListAttribute<Product, PurchaseOrder> purchaseOrderList;
    public static volatile SingularAttribute<Product, Integer> quantityOnHand;
    public static volatile SingularAttribute<Product, String> available;
    public static volatile SingularAttribute<Product, Manufacturer> manufacturerId;
    public static volatile SingularAttribute<Product, String> description;

}