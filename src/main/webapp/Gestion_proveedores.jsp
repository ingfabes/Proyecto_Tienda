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
    <form action="controladorProveedor" method="post">
    
    <header class="conte-header">
        <div>
            <h1 class="titulo">Tienda gen�rica</h1>
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

String nitproveedor="", ciudad_proveedor="", direccion_proveedor="", nombre_proveedor="", telefono_proveedor="", estado="", estado_boton="disabled";
%>
<%
if(request.getParameter("nitproveedor")!=null){
	nitproveedor=request.getParameter("nitproveedor");
	ciudad_proveedor=request.getParameter("ciudad_proveedor");
	direccion_proveedor=request.getParameter("direccion_proveedor");
	nombre_proveedor=request.getParameter("nombre_proveedor");
	telefono_proveedor=request.getParameter("telefono_proveedor");
	estado="disabled";
	estado_boton="";
}else{
	nitproveedor="";
	ciudad_proveedor="";
	direccion_proveedor="";
	nombre_proveedor="";
	telefono_proveedor="";
	estado="";
	estado_boton="disabled";
}
if(request.getParameter("mens")!=null){
	String mensaje= request.getParameter("mens");
	out.print("<script>alert('"+mensaje+"');</script>");
}
%>
         <div id="login-box">
            <h1>Gesti�n de Proveedores</h1>

            <div class="form">
                <div class="item"> 
                   
                    <input type="tel" placeholder="NIT del proveedor" name="nitproveedor" value="<%=nitproveedor%>" <%=nitproveedor%>> 
                    <input type="hidden" name="ced" value="<%=nitproveedor%>">
                </div>

                <div class="item">
                   
                    
                    <input type="text" placeholder="Ciudad del proveedor" name="ciudad_proveedor" value="<%=ciudad_proveedor%>">
                </div>

                <div class="item">
                   
                    
                    <input type="text" placeholder="Direccion del proveedor" name="direccion_proveedor" value="<%=direccion_proveedor%>">
                </div>

                <div class="item">
                   
                    
                    <input type="text" placeholder="nombre_proveedor" name="nombre_proveedor" value="<%=nombre_proveedor%>">
                </div>

                <div class="item">
                   
                    
                    <input type="text" placeholder="telefono_proveedor" name="telefono_proveedor" value="<%=telefono_proveedor%>">
                </div>

                <div class="horizontal">
                <button  class="mainmenubtn2" name="consultar" >Consultar</button>
                <button  class="mainmenubtn2" name="crear" >Crear</button>
                <button  class="mainmenubtn2" name="actualizar" <%=estado_boton%>>Actualizar</button>
                </div>
        </div>
        </div>
    </form>
</body>
</html>