package py.edu.pooj.uaa.siges.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import py.edu.uaa.pooj.siges_mtv.dao.AsistenciaPorCursoDao;
import py.edu.uaa.pooj.siges_mtv.model.AsistenciaPorCurso;

public class AsistenciaPorCursoView {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/sistgescolar";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "4061950";

	private JFrame frmRegistroDeAsistencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsistenciaPorCursoView window = new AsistenciaPorCursoView();
					window.frmRegistroDeAsistencia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AsistenciaPorCursoView() {
		initialize();
	}

	public void confirmar() {
		Object[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(null, "¿Desea cancelar?", "Mensaje de Confirmacion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDeAsistencia = new JFrame();
		frmRegistroDeAsistencia.setFont(new Font("Arial", Font.PLAIN, 12));
		frmRegistroDeAsistencia.setBackground(Color.CYAN);
		frmRegistroDeAsistencia.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\USER\\git\\Sistema Gesti\u00F3n Escolar\\asistencia.png"));
		frmRegistroDeAsistencia.setTitle("Registro de Asistencia");
		frmRegistroDeAsistencia.getContentPane().setBackground(new Color(255, 255, 204));
		frmRegistroDeAsistencia.setBounds(100, 100, 505, 643);
		frmRegistroDeAsistencia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeAsistencia.getContentPane().setLayout(null);

		JLabel lblRegistroDeAsistencia = new JLabel("Registro de Asistencia Por Curso");
		lblRegistroDeAsistencia.setBounds(124, 0, 215, 35);
		frmRegistroDeAsistencia.getContentPane().add(lblRegistroDeAsistencia);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(10, 457, 89, 23);
		frmRegistroDeAsistencia.getContentPane().add(btnRegistrar);

		JButton btnAbrirConsulta = new JButton("Informe");
		btnAbrirConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AsistenciaPorCursoConsultaView window = new AsistenciaPorCursoConsultaView();
				window.frmInformeAsistenciaDe.setVisible(true);
			}
		});
		btnAbrirConsulta.setBounds(365, 457, 89, 23);
		frmRegistroDeAsistencia.getContentPane().add(btnAbrirConsulta);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirmar();
			}
		});
		btnCancelar.setBounds(378, 543, 89, 23);
		frmRegistroDeAsistencia.getContentPane().add(btnCancelar);

		JLabel lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setBounds(10, 137, 62, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblEmpleado);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 60, 46, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblFecha);

		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(10, 179, 46, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblCurso);

		JLabel lblJustificativo = new JLabel("Justificativo");
		lblJustificativo.setBounds(30, 358, 72, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblJustificativo);

		JTextPane txtpnCargaJuistificación = new JTextPane();
		txtpnCargaJuistificación.setText("Describa la justificaci\u00F3n.");
		txtpnCargaJuistificación.setBounds(111, 358, 191, 58);
		frmRegistroDeAsistencia.getContentPane().add(txtpnCargaJuistificación);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setToolTipText("");
		dateChooser.setBounds(80, 60, 95, 20);
		frmRegistroDeAsistencia.getContentPane().add(dateChooser);

		JPanel opcionesDescripcion = new JPanel();
		opcionesDescripcion.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Descripci\u00F3n",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		opcionesDescripcion.setBounds(10, 234, 188, 58);
		frmRegistroDeAsistencia.getContentPane().add(opcionesDescripcion);

		JRadioButton optSi = new JRadioButton("S\u00ED");
		opcionesDescripcion.add(optSi);
		optSi.setSelected(true);

		JRadioButton optNo = new JRadioButton("No");
		opcionesDescripcion.add(optNo);

		// FALTA
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnEliminar.setBounds(124, 457, 89, 23);
		frmRegistroDeAsistencia.getContentPane().add(btnEliminar);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnActualizar.setBounds(223, 457, 116, 23);
		frmRegistroDeAsistencia.getContentPane().add(btnActualizar);

		JComboBox cmbEmpleado = new JComboBox();
		cmbEmpleado.setBounds(82, 134, 93, 20);
		frmRegistroDeAsistencia.getContentPane().add(cmbEmpleado);

		JComboBox cmbCurso = new JComboBox();
		cmbCurso.setBounds(80, 176, 93, 20);
		frmRegistroDeAsistencia.getContentPane().add(cmbCurso);

		JLabel lblAlumno = new JLabel("Alumno");
		lblAlumno.setBounds(233, 179, 46, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblAlumno);

		JComboBox cmbAlumno = new JComboBox();
		cmbAlumno.setBounds(289, 176, 93, 20);
		frmRegistroDeAsistencia.getContentPane().add(cmbAlumno);

	}
}
