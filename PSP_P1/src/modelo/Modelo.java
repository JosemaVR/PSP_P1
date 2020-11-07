package modelo;

import java.io.IOException;

import vista.Vista;

public class Modelo {

	public void añadir(String string, Long id, Vista vista) {
		int i;
		int j = 1;
		for(i=0; i<vista.list.countItems(); i++) {
			if(vista.list.getItem(i).toString().contains(string)) {
				j++;
			}
		}
		vista.list.add(string + " " + j);
		vista.procesos.add(string + "//" + id);
	}

	public void matar(Vista vista) {
		for(int i=0; i<vista.list.countItems(); i++) {
			if(vista.list.getItem(i).toString().contains(vista.list.getSelectedItem())) {
				String cmd = "taskkill /F /PID " + vista.procesos.get(i).split("//")[1];
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
