package py.edu.pooj.uaa.siges.modifdatabase;

import java.sql.*;

public class ModificaBBDD {

	public static void main(String[] args) {

		try {
			Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistgescolar",
					"postgres", "4061950");
			
			Statement miStatement = dbConnection.createStatement();

//			String insertCursoSQL = "INSERT INTO curso (codigo, descripcion) VALUES (3, 'Tercero')";
//			miStatement.executeUpdate(insertCursoSQL);
			
//			String insertEmpleadoSQL = "INSERT INTO empleado (nombre, apellido) VALUES ('Jessica', 'Coronel')";
//			miStatement.executeUpdate(insertEmpleadoSQL);
			
			String insertAlumnoSQL =  "INSERT INTO alumno (nombre, apellido, numerocedula) VALUES ('Melissa', 'Talavera', 4061950)";
			miStatement.executeQuery(insertAlumnoSQL);
			
			//
			// String insertAsistencia = "INSERT INTO asistencia_curso
			// (empleado, fecha, curso, alumno, descripcion, justificativo)
			// VALUES ('alan', 323, 'tercer curso', 'melissa', 'no', 'null')";
			//
			// miStatement.executeUpdate(insertAsistencia);

			System.out.println("Datos ingresados correctamente.");

		} catch (Exception e) {
			System.out.println("No es posible conectar");
			e.printStackTrace();

		}
	}

}
