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
  <form action="ControladorCliente" method="post">
    
    <header class="conte-header">
        <div>
            <h1 class="titulo">Tienda genérica</h1>
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
        
        <%!
        
        String cedula="", nombre="", direccion="", telefono="", correo="", estado="", estado_boton="disabled";
        %>
        <%
        if(request.getParameter("cedula")!=null){
        	cedula=request.getParameter("cedula");
        	nombre =request.getParameter("nombre");
        	direccion=request.getParameter("direccion");
        	telefono=request.getParameter("telefono");
        	correo=request.getParameter("correo");
        	estado="disabled";
        	estado_boton="";
        }else{
        	cedula="";
        	nombre="";
        	direccion="";
        	telefono="";
        	correo="";
        	estado="";
        	estado_boton="disabled";
        }
        if(request.getParameter("mens")!=null){
        	String mensaje= request.getParameter("mens");
        	out.print("<script>alert('"+mensaje+"');</script>");
        }
        %>
                 <div id="login-box">
                    <h1>Gestion de Clientes</h1>

                    <div class="form">
                        <div class="item"> 
                           
                            <input type="tel" placeholder="Cedula" name="cedula" value="<%=cedula%>" <%=cedula%>> 
                            <input type="hidden" name="ced" value="<%=cedula%>">
                        </div>

                        <div class="item">
                           
                            
                            <input type="text" placeholder="Nombre completo" name="nombre" value="<%=nombre%>">
                        </div>

                        <div class="item">
                           
                            
                            <input type="text" placeholder="Direccion" name="direccion" value="<%=direccion%>">
                        </div>

                        <div class="item">
                           
                            
                            <input type="text" placeholder="Telefono" name="telefono" value="<%=telefono%>">
                        </div>

                        <div class="item">
                           
                            
                            <input type="text" placeholder="Correo electronico" name="correo" value="<%=correo%>">
                        </div>

                        <div class="horizontal">
                        <button  class="mainmenubtn2" name="Buscar" >Consultar</button>
                        <button  class="mainmenubtn2" name="Registrar" >Crear</button>
                        <button  class="mainmenubtn2" name="Actualizar" <%=estado_boton%>>Actualizar</button>
                        <button  class="mainmenubtn2" name="Eliminar" <%=estado_boton%>>Borrar</button>
                        </div>
                </div>
                </div>
            </form>

</body>
</html>