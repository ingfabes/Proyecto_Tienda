package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	private String bd="tiendagenerica";
	private String url="jdbc:mysql://localhost:3306/"+bd;
	private String user="root";
	private String pass="admin";
	
	Connection conect=null;
	
	public Connection conecta() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conect=DriverManager.getConnection(url,user,pass);
		}catch(Exception e) {
			conect=null;
		}
		return conect;
	}
}
