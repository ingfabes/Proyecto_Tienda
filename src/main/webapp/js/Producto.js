$(document).ready(function(){

function listaProductos(){
	
     $.ajax({
	type:"post",
	url:"controladorJS",
	dataType:"json",
	data:{opcion:"productos"},
	success: function(result){
		console.log(result) //Imprime Json en la consola
		var tabla=document.getElementById("tabla")
		tabla.innerHTML=''
		tabla.innerHTML+=`<tr>
		<th>CODIGO </th>
		<th>IVA </th>
		<th>NIT PROVEEDOR </th>
		<th>PRODUCTO </th>
		<th>PRECIO DE COMPRA </th>
		<th>PRECIO DE VENTA </th>
		</tr>`
		for(let fila of result){
			tabla.innerHTML+=`<tr>
			<td>${fila.codigo_producto}</td>
			<td>${fila.ivacompra}</td>
			<td>${fila.nitproveedor}</td>
			<td>${fila.nombre_producto}</td>
			<td>${fila.precio_compra}</td>
			<td>${fila.precio_venta}</td>
			</tr>`}}
})
	
}	
$('#listaProductos').on('click',function(){
	//alert("Entro a boton")	
	listaProductos();
})
		
	
	
})