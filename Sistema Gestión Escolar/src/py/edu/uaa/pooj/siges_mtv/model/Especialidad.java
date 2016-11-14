package py.edu.uaa.pooj.siges_mtv.model;

public class Especialidad {
	@Override
	public String toString() {
		return "Especialidad [descripcion=" + descripcion + "]";
	}

	private String descripcion;
	
	public Especialidad() {

	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
