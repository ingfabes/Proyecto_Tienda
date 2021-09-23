package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class UsuarioDAO {
	
	Conexion cn= new Conexion();
	Connection conect=cn.conecta();
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public boolean Registra_usuario(UsuarioDTO UDTO) {
		boolean registrado=false;
		UsuarioDTO usudto=null;
		try {
			usudto=Buscar_usuario(UDTO.getCedula());
			if(usudto==null) {
			String sql="insert into usuarios values(?,?,?,?,?)";
			ps=conect.prepareStatement(sql);
			ps.setLong(1, UDTO.getCedula());
			ps.setString(2, UDTO.getEmail());
			ps.setString(3, UDTO.getNombre());
			ps.setString(4, UDTO.getPassword());
			ps.setString(5, UDTO.getUsuario());
			registrado=ps.executeUpdate()>0;
			}else {
				JOptionPane.showMessageDialog(null, "El usuario ya existe");
			}
		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Registrar: "+e);
	}
		return registrado;	
}
	
	public UsuarioDTO Buscar_usuario(long cedula) {
		UsuarioDTO UDTO=null;
		try {
			String sql="select * from usuarios where cedula_usuario=?";
			ps=conect.prepareStatement(sql);
			ps.setLong(1, cedula);
			rs=ps.executeQuery();
			while(rs.next()) {
			UDTO=new UsuarioDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		}catch(SQLException s){
			JOptionPane.showMessageDialog(null, "Error al consultar: "+s);
		}
		return UDTO;
	}
	
	public boolean Actualizar_usuario(UsuarioDTO UDTO) {
		boolean resultado=false;
		try {
			String sql="update usuarios set email_usuario=?, nombre_usuario=?, password=?, usuario=? where cedula_usuario=?";
			ps=conect.prepareStatement(sql);
			ps.setString(1, UDTO.getEmail());
			ps.setString(2, UDTO.getNombre());
			ps.setString(3, UDTO.getPassword());
			ps.setString(4, UDTO.getUsuario());
			ps.setLong(5, UDTO.getCedula());
			resultado=ps.executeUpdate()>0;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al actualizar: "+e);
		}
		return resultado;
	}
	
	public boolean Eliminar_usuario(Long cedula) {
		boolean resultado=false;
		try {
			String sql="delete from usuarios where cedula_usuario=?";
			ps=conect.prepareStatement(sql);
			ps.setLong(1, cedula);
			resultado=ps.executeUpdate()>0;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar: "+e);
		}
		return resultado;
	}
	
	public boolean Login(String usuario, String contraseña) {
		boolean resultado=false;
		try {
			String sql="select * from usuarios where usuario=? and password=?";
			ps=conect.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, contraseña);
			rs=ps.executeQuery();
			while(rs.next()) {
				resultado=true;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al consultar: "+e);
		}
		return resultado;
	}
	


}
	
	
