package py.edu.uaa.pooj.siges_mtv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import py.edu.uaa.pooj.siges_mtv.model.AsistenciaPorCurso;

public class AsistenciaPorCursoDao {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/sistgescolar";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "4061950";

	// recuperacion
	public AsistenciaPorCurso recuperarAsistencia() {
		Connection dbConnection = null;

		Statement statement = null;

		String query = "SELECT *FROM asistencia_curso";
		AsistenciaPorCurso asistencia = null;

		try {

			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {

				// crear objeto del modelo
				// setear propiedades del modelo en base a lo ue se recupera de
				// la database
				asistencia = new AsistenciaPorCurso();

				asistencia.setEmpleado(rs.getString(1));
				asistencia.setCurso(rs.getString(2));
				asistencia.setAlumno(rs.getString(3));
				// falta cargar los demas atributos por tipo de dato.
				

			}
			System.out.println(asistencia.toString());
			return asistencia;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				dbConnection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return asistencia;

	}

	public boolean registrarAsistencia(AsistenciaPorCurso asistencia_curso) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		// para probar se borran Fecha, descripcion y justificativo por
		// tipodedato
		// String insertTableSQL = "INSERT INTO asistencia_curso"
		// + "(empleado, fecha, curso, alumno, descripcion, justificativo)
		// VALUES" + "(?,?,?,?,?,?)";

		String insertTableSQL = "INSERT INTO asistencia_curso" + "(empleado, curso, alumno) VALUES" + "(?,?,?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			// Cambiar tipo de dato
			preparedStatement.setString(1, asistencia_curso.getEmpleado());
			// preparedStatement.setLong(2, asistencia_curso.getFecha());
			preparedStatement.setString(2, asistencia_curso.getCurso()); // modificar
																			// rango
			preparedStatement.setString(3, asistencia_curso.getAlumno()); // modificar
																			// rango
			// preparedStatement.setBoolean(5,
			// asistencia_curso.getDescripcion());
			// preparedStatement.setString(6,
			// asistencia_curso.getJustificativo());

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
