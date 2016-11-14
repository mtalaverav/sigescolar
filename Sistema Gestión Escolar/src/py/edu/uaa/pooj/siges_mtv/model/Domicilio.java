package py.edu.uaa.pooj.siges_mtv.model;

public class Domicilio {
	@Override
	public String toString() {
		return "Domicilio [calle=" + calle + ", numeroDeCasa=" + numeroDeCasa + ", ciudad=" + ciudad + ", barrio="
				+ barrio + "]";
	}

	private String calle;
	private int numeroDeCasa;
	private String ciudad;
	private String barrio;
	
	public Domicilio() {

	}


	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumeroDeCasa() {
		return numeroDeCasa;
	}

	public void setNumeroDeCasa(int numeroDeCasa) {
		this.numeroDeCasa = numeroDeCasa;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	
	

}
