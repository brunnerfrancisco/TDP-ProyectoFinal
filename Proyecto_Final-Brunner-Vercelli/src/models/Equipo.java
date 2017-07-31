package models;

import java.util.*;

public class Equipo {

	private String nombre;
	private int cantidadJugadores;
	private int cantidadInscriptos;
	private LinkedList<Jugador> jugadores;
	
	public Equipo() {
		this.jugadores = new LinkedList<Jugador>();
	}

	public Equipo(String nombre, int cantidadJugadores, int cantidadInscriptos) {
		this.nombre = nombre;
		this.cantidadJugadores = cantidadJugadores;
		this.cantidadInscriptos = cantidadInscriptos;
		this.jugadores = new LinkedList<Jugador>();
	}

	public void agregarJugador(Jugador jugador) {
		this.jugadores.add(jugador);
	}

	public void eliminarJugador(Jugador jugador) {
		this.jugadores.remove(jugador);
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantidadJugadores() {
		return cantidadJugadores;
	}

	public int getCantidadInscriptos() {
		return cantidadInscriptos;
	}

	public void setCantidadInscriptos(int cantidadInscriptos) {
		this.cantidadInscriptos = cantidadInscriptos;
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
