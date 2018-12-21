/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.interfaceukc.javaee.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.interfaceukc.javaee.helloejb.controller.CustomerController;
import ru.interfaceukc.javaee.helloejb.controller.CustomerControllerRemote;
import ru.interfaceukc.javaee.helloejb.model.CustomerPOJO;
import ru.interfaceukc.javaee.helloejb.model.entities.Customer;

/**
 *
 * @author Администратор
 */
@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {

//    @EJB CustomerController controller;
    @EJB CustomerControllerRemote controller;
    
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Customer</h1>");
            out.println("<table border='1'>");
            out.println("<tr><th>CUSTOMER_ID</th><th>DISCOUNT_CODE</th><th>ZIP</th><th>NAME</th><th>ADDRESSLINE1</th><th>ADDRESSLINE2</th><th>CITY</th><th>STATE</th><th>PHONE</th><th>FAX</th><th>EMAIL</th><th>CREDIT_LIMIT</th></tr>");
            if (request.getParameter("id") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                CustomerPOJO cust = controller.findById(id);
                if (cust != null) {
                    printCustomer(out, cust);
                } else {
                    out.println("<tr><td colspan='12'>Not Found</td></tr>");
                }
            }
            if (request.getParameter("discount") != null) {
                for (CustomerPOJO cust : controller.findByDiscountCode(request.getParameter("discount"))) {
                    printCustomer(out, cust);
                }
            }
            if (request.getParameter("zip") != null) {
                for (Customer cust : controller.findByZipCode(request.getParameter("zip"))) {
                    printCustomer(out, cust);
                }
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void printCustomer(final PrintWriter out, CustomerPOJO cust) {
        out.print("<tr>");
        out.print("<td>" + cust.getId() + "</td>");
        out.print("<td>" + cust.getDiscountCode()+ "</td>");
        out.print("<td>" + cust.getZip()+ "</td>");
        out.print("<td>" + cust.getName()+ "</td>");
        out.print("<td>" + cust.getAddressline1()+ "</td>");
        out.print("<td>" + cust.getAddressline2()+ "</td>");
        out.print("<td>" + cust.getCity()+ "</td>");
        out.print("<td>" + cust.getState()+ "</td>");
        out.print("<td>" + cust.getPhone()+ "</td>");
        out.print("<td>" + cust.getFax()+ "</td>");
        out.print("<td>" + cust.getEmail()+ "</td>");
        out.print("<td>" + cust.getCreditLimit()+ "</td>");
        out.println("</tr>");
    }

    private void printCustomer(PrintWriter out, Customer cust) {
        System.out.println("cust = " + cust);
        out.print("<tr>");
        out.print("<td>" + cust.getId() + "</td>");
        out.print("<td>" + cust.getDiscountCode().getDiscountCode() + "</td>");
        out.print("<td>" + cust.getZip().getZipCode() + "</td>");
        out.print("<td>" + cust.getName()+ "</td>");
        out.print("<td>" + cust.getAddress().getAddressline1()+ "</td>");
        out.print("<td>" + cust.getAddress().getAddressline2()+ "</td>");
        out.print("<td>" + cust.getAddress().getCity()+ "</td>");
        out.print("<td>" + cust.getAddress().getState()+ "</td>");
        out.print("<td>" + cust.getContactInfo().getPhone()+ "</td>");
        out.print("<td>" + cust.getContactInfo().getFax()+ "</td>");
        out.print("<td>" + cust.getContactInfo().getEmail()+ "</td>");
        out.print("<td>" + cust.getCreditLimit()+ "</td>");
        out.println("</tr>");
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
