package models;

import java.util.Iterator;
import java.util.LinkedList;

public class Partido {

	private int ID_partido;
	private String lugar;
	private String fecha;
	private String hora;
	private int cantidadJugadores;
	private int cantidadInscriptos;
	private int precio;
	private Equipo[] equipos;

	public Partido() {
		this.equipos = new Equipo[2];
		this.equipos[0] = new Equipo();
		this.equipos[1] = new Equipo();
	}

	public Partido(String lugar, String fecha, String hora, int cantidadJugadores, int cantidadInscriptos, int precio, String nombreEquipoA, String nombreEquipoB) {
		this.lugar = lugar;
		this.fecha = fecha;
		this.hora = hora;
		this.cantidadJugadores = cantidadJugadores;
		this.cantidadInscriptos = cantidadInscriptos;
		this.precio = precio;
		this.equipos = new Equipo[2];
		this.equipos[0] = new Equipo(nombreEquipoA,cantidadJugadores/2,0);
		this.equipos[1] = new Equipo(nombreEquipoB,cantidadJugadores/2,0);
	}

	public void agregarJugador(Jugador jugador, String nombreEquipo) {
		if(this.equipos[0].getNombre().equals(nombreEquipo)) {
			this.equipos[0].agregarJugador(jugador);
		}
		else
			if(this.equipos[1].getNombre().equals(nombreEquipo)) {
				this.equipos[1].agregarJugador(jugador);
			}
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
	
	public int getCantidadInscriptos() {
		return cantidadInscriptos;
	}

	public void setCantidadInscriptos(int cantidadInscriptos) {
		this.cantidadInscriptos = cantidadInscriptos;
	}

	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Equipo[] getEquipos() {
		return equipos;
	}

	public void setEquipos(Equipo[] equipos) {
		this.equipos = equipos;
	}
	
	public void setEquipo(Equipo equipo, int i) {
		this.equipos[i]=equipo;
	}
	
	public Equipo getEquipo(int i) {
		return this.equipos[i];
	}
	
	public LinkedList<String> getEquiposList0() {
		LinkedList<String> equipos =  new LinkedList<String>();
		equipos.addLast(this.equipos[0].getNombre());
		equipos.addLast(this.equipos[1].getNombre());
		return equipos;
	}
	
	public Iterator<String> getEquiposList1() {
		LinkedList<String> equipos =  new LinkedList<String>();
		equipos.addLast(this.equipos[1].getNombre());
		return equipos.iterator();
	}
	
}
