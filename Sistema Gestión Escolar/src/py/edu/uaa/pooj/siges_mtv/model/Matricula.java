package py.edu.uaa.pooj.siges_mtv.model;

import java.util.Date;

public class Matricula {
	private Empleado empleado;
	private Curso curso;
	private Alumno alumno;
	private int costoMatricula;
	private int cantidadCuotas;
	private Date fechaInscripcion;
	
	public Matricula() {

	}

	public void registrarMatricula() {

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

	public int getCostoMatricula() {
		return costoMatricula;
	}

	public void setCostoMatricula(int costoMatricula) {
		this.costoMatricula = costoMatricula;
	}

	public int getCantidadCuotas() {
		return cantidadCuotas;
	}

	public void setCantidadCuotas(int cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	
}
