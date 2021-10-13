package Modelo;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ProductoDAO {

	Conexion cnn= new Conexion();
	Connection conec=cnn.conecta();
	PreparedStatement ps=null;
	ResultSet res=null;
	
public String Cargar_Producto(String Ruta) {
	
		
		String mensaje="";
		
		try {
		String sql="delete from productos";
		ps = conec.prepareStatement(sql);
		ps.executeUpdate();
			
			
		String sql2="load data infile '"+Ruta+"' into table productos fields terminated by ',' lines terminated by '\r\n';";
		//String sql2="load data infile '"+Ruta+"' into table productos fields terminated by ',' lines terminated by '\n';";
		//para linux no borrar.
		ps=conec.prepareStatement(sql2);
		if(ps.executeUpdate()>0) {
			mensaje="ok";
		}
		}catch(SQLException ex) {
			if(ex.getErrorCode()==1452) {
				mensaje="Hay proveedores que no existen en la base de datos";
			}else if(ex.getErrorCode()==1262) {
				mensaje="El numero de campos a registrar no concuerda con los de la base de datos";
			}else if(ex.getErrorCode()==1062) {
				mensaje="Hay codigos del producto duplicados, por favor verificar el archivo";
			}else if(ex.getErrorCode()==1265) {
				mensaje="datos leidos invalidos, verifique";
			}else if(ex.getErrorCode()==1366) {
				mensaje="Hay campos obligatorios vacios o con caracteres no permitidos, verifique";
			}
			
		}
		
		return mensaje;
	}

public ArrayList<ProductoDTO> listarproductos(){
	
	ProductoDTO pro=null;
	ArrayList<ProductoDTO> lista= new ArrayList<>();
	try {
	String sql="select * from productos";
	ps=conec.prepareStatement(sql);
	res=ps.executeQuery();
	while(res.next()) {
		pro=new ProductoDTO(res.getInt("codigo_producto"),res.getInt("ivacompra"),res.getInt("nitproveedor"),res.getString("nombre_producto"),res.getInt("precio_compra"),res.getInt("precio_venta"));
		lista.add(pro);
	}
		
	}catch(SQLException ex) {
		JOptionPane.showMessageDialog(null,"Error al consultar prestamos" +ex);
	}
	 return lista;
}

}