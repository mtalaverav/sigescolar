package py.edu.uaa.pooj.siges_mtv.dao;

import java.util.List;

import py.edu.uaa.pooj.siges_mtv.model.Alumno;
import py.edu.uaa.pooj.siges_mtv.model.AsistenciaPorCurso;
import py.edu.uaa.pooj.siges_mtv.model.Curso;
import py.edu.uaa.pooj.siges_mtv.model.País;

public class MainConsultas {

	public static void main(String[] args) {

		System.out.println("Consultas.");

		System.out.println("\n");
		AlumnoDao alumnoDao = new AlumnoDao();
		List<Alumno> alumnos = alumnoDao.recuperarAlumno();
		for (Alumno alumno : alumnos) {
			System.out.println(alumno.toString());
		}
//
//		System.out.println("\n");
//		EspecialidadDao especialidadDao = new EspecialidadDao();
//		List<Especialidad> especialidades = especialidadDao.recuperarEspecialidad();
//		for (Especialidad especialidad : especialidades) {
//			System.out.println(especialidad.toString());
//		}
//
//		System.out.println("\n");
//		MateriaDao materiaDao = new MateriaDao();
//		List<Materia> materias = materiaDao.recuperarMateria();
//		for (Materia materia : materias) {
//			System.out.println(materia.toString());
//		}
//
//		System.out.println("\n");
//		ContactoDao contactoDao = new ContactoDao();
//		List<Contacto> contactos = contactoDao.recuperarContacto();
//		for (Contacto contacto : contactos) {
//			System.out.println(contacto.toString());
//		}
//
//		System.out.println("\n");
//		PaisDao paisDao = new PaisDao();
//		List<País> paises = paisDao.recuperarPais();
//		for (País pais : paises) {
//			System.out.println(pais.toString());
//		}

//		System.out.println("\n");
//		AsistenciaPorCursoDao asistenciaDao = new AsistenciaPorCursoDao();
//		List<AsistenciaPorCurso> asistencias = asistenciaDao.recuperarAsistencia();
//		for (AsistenciaPorCurso  asistencia : asistencias) {
//			System.out.println(asistencia.toString());
//		}
//
//		System.out.println("\n");
//		TurnoDao turno = new TurnoDao();
//		turno.consultaTurno();
//
//		System.out.println("\n");
//		TipoPagoDao tipopago = new TipoPagoDao();
//		tipopago.consultaTipoPago();
//
//		System.out.println("\n");
//		TipoEncargadoDao tipoEncargado = new TipoEncargadoDao();
//		tipoEncargado.consultaTipoEncargado();
//
//		System.out.println("\n");
//		DomicilioDao domicilio = new DomicilioDao();
//		domicilio.consultaDomicilio();
		
		System.out.println("\n");
		CursoDao cursoDao = new CursoDao ();
		List<Curso> cursos = cursoDao.recuperarCursos();
		for (Curso curso : cursos) {
			System.out.println(curso.toString());
		}
	}

}
