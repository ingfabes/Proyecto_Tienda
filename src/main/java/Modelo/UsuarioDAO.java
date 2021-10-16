package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.*;
import Modelo.*;

public class UsuarioDAO {

	Conexion cn = new Conexion();
	Connection conect = cn.conecta();
	PreparedStatement ps = null;
	ResultSet rs = null;
	private String Mnsje="";
	public static int cedula_usuario;
	
	public String getMnsje() {
		return Mnsje;
	}

	public void setMnsje(String mnsje) {
		Mnsje = mnsje;
	}

	public String Registra_usuario(UsuarioDTO UDTO) {
		String mensaje="";
		if(conect!=null) {
		UsuarioDTO usudto = null;
		try {
			usudto = Buscar_usuario(UDTO.getCedula());
			if (usudto == null) {
				String sql = "insert into usuarios values(?,?,?,?,?)";
				ps = conect.prepareStatement(sql);
				ps.setLong(1, UDTO.getCedula());
				ps.setString(2, UDTO.getEmail());
				ps.setString(3, UDTO.getNombre());
				ps.setString(4, UDTO.getPassword());
				ps.setString(5, UDTO.getUsuario());
				if(ps.executeUpdate() > 0) {
					mensaje="ok";
				}
			} else {
				mensaje= "El usuario ya existe";
			}

		} catch (Exception e) {
			mensaje="No se pudo registrar el usuario en la base datos";
		}
		}else {
			mensaje="No se pudo conectar con la base de datos";
		}
		return mensaje;
	}

	public UsuarioDTO Buscar_usuario(long cedula) {
		setMnsje("");
		UsuarioDTO UDTO = null;
		if(conect!=null) {
		try {
			String sql = "select * from usuarios where cedula_usuario=?";
			ps = conect.prepareStatement(sql);
			ps.setLong(1, cedula);
			rs = ps.executeQuery();
			while (rs.next()) {
				UDTO = new UsuarioDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}
			setMnsje("ok");
		} catch (SQLException s) {
			setMnsje("No se pudo establecer la consulta");
		}
		}else {
			setMnsje("No se pudo conectar con la base de datos");
		}
		return UDTO;
	}

	public boolean Actualizar_usuario(UsuarioDTO UDTO) {
		setMnsje("");
		boolean resultado = false;
		if(conect!=null) {
		try {
			String sql = "update usuarios set email_usuario=?, nombre_usuario=?, password=?, usuario=? where cedula_usuario=?";
			ps = conect.prepareStatement(sql);
			ps.setString(1, UDTO.getEmail());
			ps.setString(2, UDTO.getNombre());
			ps.setString(3, UDTO.getPassword());
			ps.setString(4, UDTO.getUsuario());
			ps.setLong(5, UDTO.getCedula());
			resultado = ps.executeUpdate() > 0;
		} catch (Exception e) {
			resultado=false;
		}
		}else {
			setMnsje("No se pudo conectar con la base de datos");
		}
		return resultado;
	}

	public boolean Eliminar_usuario(Long cedula) {
		boolean resultado=false;
		if(conect!=null) {
		try {
			String sql="delete from usuarios where cedula_usuario=?";
			ps=conect.prepareStatement(sql);
			ps.setLong(1, cedula);
			resultado=ps.executeUpdate()>0;
		}catch(Exception e) {
			resultado=false;
		}
		}else {
			setMnsje("No se pudo conectar con la base de datos");;
		}
		return resultado;
	}

	public boolean Login(String usuario, String contrasena) {
		boolean resultado=false;
		try {
			String sql="select * from usuarios where usuario=? and password=?";
			ps=conect.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, contrasena);
			rs=ps.executeQuery();
			while(rs.next()) {
				resultado=true;
				cedula_usuario = rs.getInt("cedula_usuario");
				//JOptionPane.showMessageDialog(null,"la cedula del usuario es "+cedula_usuario);
				
			}
		}catch(Exception e) {
			resultado=false;
		}
		return resultado;
	}
	public ArrayList<UsuarioDTO> listarusuarios(){
		
		UsuarioDTO usu=null;
		ArrayList<UsuarioDTO> lista= new ArrayList<>();
		try {
		String sql="select * from usuarios";
		ps=conect.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()) {
			usu=new UsuarioDTO(rs.getInt("cedula_usuario"),rs.getString("email_usuario"),rs.getString("nombre_usuario"),rs.getString("password"),rs.getString("usuario"));
			lista.add(usu);
		}
			
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error al consultar" +ex);
		}
		 return lista;
	}

	

}
