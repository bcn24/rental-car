
<%@page import="Entities.Clientes"%>
<%-- 
    Document   : index
    Created on : Mar 27, 2018, 8:03:03 AM
    Author     : kasia
--%>

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
      <a class="navbar-brand" href="#">RentalCars</a>
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="#"></a>
        </li>
      </ul>
    </nav>
        
        <div class="main">
        
        <%
            if(request.getAttribute("respuesta")==null){
                out.println("");
            }
            else{
                out.println(request.getAttribute("respuesta"));
            }
            
            if(request.getAttribute("sessionNull")==null){
                out.println("");
            }
            else{
                out.println(request.getAttribute("sessionNull"));
            }
            %>
        <form action="login" method="POST">
            <p><input type="text" name="emailLog" placeholder="E-mail address" value="" /></p>
            <p><input type="password" name="passwordLog" placeholder="Password" value="" /></p>
            <p><input type="submit" class="btn btn-primary btn-sm" value="Log in" /></p>
        </form>
        <form action="register.jsp" method="POST">
            <p><input type="submit" class="btn btn-success btn-sm" value="Register" /></p>
        </form>
                
        
</div>
    </body>
</html>

