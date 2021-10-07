package Modelo;

import java.sql.*;


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



}