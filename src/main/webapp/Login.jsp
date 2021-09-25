<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8">
	<title>Tienda generica</title>
	<link rel="stylesheet" type="text/css" href="css/Estilo_L.css">
</head>
<body>
	
    <form action="controlador" method="post">
        <div id="login-box">
            <h1>Iniciar Sesión</h1> 

            <div class="form">
                <div class="item"> 
                   
                    <input type="text" placeholder="usuario" name="username"> 
                </div>

                <div class="item"> 
                   
                    
                    <input type="password" placeholder="contraseña" name="password">
                </div>

            </div>
            
            <div class="boton"><button type="submit" name="ingresar">Login</button></div>
            
        </div>
    </form>
<%
if(request.getParameter("mens")!=null){
	String mensaje= request.getParameter("mens");
	out.print("<script>alert('"+mensaje+"');</script>");
}
%>
</body>
</html>