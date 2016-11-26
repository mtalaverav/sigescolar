package py.edu.uaa.pooj.siges_mtv.model;

import java.util.Date;
import java.util.List;


public class AsistenciaPorCurso {
	@Override
	public String toString() {
		return "AsistenciaPorCurso [empleado=" + empleado + ", fecha=" + fecha + ", curso=" + curso + ", alumno="
				+ alumno + ", descripcion=" + descripcion + ", justificativo=" + justificativo + ", alumnos=" + alumnos
				+ "]";
	}

	
	//cambiar tipo de datos.
	private Empleado empleado;
	private String fecha;
	private Curso curso;
	private Alumno alumno;
	private Boolean descripcion;
	private String justificativo;
	private List <Alumno> alumnos;

	public AsistenciaPorCurso() {

	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
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

	public Boolean getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(Boolean descripcion) {
		this.descripcion = descripcion;
	}

	public String getJustificativo() {
		return justificativo;
	}

	public void setJustificativo(String justificativo) {
		this.justificativo = justificativo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public List <Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List <Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	

}
