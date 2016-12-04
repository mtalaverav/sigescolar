package py.edu.uaa.pooj.siges_mtv.dao;

import java.util.List;

import py.edu.uaa.pooj.siges_mtv.model.AsistenciaPorCurso;

public class MainConsultaAsistCurso {

	public static void main(String[] args) {
		System.out.println("\n");
		AsistenciaPorCursoDao asistenciaDao = new AsistenciaPorCursoDao();
		List<AsistenciaPorCurso> asistencias = asistenciaDao.recuperarAsistencia();
		for (AsistenciaPorCurso  asistencia : asistencias) {
			System.out.println(asistencia.toString());
		}

	}

}
