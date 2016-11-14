package py.edu.uaa.pooj.siges_mtv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import py.edu.uaa.pooj.siges_mtv.model.TipoPago;

public class TipoPagoDao {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/sistgescolar";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "4061950";

	public boolean agregarTurno(TipoPago tipo_pago) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO tipopago (descripcion) VALUES('?')";

		try {

			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			preparedStatement.setString(1, tipo_pago.getDescripcion());

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

	public TipoPago consultaTipoPago() {

		Connection dbConnection = null;

		Statement statement = null;

		String query = "SELECT * FROM tipopago";
		TipoPago tipopago = null;
		try {

			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {

				tipopago = new TipoPago();

				tipopago.setDescripcion(rs.getString(1));

			}

			System.out.println(tipopago.toString());
			return tipopago;

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
		return tipopago;
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
