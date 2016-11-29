package py.edu.uaa.pooj.siges_mtv.model;

public abstract class Persona {

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", numeroCedula=" + numeroCedula
				+ ", nacionalidad=" + "]";
	}

	private String nombre;
	private String apellido;
	private int numeroCedula;
	// protected Domicilio direccion;
	// protected Contacto contacto;
	// protected País nacionalidad;

	public Persona(String nombre, String apellido, int numeroCedula) {

		super();

		this.nombre = nombre;
		this.apellido = apellido;
		this.numeroCedula = numeroCedula;
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

}
