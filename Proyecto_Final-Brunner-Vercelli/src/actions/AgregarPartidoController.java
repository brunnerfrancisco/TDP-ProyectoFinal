package actions;

import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;

import models.ColeccionPartidos;
import models.Partido;

public class AgregarPartidoController extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String lugar;
	private String fecha;
	private String hora;
	private int precio;
	private int cantidadJugadores;
	private String nombreEquipo1;
	private String nombreEquipo2;
	private Partido partido;

	/**
	 * Crea el nuevo partido y lo agrega a la coleccion
	 * */
	public String execute()
	{
		partido=new Partido(lugar,fecha, hora, cantidadJugadores, 0, precio, nombreEquipo1, nombreEquipo2);
		try {
			ColeccionPartidos partidos=new ColeccionPartidos();
			partidos.agregarPartido(partido);
		}catch (IOException e) {
			return "ERROR";
		}
		return "SUCCESS";
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
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public int getCantidadJugadores() {
		return cantidadJugadores;
	}
	
	public void setCantidadJugadores(int cantidadJugadores) {
		this.cantidadJugadores = cantidadJugadores;
	}

	public String getNombreEquipo1() {
		return nombreEquipo1;
	}

	public String getNombreEquipo2() {
		return nombreEquipo2;
	}

	public void setNombreEquipo1(String nombreEquipo1) {
		this.nombreEquipo1 = nombreEquipo1;
	}

	public void setNombreEquipo2(String nombreEquipo2) {
		this.nombreEquipo2 = nombreEquipo2;
	}
	
}
