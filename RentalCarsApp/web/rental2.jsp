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
        
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link href="styleAll.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
      <a class="navbar-brand" href="">RentalCars</a>
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="yourAccount.jsp">Go to your account</a>
        </li>
      </ul>
    </nav>
        
        <div class="main">
       
        <%
            Clientes c;
            try{
                if(session.getAttribute("client")!=null){
                     c=(Clientes) session.getAttribute("client");
                     out.println("Welcome "+c.getName());
                }else{
                    c=(Clientes) session.getAttribute("clientRegistered");
                     out.println("Welcome "+c.getName());
                }
                session.setAttribute("clientAccount", c);
                
                CarDaoImpl cdi=new CarDaoImpl();
                //ArrayList<Car>carCliente= cdi.showAllClientsCars(c);
                //for(Car i:carCliente){
                //   out.println("<p><form action='returnCar' method='POST'>"+i.getMarca()+" "+i.getSeria()+
                 //          "<input type='submit' class='btn btn-success btn-sm' value='Return' /></form></p>");
               // }
                
                ArrayList<Car>cars=cdi.showAll();
        %>
                
                    
                <%
                    
                for(Car i:cars){
                    if(i.getClientes()==null ){
                        
                        out.println("<p><form action='rentCar' method='POST'>"
                                + "<input type='hidden' name='idCar' value="+Integer.toString (i.getIdcar())+">"
                                +i.getMarca()+i.getSeria()+
                                "<input type='submit' class='btn btn-primary btn-sm' value='Rent this car' /></form></p>");
                    }
                }
                
                for(Car a:cars){
                    if(a.getClientes()!=null ){
                       out.println("<p>"+a.getMarca()+" "+a.getSeria()+" "
                               +"<input type='submit' class='btn btn-basic btn-sm' "
                               + "disabled value='Not available' /></p>"); 
                    }
                }
                %>
                   
        </form>
                    <%
            }
            catch(Exception e){
                    out.println("You need to be logged in ");
                    }
           
            %>
            
         </div>
    </body>
  
</html>