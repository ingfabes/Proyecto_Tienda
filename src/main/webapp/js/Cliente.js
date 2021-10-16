$(document).ready(function(){

function buscaCliente(){
	
     $.ajax({
	type:"post",
	url:"controladorJSCliente",
	dataType:"json",
	data:{opcion:"cliente", cedula:$('#cedula').val()},
	success: function(result){
		console.log(result) //Imprime Json en la consola
		var nombre=document.getElementById("nombre")
			if(result==null)
			{
				alert("El documento no existe");
				nombre.value="";

			}
			else
			{
				//alert("El documento existe");
				nombre.value=JSON.stringify(result.nombre_completo).replace(/['"]+/g, '');
				$('#cedula').attr("readonly","readonly")
			}
			//nombre.value=JSON.stringify({result, toJSON(){ return this.nombre_completo; } });
			//`${result.nombre_cliente}`
		}
})
	
}	
$('#buscaCliente').on('click',function(){
	//alert("Entro a boton")	
	buscaCliente();
})
		
	
	
})