$(document).ready(function(){

function buscaProducto(producto){
	
     $.ajax({
	type:"post",
	url:"controladorJSProductos",
	dataType:"json",
	beforeSend:function(){
     //alert("#codigo_"+producto);
  	},
	data:{opcion:"productos", codigo_producto:$("#codigo_"+producto).val()},
	success: function(result){
		console.log(result) //Imprime Json en la consola
		var nombre=document.getElementById("nombre_"+producto)
		var cantidad=document.getElementById("cantidad_"+producto)
		var precio=document.getElementById("precio_"+producto)
		var iva=document.getElementById("iva_"+producto)
			if(result==null)
			{
				alert("El producto no existe");
				nombre.value="";
				cantidad.value="";
				precio.value="";

			}
			else
			{
				//alert("El documento existe");
				nombre.value=JSON.stringify(result.nombre_producto).replace(/['"]+/g, '');
				//cantidad.value="0";
				precio.value=JSON.stringify(result.precio_venta).replace(/['"]+/g, '');
				iva.value=JSON.stringify(result.ivacompra).replace(/['"]+/g, '');
				
			}
		}
	})
}

function guardaVenta(){
	//alert("entra a guardar");

	$.ajax({
	type:"post",
	url:"controladorVenta",
	dataType:"json",
	beforeSend:function(){
     //alert("entro al ajax");
  	},
	data:{opcion:"ventas",
		cedula_cliente:$("#cedula").val(),
		ivaventa:$("#ivaventa").val(),
		valor_venta:$("#valor_venta").val(),
		total_venta:$("#total_venta").val()
		},
	success: function(result){
		//alert("entro al success");
		var consecutivo=document.getElementById("consecutivo")
		console.log(result) //Imprime Json en la consola
			if(result==null)
			{
				alert("error con la llave");

			}
			else
			{
				var datos = JSON.parse(result);
				consecutivo.value=datos.llave;
				//alert("la llave es " + datos.llave);
				guardaDetalleVenta(datos.llave)
					
			}
		}
	})
	
}

function guardaDetalleVenta(llave){
	//alert("entra a guardardetalle");
	
	for (j=1;j<=3;j++) {
	
		$.ajax({
		type:"post",
		url:"controladorDetalleVenta",
		dataType:"json",
		beforeSend:function(){
	     //alert("entro al ajax");
	  	},
		data:{opcion:"detalleVentas",
			cantidad_producto:$("#cantidad_producto"+j).val(),
			codigo_producto:$("#codigo_producto"+j).val(),
			codigo_venta:llave,
			valor_total:$("#precio_producto"+j).val(),
			valor_venta:$("#valor_total"+j).val(),
			valoriva:$("#iva_producto"+j).val()
			},
		success: function(result){
			//alert("entro al success");
			console.log(result) //Imprime Json en la consola
				if(result==null)
				{
					alert("error con la llave");
	
				}
				else
				{
					var datos = JSON.parse(result);
					//alert("la llave es " + datos.llave);
					
						
				}
			}
		})
	}
	alert("la factura  " + llave +" creada");
	
}



	$('.mainmenubtn2').on('click',function(){
		//alert("Entro a boton " + this.id)
		var boton = this.id;
		var producto = boton.replace("busca_","");
		if(this.id!="confirmar")
		{
			
			//alert("producto es " + producto)	
			buscaProducto(producto);
			
		}
		else
		{
			var valor_venta = 0;
			for (i=1;i<=3;i++) {
				//alert($("#cantidad_producto"+i).val());
				if($("#nombre").val()== "" )
				{
					alert("debe buscar un cliente");
					break;
				}
				else if($("#cantidad_producto"+i).val() == "" )
				{
					alert("debe poner cantidades en producto "+i);
					break;
				}
				else if($("#cantidad_producto"+i).val() <= 0)
				{
					alert("las cantidades deben ser mayor que cero en producto "+i);
					break;
				}
				else
				{
					var valor_total=document.getElementById("valor_total"+i);
					valor_total.value = $("#cantidad_producto"+i).val() * $("#precio_producto"+i).val();
					if(valor_total.value == 0)
					{
						alert("debe buscar el producto"+i);		
						break;
					}
					else
					{
						//alert("se sumó "+valor_total.value);
						valor_venta =valor_venta+parseFloat(valor_total.value);
						
					}
				}
				if(i==3)//si terminó el for sin breaks
				{
					document.getElementById("valor_venta").value =valor_venta;
					document.getElementById("total_venta").value =Math.round(valor_venta*0.81);
					document.getElementById("ivaventa").value =valor_venta-Math.round(valor_venta*0.81);
					//alert("hasta aca bien");
				    guardaVenta();			
				}
				
			}
		}
	});		
	
})