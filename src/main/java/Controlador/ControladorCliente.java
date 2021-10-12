package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
				ClienteDTO CDTO = new ClienteDTO (cedula, direccion, correo, nombre, telefono);
				String mensaje=CDAO.Registrar_Cliente(CDTO);
				if (mensaje.equals("ok")) {
					response.sendRedirect("Gestion_Clientes.jsp?titulo=Registro exitoso&&mens=Cliente almacenado correctamente&&icono=success");
				} else {
					response.sendRedirect("Gestion_Clientes.jsp?titulo=No se pudo registrar el cliente&&mens="+mensaje+"&&icono=error");
				}
			} else {
				response.sendRedirect("Gestion_Clientes.jsp?mens=Por favor, diligencie los datos e intentelo nuevamente");
			}
		}

		if (request.getParameter("Buscar") != null) {
					Long cedu = Long.parseLong(request.getParameter("ced"));
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
						 if(CDAO.getMnsje().equals("ok")){
								response.sendRedirect("Gestion_Clientes.jsp?titulo=No se encontraron resultados en la busqueda&&mens=El cliente no existe&&icono=warning");
						 }else {
						response.sendRedirect("Gestion_Clientes.jsp?titulo=Error&&mens="+CDAO.getMnsje()+"&&icono=error");
					}
					}
			}

 
		if (request.getParameter("Actualizar") != null) {
			long cedu;
			String cedula, nombre, direccion, telefono, correo;
			
			cedula = request.getParameter("ced");
			correo = request.getParameter("correo");
			nombre = request.getParameter("nombre");
			direccion = request.getParameter("direccion");
			telefono = request.getParameter("telefono");
			cedu= Long.parseLong(cedula);
			
			ClienteDTO CDTO = new ClienteDTO(cedu, nombre, direccion, telefono, correo);
		
			if (CDAO.Actualizar_Cliente(CDTO)) {
				response.sendRedirect("Gestion_Clientes.jsp?titulo=Actualizacion exitosa&&mens=Cliente actualizado correctamentee&&icono=success");
			} else {
				response.sendRedirect("Gestion_Clientes.jsp?titulo=Error&&mens=El cliente no fue actualizado&&icono=error");
			}

		}

		if (request.getParameter("Eliminar") != null) {
			long cedu = Long.parseLong(request.getParameter("ced"));
				if (CDAO.Eliminar_Cliente(cedu)) {
					response.sendRedirect("Gestion_Clientes.jsp?titulo=Eliminacion exitosa&&mens=Cliente eliminado correctamente&&icono=success");
				} else {
					response.sendRedirect("Gestion_Clientes.jsp?titulo=Error&&mens=El ciente no fue eliminado&&icono=error");
				}


		}
	}
}


