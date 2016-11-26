package py.edu.uaa.pooj.siges_mtv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import py.edu.uaa.pooj.siges_mtv.model.Alumno;
import py.edu.uaa.pooj.siges_mtv.model.AsistenciaPorCurso;
import py.edu.uaa.pooj.siges_mtv.model.Curso;
import py.edu.uaa.pooj.siges_mtv.model.Empleado;

public class AsistenciaPorCursoDao {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/sistgescolar";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "4061950";
	private AlumnoDao alumnoDao = new AlumnoDao();
	private EmpleadoDao empleadoDao = new EmpleadoDao();
	private CursoDao cursoDao = new CursoDao();

	public List<AsistenciaPorCurso> recuperarAsistencia() {

		Connection dbConnection = null;
		Statement statement = null;

		String query = "SELECT * FROM asistencia_curso";
		List<AsistenciaPorCurso> asistencias = new ArrayList<AsistenciaPorCurso>();

		try {
			dbConnection = getDBConnection();
			ResultSet rs = dbConnection.createStatement().executeQuery(query);
			while (rs.next()) {
				AsistenciaPorCurso asistcurso = new AsistenciaPorCurso();

				// Empleado
				String codigoEmpleado = rs.getString(1);
				if (codigoEmpleado != null) {
					Empleado empleado = this.empleadoDao.recuperarEmpleadoPorCodigo(codigoEmpleado);
					asistcurso.setEmpleado(empleado);
				}

				// FALTA FECHA (2)

				// Curso
				String codigoCurso = rs.getString(3);
				if (codigoCurso != null) {
					Curso curso = this.cursoDao.recuperarCursoPorCodigo(codigoCurso);
					asistcurso.setCurso(curso);
				}

				// Alumno
				String codigoAlumno = rs.getString(4);
				if (codigoAlumno != null) {
					Alumno alumno = this.alumnoDao.recuperarAlumnoPorCodigo(codigoAlumno);
					asistcurso.setAlumno(alumno);

				}

				asistencias.add(asistcurso);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if (statement != null) {
					statement.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return asistencias;

	}

	public boolean registrarAsistencia(AsistenciaPorCurso asistencia_curso) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		// AGREGAR FECHA, DESCRIPCION Y JUSTIFICATIVO
		String insertTableSQL = "INSERT INTO asistencia_curso" + "( empleado, fecha, curso, alumno ) VALUES"
				+ "(?, ?, ?, ?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			// EMPLEADO
			if (asistencia_curso.getEmpleado() != null) {
				preparedStatement.setString(1, asistencia_curso.getEmpleado().getCodigo());
			} else {
				preparedStatement.setNull(1, Types.CHAR);
			}

			// FECHA
			if (asistencia_curso.getFecha() != null) {
				preparedStatement.setString(2, asistencia_curso.getFecha());
			} else {
				preparedStatement.setNull(2, Types.CHAR);
			}

			// CURSO
			if (asistencia_curso.getCurso() != null) {
				preparedStatement.setString(3, asistencia_curso.getCurso().getCodigo());
			} else {
				preparedStatement.setNull(3, Types.CHAR);
			}

			// Alumno
			if (asistencia_curso.getAlumno() != null) {
				preparedStatement.setString(4, asistencia_curso.getAlumno().getCodigo());
			} else {
				preparedStatement.setNull(4, Types.CHAR);
			}

			preparedStatement.executeUpdate();
			System.out.println("Registro correcto de datos.");
			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}

	}

	public boolean eliminarAsistencia(AsistenciaPorCurso asistencia_curso) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String deleteSQL = "DELETE from asist_curso WHERE alumno = ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);

			// preparedStatement.setObject(1, asistencia_curso.getAlumno());
			if (asistencia_curso.getCurso() != null) {
				preparedStatement.setString(4, asistencia_curso.getCurso().getCodigo());
			} else {
				preparedStatement.setNull(4, Types.CHAR);
			}

			// execute delete SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Registro borrado de forma correcta");
			return true;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}

		}
		return false;

	}

	public boolean actualizarAsistencia(AsistenciaPorCurso asistencia_curso) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		// los parametros del where son en base a la necesidad de la logica de
		// negocio.
		String updateSql = "UPDATE asistencia_curso set empleado = ?, curso = ?, alumno = ?, WHERE alumno = ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(updateSql);

			// EMPLEADO
			if (asistencia_curso.getEmpleado() != null) {
				preparedStatement.setString(1, asistencia_curso.getEmpleado().getCodigo());
			} else {
				preparedStatement.setNull(1, Types.CHAR);
			}

			// CURSO
			if (asistencia_curso.getCurso() != null) {
				preparedStatement.setString(4, asistencia_curso.getCurso().getCodigo());
			} else {
				preparedStatement.setNull(4, Types.CHAR);
			}

			// Alumno
			if (asistencia_curso.getCurso() != null) {
				preparedStatement.setString(4, asistencia_curso.getAlumno().getCodigo());
			} else {
				preparedStatement.setNull(4, Types.CHAR);
			}

			// execute delete SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Registro actualizado de forma correcta.");
			return true;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}

		}
		return false;

	}

	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}
}
