package models;

import java.util.*;

public class Partido {
	private String lugar;
	private String fecha;
	private String hora;
	private int cantidadJugadores;
	private int precio;
	private LinkedList<String> inscriptos;
	
	public Partido() {
		this.inscriptos = new LinkedList<String>();
	}
	
	public String getLugar() {
		return lugar;
	}
	
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getHora() {
		return hora;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public int getCantidadJugadores() {
		return cantidadJugadores;
	}
	
	public void setCantidadJugadores(int cantidadJugadores) {
		this.cantidadJugadores = cantidadJugadores;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public LinkedList<String> getInscriptos() {
		return inscriptos;
	}
	
	public void setInscriptos(LinkedList<String> inscriptos) {
		this.inscriptos = inscriptos;
	}
	
}
