$(document).ready(function(){

function listaUsuarios(){
	
     $.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"usuarios"},
	success: function(result){
		console.log(result) //Imprime Json en la consola
		var tabla=document.getElementById("tabla")
		tabla.innerHTML=''
		tabla.innerHTML+=`<tr>
		<th>CEDULA </th>
		<th>CORREO </th>
		<th>NOMBRE </th>
		<th>PASSWORD </th>
		<th>USUARIO </th>
		
		</tr>`
	
		for(let fila of result){
			tabla.innerHTML+=`<tr>
			<td>${fila.cedula}</td>
			<td>${fila.email}</td>
			<td>${fila.nitnombre}</td>
			<td>${fila.password}</td>
			<td>${fila.usuario}</td>
			
			</tr>`}}
})
	
}	


function listaClientes(){
	
     $.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"clientes"},
	success: function(result){
		console.log(result) //Imprime Json en la consola
		var tabla=document.getElementById("tabla")
		tabla.innerHTML=''
		tabla.innerHTML+=`<tr>
		<th>CEDULA </th>
		<th>NOMBRE </th>
		<th>DIRECCION </th>
		<th>TELEFONO </th>
		<th>CORREO </th>
		
		</tr>`
	
		for(let fila of result){
			tabla.innerHTML+=`<tr>
			<td>${fila.cedula}</td>
			<td>${fila.nombre_completo}</td>
			<td>${fila.direccion}</td>
			<td>${fila.telefono}</td>
			<td>${fila.correoelectronico}</td>
			
			</tr>`}}
})
	
}	


function listaVentas(){
	
     $.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"ventas"},
	success: function(result){
		console.log(result) //Imprime Json en la consola
		var tabla=document.getElementById("tabla")
		tabla.innerHTML=''
		tabla.innerHTML+=`<tr>
		<th>CEDULA CLIENTE </th>
		<th>TOTAL VENTA </th>
		
		
		</tr>`
	
		for(let fila of result){
			tabla.innerHTML+=`<tr>
			<td>${fila.cedula_cliente}</td>
			<td>${fila.valor_venta}</td>
			
			
			
			</tr>`}}
})
	
}	





$('#listaUsuarios').on('click',function(){
	//alert("Entro a boton")	
	listaUsuarios();
})

$('#listaClientes').on('click',function(){
	//alert("Entro a boton")	
	listaClientes();
})

$('#listaVentas').on('click',function(){
	//alert("Entro a boton")	
	listaVentas();
})
	
		
	
	
})