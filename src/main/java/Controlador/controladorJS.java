package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import Modelo.ProductoDAO;
import Modelo.ProductoDTO;

/**
 * Servlet implementation class controladorJS
 */
@WebServlet("/controladorJS")
public class controladorJS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controladorJS() {
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
			
			ArrayList<ProductoDTO> lista= new ArrayList<>();
			lista=proDao.listarproductos();
			salida.println(datos.toJson(lista));
			//JOptionPane.showMessageDialog(null, "Json creado");
		}
		
	}

}
