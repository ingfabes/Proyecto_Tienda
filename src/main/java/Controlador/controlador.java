package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;

/**
 * Servlet implementation class controlador
 */
@WebServlet("/controlador")
public class controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controlador() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO UDAO= new UsuarioDAO();
		
		if(request.getParameter("ingresar")!=null) {
			String usuario, password;
			usuario=request.getParameter("username");
			password=request.getParameter("password");
			if(UDAO.Login(usuario, password)) {
				response.sendRedirect("Pagina_principal.jsp");
			}else {
				response.sendRedirect("Login.jsp?mens=Datos invalidos");
			}
		}
		
		if(request.getParameter("crear")!=null) {
			long cedula;
			String ced, email, nombre, password, usuario;
			ced=request.getParameter("cedula");
			email=request.getParameter("correo");
			nombre=request.getParameter("nombre");
			password=request.getParameter("password");
			usuario=request.getParameter("usuario");
			if(!ced.equals("") && !nombre.equals("") && !password.equals("") && !usuario.equals("")) {
			cedula=Long.parseLong(ced);
			UsuarioDTO UDTO= new UsuarioDTO(cedula,email,nombre,password,usuario);
			if(UDAO.Registra_usuario(UDTO)) {
				response.sendRedirect("Gestion_usuarios.jsp?mens=Usuario almacenado exitosamente");
			}else {
				response.sendRedirect("Gestion_usuarios.jsp?mens=El usuario no fue almacenado");
			}
		} else {
			response.sendRedirect("Gestion_usuarios.jsp?mens=Porfavor, llene todos los datos e intente nuevamente");
		}
	}
		
		if(request.getParameter("consultar")!=null) {
			String cedu=JOptionPane.showInputDialog("Digite el numero de cedula a consultar");
			if(cedu!=null) {
				if(!cedu.isEmpty()) {
					Long cedula= Long.parseLong(cedu);
					UsuarioDTO UDTO=UDAO.Buscar_usuario(cedula);
					if(UDTO!=null) {
					long ced;
					String email, nombre, password, usuario;
					ced=UDTO.getCedula();
					email=UDTO.getEmail();
					nombre=UDTO.getNombre();
					password=UDTO.getPassword();
					usuario=UDTO.getUsuario();
					response.sendRedirect("Gestion_usuarios.jsp?ced="+ced+"&&correo="+email+"&&nomb="+nombre+"&&pass="+password+"&&usuario="+usuario);
					}else {
						response.sendRedirect("Gestion_usuarios.jsp?mens=El usuario no existe");
					}
				}else {
					response.sendRedirect("Gestion_usuarios.jsp?mens=Busqueda vacia");
				}
				
			}else if (cedu==null){
				response.sendRedirect("Gestion_usuarios.jsp");
			}
		
		}
		
		if(request.getParameter("actualizar")!=null) {
			long ced;
			String email, nombre, password, usuario;
			ced=Long.parseLong(request.getParameter("ced"));
			email=request.getParameter("correo");
			nombre=request.getParameter("nombre");
			password=request.getParameter("password");
			usuario=request.getParameter("usuario");
			UsuarioDTO UDTO= new UsuarioDTO(ced,email,nombre,password,usuario);
			if(UDAO.Actualizar_usuario(UDTO)) {
				response.sendRedirect("Gestion_usuarios.jsp?mens=Usuario actualizado exitosamente");
			}else {
				response.sendRedirect("Gestion_usuarios.jsp?mens=El Usuario no fue actualizado");
			}
			
		}
		
		if(request.getParameter("borrar")!=null) {
			long cedula = Long.parseLong(request.getParameter("ced"));
			int op=JOptionPane.showConfirmDialog(null, "desea eliminar el usuario con cedula: "+cedula);
			if(op==0) {
			if(UDAO.Eliminar_usuario(cedula)) {
				response.sendRedirect("Gestion_usuarios.jsp?mens=Usuario eliminado exitosamente");
			}else {
				response.sendRedirect("Gestion_usuarios.jsp?mens=El Usuario no fue eliminado");
			}
			
			}else if (op==1 || op==2){
				response.sendRedirect("Gestion_usuarios.jsp");
			}
			
		}
		
		if(request.getParameter("usu")!=null){
			response.sendRedirect("Gestion_usuarios.jsp");
		}
}
}
