package py.edu.uaa.pooj.siges_mtv.model;

public class Alumno extends Persona {

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", encargado=" + encargado + ", curso=" + curso + super.toString() + "]";
	}

	private String codigo;
	private Encargado encargado;
	private Curso curso;

	public Alumno() {

	}

	public Alumno(String codigo, Encargado encargado, Curso curso) {
		
		super();
		this.codigo = codigo;
		this.encargado = encargado;
		this.curso = curso;
			
	}

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
