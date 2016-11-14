package py.edu.uaa.pooj.siges_mtv.model;

public class TipoEncargado {

	@Override
	public String toString() {
		return "TipoEncargado [descripcion=" + descripcion + "]";
	}

	private String descripcion;

	public TipoEncargado() {

	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
