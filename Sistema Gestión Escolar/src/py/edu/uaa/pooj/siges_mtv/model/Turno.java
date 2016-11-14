package py.edu.uaa.pooj.siges_mtv.model;

public class Turno {
	@Override
	public String toString() {
		return "Turno [descripcion=" + descripcion + "]";
	}

	private String descripcion;

	public Turno() {

	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
