package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Modelo.ProductoDAO;
import Modelo.ProductoDTO;
import Modelo.VentaDAO;
import Modelo.VentaDTO;

/**
 * Servlet implementation class controladorVenta
 */
@WebServlet("/controladorVenta")
public class controladorVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controladorVenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VentaDAO ventaDao= new VentaDAO();
		String op=request.getParameter("opcion");
		//JOptionPane.showMessageDialog(null, op);
		PrintWriter salida= response.getWriter();
		Gson datos= new Gson();
			
		if(op.equals("ventas")) {
			//JOptionPane.showMessageDialog(null, request.getParameter("codigo_producto"));
			int cedula_cliente = Integer.parseInt(request.getParameter("cedula_cliente"));
			int cedula_usuario = (Integer)request.getSession().getAttribute("cedula_usuario");
			double ivaventa = Double.parseDouble(request.getParameter("ivaventa"));
			double total_venta = Double.parseDouble(request.getParameter("total_venta"));
			double valor_venta = Double.parseDouble(request.getParameter("valor_venta"));
			VentaDTO ventaDto= new VentaDTO(cedula_cliente,cedula_usuario, ivaventa,total_venta,valor_venta);
			int llave = ventaDao.Registra_venta(ventaDto);
			String llaveJSON = "{\"llave\":\""+llave+"\"}";
			salida.println(datos.toJson(llaveJSON));
		}
	}

}
