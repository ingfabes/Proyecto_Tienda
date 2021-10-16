package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Modelo.DetalleVentaDAO;
import Modelo.DetalleVentaDTO;
import Modelo.ProductoDAO;
import Modelo.ProductoDTO;
import Modelo.VentaDAO;
import Modelo.VentaDTO;

/**
 * Servlet implementation class controladorVenta
 */
@WebServlet("/controladorDetalleVenta")
public class controladorDetalleVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controladorDetalleVenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DetalleVentaDAO detalleVentaDao= new DetalleVentaDAO();
		String op=request.getParameter("opcion");
		//JOptionPane.showMessageDialog(null, op);
		PrintWriter salida= response.getWriter();
		Gson datos= new Gson();
			
		if(op.equals("detalleVentas")) {
			//JOptionPane.showMessageDialog(null, request.getParameter("codigo_producto"));
			int cantidad_producto = Integer.parseInt(request.getParameter("cantidad_producto"));
			int codigo_producto = Integer.parseInt(request.getParameter("codigo_producto"));
			int codigo_venta = Integer.parseInt(request.getParameter("codigo_venta"));
			double valor_total = Double.parseDouble(request.getParameter("valor_total"));
			double valor_venta = Double.parseDouble(request.getParameter("valor_venta"));
			double valoriva = Double.parseDouble(request.getParameter("valoriva"));
			DetalleVentaDTO detalleVentaDto= new DetalleVentaDTO(cantidad_producto,codigo_producto, codigo_venta,valor_total,valor_venta,valoriva);
			detalleVentaDao.Registra_detalleVenta(detalleVentaDto);
			//String llaveJSON = "{\"llave\":\""+llave+"\"}";
			//salida.println(datos.toJson(llaveJSON));
		}
	}

}
