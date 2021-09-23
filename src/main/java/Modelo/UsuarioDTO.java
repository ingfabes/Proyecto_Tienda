package Modelo;

public class UsuarioDTO {
	private long cedula;
	private String email, nombre, password, usuario;
	
	public UsuarioDTO(long cedula, String email, String nombre, String password, String usuario) {
		super();
		this.cedula = cedula;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		this.usuario = usuario;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
}
