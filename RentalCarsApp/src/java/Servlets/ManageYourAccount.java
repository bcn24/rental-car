/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DaoImpl.CarDaoImpl;
import DaoImpl.ClientesDaoImpl;
import Entities.Car;
import Entities.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kasia
 */
@WebServlet(name = "ManageYourAccount", urlPatterns = {"/update", "/logout", "/deleteAccount"})
public class ManageYourAccount extends HttpServlet {
    



    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String url = request.getServletPath();
            
            switch (url) {
            case "/update":
                this.updateDetails(request, response);
                break;
            case "/logout":
                this.logout(request, response);
                break;
            case "/deleteAccount":
                this.deleteAccount(request, response);
                break;
        
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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
        protected void updateDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("hola update");
            
        }
        }
    
        protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
            request.getSession().invalidate() ;
            response.sendRedirect("index.jsp");
            return;
        
        }
        
        protected void deleteAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            ClientesDaoImpl cdi=new ClientesDaoImpl();
            CarDaoImpl cardi=new CarDaoImpl();
            Clientes c=(Clientes) request.getSession().getAttribute("clientAccount");
            ArrayList<Car>cars=cardi.showAllClientsCars(c);
            for(Car i:cars){
                cardi.returnCar(c.getIdclientes(), i.getIdcar());
            }
            cdi.delete(c.getIdclientes());
            response.sendRedirect("index.jsp");
        }
        }

}
