package Modelo;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class DetalleVentaDAO {

	Conexion cnn= new Conexion();
	Connection conec=cnn.conecta();
	PreparedStatement ps=null;
	ResultSet res=null;

	public void Registra_detalleVenta(DetalleVentaDTO DVDTO) {
		if(conec!=null) {
			try 
			{
				String sql = "insert into detalle_ventas (cantidad_producto,codigo_producto,codigo_venta,valor_total,valor_venta,valoriva) values(?,?,?,?,?,?)";
				ps = conec.prepareStatement(sql);
				ps.setInt(1, DVDTO.getCantidad_producto());
				ps.setDouble(2, DVDTO.getCodigo_producto());
				ps.setDouble(3, DVDTO.getCodigo_venta());
				ps.setDouble(4, DVDTO.getValor_total());
				ps.setDouble(5, DVDTO.getValor_venta());
				ps.setDouble(6, DVDTO.getValoriva());
				if(ps.executeUpdate() > 0) 
				{	
					//JOptionPane.showMessageDialog(null,"ok detalle");
				}
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"No se pudo registrar el detalle de la venta en la base datos" +e);
			}
		}else {
			JOptionPane.showMessageDialog(null,"No se pudo conectar con la base de datos");
		}
	}

}