package models;

import java.util.*;

public class Partido {
	private int ID_partido;
	private String lugar;
	private String fecha;
	private String hora;
	private int cantidadJugadores;
	private int precio;
	private LinkedList<Jugador> inscriptos;
	
	public Partido() {
		this.inscriptos = new LinkedList<Jugador>();
	}
	
	public int getID_partido() {
		return ID_partido;
	}

	public void setID_partido(int iD_partido) {
		ID_partido = iD_partido;
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
	
	public LinkedList<Jugador> getInscriptos() {
		return inscriptos;
	}
	
	public void setInscriptos(LinkedList<Jugador> inscriptos) {
		this.inscriptos = inscriptos;
	}
	
}
