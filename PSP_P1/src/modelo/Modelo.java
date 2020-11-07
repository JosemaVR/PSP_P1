package modelo;

import java.io.IOException;

import vista.Vista;

public class Modelo {

	public void añadir(String string, Long id, Vista vista) {
		vista.list.add(string);
		vista.procesos.add(string + "//" + id);
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
						vista.btnBloc.setEnabled(true);
						break;
					case "Juego":
						vista.btnBloc.setEnabled(true);
						break;
					case "Programa de gestion":
						vista.btnBloc.setEnabled(true);
						break;
				}
				vista.list.remove(i);
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
