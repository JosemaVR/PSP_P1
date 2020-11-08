package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import modelo.Modelo;
import vista.Vista;

public class Controlador implements ActionListener, WindowListener{

	public Vista vista;
	public Modelo modelo;	
	public Process p;

	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;

		vista.btnBloc.addActionListener(this);
		vista.btnJuego.addActionListener(this);
		vista.btnGestion.addActionListener(this);
		vista.btnPaint.addActionListener(this);
		vista.btnProcesos.addActionListener(this);
		vista.btnEjecutar.addActionListener(this);
		
		vista.addWindowListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object fuente = e.getSource();
		if (fuente.equals(vista.btnBloc)) {
			try {
				p = Runtime.getRuntime().exec("notepad.exe");
				modelo.añadir("Bloc de notas", p, vista);
				new Thread(new Principal()).start();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (fuente.equals(vista.btnPaint)) {
			try {
				p = Runtime.getRuntime().exec("mspaint.exe");
				modelo.añadir("Paint", p, vista);
				new Thread(new Principal()).start();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (fuente.equals(vista.btnJuego)) {
			try {
				p = Runtime.getRuntime().exec("java.exe -jar C://Users/josev/Desktop/Juego.jar");
				modelo.añadir("Juego", p, vista);
				new Thread(new Principal()).start();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (fuente.equals(vista.btnGestion)) {
			try {
				p = Runtime.getRuntime().exec("java.exe -jar C://Users/josev/Desktop/ProgramaDeGestion.jar");
				modelo.añadir("Programa de gestion", p, vista);
				new Thread(new Principal()).start();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(fuente.equals(vista.btnEjecutar)) {
			try {
				p = Runtime.getRuntime().exec("cmd /c " + vista.txtCmd.getText());
				System.out.println("cmd " + vista.txtCmd.getText());
				modelo.ejecutarCmd(p, vista);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (fuente.equals(vista.btnProcesos)) {
			modelo.matar(vista);
		}
	}
}