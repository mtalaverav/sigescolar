package py.edu.uaa.pooj.siges_mtv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.edu.uaa.pooj.siges_mtv.model.Empleado;

public class EmpleadoDao {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/sistgescolar";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "4061950";

	public Empleado recuperarEmpleadoPorCodigo(String codigo) {
		Connection dbConnection = null;

		PreparedStatement statement = null;

		String query = "SELECT * FROM empleado where codigo = ?";

		try {
			dbConnection = getDBConnection();

			statement = dbConnection.prepareStatement(query);

			statement.setString(1, codigo);
			ResultSet rs = statement.executeQuery(query);

			if (rs.next()) {
				Empleado empleado = new Empleado();

				empleado.setCodigo(rs.getString(1));
				empleado.setNombre(rs.getString(2));
				empleado.setApellido(rs.getString(3));
				empleado.setNumeroCedula(rs.getInt(4));
				return empleado;
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

	public List<Empleado> recuperarEmpleados() {
		Connection dbConnection = null;
		Statement statement = null;

		String query = "SELECT * FROM empleado";
		List<Empleado> empleados = new ArrayList<Empleado>();

		try {
			dbConnection = getDBConnection();
			ResultSet rs = dbConnection.createStatement().executeQuery(query);
			while (rs.next()) {
				Empleado empleado = new Empleado();

				empleado.setCodigo(rs.getString(1));
				empleado.setNombre(rs.getString(2));
				empleado.setApellido(rs.getString(3));
				empleado.setNumeroCedula(rs.getInt(4));

				empleados.add(empleado);
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

		return empleados;

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
