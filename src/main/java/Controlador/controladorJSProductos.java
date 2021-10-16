package Controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.ProductoDAO;
import Modelo.ProductoDTO;

/**
 * Servlet implementation class controladorJSCliente
 */
@WebServlet("/controladorJSProductos")
public class controladorJSProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controladorJSProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoDAO proDao= new ProductoDAO();

		String op=request.getParameter("opcion");
		//JOptionPane.showMessageDialog(null, op);
		PrintWriter salida= response.getWriter();
		Gson datos= new Gson();
		
		
		if(op.equals("productos")) {
			//JOptionPane.showMessageDialog(null, request.getParameter("codigo_producto"));
			int codigo_producto = Integer.parseInt(request.getParameter("codigo_producto"));
			ProductoDTO PDTO = proDao.Buscar_producto(codigo_producto);
			salida.println(datos.toJson(PDTO));
		}
		
	}

}
