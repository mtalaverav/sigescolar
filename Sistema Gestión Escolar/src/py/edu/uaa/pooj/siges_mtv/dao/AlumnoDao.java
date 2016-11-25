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
import py.edu.uaa.pooj.siges_mtv.model.Curso;

public class AlumnoDao {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/sistgescolar";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "4061950";

	public Alumno recuperarAlumnoPorCodigo(String codigo) {
		Connection dbConnection = null;

		PreparedStatement statement = null;

		String query = "SELECT * FROM alumno where codigo = ?";

		try {
			dbConnection = getDBConnection();

			statement = dbConnection.prepareStatement(query);

			statement.setString(1, codigo);
			ResultSet rs = statement.executeQuery(query);

			if (rs.next()) {
				Alumno alumno = new Alumno();

				alumno.setNombre(rs.getString(1));
				alumno.setApellido(rs.getString(2));
				alumno.setNumeroCedula(rs.getInt(3));

				return alumno;
			}
		}

		catch (Exception e) {
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

		return null;
	}

	public boolean registrarAlumno(Alumno alumno) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null; // sentencias precompiladas

		// se borro los dats para prueba, ojo volver a agregar.
		String insertTableSQL = "INSERT INTO alumno" + "(nombre, apellido, numeroCedula, codigo_curso) VALUES"
				+ "(?,?,?,?)";

		try {
			dbConnection = getDBConnection(); // metodo local
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			// para probar comentamos, ojo volver a agregar luego.
			preparedStatement.setString(1, alumno.getNombre());
			preparedStatement.setString(2, alumno.getApellido());
			preparedStatement.setLong(3, alumno.getNumeroCedula());
			// preparedStatement.setObject(4, alumno.getContacto());
			// preparedStatement.setObject(5, alumno.getNacionalidad());
			// preparedStatement.setObject(6, alumno.getDireccion());
			// preparedStatement.setObject(7, alumno.getCurso());
			// preparedStatement.setObject(8, alumno.getEncargado());

			if (alumno.getCurso() != null) {
				preparedStatement.setString(4, alumno.getCurso().getCodigo());
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

	public List<Alumno> recuperarAlumno() {

		Connection dbConnection = null;

		Statement statement = null;

		// recuperacion de alumno

		String query = "SELECT *FROM alumno";
		List<Alumno> alumnos = new ArrayList<Alumno>();
		try {

			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {

				// crear objeto del modelo
				// setear propiedades del modelo en base a lo ue se recupera de
				// la database
				Alumno alumno = new Alumno();

				alumno.setNombre(rs.getString(1));
				alumno.setApellido(rs.getString(2));
				// alumno.setNumeroCedula(rs.getString(3));

				alumnos.add(alumno);

			}

			// System.out.println(alumno.toString());
			// return alumno;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				dbConnection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return alumnos;
	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER); // metodo estatico de la clase Class .
										// nombre del driver es una constante

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage()); // mensaje en consola

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
