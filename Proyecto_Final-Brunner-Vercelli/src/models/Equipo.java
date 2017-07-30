package models;

import java.util.*;

public class Equipo {

	private String nombre;
	private int cantidadJugadores;
	private LinkedList<Jugador> jugadores;
	
	public Equipo() {
		this.jugadores = new LinkedList<Jugador>();
	}

	public Equipo(String nombre, int cantidadJugadores) {
		this.nombre = nombre;
		this.cantidadJugadores = cantidadJugadores;
		this.jugadores = new LinkedList<Jugador>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantidadJugadores() {
		return cantidadJugadores;
	}

	public LinkedList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCantidadJugadores(int cantidadJugadores) {
		this.cantidadJugadores = cantidadJugadores;
	}

	public void setJugadores(LinkedList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
}
