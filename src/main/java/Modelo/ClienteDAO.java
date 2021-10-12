package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controlador.Conexion;

public class ClienteDAO {

		Conexion cn = new Conexion();
		Connection conect = cn.conecta();
		PreparedStatement ps = null;
		ResultSet rs = null;
		private String Mnsje="";

		public String getMnsje() {
			return Mnsje;
		}

		public void setMnsje(String mnsje) {
			Mnsje = mnsje;
		}
		
		public String Registrar_Cliente(ClienteDTO CDTO) {
			String mensaje="";
			if(conect!=null) {
			ClienteDTO clidto = null;
			try {
				clidto = Buscar_Cliente(CDTO.getCedula());
				if (clidto == null) {
					String sql = "insert into clientes values(?,?,?,?,?)";
					ps = conect.prepareStatement(sql);
					ps.setLong(1, CDTO.getCedula());
					ps.setString(2, CDTO.getDireccion());
					ps.setString(3, CDTO.getCorreoelectronico());
					ps.setString(4, CDTO.getNombre_completo());			
					ps.setString(5, CDTO.getTelefono());
					
					if(ps.executeUpdate() > 0) {
						mensaje="ok";
					}
				} else {
					mensaje= "El cliente ya existe";
				}

			} catch (Exception e) {
				mensaje="No se pudo registrar el cliente en la base datos";
			}
			}else {
				mensaje="No se pudo conectar con la base de datos";
			}
			return mensaje;
		}

		public ClienteDTO Buscar_Cliente(long cedula) {
			setMnsje("");
			ClienteDTO CDTO = null;
			if(conect!=null) {
			try {
				String sql = "select * from clientes where cedula_cliente=?";
				ps = conect.prepareStatement(sql);
				ps.setLong(1, cedula);
				rs = ps.executeQuery();
				while (rs.next()) {
					CDTO = new ClienteDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5));
				}
				setMnsje("ok");
			} catch (SQLException s) {
				setMnsje("No se pudo establecer la consulta");
			}
			}else {
				setMnsje("No se pudo conectar con la base de datos");;
			}
			return CDTO;
		}

		public boolean Actualizar_Cliente(ClienteDTO CDTO) {
			setMnsje("");
			boolean resultado = false;
			if(conect!=null) {
			try {
				String sql = "update clientes set direccion_cliente=?, email_cliente=?, nombre_cliente=?, telefono_cliente=? where cedula_cliente=?";
				
				
				ps = conect.prepareStatement(sql);
				ps.setString(1, CDTO.getDireccion());
				ps.setString(2, CDTO.getCorreoelectronico());
				ps.setString(3, CDTO.getNombre_completo());			
				ps.setString(4, CDTO.getTelefono());
				ps.setLong(5, CDTO.getCedula());
				
				resultado = ps.executeUpdate() > 0;
			} catch (Exception e) {
				resultado=false;
			}
			}else {
				setMnsje("No se pudo conectar con la base de datos");
			}
			return resultado;
		}

		public boolean Eliminar_Cliente(Long cedula) {
			boolean resultado=false;
			if(conect!=null) {
			try {
				String sql="delete from clientes where cedula_cliente=?";
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

		
		}
		


