/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Администратор
 */
public class DateXmlAdapter extends XmlAdapter<String, Date> {

    public Date unmarshal(String v) throws Exception {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(v);
    }

    public String marshal(Date v) throws Exception {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(v);
    }
}
