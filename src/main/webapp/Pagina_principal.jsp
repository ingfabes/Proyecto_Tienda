<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda generica</title>
<link rel="stylesheet" type="text/css" href="css/Estilo_B.css">
<link rel="stylesheet" type="text/css" href="css/Estilo_pp.css">
</head>
<body>
<form action="controlador" method="post">
    
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
    </form>
</body>
</html>