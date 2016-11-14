package py.edu.pooj.uaa.siges.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import py.edu.uaa.pooj.siges_mtv.dao.AlumnoDao;
import py.edu.uaa.pooj.siges_mtv.model.Alumno;

public class AlumnoViewPrueba {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textNumeroCedula;
	private JTextField textDireccion;
	private JTextField textContacto;
	private JTextField textNacionalidad;
	private JTextField textEncargado;
	private JTextField textCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlumnoViewPrueba window = new AlumnoViewPrueba();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlumnoViewPrueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.GRAY);
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\USER\\workspace\\Sistema Gesti\u00F3n Escolar\\10522.png"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);

		JButton btnAceptar = new JButton("Aceptar ");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					Alumno alumno = new Alumno();

					String numeroCedula = textNumeroCedula.getText();
					alumno.setNumeroCedula(Integer.valueOf(numeroCedula));

					alumno.setNombre(textNombre.getText());
					alumno.setApellido(textApellido.getText());
//					alumno.setDireccion(textDireccion.getText());
//					alumno.setContacto(textContacto.getText());
//					alumno.setNacionalidad(textNacionalidad.getText());
//					alumno.setEncargado(textEncargado.getText());
//					alumno.setCurso(textCurso.getText());

					AlumnoDao alumnoDao = new AlumnoDao();
					Boolean isInserted = alumnoDao.registrarAlumno(alumno);

					if (isInserted) {
						JOptionPane.showMessageDialog(null, "Alumno registrado correctamente", "",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "No se pudo insertar el registro del alumno", null,
								JOptionPane.ERROR_MESSAGE, null);
					}

				} catch (SQLException e1) {

					System.out.println(e1.getMessage());

				}
			}

			
		});
		
		btnAceptar.setBounds(236, 227, 89, 23);
		frame.getContentPane().add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnCancelar);

		textNombre = new JTextField();
		textNombre.setBounds(131, 69, 86, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(26, 72, 46, 14);
		frame.getContentPane().add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(26, 97, 46, 14);
		frame.getContentPane().add(lblApellido);

		textApellido = new JTextField();
		textApellido.setBounds(131, 94, 86, 20);
		frame.getContentPane().add(textApellido);
		textApellido.setColumns(10);

		JLabel lblNmeroDeCdula = new JLabel("C.I. N\u00FAmero");
		lblNmeroDeCdula.setBounds(27, 44, 98, 14);
		frame.getContentPane().add(lblNmeroDeCdula);

		textNumeroCedula = new JTextField();
		textNumeroCedula.setBounds(131, 38, 86, 20);
		frame.getContentPane().add(textNumeroCedula);
		textNumeroCedula.setColumns(10);

		JLabel lblNewLabel = new JLabel("Direcci\u00F3n");
		lblNewLabel.setBounds(26, 128, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(26, 153, 46, 14);
		frame.getContentPane().add(lblContacto);

		textDireccion = new JTextField();
		textDireccion.setBounds(131, 125, 86, 20);
		frame.getContentPane().add(textDireccion);
		textDireccion.setColumns(10);

		textContacto = new JTextField();
		textContacto.setBounds(131, 150, 86, 20);
		frame.getContentPane().add(textContacto);
		textContacto.setColumns(10);

		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(28, 184, 68, 14);
		frame.getContentPane().add(lblNacionalidad);

		textNacionalidad = new JTextField();
		textNacionalidad.setBounds(131, 181, 86, 20);
		frame.getContentPane().add(textNacionalidad);
		textNacionalidad.setColumns(10);

		JLabel lblEncargado = new JLabel("Encargado");
		lblEncargado.setBounds(232, 44, 57, 14);
		frame.getContentPane().add(lblEncargado);

		textEncargado = new JTextField();
		textEncargado.setBounds(299, 41, 86, 20);
		frame.getContentPane().add(textEncargado);
		textEncargado.setColumns(10);

		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(236, 72, 46, 14);
		frame.getContentPane().add(lblCurso);

		textCurso = new JTextField();
		textCurso.setBounds(299, 69, 86, 20);
		frame.getContentPane().add(textCurso);
		textCurso.setColumns(10);

		JLabel lblAlumno = new JLabel("Alumno");
		lblAlumno.setBounds(168, 11, 46, 14);
		frame.getContentPane().add(lblAlumno);
	}
}
