package Controlador;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
				String mensaje=PDAO.Registra_proveedor(PDTO);
				if (mensaje.equals("ok")) {
					response.sendRedirect("Gestion_proveedores.jsp?titulo=Registro exitoso&&mens=Proveedor almacenado correctamente&&icono=success");
				} else {
					response.sendRedirect("Gestion_proveedores.jsp?titulo=No se pudo registrar el proveedor&&mens="+mensaje+"&&icono=error");
				}
			} else {
				response.sendRedirect("Gestion_proveedores.jsp?mens=Porfavor, llene todos los datos e intente nuevamente");
			}
		}

		if (request.getParameter("consultar") != null) {
					nitproveedor = Long.parseLong(request.getParameter("ced"));
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
						if(PDAO.getMnsje().equals("ok")){
							response.sendRedirect("Gestion_proveedores.jsp?titulo=No se encontraron resultados en la busqueda&&mens=El proveedor no existe&&icono=warning");
					 }else {
					response.sendRedirect("Gestion_proveedores.jsp?titulo=Error&&mens="+PDAO.getMnsje()+"&&icono=error");
				}
					}

		}

		if (request.getParameter("actualizar") != null) {
			nitproveedor = Long.parseLong(request.getParameter("ced"));
			ciudad_proveedor = request.getParameter("ciudad_proveedor");
			direccion_proveedor = request.getParameter("direccion_proveedor");
			nombre_proveedor = request.getParameter("nombre_proveedor");
			telefono_proveedor = request.getParameter("telefono_proveedor");
			ProveedorDTO PDTO = new ProveedorDTO(nitproveedor, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor);
			if (PDAO.Actualizar_proveedor(PDTO)) {
				response.sendRedirect("Gestion_proveedores.jsp?titulo=Actualizacion exitosa&&mens=Proveedor actualizado correctamentee&&icono=success");
			} else {
				response.sendRedirect("Gestion_proveedores.jsp?titulo=Error&&mens=El usuario no fue actualizado&&icono=error");
			}

		}
		
	}

}
