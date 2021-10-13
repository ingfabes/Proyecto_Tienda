<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="Pagina_principal.jsp"%>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<body>
    <form action="controlador" method="post" id="form">
      
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
	nombre="";
	pass="";
	user="";
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
            <h1>Gestion de Usuarios</h1>

            <div class="form">
                <div class="item"> 
                   
                    <input type="text" placeholder="Cedula" class="campocedula" name="cedula" value="<%=cedula%>" <%=estado%>> 
                    <input type="hidden" name="ced" id="ced" value="<%=cedula%>">
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
                <input type="button" class="mainmenubtn2" name="buscar"onclick="alerta_consulta();" value="Consultar"> 
                <button style="display:none" id="cons" name="consultar" >Consultar</button>
                <button  class="mainmenubtn2" name="crear" >Crear</button>
                <button  class="mainmenubtn2" name="actualizar" <%=estado_boton%>>Actualizar</button>
                <button style="display:none" id="borra" name="borrar"<%=estado_boton%>>Borrar</button>  
                <input type="button" class="mainmenubtn2" name="eliminar"onclick="alertaEliminar();" value="Borrar" <%=estado_boton%>>            
                </div>
        </div>
        </div>
    </form>
    
</body>
<script type="text/javascript">
function alertaEliminar() {
	swal.fire({
        title: '¿Seguro que desea eliminar el usuario con cedula: <%= cedula %> ? ',
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
    	location.href="Gestion_usuarios.jsp";
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