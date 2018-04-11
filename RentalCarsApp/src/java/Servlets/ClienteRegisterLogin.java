/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DaoImpl.ClientesDaoImpl;
import Entities.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kasia
 */
@WebServlet(name = "ClienteRegisterLogin", urlPatterns = {"/login", "/register"})
public class ClienteRegisterLogin extends HttpServlet {
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

            String url = request.getServletPath();
            
            switch (url) {
            case "/login":
                this.login(request, response);
                break;
            case "/register":
                this.register(request, response);
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

    
    
    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            ClientesDaoImpl cdi = new ClientesDaoImpl();
            String email=request.getParameter("emailLog").trim() ;
            String pass=request.getParameter("passwordLog").trim();
            String res="";
        
            if(!email.isEmpty()
                    &&cdi.checkPasswordFormat(pass)
                    &&cdi.checkIfLoginInDB(email)
                    &&cdi.checkIfPasswordMatching(email, pass)!=null){
                        Clientes c=cdi.checkIfPasswordMatching(email, pass);
                        
                            request.getSession().setAttribute("client", c);
                            request.getRequestDispatcher("/rental2.jsp").forward(request, response);
            }
            else{
                res="Please provide a valid login and password or register your account";
                request.setAttribute("respuesta", res);
                request.getRequestDispatcher("/index.jsp").include(request, response);
            }
        }
    }
    
    protected void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                
                String name=request.getParameter("name").trim();
                String surname=request.getParameter("surname").trim();
                String email=request.getParameter("email").trim();
                String pass=request.getParameter("password").trim();

                ClientesDaoImpl cdi = new ClientesDaoImpl();
                
               if(!name.isEmpty()&&!surname.isEmpty()
                       &&cdi.checkLoginFormat(email)
                       &&!cdi.checkIfLoginInDB(email)
                       &&cdi.checkPasswordFormat(pass)){
                Clientes c1=new Clientes(name, surname, email, pass);
                cdi.create(c1);

                request.getSession().setAttribute("clientRegistered", c1);
                request.getRequestDispatcher("/rental2.jsp").forward(request, response);
               }
               else{
                String res="Please provide valid username(valid email address) and login. "
                        + "Login must contain digits and letters only and have at least 5 letters/digits";
                request.setAttribute("responseRegister", res);
                request.getRequestDispatcher("/register.jsp").include(request, response);
               }
           
        }
    }
}
