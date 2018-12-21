<%-- 
    Document   : HelloJSP
    Created on : Dec 17, 2018, 12:31:10 PM
    Author     : Администратор
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%! private final String str = "Hello JSP"; %>

<% HttpSession session2 = request.getSession(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        currentDate = <%= new Date()%><br/>
        session.lastDate = <%= session2.getAttribute("lastDate") %>
        
<% for (int i = 0; i < 5; i++) { %>
        <br/>i = <%=i%>
<%}%>
        
    </body>
</html>
<% session.setAttribute("lastDate", new Date()); %>
