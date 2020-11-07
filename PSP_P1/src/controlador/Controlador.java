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
		        modelo.añadir("Bloc de notas", p.pid(), vista);
		        vista.btnBloc.setEnabled(false);
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