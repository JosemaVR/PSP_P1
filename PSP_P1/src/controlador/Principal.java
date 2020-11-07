package controlador;

import modelo.Modelo;
import vista.Vista;

public class Principal {

	public static void main(String[] args) {
		Vista objVista = new Vista();
		Modelo objModelo = new Modelo();
		
		new Controlador(objVista, objModelo);
	}
}
