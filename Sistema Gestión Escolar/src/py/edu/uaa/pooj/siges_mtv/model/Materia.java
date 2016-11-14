package py.edu.uaa.pooj.siges_mtv.model;

public class Materia {
	@Override
	public String toString() {
		return "Materia [descripcion=" + descripcion + "]";
	}

	private String descripcion;


	public Materia() {

	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
