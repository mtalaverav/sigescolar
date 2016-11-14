package py.edu.uaa.pooj.siges_mtv.model;

import java.util.Date;

public class Cuota {
	
	private Alumno alumno;
	private int totalCuotas;
	private int numeroCuota;
	private Date fechaVenicmiento;
	private int monto;
	private boolean pagado;
	private Matricula matricula;
	
	public Cuota() {

	}

	public void registrarCuota() {

	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public int getTotalCuotas() {
		return totalCuotas;
	}

	public void setTotalCuotas(int totalCuotas) {
		this.totalCuotas = totalCuotas;
	}

	public int getNumeroCuota() {
		return numeroCuota;
	}

	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public Date getFechaVenicmiento() {
		return fechaVenicmiento;
	}

	public void setFechaVenicmiento(Date fechaVenicmiento) {
		this.fechaVenicmiento = fechaVenicmiento;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

}
