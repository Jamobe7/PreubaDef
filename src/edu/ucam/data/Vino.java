package edu.ucam.data;

public class Vino {
public int id; 
public int anio;
public String nombre; 
public int valoracion;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getValoracion() {
	return valoracion;
}
public void setValoracion(int valoracion) {
	this.valoracion = valoracion;
}
public Vino(int id, int anio, String nombre, int valoracion) {
	super();
	this.id = id;
	this.anio = anio;
	this.nombre = nombre;
	this.valoracion = valoracion;
}
public Vino() {
	super();
}
@Override
public String toString() {
	return "Vino [id=" + id + ", anio=" + anio + ", nombre=" + nombre + ", valoracion=" + valoracion + "]";
} 

}
