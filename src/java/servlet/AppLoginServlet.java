/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import BankingDomain.Customer;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Chandana
 */
public class AppLoginServlet extends HttpServlet {

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
        
            Customer objCustomer = new Customer();
            String url = "/login.html";
           try{
               String userID = request.getParameter("userID");
               String password = request.getParameter("strPassword");
              
              ArrayList<Customer> arrListCustomer = Customer.getCustomers();
             //checking arrListCustomer size to avoid calling init method multiple times
              if(arrListCustomer.isEmpty() ){
                  Customer.init();
                  arrListCustomer = Customer.getCustomers();
              } 
              
               objCustomer = Customer.loginCustomer(userID, password);
                // set User object in request object and set URL
                System.out.println(objCustomer);
            request.setAttribute("customer", objCustomer);
            request.setAttribute("welocme", "Welcome");
            request.setAttribute("message", "Login Successful");
            url = "/loginSuccess.jsp"; 

            getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
           }catch(Exception e){
               url = "/login.jsp"; 
               request.setAttribute("message", e.getMessage());
               HttpSession session = request.getSession();
               session.setAttribute("message", e.getMessage());
               getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
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
