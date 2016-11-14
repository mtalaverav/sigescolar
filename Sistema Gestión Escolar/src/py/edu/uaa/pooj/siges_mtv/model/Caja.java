package py.edu.uaa.pooj.siges_mtv.model;

import java.util.Date;

public class Caja {
	@Override
	public String toString() {
		return "Caja [empleado=" + empleado + ", numeroFactura=" + numeroFactura + ", cantidadCuota=" + cantidadCuota
				+ ", tipoPago=" + tipoPago + ", fecha=" + fecha + ", importe=" + importe + "]";
	}

	private Empleado empleado;
	private Factura numeroFactura;
	private Cuota cantidadCuota;
	private TipoPago tipoPago;
	private Date fecha;
	private int importe;
	
	public Caja() {

	}

	public void registrarGestion () {

	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Factura getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(Factura numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Cuota getCantidadCuota() {
		return cantidadCuota;
	}

	public void setCantidadCuota(Cuota cantidadCuota) {
		this.cantidadCuota = cantidadCuota;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}
	
	
}
