package Modelo;

public class ClienteDTO {
	
	private long cedula;
	private String nombre_completo, direccion, telefono, correoelectronico;

	public ClienteDTO(long cedula, String direccion, String correoelectronico, String nombre_completo,
			String telefono) {
		
		super();
		this.cedula = cedula;
		this.nombre_completo = nombre_completo;
		this.direccion = direccion;
		this.telefono= telefono;
		this.correoelectronico = correoelectronico;
	}

	public long getCedula() {
		return cedula;
	}
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreoelectronico() {
		return correoelectronico;
	}
	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}	
	@Override
	public String toString() {
		return "ClienteDTO [cedula=" + cedula + ", nombre_completo=" + nombre_completo + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", correoelectronico=" + correoelectronico + "]";
	}
	
}
