package py.edu.uaa.siges.test;

import py.edu.uaa.pooj.siges_mtv.dao.AsistenciaPorCursoDao;
import py.edu.uaa.pooj.siges_mtv.model.Alumno;
import py.edu.uaa.pooj.siges_mtv.model.AsistenciaPorCurso;
import py.edu.uaa.pooj.siges_mtv.model.Curso;
import py.edu.uaa.pooj.siges_mtv.model.Empleado;

public class TestActualizar {
	public static void main(String[] args) {
		// ACTUALIZAR

		Alumno alm = new Alumno();
		alm.setCodigo("ND");
		alm.setNombre("Norma");
		alm.setApellido("Delvalle");
		alm.setNumeroCedula(1026650);

		AsistenciaPorCurso asistCurso = new AsistenciaPorCurso();

		asistCurso.setAlumno(alm);
		asistCurso.setDescripcion("No");
		asistCurso.setJustificativo("Laboral");

		AsistenciaPorCursoDao asistDao = new AsistenciaPorCursoDao();
		asistDao.actualizarAsistencia(asistCurso);
	}

}
