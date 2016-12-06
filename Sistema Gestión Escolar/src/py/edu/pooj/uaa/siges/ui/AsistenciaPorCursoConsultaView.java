package py.edu.pooj.uaa.siges.ui;

import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;

public class AsistenciaPorCursoConsultaView {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/sistgescolar";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "4061950";

	protected static final String frame = null;
	JFrame frmInformeAsistenciaDe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsistenciaPorCursoConsultaView window = new AsistenciaPorCursoConsultaView();
					window.frmInformeAsistenciaDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AsistenciaPorCursoConsultaView() {
		initialize();
	}

	public void confirmar() {
		Object[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(frmInformeAsistenciaDe, "¿Desea cancelar?",
				"Mensaje de Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones,
				"Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInformeAsistenciaDe = new JFrame();
		frmInformeAsistenciaDe.getContentPane().setBackground(new Color(255, 255, 204));
		frmInformeAsistenciaDe.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\USER\\git\\Sistema Gesti\u00F3n Escolar\\Tutorial Apolo 4.0_html_m10daeb51.jpg"));
		frmInformeAsistenciaDe.setTitle("Informe Asistencia de Alumnos");
		frmInformeAsistenciaDe.setBounds(100, 100, 450, 417);
		frmInformeAsistenciaDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInformeAsistenciaDe.getContentPane().setLayout(null);

		JComboBox comboCurso = new JComboBox();
		comboCurso.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		comboCurso.setBounds(114, 64, 114, 20);
		frmInformeAsistenciaDe.getContentPane().add(comboCurso);
		comboCurso.addItem("Todos");

		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblCurso.setBounds(21, 67, 46, 14);
		frmInformeAsistenciaDe.getContentPane().add(lblCurso);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblDescripcin.setBounds(21, 105, 69, 14);
		frmInformeAsistenciaDe.getContentPane().add(lblDescripcin);

		JComboBox comboDescripcion = new JComboBox();
		comboDescripcion.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		comboDescripcion.setBounds(112, 102, 116, 20);
		frmInformeAsistenciaDe.getContentPane().add(comboDescripcion);
		comboDescripcion.addItem("Todos");

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setColumns(6);
		textArea.setBounds(21, 172, 383, 149);
		frmInformeAsistenciaDe.getContentPane().add(textArea);

		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnConsulta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				PreparedStatement enviaConsultaCurso;
				String consultaCursos = "SELECT empleado, fecha, curso, alumno, descripcion, justificativo FROM asistencia_curso WHERE curso = ?";
				Connection dbConnection = null;

				ResultSet rs = null;

				try {

					String curso = (String) comboCurso.getSelectedItem();
					enviaConsultaCurso = dbConnection.prepareStatement(consultaCursos);

					enviaConsultaCurso.setString(1, curso);

					rs = enviaConsultaCurso.executeQuery();

					while (rs.next()) {

						textArea.append(rs.getString(1));
						textArea.append((", "));
						textArea.append(rs.getString(2));
						textArea.append((", "));
						textArea.append(rs.getString(3));
						textArea.append((", "));
						textArea.append(rs.getString(4));
						textArea.append((", "));
						textArea.append(rs.getString(5));
						textArea.append((", "));
						textArea.append(rs.getString(6));
						textArea.append((", "));

					}

				} catch (Exception e1) {

				}

			}
		});
		btnConsulta.setBounds(236, 344, 89, 23);
		frmInformeAsistenciaDe.getContentPane().add(btnConsulta);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmar();
			}
		});
		btnCancelar.setBounds(335, 344, 89, 23);
		frmInformeAsistenciaDe.getContentPane().add(btnCancelar);
		
		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblBuscarPor.setBounds(21, 42, 69, 14);
		frmInformeAsistenciaDe.getContentPane().add(lblBuscarPor);
		
		JLabel lblInformeDeAsistencia = new JLabel("Informe de Asistencia");
		lblInformeDeAsistencia.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblInformeDeAsistencia.setBounds(150, 26, 196, 14);
		frmInformeAsistenciaDe.getContentPane().add(lblInformeDeAsistencia);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblResultado.setBounds(21, 147, 69, 14);
		frmInformeAsistenciaDe.getContentPane().add(lblResultado);

		// Conexión

		Connection dbConnection = null;

		Statement statement = null;

		try {

			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			// Carga ComboBox CURSO

			String consulta = "SELECT DISTINCT curso FROM asistencia_curso";
			ResultSet rs = statement.executeQuery(consulta);

			while (rs.next()) {

				comboCurso.addItem(rs.getString(1));
			}
			rs.close();

			// Carga ComboBox Descripcion
			consulta = "SELECT DISTINCT descripcion FROM asistencia_curso";
			rs = statement.executeQuery(consulta);

			while (rs.next()) {
				comboDescripcion.addItem(rs.getString(1));
			}
			rs.close();

		} catch (Exception e) {

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
