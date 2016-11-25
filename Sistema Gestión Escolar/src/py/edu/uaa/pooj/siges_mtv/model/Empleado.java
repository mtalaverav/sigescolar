package py.edu.uaa.pooj.siges_mtv.model;

public class Empleado extends Persona {

	private String codigo;

	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", toString()=" + super.toString() + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
