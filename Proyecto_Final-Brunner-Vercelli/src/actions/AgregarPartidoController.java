package actions;

import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;

import models.ColeccionPartidos;
import models.Partido;

public class AgregarPartidoController extends ActionSupport {
	private static final long serialVersionUID = 1L; // esto esta para que no aparezca warning
	private String lugar;
	private String fecha;
	private String hora;
	private int precio;
	private int cantidadJugadores;
	private Partido partido;
	
	public String agregarPartido()
	{
		partido=new Partido();
		partido.setLugar(lugar);
		partido.setFecha(fecha);
		partido.setHora(hora);
		partido.setPrecio(precio);
		partido.setCantidadJugadores(cantidadJugadores);
		try {
			ColeccionPartidos partidos=new ColeccionPartidos();
			System.out.println(partidos.toString());
			partidos.agregarPartido(partido);
		}catch (IOException e) {
			System.out.println(e.getMessage());
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
	
}
