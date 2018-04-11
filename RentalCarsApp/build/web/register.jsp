<%-- 
    Document   : register
    Created on : Apr 3, 2018, 7:28:19 PM
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
      <a class="navbar-brand" href="index.jsp">RentalCars</a>
    </nav>
        <div class="main">
        <%
            if(request.getAttribute("responseRegister")==null){
                out.println("");
            }else{
            out.println(request.getAttribute("responseRegister"));
            }
            %>
        <form action="register" method="POST">
            <p><input type="text" name="name" placeholder="Name" value="" /></p>
            <p><input type="text" name="surname" placeholder="Surname" value="" /></p>
            <p><input type="text" name="email" placeholder="E-mail address" value="" /></p>
            <p><input type="password" name="password" placeholder="Password" value="" /></p>
            <p><input type="submit" class="btn btn-primary btn-sm" value="Register" /></p>
        </form>
        
        </div>
    </body>
</html>
