package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import modelo.Modelo;
import vista.Vista;

public class Principal implements Runnable {

	static Vista vista = new Vista();
	static Modelo modelo = new Modelo();

	public Principal() {
	}

	public void run() {
		try {
			while(0!=vista.procesos.size()) {
				Thread.sleep(1500);
				for(int k=0; k<vista.procesos.size(); k++) {
					String cmd = "cmd /c tasklist /FI \"PID eq " + vista.procesos.get(k).split("//")[1] +"\"";
					if(vista.procesos.size()!=0) {	
						Process p = Runtime.getRuntime().exec(cmd);
						BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
						InputStream is = p.getInputStream();
						InputStreamReader isr = new InputStreamReader(is);
						BufferedReader br = new BufferedReader(isr);
						String line;
						br.readLine();
						br.readLine();
						br.readLine();
						if ((line = br.readLine()) == null)
						{
							if(vista.procesos.size()!=0 && vista.procesos.size()>=k) {
								switch (vista.procesos.get(k).split("//")[0]) {
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
								if(vista.list.countItems()!=0) {
									vista.list.remove(k);
									vista.procesos.remove(k);
								}
							}
						}
						is.close();
					}
				}
			}
			Thread.currentThread().stop();
		}
		catch (InterruptedException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Controlador(vista, modelo);
		vista.txtCmd.grabFocus();
	}
}
