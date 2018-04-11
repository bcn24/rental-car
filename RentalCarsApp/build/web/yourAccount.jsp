<%-- 
    Document   : yourAccount
    Created on : Apr 8, 2018, 12:37:40 PM
    Author     : kasia
--%>

<%@page import="Entities.Clientes"%>
<%@page import="Entities.Car"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DaoImpl.CarDaoImpl"%>
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
          <a class="nav-link" href="rental2.jsp">Back to rental</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="logout">Log out</a>
        </li>
      </ul>
    </nav>
        <div class="main">
        <%
            if(session.getAttribute("clientAccount")!=null){
            
            Clientes c= (Clientes) session.getAttribute("clientAccount");
            out.println("<p><form action='deleteAccount' method='POST'>"
                     + "<input type='submit' class='btn btn-primary btn-sm' value='Delete your account' /></form></p>");
            out.println(c.getName());
            
            
               CarDaoImpl cdi=new CarDaoImpl();
               ArrayList<Car>carCliente= cdi.showAllClientsCars(c);
               if(!carCliente.isEmpty()){
                out.println("<h3>Cars that you have rented:</h3>");
                 for(Car i:carCliente){
                    out.println("<p><form action='returnCar' method='POST'>"
                            + "<input type='hidden' name='idCar' value="+Integer.toString (i.getIdcar())+">"
                            +i.getMarca()+" "+i.getSeria()+
                            "<input type='submit' class='btn btn-success btn-sm' value='Return the car' /></form></p>");
                 }
                }
               else{
                   out.println("No cars rented");
               }

            
            }
            else{
                String msg="Please log in in order to manage your account";
                request.setAttribute("sessionNull", msg);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }


            %>
        </div>
    </body>
</html>
