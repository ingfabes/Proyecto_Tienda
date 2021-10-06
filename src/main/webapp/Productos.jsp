<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="Pagina_principal.jsp"%>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<body>

<form action="controlador_Producto" method="post" enctype="multipart/form-data">
<div id="login-box">
<div class= "form">
<div>
<input type="file" value="Examinar" name="archivo" accept=".csv" id="archivoInput" onchange="return validarExt()">
</div>

 <button  class="mainmenubtn2" type="submit" name="cargar" >Cargar Productos</button>
</div></div>
</form>
<% if(request.getParameter("mens")!=null){
	String mensaje= request.getParameter("mens");
	out.print("<script>alert('"+mensaje+"');</script>");
}%>
</body>

<script type="text/javascript">
function validarExt()
{
    var archivoInput = document.getElementById('archivoInput');
    var archivoRuta = archivoInput.value;
    var extPermitidas = /(.csv)$/i;
    if(!extPermitidas.exec(archivoRuta)){
    	Swal.fire({title: "Asegurese de haber seleccionado un archivo con extensión .csv", icon: 'warning'});
        archivoInput.value = '';
        return false;
    }
}
</script>
</html>
