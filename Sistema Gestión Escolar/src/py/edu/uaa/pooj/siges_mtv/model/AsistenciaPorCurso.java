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
	private String empleado;
	private Date fecha;
	private String curso;
	private String alumno;
	private Boolean descripcion;
	private String justificativo;
	private List <Alumno> alumnos;

	public AsistenciaPorCurso() {

	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getAlumno() {
		return alumno;
	}

	public void setAlumno(String alumno) {
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List <Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List <Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	

}
