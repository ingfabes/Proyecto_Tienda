<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="Pagina_principal.jsp"%>
<body>
  <form action="ControladorCliente" method="post">
        
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