/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.helloejb.controller;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import ru.interfaceukc.javaee.helloejb.model.CustomerPOJO;

/**
 *
 * @author Администратор
 */
@WebService
public interface CustomerWebService {
    @WebMethod
    CustomerPOJO findById(@WebParam(name = "id") int id);
}
