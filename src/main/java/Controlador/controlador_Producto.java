package Controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import Modelo.ProductoDAO;

/**
 * Servlet implementation class controlador_Producto
 */
@WebServlet("/controlador_Producto")
@MultipartConfig
public class controlador_Producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controlador_Producto() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		ProductoDAO proDao= new ProductoDAO();
            if(request.getParameter("cargar")!=null) {
			
			Part archivo= request.getPart("archivo");
		
			String Url="C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/";
			
			try {
			InputStream file= archivo.getInputStream();
			File copia = new File(Url+"prueba.csv");
			FileOutputStream escribir= new FileOutputStream(copia);
			int num= file.read();
			while(num != -1) {
			 escribir.write(num);
			 num=file.read();
	      	}
			escribir.close();
			file.close();
			JOptionPane.showMessageDialog(null, "Se Cargo el Archivo Correctamente.");
			if(proDao.Cargar_Producto(Url+"prueba.csv")) {
				response.sendRedirect("Productos.jsp?men=Se Inserto  Correctamente");
			}else
			{
				response.sendRedirect("Productos.jsp?men=No se Inserto ");
			}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Error de Archivo....."+e);
			}
		}
	}

}
