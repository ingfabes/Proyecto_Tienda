package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {
	private String bd="grupo25_equipo5";
	private String url="jdbc:mariadb://grupo25db2.c47knbsonjdi.us-east-2.rds.amazonaws.com:3306/"+bd;//"jdbc:mysql://localhost:3306/"+bd;
	private String user="admin";
	private String pass="Grupo25DB2";
	
	Connection conect=null;
	
	public Connection conecta() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conect=DriverManager.getConnection(url,user,pass);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "error de conexion:" + e);
			conect=null;
		}
		return conect;
	}
}
