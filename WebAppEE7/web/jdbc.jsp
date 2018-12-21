<%-- 
    Document   : jdbc
    Created on : Dec 17, 2018, 2:58:32 PM
    Author     : Администратор
--%>

<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
        private DataSource dataSource;

    public void jspInit() {
        System.out.println("@@@@ jdbc.jspinit()");

        try {
            dataSource = (DataSource)new InitialContext().lookup("jdbc/sample");
        } catch (NamingException ex) {
            System.out.println("jdbc.Jspinit() Error: " + ex.getMessage());
        }
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Table</title>
    </head>
    <body>
        <h1>Customer</h1>
<%  String sql = "SELECT * FROM customer";
    String discountCode = request.getParameter("discount");
    if (discountCode != null) {
        sql += " WHERE discount_code = '" + discountCode + "'";
    }
    Connection connection = dataSource.getConnection();
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    ResultSetMetaData metaData = rs.getMetaData();
%>
        <table border="1">
            <tr>
<% for (int i = 1; i <= metaData.getColumnCount(); i++) {%>
                <th><%= metaData.getColumnName(i)%></th>
<%}%>
            </tr>
<% while (rs.next()) {%>
            <tr>
<% for (int i = 1; i <= metaData.getColumnCount(); i++) {%>
                <td><%= rs.getString(i)%></td>
<%}%>
            </tr>
<%}%>
        </table>
<%
    rs.close();
    stmt.close();
    connection.close();
%>
    </body>
</html>
