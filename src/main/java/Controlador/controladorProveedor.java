package Controlador;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.ProveedorDAO;
import Modelo.ProveedorDTO;

/**
 * Servlet implementation class controladorProveedor
 */
@WebServlet("/controladorProveedor")
public class controladorProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controladorProveedor() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProveedorDAO PDAO = new ProveedorDAO();
		
		long nitproveedor;
		String nitproveedorS, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor;
		
		if (request.getParameter("crear") != null) {
			
			nitproveedorS = request.getParameter("nitproveedor");
			ciudad_proveedor = request.getParameter("ciudad_proveedor");
			direccion_proveedor = request.getParameter("direccion_proveedor");
			nombre_proveedor = request.getParameter("nombre_proveedor");
			telefono_proveedor = request.getParameter("telefono_proveedor");
			if (!nitproveedorS.equals("") && !ciudad_proveedor.equals("") && !direccion_proveedor.equals("") && !nombre_proveedor.equals("") && !telefono_proveedor.equals("")) {
				nitproveedor = Long.parseLong(nitproveedorS);
				ProveedorDTO PDTO = new ProveedorDTO(nitproveedor, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor);
				if (PDAO.Registra_proveedor(PDTO)) {
					response.sendRedirect("Gestion_proveedores.jsp?mens=Proveedor almacenado exitosamente");
				} else {
					response.sendRedirect("Gestion_proveedores.jsp?mens=El Proveedor no fue almacenado");
				}
			} else {
				response.sendRedirect("Gestion_proveedores.jsp?mens=Porfavor, llene todos los datos e intente nuevamente");
			}
		}

		if (request.getParameter("consultar") != null) {
			nitproveedorS = JOptionPane.showInputDialog("Digite el numero de Nit a consultar");
			if (nitproveedorS != null) {
				if (!nitproveedorS.isEmpty()) {
					nitproveedor = Long.parseLong(nitproveedorS);
					ProveedorDTO PDTO = PDAO.Buscar_proveedor(nitproveedor);
					if (PDTO != null) {
						nitproveedor = PDTO.getNitproveedor();
						ciudad_proveedor = PDTO.getCiudad_proveedor();
						direccion_proveedor = PDTO.getDireccion_proveedor();
						direccion_proveedor = URLEncoder.encode(direccion_proveedor, "UTF-8");
						nombre_proveedor = PDTO.getNombre_proveedor();
						telefono_proveedor = PDTO.getTelefono_proveedor();
						response.sendRedirect("Gestion_proveedores.jsp?nitproveedor=" + nitproveedor + "&&ciudad_proveedor=" + ciudad_proveedor + "&&direccion_proveedor="
								+ direccion_proveedor + "&&nombre_proveedor=" + nombre_proveedor + "&&telefono_proveedor=" + telefono_proveedor);
					} else {
						response.sendRedirect("Gestion_proveedores.jsp?mens=El proveedor no existe");
					}
				} else {
					response.sendRedirect("Gestion_proveedores.jsp?mens=Busqueda vacia");
				}

			} else if (nitproveedorS == null) {
				response.sendRedirect("Gestion_proveedores.jsp");
			}

		}

		if (request.getParameter("actualizar") != null) {
			nitproveedor = Long.parseLong(request.getParameter("nitproveedor"));
			ciudad_proveedor = request.getParameter("ciudad_proveedor");
			direccion_proveedor = request.getParameter("direccion_proveedor");
			nombre_proveedor = request.getParameter("nombre_proveedor");
			telefono_proveedor = request.getParameter("telefono_proveedor");
			ProveedorDTO PDTO = new ProveedorDTO(nitproveedor, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor);
			if (PDAO.Actualizar_usuario(PDTO)) {
				response.sendRedirect("Gestion_proveedores.jsp?mens=Proveedor actualizado exitosamente");
			} else {
				response.sendRedirect("Gestion_proveedores.jsp?mens=El Proveedor no fue actualizado");
			}

		}
		
	}

}
