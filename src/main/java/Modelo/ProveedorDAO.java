/**
 * 
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	private String Mnsje="";

	public String getMnsje() {
		return Mnsje;
	}

	public void setMnsje(String mnsje) {
		Mnsje = mnsje;
	}
	
	public String Registra_proveedor(ProveedorDTO PDTO) {
		String mensaje="";
		if(conect!=null) {
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
				if(ps.executeUpdate() > 0) {
					mensaje="ok";
				}
			} else {
				mensaje= "El proveedor ya existe";
			}

		} catch (Exception e) {
			mensaje="No se pudo registrar el proveedor en la base datos";
		}
		}else {
			mensaje="No se pudo conectar con la base de datos";
		}
		return mensaje;
	}

	public ProveedorDTO Buscar_proveedor(long nitproveedor) {
		setMnsje("");
		ProveedorDTO PDTO = null;
		if(conect!=null) {
		try {
			String sql = "select * from proveedores where nitproveedor=?";
			ps = conect.prepareStatement(sql);
			ps.setLong(1, nitproveedor);
			rs = ps.executeQuery();
			while (rs.next()) {
				PDTO = new ProveedorDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}
			setMnsje("ok");
		} catch (SQLException s) {
			setMnsje("No se pudo establecer la consulta");
		}
		}else {
			setMnsje("No se pudo conectar con la base de datos");;
		}
		return PDTO;
	}
	

	public boolean Actualizar_proveedor(ProveedorDTO PDTO) {
		boolean resultado = false;
		if(conect!=null) {
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
			resultado=false;
		}
		}else {
			setMnsje("No se pudo conectar con la base de datos");;
		}
		return resultado;
	}
}
