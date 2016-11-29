package py.edu.uaa.siges.test;

import java.sql.SQLException;

import py.edu.uaa.pooj.siges_mtv.dao.AsistenciaPorCursoDao;
import py.edu.uaa.pooj.siges_mtv.model.Alumno;
import py.edu.uaa.pooj.siges_mtv.model.AsistenciaPorCurso;
import py.edu.uaa.pooj.siges_mtv.model.Curso;
import py.edu.uaa.pooj.siges_mtv.model.Empleado;

public class TestJDBC {

	public static void main(String[] args) {

		Empleado empleado = new Empleado();
		empleado.setNombre("José");
		empleado.setApellido("Flores");
		empleado.setNumeroCedula(1234567);
		

		Alumno alumno = new Alumno();
		alumno.setApellido("Melissa");
		alumno.setApellido("Talavera");
		alumno.setNumeroCedula(4061950);

		Curso curso = new Curso();
		curso.setCodigo("p");
		curso.setDecripcion("Primero");

		AsistenciaPorCurso asistCurso = new AsistenciaPorCurso();
		asistCurso.setEmpleado(empleado);
		asistCurso.setFecha("21/03/2016");
		asistCurso.setCurso(curso);
		asistCurso.setAlumno(alumno);
		asistCurso.setDescripcion("Sí");
		asistCurso.setJustificativo("");

		AsistenciaPorCursoDao asistDao = new AsistenciaPorCursoDao();
		try {
			asistDao.registrarAsistencia(asistCurso);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
