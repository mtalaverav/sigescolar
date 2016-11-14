package py.edu.uaa.pooj.siges_mtv.model;

public class Calificación {
	@Override
	public String toString() {
		return "Calificación [materia=" + materia + ", alumno=" + alumno + ", notaExamenParcial=" + notaExamenParcial
				+ ", notaExamenFinal=" + notaExamenFinal + ", calificacionFinal=" + calificacionFinal + "]";
	}

	private Materia materia;
	private Alumno alumno;
	private int notaExamenParcial;
	private int notaExamenFinal;
	private int calificacionFinal;
	
	public Calificación() {

	}

	public void registrarCalificacion () {

	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public int getNotaExamenParcial() {
		return notaExamenParcial;
	}

	public void setNotaExamenParcial(int notaExamenParcial) {
		this.notaExamenParcial = notaExamenParcial;
	}

	public int getNotaExamenFinal() {
		return notaExamenFinal;
	}

	public void setNotaExamenFinal(int notaExamenFinal) {
		this.notaExamenFinal = notaExamenFinal;
	}

	public int getCalificacionFinal() {
		return calificacionFinal;
	}

	public void setCalificacionFinal(int calificacionFinal) {
		this.calificacionFinal = calificacionFinal;
	}

}
