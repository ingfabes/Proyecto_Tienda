<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@include file="Pagina_principal.jsp"%>

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>

<script type="text/javascript" src="js/Cliente.js"></script>
<script type="text/javascript" src="js/Productos_venta.js"></script>

<body>
<table>
	<tr>
		<td><input type="number" placeholder="Ingrese Cédula del cliente" name="cedula" id="cedula"></td>
		<td><button id="buscaCliente" class="mainmenubtn"  >Buscar Cliente</button></td>
		<td><input type="text" placeholder="Nombre completo" name="nombre" id="nombre" readonly></td>
		<td><input type="text"  placeholder="consecutivo" name="consecutivo" id="consecutivo"></td>
	</tr>
	<tr>
		<td><input type="number" placeholder="Ingrese cod del producto" name="codigo_producto1" id="codigo_producto1"></td>
		<td><button id="busca_producto1" class="mainmenubtn2"  >Buscar Producto</button></td>
		<td><input type="text" placeholder="Nombre del Producto" name="nombre_producto1" id="nombre_producto1" readonly>
		<br><input type="text" placeholder="Precio del Producto" name="precio_producto1" id="precio_producto1" readonly>
		<br><input type="text" placeholder="IVA del Producto" name="iva_producto1" id="iva_producto1" readonly></td>
		<td><input type="number" placeholder="cantidad" name="cantidad_producto1" id="cantidad_producto1"></td>
		<td><input type="text" placeholder="valor total" name="valor_total1" id="valor_total1" readonly></td>
	</tr>
	<tr>
		<td><input type="number" placeholder="Ingrese cod del producto" name="codigo_producto2" id="codigo_producto2"></td>
		<td><button id="busca_producto2" class="mainmenubtn2"  >Buscar Producto</button></td>
		<td><input type="text" placeholder="Nombre del Producto" name="nombre_producto2" id="nombre_producto2" readonly>
		<br><input type="text" placeholder="Precio del Producto" name="precio_producto2" id="precio_producto2" readonly>
		<br><input type="text" placeholder="IVA del Producto" name="iva_producto2" id="iva_producto2" readonly></td>
		<td><input type="number" placeholder="cantidad" name="cantidad_producto2" id="cantidad_producto2"></td>
		<td><input type="text" placeholder="valor total" name="valor_total2" id="valor_total2" readonly></td>
	</tr>
	<tr>
		<td><input type="number" placeholder="Ingrese cod del producto" name="codigo_producto3" id="codigo_producto3"></td>
		<td><button id="busca_producto3" class="mainmenubtn2"  >Buscar Producto</button></td>
		<td><input type="text" placeholder="Nombre del Producto" name="nombre_producto3" id="nombre_producto3" readonly>
		<br><input type="text" placeholder="Precio del Producto" name="precio_producto3" id="precio_producto3" readonly>
		<br><input type="text" placeholder="IVA del Producto" name="iva_producto3" id="iva_producto3" readonly></td>
		<td><input type="number" placeholder="cantidad" name="cantidad_producto3" id="cantidad_producto3"></td>
		<td><input type="text" placeholder="valor total" name="valor_total3" id="valor_total3" readonly></td>
	</tr>
	
	<tr>
		<td></td><td></td><td></td><td>total Venta</td>
		<td><input type="text" placeholder="total venta" name="total_venta" id="total_venta" readonly></td>
	</tr>
	<tr>
		<td></td><td></td><td></td><td>total Iva</td>
		<td><input type="text" placeholder="total iva" name="ivaventa" id="ivaventa" readonly></td>
	</tr>
	<tr>
		<td></td><td></td><td><button id="confirmar" class="mainmenubtn2" >Confirmar</button></td>
		<td>total con Iva</td>
		<td><input type="text" placeholder="valor venta" name="valor_venta" id="valor_venta" readonly></td>
	</tr>

</table> 
 
</body>
</html>