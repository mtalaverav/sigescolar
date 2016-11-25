package py.edu.uaa.pooj.siges_mtv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.edu.uaa.pooj.siges_mtv.model.Curso;

public class CursoDao {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/sistgescolar";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "4061950";

	public Curso recuperarCursoPorCodigo(String codigo) {
		Connection dbConnection = null;

		PreparedStatement statement = null;

		String query = "SELECT * FROM curso where codigo = ?";

		try {
			dbConnection = getDBConnection();

			statement = dbConnection.prepareStatement(query);

			statement.setString(1, codigo);
			ResultSet rs = statement.executeQuery(query);

			if (rs.next()) {
				Curso curso = new Curso();

				curso.setCodigo(rs.getString(1));
				curso.setDecripcion(rs.getString(2));

				return curso;
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

	public List<Curso> recuperarCursos() {
		Connection dbConnection = null;
		Statement statement = null;

		String query = "SELECT * FROM curso";
		List<Curso> cursos = new ArrayList<Curso>();

		try {
			dbConnection = getDBConnection();
			ResultSet rs = dbConnection.createStatement().executeQuery(query);
			while (rs.next()) {
				Curso curso = new Curso();

				curso.setCodigo(rs.getString(1));
				curso.setDecripcion(rs.getString(2));

				cursos.add(curso);
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

		return cursos;

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
