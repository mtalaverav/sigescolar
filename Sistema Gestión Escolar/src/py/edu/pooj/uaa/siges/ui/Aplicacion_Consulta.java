package py.edu.pooj.uaa.siges.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Aplicacion_Consulta {

	public static void main(String[] args) {

		JFrame mimarco = new Marco_Aplicacion();
		mimarco.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\USER\\git\\siges\\Sistema Gesti\u00F3n Escolar\\Tutorial Apolo 4.0_html_m10daeb51.jpg"));

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame {

	public Marco_Aplicacion() {

		setTitle("Informe Asistencia de Alumnos");

		setBounds(500, 300, 400, 400);

		setLayout(new BorderLayout());

		JPanel menus = new JPanel();

		menus.setLayout(new FlowLayout());

		cursos = new JComboBox();

		cursos.setEditable(false);

		cursos.addItem("Todos");

		descripciones = new JComboBox();

		descripciones.setEditable(false);

		descripciones.addItem("Todos");

		resultado = new JTextArea(4, 50);

		resultado.setEditable(false);

		add(resultado);

		menus.add(cursos);

		menus.add(descripciones);

		add(menus, BorderLayout.NORTH);

		add(resultado, BorderLayout.CENTER);

		JButton botonConsulta = new JButton("Consulta");

		botonConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ejecutaConsulta();
			}

		});

		add(botonConsulta, BorderLayout.SOUTH);

		try {

			Connection miConexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistgescolar",
					"postgres", "4061950");

			Statement statement = miConexion.createStatement();

			// Carga ComboBox CURSO

			String consulta = "SELECT DISTINCT curso FROM asistencia_curso";
			ResultSet rs = statement.executeQuery(consulta);

			while (rs.next()) {

				cursos.addItem(rs.getString(1));
			}
			rs.close();

			// Carga ComboBox Descripcion
			consulta = "SELECT DISTINCT descripcion FROM asistencia_curso";
			rs = statement.executeQuery(consulta);

			while (rs.next()) {
				descripciones.addItem(rs.getString(1));
			}
			rs.close();

		} catch (Exception e) {

		}

	}

	private void ejecutaConsulta() {

		ResultSet rs = null;

		try {

			String curso = (String) cursos.getSelectedItem();
			enviaConsultaCurso = dbConnection.prepareStatement(consultaCursos);

			enviaConsultaCurso.setString(1, curso);

			rs = enviaConsultaCurso.executeQuery();

			while (rs.next()) {

				resultado.append(rs.getString(1));
				resultado.append(", ");
				resultado.append(rs.getString(2));
				resultado.append(", ");
				resultado.append(rs.getString(3));
				resultado.append(", ");
				resultado.append(rs.getString(4));
				resultado.append(", ");
				resultado.append(rs.getString(5));
				resultado.append(", ");
				resultado.append(rs.getString(6));
				resultado.append(", ");

			}

		} catch (Exception e1) {

		}

	}

	private PreparedStatement enviaConsultaCurso;

	private final String consultaCursos = "SELECT empleado, fecha, curso, alumno, descripcion, justificativo FROM asistencia_curso WHERE curso = ?";

	private Connection dbConnection;

	private JComboBox cursos;

	private JComboBox descripciones;

	private JTextArea resultado;

}
