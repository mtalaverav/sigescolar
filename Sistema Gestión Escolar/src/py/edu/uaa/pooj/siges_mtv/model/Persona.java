package py.edu.uaa.pooj.siges_mtv.model;

public abstract class Persona {
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", numeroCedula=" + numeroCedula
				+ ", direccion=" + direccion + ", contacto=" + contacto + ", nacionalidad=" + nacionalidad + "]";
	}

	private String nombre;
	private String apellido;
	private int numeroCedula;
	private Domicilio direccion;
	private Contacto contacto;
	private País nacionalidad;

	public Persona(String nombre, String apellido, int numeroCedula, Domicilio direccion, Contacto contacto,
			País nacionalidad) {
		super();

		this.nombre = nombre;
		this.apellido = apellido;
		this.numeroCedula = numeroCedula;
		this.direccion = direccion;
		this.contacto = contacto;
		this.nacionalidad = nacionalidad;
	}

	public Persona() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNumeroCedula() {
		return numeroCedula;
	}

	public void setNumeroCedula(int numeroCedula) {
		this.numeroCedula = numeroCedula;
	}

	public Domicilio getDireccion() {
		return direccion;
	}

	public void setDireccion(Domicilio direccion) {
		this.direccion = direccion;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public País getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(País nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	
}
