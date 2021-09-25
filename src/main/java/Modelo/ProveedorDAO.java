/**
 * 
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

/**
 * @author root
 *
 */
public class ProveedorDAO {

	Conexion cn = new Conexion();
	Connection conect = cn.conecta();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public boolean Registra_proveedor(ProveedorDTO PDTO) {
		boolean registrado = false;
		ProveedorDTO prodto = null;
		try {
			prodto = Buscar_proveedor(PDTO.getNitproveedor());
			if (prodto == null) {
				String sql = "insert into proveedores values(?,?,?,?,?)";
				ps = conect.prepareStatement(sql);
				ps.setLong(1, PDTO.getNitproveedor());
				ps.setString(2, PDTO.getCiudad_proveedor());
				ps.setString(3, PDTO.getDireccion_proveedor());
				ps.setString(4, PDTO.getNombre_proveedor());
				ps.setString(5, PDTO.getTelefono_proveedor());
				registrado = ps.executeUpdate() > 0;
			} else {
				JOptionPane.showMessageDialog(null, "El proveedor ya existe");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Registrar: " + e);
		}
		return registrado;
	}

	public ProveedorDTO Buscar_proveedor(long nitproveedor) {
		ProveedorDTO PDTO = null;
		try {
			String sql = "select * from proveedores where nitproveedor=?";
			ps = conect.prepareStatement(sql);
			ps.setLong(1, nitproveedor);
			rs = ps.executeQuery();
			while (rs.next()) {
				PDTO = new ProveedorDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}
		} catch (SQLException s) {
			JOptionPane.showMessageDialog(null, "Error al consultar: " + s);
		}
		return PDTO;
	}
	

	public boolean Actualizar_usuario(ProveedorDTO PDTO) {
		boolean resultado = false;
		try {
			String sql = "update proveedores set ciudad_proveedor=?, direccion_proveedor=?, nombre_proveedor=?, telefono_proveedor=? where nitproveedor=?";
			ps = conect.prepareStatement(sql);
			ps.setString(1, PDTO.getCiudad_proveedor());
			ps.setString(2, PDTO.getDireccion_proveedor());
			ps.setString(3, PDTO.getNombre_proveedor());
			ps.setString(4, PDTO.getTelefono_proveedor());
			ps.setLong(5, PDTO.getNitproveedor());
			resultado = ps.executeUpdate() > 0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al actualizar: " + e);
		}
		return resultado;
	}
}
