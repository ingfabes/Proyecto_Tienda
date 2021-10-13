<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="Pagina_principal.jsp"%>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
        	String titulo= request.getParameter("titulo");
        	String mensaje= request.getParameter("mens");
        	String icon=request.getParameter("icono");
        	out.print("<script>Swal.fire({title: '"+titulo+"', text:'"+mensaje+"', icon: '"+icon+"'});</script>");
        }
        %>
                 <div id="login-box">
                    <h1>Gestion de Clientes</h1>

                    <div class="form">
                        <div class="item"> 
                           
                            <input type="tel" placeholder="Cedula" name="cedula" value="<%=cedula%>" <%=estado%>> 
                            <input type="hidden" id="ced" name="ced" value="<%=cedula%>">
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
                        <input type="button" class="mainmenubtn2" name="buscar"onclick="alerta_consulta();" value="Consultar"> 
               			<button style="display:none" id="cons" name="Buscar" >Consultar</button> 
                        <button  class="mainmenubtn2" name="Registrar" >Crear</button>
                        <button  class="mainmenubtn2" name="Actualizar" <%=estado_boton%>>Actualizar</button>                       
                        <button style="display:none" id="borra" name="Eliminar">Borrar</button>  
                		<input type="button" class="mainmenubtn2" name="eliminar"onclick="alertaEliminar();" value="Borrar" <%=estado_boton%>>
                        </div>
                </div>
                </div>
            </form>

</body>

<script type="text/javascript">
function alertaEliminar() {
	swal.fire({
        title: '¿Seguro que desea eliminar el cliente con cedula: <%= cedula %> ? ',
        type: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        cancelButtonText: 'Cancelar',
        confirmButtonText: '¡Si, eliminar!'
    }).then((result) => {
    if (result.value) {
    	document.getElementById("borra").click();
    }else{
    	location.href="Gestion_Clientes.jsp";
    }
});
  }
  
function alerta_consulta(){
	Swal.fire({
	    title: "Consulta usuario",
	    icon: "question",
	    text: "Ingresa el número de cédula",
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
	}).then(resultado => {
	    if (resultado.value) {
	        let nombre = resultado.value;
	        document.getElementById("ced").value=nombre;
	        document.getElementById("cons").click();
	    }
	});
	}
  
</script>

</html>