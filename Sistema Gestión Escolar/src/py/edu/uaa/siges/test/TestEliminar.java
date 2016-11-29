package py.edu.uaa.siges.test;

import py.edu.uaa.pooj.siges_mtv.dao.AsistenciaPorCursoDao;
import py.edu.uaa.pooj.siges_mtv.model.Alumno;
import py.edu.uaa.pooj.siges_mtv.model.AsistenciaPorCurso;
import py.edu.uaa.pooj.siges_mtv.model.Curso;
import py.edu.uaa.pooj.siges_mtv.model.Empleado;

public class TestEliminar {
	public static void main(String[] args) {

		 // ELIMINAR
		
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
		
		 // Prueba de eliminar
		 AsistenciaPorCurso asistCurso1 = new AsistenciaPorCurso();
		 asistCurso1.setEmpleado(empleado);
		 asistCurso1.setFecha("21/03/2016");
		 asistCurso1.setCurso(curso);
		 asistCurso1.setAlumno(alm);
		 asistCurso1.setDescripcion("No");
		 asistCurso1.setJustificativo("Laboral");
		
		 AsistenciaPorCursoDao asisDao = new AsistenciaPorCursoDao();
		 asisDao.eliminarAsistencia(asistCurso1);

	}

}
