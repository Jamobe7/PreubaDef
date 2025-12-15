package edu.ucam.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import edu.ucam.data.Vino;

public class Hilo extends Thread {
private int id; 
private Servidor server; 
private Socket socket;


public void run() {
	
	try {
		BufferedReader br = new BufferedReader(new InputStreamReader(this.socket.getInputStream())); 
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
		
		String linea; 
		String comando[]; 
		boolean bucle = true; 
		String respuesta; 
		
		while(bucle)
		{
			linea = br.readLine(); 
			comando = linea.split(" "); 
			respuesta = "comando invalido";
			switch (comando[0]) {
			case "ADDVINO":
				Vino v = new Vino(Integer.parseInt(comando[1]),Integer.parseInt(comando[2]), comando[3], 0);
				server.addvino(v);
				respuesta = "Vino creado " + v;
				break;
			case "GETVINO":
				Vino v2 = server.getvino(Integer.parseInt(comando[1]));
				respuesta = v2.toString();
				break;
			case "DELVINO":
				
				respuesta = server.delvino(Integer.parseInt(comando[1]));
				break;
			case "LIST":
				for (Vino vino : server.listar()) {
					pw.println(vino + "p"); pw.flush();
				}
				break;
			case "ADDVALORACION":
				server.addvaloracion(Integer.parseInt(comando[1]), Integer.parseInt(comando[2]));
				respuesta = "Valoracion añadida";
				break;
			case "FIN":
				bucle= false;
				break;
			
			default:
				break;
			}
			pw.println(respuesta); pw.flush();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public Hilo(int id, Servidor server, Socket socket) {
	super();
	this.id = id;
	this.server = server;
	this.socket = socket;
}
public Hilo() {
	super();
}


@Override
public String toString() {
	return "Hilo [id=" + id + "]";
}



}
