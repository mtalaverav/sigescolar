package py.edu.uaa.pooj.siges_mtv.model;

public class Curso {
	
//	@Override
//	public String toString() {
//		return "Curso [descripcion=" + descripcion + ", especialidad=" + especialidad + ", turno=" + turno + ", codigo="
//				+ codigo + "]";
//	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}

	private String codigo;
	private String descripcion;
	// private Especialidad especialidad;
	// private Turno turno;

	public Curso() {

	}

	// public Curso(String descripcion, Especialidad especialidad, Turno turno,
	// String codigo) {
	// this.descripcion = descripcion;
	// this.especialidad = especialidad;
	// this.turno = turno;
	// this.codigo = codigo;
	//
	// }

	public Curso(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		

	}

	public String getDecripcion() {
		return descripcion;
	}

	public void setDecripcion(String decripcion) {
		this.descripcion = decripcion;
	}

//	public Especialidad getEspecialidad() {
//		return especialidad;
//	}
//
//	public void setEspecialidad(Especialidad especialidad) {
//		this.especialidad = especialidad;
//	}
//
//	public Turno getTurno() {
//		return turno;
//	}
//
//	public void setTurno(Turno turno) {
//		this.turno = turno;
//	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
