package edu.ucam.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;

import edu.ucam.data.Vino;

public class Servidor {
	ArrayList<Hilo> hilos = new ArrayList<Hilo>();
	ArrayList<Vino> vinos = new ArrayList<Vino>();
public void ejecutar() 
{
	int i = 0;
	ServerSocket server;
	System.out.println("Servidor iniciado");
	try {
		server = new ServerSocket(500);
		while(true) {
			Socket s = server.accept();
			Hilo h = new Hilo(i++, this, s);
			h.start();
			hilos.add(h);
			
			System.out.println(h);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	
}
public static void main(String[] args) throws IOException {
	Servidor s = new Servidor(); 
	s.ejecutar();
}


public String addvino(Vino v) {
	
	if(vinos.contains(v))
	{
		return "El vino con esa id ya existe";
	}
	vinos.add(v);
	return "Vino aniadido";
}

public Vino getvino(int id){
	Vino v = vinos.get(id-1);
	return v;
}
public String delvino(int id) {
	vinos.remove(id-1);
	return "Vino borrado";
}

public ArrayList<Vino> listar()
{
	return vinos;
}

public String addvaloracion(int id, int val)
{
	vinos.get(id-1).setValoracion(val);
	return "valoracion nueva";
}
}
