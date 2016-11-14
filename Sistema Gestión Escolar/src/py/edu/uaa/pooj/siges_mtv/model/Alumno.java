package py.edu.uaa.pooj.siges_mtv.model;

public class Alumno extends Persona {

	@Override
	public String toString() {
		return "Alumno [encargado=" + encargado + ", curso=" + curso + super.toString() + "]";
	}

	private Encargado encargado;
	private Curso curso;

	public Encargado getEncargado() {
		return encargado;
	}

	public void setEncargado(Encargado encargado) {
		this.encargado = encargado;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
