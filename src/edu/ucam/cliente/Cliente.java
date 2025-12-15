package edu.ucam.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
public void ejecutar() {
	Socket s;
	try {
		s = new Socket("localhost", 500);
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream())); 
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		Scanner scanner = new Scanner(System.in); 
		String linea;
		String l; 
		boolean bucle = true;
		while(bucle){
			System.out.println("Introduce una operacion");
			linea = scanner.nextLine();
			System.out.println(linea);
			pw.println(linea); pw.flush();
			if (linea.equals("FIN")) {
				bucle = false;
			}
			l = br.readLine();
			System.out.println(l);
		}
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static void main(String[] args) throws IOException {
	Cliente c = new Cliente(); 
	c.ejecutar();
}
}
