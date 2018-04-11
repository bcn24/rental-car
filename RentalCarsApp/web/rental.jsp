<%-- 
    Document   : rental
    Created on : Apr 4, 2018, 10:38:05 PM
    Author     : kasia
--%>

<%@page import="Entities.Car"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DaoImpl.CarDaoImpl"%>
<%@page import="Entities.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! rental</h1>
        <%
            try{
                if(session.getAttribute("client")!=null){
                     Clientes c=(Clientes) session.getAttribute("client");
                     out.println("Welcome "+c.getName());
                }else{
                    Clientes c=(Clientes) session.getAttribute("clientReg");
                     out.println("Welcome "+c.getName());
                }
                String a="booked";
                CarDaoImpl cdi=new CarDaoImpl();
                ArrayList<Car>cars=cdi.showAll();%>
                <form action="booking" method="POST">
                    <p><select name="carsToRent" size="cars.size()" multiple></p>
                <%
                for(Car c:cars){
                    if(c.getClientes()==null ){
                out.println("<option>"+c.getMarca()+c.getSeria()+"</option>");
                    }
                    else{
                       out.println("<option>"+c.getMarca()+c.getSeria()+a+"</option>"); 
                    }
                }
                %>
                    </select>
                    <p><input type="submit" class="btn btn-primary btn-sm" value="Book" /></p>
        </form>
                    <%
            }
            catch(Exception e){
                    out.println("You need to be logged in "+e);
                    }
           
            %>
    </body>
</html>
