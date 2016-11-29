package py.edu.uaa.siges.test;

import java.sql.SQLException;

import py.edu.uaa.pooj.siges_mtv.dao.AsistenciaPorCursoDao;
import py.edu.uaa.pooj.siges_mtv.model.Alumno;
import py.edu.uaa.pooj.siges_mtv.model.AsistenciaPorCurso;
import py.edu.uaa.pooj.siges_mtv.model.Curso;
import py.edu.uaa.pooj.siges_mtv.model.Empleado;

public class TestInsertar {

	public static void main(String[] args) {

		// INSERTAR

		Empleado empleado = new Empleado();
		empleado.setCodigo("JF");
		empleado.setNombre("José");
		empleado.setApellido("Flores");
		empleado.setNumeroCedula(1234567);

		Alumno alm = new Alumno();
		alm.setCodigo("ND");
		alm.setNombre("Norma");
		alm.setApellido("Delvalle");
		alm.setNumeroCedula(1026650);

		Curso curso = new Curso();
		curso.setCodigo("S");
		curso.setDecripcion("Segundo");

		AsistenciaPorCurso asistCurso = new AsistenciaPorCurso();
		asistCurso.setEmpleado(empleado);
		asistCurso.setFecha("22/03/2016");
		asistCurso.setCurso(curso);
		asistCurso.setAlumno(alm);
		asistCurso.setDescripcion("No");
		asistCurso.setJustificativo("Laboral");

		AsistenciaPorCursoDao asistDao = new AsistenciaPorCursoDao();
		try {
			asistDao.registrarAsistencia(asistCurso);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
