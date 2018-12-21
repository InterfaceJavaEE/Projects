<%-- 
    Document   : jdbc2
    Created on : Dec 17, 2018, 5:08:02 PM
    Author     : Администратор
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="mb" class="ru.interfaceukc.javaee.beans.MyBean"/>
<jsp:setProperty name="mb" property="discountCode" param="discount"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JDBC Test MyBean</title>
    </head>
    <body>
        <h1>Customer</h1>
        <jsp:getProperty name="mb" property="result" />
    </body>
</html>
