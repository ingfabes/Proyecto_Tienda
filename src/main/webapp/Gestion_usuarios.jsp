<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Tienda generica</title>
	<link rel="stylesheet" type="text/css" href="css/Estilo_B.css">
	<link rel="stylesheet" type="text/css" href="css/Estilo_gu.css">
</head>
<body>
    <form action="controlador" method="post">
    
    <header class="conte-header">
        <div>
            <h1 class="titulo">Tienda generica</h1>
        </div>
        <nav>
            <ul>
            	<li><button name="usu" class="botones">Usuarios</button></li>
            	<li><button name="cli" class="botones">Clientes</button></li>
            	<li><button name="pro" class="botones">Proveedores</button></li>
            	<li><button name="prod" class="botones">Productos</button></li>
				<li><button name="ven" class="botones">Ventas</button></li>  
				<li><button name="rep" class="botones">Reportes</button></li>      
            </ul>
        </nav>
    </header>
    
        <div id="login-box">
        
        <%!

String cedula="", correo="", nombre="", pass="", user="", estado="";
%>
<%
if(request.getParameter("ced")!=null){
	cedula=request.getParameter("ced");
	correo=request.getParameter("correo");
	nombre=request.getParameter("nomb");
	pass=request.getParameter("pass");
	user=request.getParameter("usuario");
	estado="disabled";
}
%>
        
            <h1>Gestion de Usuarios</h1>

            <div class="form">
                <div class="item"> 
                   
                    <input type="tel" placeholder="Cedula" name="cedula" value="<%=cedula%>" <%=estado%>> 
                    <input type="hidden" name="ced" value="<%=cedula%>">
                </div>

                <div class="item">
                   
                    
                    <input type="text" placeholder="Nombre completo" name="nombre" value="<%=nombre%>">
                </div>

                <div class="item">
                   
                    
                    <input type="email" placeholder="Correo electronico" name="correo" value="<%=correo%>">
                </div>

                <div class="item">
                   
                    
                    <input type="text" placeholder="Usuario" name="usuario" value="<%=user%>">
                </div>

                <div class="item">
                   
                    
                    <input type="password" placeholder="contraseña" name="password" value="<%=pass%>">
                </div>

                <div class="horizontal">
                <button  class="mainmenubtn2" name="consultar" >Consultar</button>
                <button  class="mainmenubtn2" name="crear">Crear</button>
                <button  class="mainmenubtn2" name="actualizar">Actualizar</button>
                <button  class="mainmenubtn2" name="borrar">Borrar</button>
                </div>
          
            
        </div>
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