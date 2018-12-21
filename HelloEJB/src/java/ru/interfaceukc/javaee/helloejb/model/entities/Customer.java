/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.helloejb.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.id = :id")
    , @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name")
    , @NamedQuery(name = "Customer.findByAddressline1", query = "SELECT c FROM Customer c WHERE c.address.addressline1 = :addressline1")
    , @NamedQuery(name = "Customer.findByAddressline2", query = "SELECT c FROM Customer c WHERE c.address.addressline2 = :addressline2")
    , @NamedQuery(name = "Customer.findByCity", query = "SELECT c FROM Customer c WHERE c.address.city = :city")
    , @NamedQuery(name = "Customer.findByState", query = "SELECT c FROM Customer c WHERE c.address.state = :state")
    , @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.contactInfo.phone = :phone")
    , @NamedQuery(name = "Customer.findByFax", query = "SELECT c FROM Customer c WHERE c.contactInfo.fax = :fax")
    , @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.contactInfo.email = :email")
    , @NamedQuery(name = "Customer.findByCreditLimit", query = "SELECT c FROM Customer c WHERE c.creditLimit = :creditLimit")})
@EntityListeners(CustomerListener.class)
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    // FIELDS
    
    @Id
//    @SequenceGenerator(name = "seq_name")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMER_ID", nullable = false)
    private Integer id;
    
    @Size(max = 30)
    @Column(name = "NAME", length = 30)
    private String name;
    
    @Embedded
    private Address address;
    
    @Embedded
    private ContactInfo contactInfo;
    
    @Column(name = "CREDIT_LIMIT")
    private Integer creditLimit;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private List<PurchaseOrder> purchaseOrders;
    
    @JoinColumn(name = "DISCOUNT_CODE", referencedColumnName = "DISCOUNT_CODE", nullable = false)
    @ManyToOne(optional = false)
    private DiscountCode discountCode;

    @JoinColumn(name = "ZIP", referencedColumnName = "ZIP_CODE", nullable = false)
    @ManyToOne(optional = false)
    private MicroMarket zip;

    // CONSTRUCTORS
    
    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }
    
    // GETTERS & SETTERS 
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
    
    
    
    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    @XmlTransient
    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    public DiscountCode getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(DiscountCode discountCode) {
        this.discountCode = discountCode;
    }

    public MicroMarket getZip() {
        return zip;
    }

    public void setZip(MicroMarket zip) {
        this.zip = zip;
    }

    // EQUALS & HASH_CODE
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    // TO_STRING

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", address=" + address + ", contactInfo=" + contactInfo + ", creditLimit=" + creditLimit + ", discountCode=" + discountCode.getDiscountCode() + ", zip=" + zip.getZipCode() + '}';
    }
}
