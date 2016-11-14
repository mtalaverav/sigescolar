package py.edu.uaa.pooj.siges_mtv.dao;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import py.edu.uaa.pooj.siges_mtv.model.AsistenciaPorCurso;

public class AsistenciaPorCursoConsultaDao {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/sistgescolar";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "4061950";

	// recuperacion
	public AsistenciaPorCurso recuperarAsistencia() {
		Connection dbConnection = null;

		Statement statement = null;

		
		AsistenciaPorCurso asistencia = null;

		try {
			
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			statement = dbConnection.createStatement();
			String query = "SELECT *FROM asistencia_curso";
			
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
//
//	private static Connection getDBConnection() {
//		Connection dbConnection = null;
//		try {
//			Class.forName(DB_DRIVER);
//		} catch (ClassNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
//			return dbConnection;
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		return dbConnection;
//	}
}
