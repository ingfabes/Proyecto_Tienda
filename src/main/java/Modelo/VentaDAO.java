package Modelo;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class VentaDAO {

	Conexion cnn= new Conexion();
	Connection conec=cnn.conecta();
	PreparedStatement ps=null;
	ResultSet res=null;

	public int Registra_venta(VentaDTO VDTO) {
		int venta = 0;
		if(conec!=null) {
			try 
			{
				String sql = "insert into ventas (cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta) values(?,?,?,?,?)";
				ps = conec.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, VDTO.getCedula_cliente());
				ps.setInt(2, VDTO.getCedula_usuario());
				ps.setDouble(3, VDTO.getIvaventa());
				ps.setDouble(4, VDTO.getTotal_venta());
				ps.setDouble(5, VDTO.getValor_venta());
				if(ps.executeUpdate() > 0) 
				{	
					ResultSet rs = ps.getGeneratedKeys();
					while (rs.next()) 
					{
						venta = rs.getInt(1); 
						//JOptionPane.showMessageDialog(null,"la llave"+venta);
					}
					
					
				}
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"No se pudo registrar la venta en la base datos" +e);
			}
		}else {
			JOptionPane.showMessageDialog(null,"No se pudo conectar con la base de datos");
		}
		return venta;
	}

}