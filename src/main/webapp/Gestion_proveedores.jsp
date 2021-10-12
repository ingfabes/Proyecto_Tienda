<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="Pagina_principal.jsp"%>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
	String titulo= request.getParameter("titulo");
	String mensaje= request.getParameter("mens");
	String icon=request.getParameter("icono");
	out.print("<script>Swal.fire({title: '"+titulo+"', text:'"+mensaje+"', icon: '"+icon+"'});</script>");
}
%>
         <div id="login-box">
            <h1>Gestión de Proveedores</h1>

            <div class="form">
                <div class="item"> 
                   
                    <input type="tel" placeholder="NIT del proveedor" name="nitproveedor" value="<%=nitproveedor%>" <%=estado%>> 
                    <input type="hidden" id="ced" name="ced" value="<%=nitproveedor%>">
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
                <input type="button" class="mainmenubtn2" name="buscar"onclick="alerta_consulta();" value="Consultar"> 
                <button style="display:none" id="cons" name="consultar" >Consultar</button>
                <button  class="mainmenubtn2" name="crear" >Crear</button>
                <button  class="mainmenubtn2" name="actualizar" <%=estado_boton%>>Actualizar</button>
                </div>
        </div>
        </div>
    </form>
       
</body>
<script type="text/javascript">
function alerta_consulta(){
	Swal.fire({
	    title: "Consulta proveedor",
	    icon: "question",
	    text: "Ingresa el número de NIT",
	    input: "number",
	    showCancelButton: true,
	    confirmButtonText: "Buscar",
	    cancelButtonText: "Cancelar",
	    inputValidator: nombre => {
	        if (!nombre) {
	            return "Campo vacío, ingresa un valor";
	        } else {
	            return undefined;
	        }
	    }
	})
	.then(resultado => {
	    if (resultado.value) {
	        let nombre = resultado.value;
	        document.getElementById("ced").value=nombre;
	        document.getElementById("cons").click();
	    }
	});
	}
</script>
</html>