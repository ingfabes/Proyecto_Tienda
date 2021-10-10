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
	
public boolean Cargar_Producto(String Ruta) {
	
		
		boolean resul=false;
		
		try {
		String sql="delete from productos";
		ps = conec.prepareStatement(sql);
		ps.executeUpdate();
			
			
		String sql2="load data infile '"+Ruta+"' into table productos fields terminated by ',' lines terminated by '\r\n';";
		//String sql2="load data infile '"+Ruta+"' into table productos fields terminated by ',' lines terminated by '\n';";
		//para linux no borrar.
		ps=conec.prepareStatement(sql2);
		resul=ps.executeUpdate()>0;
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al Cargar :   "+ex);
		}
		
		return resul;
	}

public ArrayList<ProductoDTO> listarproductos(){
	
	ProductoDTO pro=null;
	ArrayList<ProductoDTO> lista= new ArrayList<>();
	try {
	String sql="select * from productos";
	ps=conec.prepareStatement(sql);
	res=ps.executeQuery();
	while(res.next()) {
		pro=new ProductoDTO(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getInt(5),res.getInt(6));
		lista.add(pro);
	}
		
	}catch(SQLException ex) {
		JOptionPane.showMessageDialog(null,"Error al consultar prestamos" +ex);
	}
	 return lista;
}

}