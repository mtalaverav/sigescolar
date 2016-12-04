package py.edu.pooj.uaa.siges.ui;

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

public class AsistenciaPorCursoConsultaView {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/sistgescolar";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "4061950";

	// consulta preparada.
	private PreparedStatement enviaConsultaCurso;
	private final String consultaCursos = "SELECT empleado, fecha, curso, alumno, descripcion, justificativo FROM asistencia_curso WHERE curso = ?";

	private JComboBox comboCurso;
	private JComboBox comboDescripcion;
	private JTextArea textResultado;

	private Connection dbConnection;

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
		frmInformeAsistenciaDe.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\USER\\git\\Sistema Gesti\u00F3n Escolar\\Tutorial Apolo 4.0_html_m10daeb51.jpg"));
		frmInformeAsistenciaDe.setTitle("Informe Asistencia de Alumnos");
		frmInformeAsistenciaDe.setBounds(100, 100, 450, 417);
		frmInformeAsistenciaDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInformeAsistenciaDe.getContentPane().setLayout(null);

		JComboBox comboCurso = new JComboBox();
		comboCurso.setBounds(110, 30, 114, 20);
		frmInformeAsistenciaDe.getContentPane().add(comboCurso);
		comboCurso.addItem("Todos");

		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(21, 33, 46, 14);
		frmInformeAsistenciaDe.getContentPane().add(lblCurso);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(21, 75, 46, 14);
		frmInformeAsistenciaDe.getContentPane().add(lblFecha);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(110, 75, 103, 20);
		frmInformeAsistenciaDe.getContentPane().add(dateChooser);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(21, 119, 69, 14);
		frmInformeAsistenciaDe.getContentPane().add(lblDescripcin);

		JComboBox comboDescripcion = new JComboBox();
		comboDescripcion.setBounds(114, 116, 99, 20);
		frmInformeAsistenciaDe.getContentPane().add(comboDescripcion);
		comboDescripcion.addItem("Todos");

		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ejecutarConsulta();
			}
		});
		btnConsulta.setBounds(236, 344, 89, 23);
		frmInformeAsistenciaDe.getContentPane().add(btnConsulta);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmar();
			}
		});
		btnCancelar.setBounds(335, 344, 89, 23);
		frmInformeAsistenciaDe.getContentPane().add(btnCancelar);

		JTextArea textResultado = new JTextArea();
		textResultado.setBounds(22, 157, 380, 160);
		frmInformeAsistenciaDe.getContentPane().add(textResultado);

		// Conexión

		Connection dbConnection = null;

		Statement statement = null;

		try {

			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			// Carga ComboBox CURSO

			String consultaCursos = "SELECT DISTINCT curso FROM asistencia_curso";
			ResultSet rs = statement.executeQuery(consultaCursos);

			while (rs.next()) {
				extracted(comboCurso, rs);
			}
			rs.close();

			// Carga ComboBox Descripcion

			String consultaDescripcion = "SELECT DISTINCT descripcion FROM asistencia_curso";
			ResultSet rS = statement.executeQuery(consultaDescripcion);

			while (rS.next()) {
				extracted(comboDescripcion, rS);
			}
			rs.close();

		} catch (Exception e) {

		}

	}

	private void extracted(JComboBox comboCurso, ResultSet rs) throws SQLException {
		comboCurso.addItem(rs.getString(1));
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

	private void ejecutarConsulta() {

		ResultSet rs = null;
		try {

			// se guarda en la variable curso lo seleccionado en el ComboBox
			// getSelectedItem = Object - se convierte a String
			String cursos = (String) comboCurso.getSelectedItem();

			// consulta preparada almacenada en enviaConsultaCurso utilizando el
			// metodo prepareStatement enviando como parametro la consulta
			// parametrizada
			enviaConsultaCurso = dbConnection.prepareStatement(consultaCursos);

			// setString para pasar por parametro el valor.
			enviaConsultaCurso.setString(1, cursos);

			// ResultSet para ejecutar la consulta
			rs = enviaConsultaCurso.executeQuery();

			while (rs.next()) { // mientras haya registros
				textResultado.append(rs.getString(1));
				textResultado.append(", ");
				textResultado.append(rs.getString(2));
				textResultado.append(", ");
				textResultado.append(rs.getString(3));
				textResultado.append(", ");
				textResultado.append(rs.getString(4));
				textResultado.append(", ");
				textResultado.append(rs.getString(5));
				textResultado.append(", ");
				textResultado.append(rs.getString(6));

				// salto de linea
				textResultado.append("\n");
			}

		} catch (Exception e) {

		}

	}
}
