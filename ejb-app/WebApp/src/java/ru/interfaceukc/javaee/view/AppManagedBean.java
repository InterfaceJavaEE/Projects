/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Администратор
 */
@Named("app")
@ApplicationScoped
public class AppManagedBean {
    private final String VERSION = "1.0.0";
    private final String START_DATE = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
    
    public String getVersion() {
        return VERSION;
    }
    
    public String getStartDate() {
        return START_DATE;
    }
}
