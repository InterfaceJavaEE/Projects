/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Администратор
 */
@WebServlet(name = "JdbcServlet", urlPatterns = {"/jdbc"})
public class JdbcServlet extends HttpServlet {

    @Resource(lookup = "jdbc/sample")
    private DataSource dataSource;
    
//    private String jdbcDriver;
//    private String jdbcUrl;
//    private String jdbcUsername;
//    private String jdbcPassword;
//
//    @Override
//    public void init() throws ServletException {
//        super.init(); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("@@@ JdbcServlet.init()");
//
//        jdbcDriver = getInitParameter("jdbcDriver");//"org.apache.derby.jdbc.ClientDriver";
//        jdbcUrl    = getInitParameter("jdbcUrl"); //"jdbc:derby://localhost:1527/sample"; 
//        jdbcUsername = getInitParameter("jdbcUsername"); //"app";
//        jdbcPassword = getInitParameter("jdbcPassword"); //"app";
//    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        final String jdbcDriver = getInitParameter("jdbcDriver");//"org.apache.derby.jdbc.ClientDriver";
//        final String jdbcUrl    = getInitParameter("jdbcUrl"); //"jdbc:derby://localhost:1527/sample"; 
//        final String jdbcUsername = getInitParameter("jdbcUsername"); //"app";
//        final String jdbcPassword = getInitParameter("jdbcPassword"); //"app";
        
        // 1. load driver
//        try {
//            Class.forName(jdbcDriver);
//        } catch (ClassNotFoundException ex) {
//            throw new ServerException("JDBC Driver", ex);
//        }
        
        String discountCode = request.getParameter("discount");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JdbcServlet</title>");            
            out.println("</head>");
            out.println("<body>");
//            try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);) {
            try (Connection connection = dataSource.getConnection();) {
                try (Statement stmt = connection.createStatement();) {
                    try (ResultSet rs = stmt.executeQuery("SELECT * FROM customer" + 
                            (discountCode == null ? "" : " WHERE discount_code = '" + discountCode + "'"));) {
                        out.println("<table border='1'>");
                        // header
                        ResultSetMetaData metaData = rs.getMetaData();
                        out.print("<tr>");
                        for (int i = 1; i <= metaData.getColumnCount(); i++) {
                            out.print("<th>" + metaData.getColumnName(i) + "</th>");
                        }
                        out.println("</tr>");
                        // data
                        while (rs.next()) {
                            out.print("<tr>");
                            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                                out.print("<td>" + rs.getString(i) + "</td>");
                            }
                            out.println("</tr>");
                        }
                        out.println("</table>");
                    }
                }
            } catch (SQLException ex) {
               throw new ServerException("SQL Error", ex);
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
