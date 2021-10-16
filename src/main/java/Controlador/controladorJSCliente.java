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

/**
 * Servlet implementation class controladorJSCliente
 */
@WebServlet("/controladorJSCliente")
public class controladorJSCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controladorJSCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDAO cliDao= new ClienteDAO();

		String op=request.getParameter("opcion");
		//JOptionPane.showMessageDialog(null, op);
		PrintWriter salida= response.getWriter();
		Gson datos= new Gson();
		
		
		if(op.equals("cliente")) {
			Long cedu = Long.parseLong(request.getParameter("cedula"));
			//JOptionPane.showMessageDialog(null, cedu);
			ClienteDTO CDTO = cliDao.Buscar_Cliente(cedu);
			//JOptionPane.showMessageDialog(null, "control:" + CDTO.toString());
			salida.println(datos.toJson(CDTO));
			//JOptionPane.showMessageDialog(null, "Json creado");
		}
		
	}

}
