/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DaoImpl.CarDaoImpl;
import Entities.Car;
import Entities.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kasia
 */
@WebServlet(name = "ReservationManage", urlPatterns = {"/rentCar", "/returnCar"})
public class ReservationManage extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
                String url= request.getServletPath();
            
                switch(url){
                    case "/rentCar":
                    this.rentCar(request, response);
                    break;
                    case "/returnCar":
                    this.returnCar(request, response);
                    break;
                }
                
        
    }


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
    
     protected void rentCar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
              Clientes c = (Clientes) request.getSession().getAttribute("clientAccount");
              Integer idCar=Integer.parseInt(request.getParameter("idCar"));
              //Set cars=new HashSet(0);
              //String[] idCars=request.getParameterValues("idCar"); 
              //for(String i:idCars){
              //    Car car=new Car();
               //   car.setIdcar(Integer.parseInt(i));
               //   cars.add(car);
              //}

              CarDaoImpl cdi=new CarDaoImpl();
              cdi.rent1(c.getIdclientes(), idCar);
              response.sendRedirect("yourAccount.jsp");
              
              
        }
    }

     protected void returnCar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
              Clientes c = (Clientes) request.getSession().getAttribute("clientAccount");
              Integer idCar=Integer.parseInt(request.getParameter("idCar"));
              
              CarDaoImpl cdi=new CarDaoImpl();
              cdi.returnCar(c.getIdclientes(), idCar);
              response.sendRedirect("yourAccount.jsp");
              
        }
    }


}
