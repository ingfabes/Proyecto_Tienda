<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="Pagina_principal.jsp"%>
<link rel="stylesheet" type="text/css" href="css/Tabla.css">
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
 
<script type="text/javascript" src="js/Reportes.js"></script>

<body>


<div id="login-box">
<div class= "form">

<div id= "botonTabla">
<button id="listaUsuarios" class="mainmenubtn2"  >Listar Usuarios</button>
<button id="listaClientes" class="mainmenubtn2"  >Listar Clientes</button>
<button id="listaVentas" class="mainmenubtn2"  >Venta por clientes</button>

</div>

</div>
</div>
<table id="tabla">

</table>



</body>

</html>
