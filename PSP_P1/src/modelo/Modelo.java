package modelo;

import java.io.IOException;

import vista.Vista;

public class Modelo {

	public void añadir(String string, Process process, Vista vista) {
		vista.list.add(string);
		vista.procesos.add(string + "//" + process.pid());
		switch (vista.procesos.get(vista.procesos.size()-1).split("//")[0]) {
		case "Bloc de notas":
			vista.btnBloc.setEnabled(false);
			break;
		case "Paint":
			vista.btnPaint.setEnabled(false);
			break;
		case "Juego":
			vista.btnJuego.setEnabled(false);
			break;
		case "Programa de gestion":
			vista.btnGestion.setEnabled(false);
			break;
		}
	}

	public void matar(Vista vista) {
		for(int i=0; i<vista.list.countItems(); i++) {
			if(vista.list.getItem(i).toString().contains(vista.list.getSelectedItem())) {
				String cmd = "taskkill /F /PID " + vista.procesos.get(i).split("//")[1];
				switch (vista.procesos.get(i).split("//")[0]) {
				case "Bloc de notas":
					vista.btnBloc.setEnabled(true);
					break;
				case "Paint":
					vista.btnPaint.setEnabled(true);
					break;
				case "Juego":
					vista.btnJuego.setEnabled(true);
					break;
				case "Programa de gestion":
					vista.btnGestion.setEnabled(true);
					break;
				}
				vista.list.remove(i);
				vista.procesos.remove(i);
				try {
					Runtime.getRuntime().exec(cmd);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}