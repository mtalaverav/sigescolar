package py.edu.pooj.uaa.siges.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import com.toedter.calendar.JDateChooser;

import py.edu.uaa.pooj.siges_mtv.dao.AlumnoDao;
import py.edu.uaa.pooj.siges_mtv.dao.AsistenciaPorCursoDao;
import py.edu.uaa.pooj.siges_mtv.dao.CursoDao;
import py.edu.uaa.pooj.siges_mtv.dao.EmpleadoDao;
import py.edu.uaa.pooj.siges_mtv.model.Alumno;
import py.edu.uaa.pooj.siges_mtv.model.AsistenciaPorCurso;
import py.edu.uaa.pooj.siges_mtv.model.Curso;
import py.edu.uaa.pooj.siges_mtv.model.Empleado;
import javax.swing.ImageIcon;

public class AsistenciaPorCursoView {

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

		CursoDao cursoDao = new CursoDao();
		AlumnoDao alumnoDao = new AlumnoDao();
		EmpleadoDao empleadoDao = new EmpleadoDao();

		frmRegistroDeAsistencia = new JFrame();
		frmRegistroDeAsistencia.getContentPane().setForeground(new Color(255, 255, 204));
		frmRegistroDeAsistencia.setFont(new Font("Arial", Font.PLAIN, 12));
		frmRegistroDeAsistencia.setBackground(Color.CYAN);
		frmRegistroDeAsistencia.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\USER\\git\\Sistema Gesti\u00F3n Escolar\\asistencia.png"));
		frmRegistroDeAsistencia.setTitle("Registro de Asistencia");
		frmRegistroDeAsistencia.getContentPane().setBackground(new Color(255, 255, 204));
		frmRegistroDeAsistencia.setBounds(100, 100, 384, 644);
		frmRegistroDeAsistencia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeAsistencia.getContentPane().setLayout(null);

		JLabel lblRegistroDeAsistencia = new JLabel("Registro de Asistencia Por Curso");
		lblRegistroDeAsistencia.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblRegistroDeAsistencia.setBounds(74, 32, 227, 46);
		frmRegistroDeAsistencia.getContentPane().add(lblRegistroDeAsistencia);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirmar();
			}
		});
		btnCancelar.setBounds(262, 553, 89, 23);
		frmRegistroDeAsistencia.getContentPane().add(btnCancelar);

		JLabel lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setBounds(74, 154, 62, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblEmpleado);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(74, 108, 46, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblFecha);

		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(74, 198, 46, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblCurso);

		JLabel lblJustificativo = new JLabel("Justificativo");
		lblJustificativo.setBounds(64, 376, 72, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblJustificativo);

		JTextPane txtpnCargaJuistificación = new JTextPane();
		txtpnCargaJuistificación.setText("Describa la justificaci\u00F3n.");
		txtpnCargaJuistificación.setBounds(109, 428, 191, 58);
		frmRegistroDeAsistencia.getContentPane().add(txtpnCargaJuistificación);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setToolTipText("");
		dateChooser.setBounds(195, 102, 95, 20);
		frmRegistroDeAsistencia.getContentPane().add(dateChooser);


		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 204));
		panel.setBackground(new Color(255, 255, 204));
		ButtonGroup descripcionAsist = new ButtonGroup();
		panel.setBounds(195, 293, 62, 66);

		JRadioButton optSi = new JRadioButton("S\u00ED", true);
		optSi.setBackground(new Color(255, 255, 204));
		JRadioButton optNo = new JRadioButton("No", false);
		optNo.setBackground(new Color(255, 255, 204));

		descripcionAsist.add(optSi);
		descripcionAsist.add(optNo);
		panel.add(optSi);
		panel.add(optNo);
		frmRegistroDeAsistencia.getContentPane().add(panel);
		
		

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(31, 553, 89, 23);
		frmRegistroDeAsistencia.getContentPane().add(btnRegistrar);

		// EMPLEADO
		List<Empleado> empleados = empleadoDao.recuperarEmpleados();
		ArrayList<String> stringComboEmpleado = new ArrayList<>();
		for (Empleado empleado : empleados) {
			stringComboEmpleado.add(empleado.getNombre());
		}
		JComboBox<Empleado> cmbEmpleado = new JComboBox(stringComboEmpleado.toArray());
		cmbEmpleado.setBounds(195, 151, 95, 20);
		frmRegistroDeAsistencia.getContentPane().add(cmbEmpleado);

		// CURSO
		List<Curso> cursos = cursoDao.recuperarCursos();
		ArrayList<String> stringComboCurso = new ArrayList<>();
		for (Curso curso : cursos) {
			stringComboCurso.add(curso.getDecripcion());
		}
		JComboBox cmbCurso = new JComboBox(stringComboCurso.toArray());
		cmbCurso.setBounds(195, 195, 95, 20);
		frmRegistroDeAsistencia.getContentPane().add(cmbCurso);

		JLabel lblAlumno = new JLabel("Alumno ");
		lblAlumno.setBounds(74, 245, 46, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblAlumno);

		// ALUMNO
		List<Alumno> alumnos = alumnoDao.recuperarAlumno();
		ArrayList<String> stringComboAlumno = new ArrayList<>();
		for (Alumno alumno : alumnos) {
			stringComboAlumno.add(alumno.getNombre());
		}
		JComboBox cmbAlumno = new JComboBox(stringComboAlumno.toArray());
		cmbAlumno.setBounds(195, 242, 95, 20);
		frmRegistroDeAsistencia.getContentPane().add(cmbAlumno);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AsistenciaPorCurso asistCurso = new AsistenciaPorCurso();
				// FECHA
				Date date = dateChooser.getDate();
				String fecha = DateFormat.getInstance().format(date);
				asistCurso.setFecha(fecha);

				// EMPLEADO
				Empleado emp = new Empleado();
				emp.setCodigo(cmbEmpleado.getSelectedItem().toString());
				asistCurso.setEmpleado(emp);

				// ALUMNO
				Alumno alm = new Alumno();
				alm.setCodigo(cmbAlumno.getSelectedItem().toString());
				asistCurso.setAlumno(alm);

				// CURSO
				Curso crs = new Curso();
				crs.setCodigo(cmbCurso.getSelectedItem().toString());
				asistCurso.setCurso(crs);
				
				//DESCRIPCION
				String descripcionAsistencia = null;
				if (optSi.isSelected()) {
					descripcionAsistencia = "Sí";
					asistCurso.setDescripcion(descripcionAsistencia);
				} else {
					optSi.setSelected(false);
					descripcionAsistencia = "No";
					asistCurso.setDescripcion(descripcionAsistencia);
				}


				AsistenciaPorCursoDao asistDao = new AsistenciaPorCursoDao();
				Boolean isDeleted = asistDao.eliminarAsistencia(asistCurso);

				if (isDeleted) {
					JOptionPane.showMessageDialog(null, "Eliminado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", null,
							JOptionPane.ERROR_MESSAGE, null);
				}

			}
		});
		btnEliminar.setBounds(148, 553, 89, 23);
		frmRegistroDeAsistencia.getContentPane().add(btnEliminar);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(74, 293, 46, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblDescripcin);

		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AsistenciaPorCurso asistCurso = new AsistenciaPorCurso();
				AsistenciaPorCursoDao asisteCursoDao = new AsistenciaPorCursoDao();
				try {

					// FECHA
					Date date = dateChooser.getDate();
					String fecha = DateFormat.getInstance().format(date);
					asistCurso.setFecha(fecha);

					// EMPLEADO
					Empleado emp = new Empleado();
					emp.setCodigo(cmbEmpleado.getSelectedItem().toString());
					// emp.setNombre(cmbEmpleado.getSelectedItem().toString());
					asistCurso.setEmpleado(emp);

					// ALUMNO
					Alumno alm = new Alumno();
					// alm.setNombre(cmbAlumno.getSelectedItem().toString());
					alm.setCodigo(cmbAlumno.getSelectedItem().toString());
					asistCurso.setAlumno(alm);

					// CURSO
					Curso crs = new Curso();
					// crs.setDecripcion(cmbCurso.getSelectedItem().toString());
					crs.setCodigo(cmbCurso.getSelectedItem().toString());
					asistCurso.setCurso(crs);
					
					//DESCRIPCION
					String descripcionAsistencia = null;
					if (optSi.isSelected()) {
						descripcionAsistencia = "Sí";
						asistCurso.setDescripcion(descripcionAsistencia);
					} else {
						optSi.setSelected(false);
						descripcionAsistencia = "No";
						asistCurso.setDescripcion(descripcionAsistencia);
					}

					Boolean isInserted = asisteCursoDao.registrarAsistencia(asistCurso);

					if (isInserted) {
						JOptionPane.showMessageDialog(null, "Registrado correctamente", "",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "No se pudo insertar el registro", null,
								JOptionPane.ERROR_MESSAGE, null);
					}

				} catch (SQLException e) {

					System.out.println(e.getMessage());

				}
			}

		});
	}

	private void add(JRadioButton optSi) {
		// TODO Auto-generated method stub

	}
}
