package vista;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	public JButton btnBloc = new JButton("Bloc de Notas");
	public JButton btnGestion = new JButton("Programa de gestión");
	public JButton btnJuego = new JButton("Juego");
	public JButton btnPaint = new JButton("Paint");
	public JTextArea areaCmd = new JTextArea();
	public JButton btnEjecutar = new JButton("Ejecutar");
	public JTextField txtCmd = new JTextField("");
	public JButton btnProcesos = new JButton("Finalizar proceso");
	public ArrayList<String> lista = new ArrayList<String>();
	public List list = new List();
	public ArrayList<String> procesos = new ArrayList<String>();
	public JScrollPane scroll = new JScrollPane(areaCmd);

	public Vista() {
		setTitle("PSP - Practica 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		btnBloc.setBounds(330, 10, 140, 25);
		contentPane.add(btnBloc);
		
		btnGestion.setBounds(330, 50, 140, 25);
		contentPane.add(btnGestion);
		
		btnJuego.setBounds(330, 90, 140, 25);
		contentPane.add(btnJuego);
		
		btnPaint.setBounds(330, 130, 140, 25);
		contentPane.add(btnPaint);
		
		scroll.setBounds(10, 50, 300, 300);
		//contentPane.add(areaCmd);
		areaCmd.setEditable(false);
		contentPane.add(scroll);
		
		btnEjecutar.setBounds(170, 10, 140, 25);
		contentPane.add(btnEjecutar);
		
		txtCmd.setBounds(10, 10, 140, 25);
		contentPane.add(txtCmd);
		txtCmd.setColumns(10);
		
		btnProcesos.setBounds(330, 325, 140, 25);
		contentPane.add(btnProcesos);
		
		list.setBounds(330, 170, 140, 140);
		contentPane.add(list);
	}
}
