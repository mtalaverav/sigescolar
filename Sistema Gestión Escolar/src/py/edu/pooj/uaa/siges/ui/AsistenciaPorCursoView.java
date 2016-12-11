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
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

import py.edu.uaa.pooj.siges_mtv.dao.AlumnoDao;
import py.edu.uaa.pooj.siges_mtv.dao.AsistenciaPorCursoDao;
import py.edu.uaa.pooj.siges_mtv.dao.CursoDao;
import py.edu.uaa.pooj.siges_mtv.dao.EmpleadoDao;
import py.edu.uaa.pooj.siges_mtv.model.Alumno;
import py.edu.uaa.pooj.siges_mtv.model.AsistenciaPorCurso;
import py.edu.uaa.pooj.siges_mtv.model.Curso;
import py.edu.uaa.pooj.siges_mtv.model.Empleado;

public class AsistenciaPorCursoView {

	private JFrame frmRegistroDeAsistencia;
	private JTextField txtCodigo;

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

	private void initialize() {

		frmRegistroDeAsistencia = new JFrame();
		frmRegistroDeAsistencia.setAutoRequestFocus(false);
		frmRegistroDeAsistencia.getContentPane().setForeground(new Color(255, 255, 204));
		frmRegistroDeAsistencia.setFont(new Font("Arial", Font.PLAIN, 12));
		frmRegistroDeAsistencia.setBackground(UIManager.getColor("CheckBox.light"));
		frmRegistroDeAsistencia.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\USER\\git\\Sistema Gesti\u00F3n Escolar\\asistencia.png"));
		frmRegistroDeAsistencia.setTitle("Registro de Asistencia");
		frmRegistroDeAsistencia.getContentPane().setBackground(new Color(255, 255, 204));
		frmRegistroDeAsistencia.setBounds(100, 100, 703, 576);
		frmRegistroDeAsistencia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeAsistencia.getContentPane().setLayout(null);

		JLabel lblRegistroDeAsistencia = new JLabel("Registro de Asistencia Por Curso");
		lblRegistroDeAsistencia.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblRegistroDeAsistencia.setBounds(195, 23, 352, 46);
		frmRegistroDeAsistencia.getContentPane().add(lblRegistroDeAsistencia);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(UIManager.getColor("Button.light"));
		btnCancelar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirmar();
			}
		});
		btnCancelar.setBounds(560, 442, 89, 23);
		frmRegistroDeAsistencia.getContentPane().add(btnCancelar);

		JLabel lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblEmpleado.setBounds(84, 201, 62, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblEmpleado);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblFecha.setBounds(368, 108, 46, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblFecha);

		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblCurso.setBounds(84, 275, 46, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblCurso);

		JLabel lblJustificativo = new JLabel("Justificativo");
		lblJustificativo.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblJustificativo.setBounds(368, 238, 95, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblJustificativo);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setToolTipText("");
		dateChooser.setBounds(455, 102, 95, 20);
		frmRegistroDeAsistencia.getContentPane().add(dateChooser);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 204));
		panel.setBackground(new Color(255, 255, 204));
		ButtonGroup descripcionAsist = new ButtonGroup();
		panel.setBounds(455, 149, 95, 66);

		JRadioButton optSi = new JRadioButton("Presente\r\n", true);
		optSi.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		optSi.setBackground(new Color(255, 255, 204));
		JRadioButton optNo = new JRadioButton("Ausente", false);
		optNo.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		optNo.setBackground(new Color(255, 255, 204));

		descripcionAsist.add(optSi);
		descripcionAsist.add(optNo);
		panel.add(optSi);
		panel.add(optNo);
		frmRegistroDeAsistencia.getContentPane().add(panel);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(UIManager.getColor("Button.light"));
		btnRegistrar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnRegistrar.setBounds(30, 442, 100, 23);
		frmRegistroDeAsistencia.getContentPane().add(btnRegistrar);

		CursoDao cursoDao = new CursoDao();
		AlumnoDao alumnoDao = new AlumnoDao();
		EmpleadoDao empleadoDao = new EmpleadoDao();

		// EMPLEADO
		List<Empleado> empleados = empleadoDao.recuperarEmpleados();
		ArrayList<String> stringComboEmpleado = new ArrayList<>();
		for (Empleado empleado : empleados) {
			stringComboEmpleado.add(empleado.getNombre());
		}
		JComboBox<Empleado> cmbEmpleado = new JComboBox(stringComboEmpleado.toArray());
		cmbEmpleado.setBackground(new Color(255, 255, 204));
		cmbEmpleado.setBounds(195, 199, 95, 20);
		frmRegistroDeAsistencia.getContentPane().add(cmbEmpleado);

		// CURSO
		List<Curso> cursos = cursoDao.recuperarCursos();
		ArrayList<String> stringComboCurso = new ArrayList<>();
		for (Curso curso : cursos) {
			stringComboCurso.add(curso.getCodigo());
		}
		JComboBox cmbCurso = new JComboBox(stringComboCurso.toArray());
		cmbCurso.setBackground(new Color(255, 255, 204));
		cmbCurso.setBounds(195, 273, 95, 20);
		frmRegistroDeAsistencia.getContentPane().add(cmbCurso);

		JLabel lblAlumno = new JLabel("Alumno ");
		lblAlumno.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblAlumno.setBounds(84, 341, 83, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblAlumno);

		// ALUMNO
		List<Alumno> alumnos = alumnoDao.recuperarAlumno();
		ArrayList<String> stringComboAlumno = new ArrayList<>();
		for (Alumno alumno : alumnos) {
			stringComboAlumno.add(alumno.getNombre());
		}
		JComboBox cmbAlumno = new JComboBox(stringComboAlumno.toArray());
		cmbAlumno.setBackground(new Color(255, 255, 204));
		cmbAlumno.setBounds(195, 339, 95, 20);
		frmRegistroDeAsistencia.getContentPane().add(cmbAlumno);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(UIManager.getColor("Button.light"));
		btnEliminar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AsistenciaPorCurso asistCurso = new AsistenciaPorCurso();
				// FECHA
				// Date date = dateChooser.getDate();
				// String fecha = DateFormat.getInstance().format(date);
				// asistCurso.setFecha(fecha);

				asistCurso.setFecha(dateChooser.getDate());

				// EMPLEADO - Guarda como String
				 Empleado emp = new Empleado();
				 emp.setCodigo(cmbEmpleado.getSelectedItem().toString());
				 asistCurso.setEmpleado(emp);

				// Empleado - Guarda como Objeto
//				asistCurso.setEmpleado((Empleado) cmbEmpleado.getSelectedItem());

//				 ALUMNO - Guarda como String
				 Alumno alm = new Alumno();
				 alm.setCodigo(cmbAlumno.getSelectedItem().toString());
				 asistCurso.setAlumno(alm);

				// Alumno - Guarda como Objeto
				//asistCurso.setAlumno((Alumno) cmbAlumno.getSelectedItem());

				 // CURSO - Guarda como String
				 Curso crs = new Curso();
				 crs.setCodigo(cmbCurso.getSelectedItem().toString());
				 asistCurso.setCurso(crs);

				// Curso - Guarda el objeto
				//asistCurso.setCurso((Curso) cmbCurso.getSelectedItem());

				// DESCRIPCION
				String descripcionAsistencia = null;
				if (optSi.isSelected()) {
					descripcionAsistencia = "Presente";
					asistCurso.setDescripcion(descripcionAsistencia);
				} else {
					descripcionAsistencia = "Ausente";
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
		btnEliminar.setBounds(301, 442, 95, 23);
		frmRegistroDeAsistencia.getContentPane().add(btnEliminar);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblDescripcin.setBounds(368, 161, 83, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblDescripcin);

		JEditorPane dtrpnDescribaLaJustificacin = new JEditorPane();
		dtrpnDescribaLaJustificacin.setToolTipText("");
		dtrpnDescribaLaJustificacin.setBackground(new Color(255, 255, 255));
		dtrpnDescribaLaJustificacin.setBounds(368, 273, 236, 104);
		frmRegistroDeAsistencia.getContentPane().add(dtrpnDescribaLaJustificacin);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(UIManager.getColor("Button.light"));
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AsistenciaPorCurso asistCurso = new AsistenciaPorCurso();
				AsistenciaPorCursoDao asisteCursoDao = new AsistenciaPorCursoDao();

				// FECHA
				// Date date = dateChooser.getDate();
				// String fecha = DateFormat.getInstance().format(date);
				// asistCurso.setFecha(fecha);

				asistCurso.setFecha(dateChooser.getDate());

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

				// DESCRIPCION
				String descripcionAsistencia = null;
				if (optSi.isSelected()) {
					descripcionAsistencia = "Presente";
					asistCurso.setDescripcion(descripcionAsistencia);
				} else {
					descripcionAsistencia = "Ausente";
					asistCurso.setDescripcion(descripcionAsistencia);
				}

				// JUSTIFICATIVO
				asistCurso.setJustificativo(dtrpnDescribaLaJustificacin.getText().toString());

				Boolean isUpdated = asisteCursoDao.actualizarAsistencia(asistCurso);

				if (isUpdated) {
					JOptionPane.showMessageDialog(null, "Actualizado correctamente", "",
							JOptionPane.INFORMATION_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro", null,
							JOptionPane.ERROR_MESSAGE, null);
				}

			}
		});
		btnActualizar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnActualizar.setBounds(156, 442, 112, 23);
		frmRegistroDeAsistencia.getContentPane().add(btnActualizar);

		JButton btnInform = new JButton("Informe");
		btnInform.setBackground(UIManager.getColor("Button.light"));
		btnInform.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AsistenciaPorCursoConsultaView visible = new AsistenciaPorCursoConsultaView();
				visible.frmInformeAsistenciaDe.setVisible(true);
			}
		});
		btnInform.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnInform.setBounds(431, 442, 89, 23);
		frmRegistroDeAsistencia.getContentPane().add(btnInform);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblCdigo.setBounds(84, 109, 46, 14);
		frmRegistroDeAsistencia.getContentPane().add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(182, 106, 86, 20);
		frmRegistroDeAsistencia.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AsistenciaPorCurso asistCurso = new AsistenciaPorCurso();
				AsistenciaPorCursoDao asisteCursoDao = new AsistenciaPorCursoDao();
				try {

					asistCurso.setCodigo(txtCodigo.getText());

					// // FECHA
					// Date date = dateChooser.getDate();
					// String fecha = DateFormat.getInstance().format(date);
					// asistCurso.setFecha(fecha);

					asistCurso.setFecha(dateChooser.getDate());

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

					// DESCRIPCION
					String descripcionAsistencia = null;
					if (optSi.isSelected()) {
						descripcionAsistencia = "Presente";
						asistCurso.setDescripcion(descripcionAsistencia);
					} else {
						descripcionAsistencia = "Ausente";
						asistCurso.setDescripcion(descripcionAsistencia);
					}

					// JUSTIFICATIVO
					asistCurso.setJustificativo(dtrpnDescribaLaJustificacin.getText().toString());

					Boolean isInserted = asisteCursoDao.registrarAsistencia(asistCurso);

					if (isInserted) {
						JOptionPane.showMessageDialog(null, "Registrado correctamente", "",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "No se pudo insertar el registro", null,
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (SQLException e) {

					System.out.println(e.getMessage());
				}
			}
		});
	}
}
