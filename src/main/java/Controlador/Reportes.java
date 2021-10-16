package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import Modelo.*;




/**
 * Servlet implementation class Reportes
 */
@WebServlet("/Reportes")
public class Reportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reportes() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO usuDao= new UsuarioDAO();
		ClienteDAO cliDao= new ClienteDAO();
		VentaDAO venDao= new VentaDAO();

		String op=request.getParameter("opcion");
		//JOptionPane.showMessageDialog(null, op);
		PrintWriter salida= response.getWriter();
		Gson datos= new Gson();
		
		
		if(op.equals("usuarios")) {
			
			ArrayList<UsuarioDTO> lista= new ArrayList<>();
			lista=usuDao.listarusuarios();
			salida.println(datos.toJson(lista));
			//JOptionPane.showMessageDialog(null, "Json creado");
		
		}
		else if(op.equals("clientes")) {
			
			ArrayList<ClienteDTO> lista= new ArrayList<>();
			lista=cliDao.listarclientes();
			salida.println(datos.toJson(lista));
			//JOptionPane.showMessageDialog(null, "Json creado");
		
		}
        else if(op.equals("ventas")) {
			
			ArrayList<VentaDTO> lista= new ArrayList<>();
			lista=venDao.listarventas();
			salida.println(datos.toJson(lista));
			//JOptionPane.showMessageDialog(null, "Json creado");
		
		}
		
		
	

}}
