/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.beans;

import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Администратор
 */
public class MyBean {

//    @Resource(lookup = "jdbc/sample")
    private DataSource dataSource;

    public MyBean() {
        System.out.println("@@@@ jdbc.jspinit()");

        try {
            dataSource = (DataSource)new InitialContext().lookup("jdbc/mydb");
        } catch (NamingException ex) {
            System.out.println("jdbc.Jspinit() Error: " + ex.getMessage());
        }
    }
    
    private String discountCode;

    /**
     * Get the value of discountCode
     *
     * @return the value of discountCode
     */
    public String getDiscountCode() {
        return discountCode;
    }

    /**
     * Set the value of discountCode
     *
     * @param discountCode new value of discountCode
     */
    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();

        String sql = "SELECT * FROM customer" + 
                        (discountCode == null ? "" : " WHERE discount_code = '" + discountCode + "'");
        try (
                Connection connection = dataSource.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
            ) {
            sb.append("<table border='1'>\n");
            // header
            ResultSetMetaData metaData = rs.getMetaData();
            sb.append("<tr>");
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                sb.append("<th>")
                    .append(metaData.getColumnName(i))
                    .append("</th>");
            }
            sb.append("</tr>\n");
            // data
            while (rs.next()) {
                sb.append("<tr>");
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    sb.append("<td>").append(rs.getString(i)).append("</td>");
                }
                sb.append("</tr>\n");
            }
            sb.append("</table>\n");
        } catch (SQLException ex) {
            sb.append("Error: ").append(ex.getMessage());
        }
        return sb.toString();
    }
    
}
