package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ClienteDAO {

		Conexion cn = new Conexion();
		Connection conect = cn.conecta();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		public boolean Registrar_Cliente(ClienteDTO CDTO) {
			boolean registrado = false;
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
					
					registrado = ps.executeUpdate() > 0;
				} else {
					JOptionPane.showMessageDialog(null, "El cliente ya existe");
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al Registrar: " + e);
			}
			return registrado;
		}

		public ClienteDTO Buscar_Cliente(long cedula) {
			ClienteDTO CDTO = null;
			try {
				String sql = "select * from clientes where cedula_cliente=?";
				ps = conect.prepareStatement(sql);
				ps.setLong(1, cedula);
				rs = ps.executeQuery();
				while (rs.next()) {
					CDTO = new ClienteDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5));
				}
			} catch (SQLException s) {
				JOptionPane.showMessageDialog(null, "Error al consultar: " + s);
			}
			return CDTO;
		}

		public boolean Actualizar_Cliente(ClienteDTO CDTO) {
			boolean resultado = false;
			try {
				String sql = "update clientes set nombre_cliente=?, direccion_cliente=?, telefono_cliente=?, email_cliente=? where cedula_cliente=?";
				
				
				ps = conect.prepareStatement(sql);
				ps.setString(1, CDTO.getNombre_completo());
				ps.setString(2, CDTO.getDireccion());
				ps.setString(3, CDTO.getTelefono());
				ps.setString(4, CDTO.getCorreoelectronico());
				ps.setLong(5, CDTO.getCedula());
				
				resultado = ps.executeUpdate() > 0;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al actualizar: " + e);
			}
			return resultado;
		}

		public boolean Eliminar_Cliente(Long cedula) {
			boolean resultado=false;
			try {
				String sql="delete from clientes where cedula_cliente=?";
				ps=conect.prepareStatement(sql);
				ps.setLong(1, cedula);
				resultado=ps.executeUpdate()>0;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Error al eliminar: "+e);
			}
			return resultado;
		}

		
		}
		


