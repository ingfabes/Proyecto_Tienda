<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="Pagina_principal.jsp"%>
<link rel="stylesheet" type="text/css" href="css/Tabla.css">
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
 
<script type="text/javascript" src="js/Producto.js"></script>

<body>

<form action="controlador_Producto" method="post" enctype="multipart/form-data">
<div id="login-box">
<div class= "form">
<div>
<input type="file" value="Examinar" name="archivo" accept=".csv" id="archivoInput" onchange="return validarExt()">
</div>

 <button  class="mainmenubtn2" type="submit" name="cargar" >Cargar Productos</button>
</div>

</div>
</form>
<div id= "botonTabla">
<button id="listaProductos" class="mainmenubtn2"  >Listar Productos</button>
</div>
<table id="tabla">

</table>


<% if(request.getParameter("men")!=null){
	String titulo= request.getParameter("titulo");
	String mensaje= request.getParameter("men");
	String icon=request.getParameter("icono");
	out.print("<script>Swal.fire({title: '"+titulo+"', text:'"+mensaje+"', icon: '"+icon+"'});</script>");
}%>
</body>

<script type="text/javascript">
function validarExt()
{
    var archivoInput = document.getElementById('archivoInput');
    var archivoRuta = archivoInput.value;
    var extPermitidas = /(.csv)$/i;
    if(!extPermitidas.exec(archivoRuta)){
    	Swal.fire({title:"Error", text: "Formato de archivo invalido, asegurese de seleccionar un archivo con extensión .csv", icon: 'error'});
        archivoInput.value = '';
        return false;
    }
}
</script>
</html>
