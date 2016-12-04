package py.edu.uaa.pooj.siges_mtv.model;

public class AsistenciaPorCurso {

	@Override
	public String toString() {
		return "AsistenciaPorCurso [empleado=" + empleado + ", fecha=" + fecha + ", curso=" + curso + ", alumno="
				+ alumno + ", descripcion=" + descripcion + ", justificativo=" + justificativo + "]";
	}

	private Empleado empleado;
	private String fecha;
	private Curso curso;
	private Alumno alumno;
	private String descripcion;
	private String justificativo;

	public AsistenciaPorCurso() {

	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public String getJustificativo() {
		return justificativo;
	}

	public void setJustificativo(String justificativo) {
		this.justificativo = justificativo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
