/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.helloejb.model.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

/**
 *
 * @author Администратор
 */
@Embeddable
public class Address implements Serializable {
    @Size(max = 30)
    @Column(name = "ADDRESSLINE1", length = 30)
    private String addressline1;
    
    @Size(max = 30)
    @Column(name = "ADDRESSLINE2", length = 30)
    private String addressline2;
    
    @Size(max = 25)
    @Column(name = "CITY", length = 25)
    private String city;
    
    @Size(max = 2)
    @Column(name = "STATE", length = 2)
    private String state;

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.addressline1);
        hash = 37 * hash + Objects.hashCode(this.addressline2);
        hash = 37 * hash + Objects.hashCode(this.city);
        hash = 37 * hash + Objects.hashCode(this.state);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (!Objects.equals(this.addressline1, other.addressline1)) {
            return false;
        }
        if (!Objects.equals(this.addressline2, other.addressline2)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Address{" + "addressline1=" + addressline1 + ", addressline2=" + addressline2 + ", city=" + city + ", state=" + state + '}';
    }
    
    
}
