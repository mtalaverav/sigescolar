package py.edu.uaa.pooj.siges_mtv.model;

public class Contacto {
	@Override
	public String toString() {
		return "Contacto [telefono=" + telefono + ", correoElectronico=" + correoElectronico + ", celular=" + celular
				+ "]";
	}

	private String telefono;
	private String correoElectronico;
	private String celular;

	public Contacto() {

	}



	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}
