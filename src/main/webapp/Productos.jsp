<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="Pagina_principal.jsp"%>

<body>

<form action="controlador_Producto" method="post" enctype="multipart/form-data">
<div id="login-box">
<div class= "form">
<div>
<input type="file" value="Examinar" name="archivo">
</div>

 <button  class="mainmenubtn2" type="submit" name="cargar" >Cargar Productos</button>
</div></div>
</form>
<% if(request.getParameter("mens")!=null){
	String mensaje= request.getParameter("mens");
	out.print("<script>alert('"+mensaje+"');</script>");
}%>
</body>
</html>