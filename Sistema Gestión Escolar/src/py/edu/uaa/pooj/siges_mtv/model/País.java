package py.edu.uaa.pooj.siges_mtv.model;

public class País {
	@Override
	public String toString() {
		return "País [descripcion=" + descripcion + "]";
	}

	private String descripcion;
	
	public País() {

	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
