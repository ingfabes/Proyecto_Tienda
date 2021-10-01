package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;



import Modelo.ClienteDTO;
import Modelo.ClienteDAO;

/**
 * Servlet implementation class ControladorCliente
 */
 @WebServlet("/ControladorCliente")
 
public class ControladorCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	public ControladorCliente() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClienteDAO CDAO = new ClienteDAO();

		 
		
		if (request.getParameter("Registrar") != null) {
			long cedula;
			String cedu, nombre, direccion, telefono, correo;
			
			cedu = request.getParameter("cedula");
			nombre = request.getParameter("nombre");
			direccion = request.getParameter("direccion");
			telefono = request.getParameter("telefono");
			correo = request.getParameter("correo");
			if (!cedu.equals("") && !nombre.equals("") && !direccion.equals("") && !telefono.equals("") && !correo.equals("")) {
				cedula = Long.parseLong(cedu);
				ClienteDTO CDTO = new ClienteDTO (cedula, nombre, direccion, telefono, correo);
				if (CDAO.Registrar_Cliente(CDTO)) {
					response.sendRedirect("Gestion_Clientes.jsp?mens=Cliente registrado exitosamente");
				} else {
					response.sendRedirect("Gestion_Clientes.jsp?mens=El cliente no fue registrado");
				}
			} else {
				response.sendRedirect("Gestion_Clientes.jsp?mens=Por favor, diligencie los datos e intentelo nuevamente");
			}
		}

		if (request.getParameter("Buscar") != null) {
			String cedula = JOptionPane.showInputDialog("Digite el numero de cedula a consultar");
			if (cedula != null) {
				if (!cedula.isEmpty()) {
					Long cedu = Long.parseLong(cedula);
					ClienteDTO CDTO = CDAO.Buscar_Cliente(cedu);
					if (CDTO != null) {
						
						String nombre, direccion, telefono, correo;
						cedu = CDTO.getCedula();
						nombre = CDTO.getNombre_completo();
						direccion = CDTO.getDireccion();
						telefono = CDTO.getTelefono();
						correo = CDTO.getCorreoelectronico();
						response.sendRedirect("Gestion_Clientes.jsp?cedula=" + cedu + "&&nombre=" + nombre + "&&direccion="
								+ direccion + "&&telefono=" + telefono + "&&correo=" + correo);
					} else {
						response.sendRedirect("Gestion_Clientes.jsp?mens=El cliente no existe");
					}
				} else {
					response.sendRedirect("Gestion_Clientes.jsp?mens=Busqueda vacia");
				}

			} else if (cedula == null) {
				response.sendRedirect("Gestion_Clientes.jsp");
			}

		}
 
		if (request.getParameter("Actualizar") != null) {
			long cedu;
			String cedula, nombre, direccion, telefono, correo;
			
			cedula = request.getParameter("cedula");
			correo = request.getParameter("correo");
			nombre = request.getParameter("nombre");
			direccion = request.getParameter("direccion");
			telefono = request.getParameter("telefono");
			cedu= Long.parseLong(cedula);
			
			ClienteDTO CDTO = new ClienteDTO(cedu, nombre, direccion, telefono, correo);
		
			if (CDAO.Actualizar_Cliente(CDTO)) {
				response.sendRedirect("Gestion_Clientes.jsp?mens=Cliente actualizado exitosamente");
			} else {
				response.sendRedirect("Gestion_Clientes.jsp?mens=El cliente no fue actualizado");
			}

		}

		if (request.getParameter("Eliminar") != null) {
			long cedu = Long.parseLong(request.getParameter("cedula"));
			int opcion = JOptionPane.showConfirmDialog(null, "Desea eliminar el cliente con cedula: " + cedu);
			if (opcion == 0) {
				if (CDAO.Eliminar_Cliente(cedu)) {
					response.sendRedirect("Gestion_Clientes.jsp?mens=Cliente eliminado exitosamente");
				} else {
					response.sendRedirect("Gestion_Clientes.jsp?mens=El cliente no fue eliminado");
				}

			} else if (opcion == 1 || opcion == 2) {
				response.sendRedirect("Gestion_Clientes.jsp");
			}

		}
	}
}


