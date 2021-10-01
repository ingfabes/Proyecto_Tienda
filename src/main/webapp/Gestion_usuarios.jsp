<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="menu.jsp"%>

<body>
    <form action="controlador" method="post">
        <%!

String cedula="", correo="", nombre="", pass="", user="", estado="", estado_boton="disabled";
%>
<%
if(request.getParameter("ced")!=null){
	cedula=request.getParameter("ced");
	correo=request.getParameter("correo");
	nombre=request.getParameter("nomb");
	pass=request.getParameter("pass");
	user=request.getParameter("usuario");
	estado="disabled";
	estado_boton="";
}else{
	cedula="";
	correo="";
	nombre="";pass="";
	user="";
	estado="";
	estado_boton="disabled";
}
if(request.getParameter("mens")!=null){
	String mensaje= request.getParameter("mens");
	out.print("<script>alert('"+mensaje+"');</script>");
}
%>
         <div id="login-box">
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
                <button  class="mainmenubtn2" name="crear" >Crear</button>
                <button  class="mainmenubtn2" name="actualizar" <%=estado_boton%>>Actualizar</button>
                <button  class="mainmenubtn2" name="borrar" <%=estado_boton%>>Borrar</button>
                </div>
        </div>
        </div>
    </form>
</body>
</html>