<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="Pagina_principal.jsp"%>
<body>
    <form action="controladorProveedor" method="post">
        
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
            <h1>Gestión de Proveedores</h1>

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