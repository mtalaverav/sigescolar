package py.edu.uaa.pooj.siges_mtv.model;

import java.util.Date;

public class Factura {
	private int numeroFactura;
	private Date fechaEmision;
	private Empleado empleado;
	private Alumno alumno;
	private Encargado encargado;
	private int cantidadCuotas;
	private int montoCuotas;
	
	public Factura() {

	}

	public void emitirFactura() {

	}

	public int getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Encargado getEncargado() {
		return encargado;
	}

	public void setEncargado(Encargado encargado) {
		this.encargado = encargado;
	}

	public int getCantidadCuotas() {
		return cantidadCuotas;
	}

	public void setCantidadCuotas(int cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
	}

	public int getMontoCuotas() {
		return montoCuotas;
	}

	public void setMontoCuotas(int montoCuotas) {
		this.montoCuotas = montoCuotas;
	}

}
