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
	private Partido partido;
	
	public String execute()
	{
		partido=new Partido();
		partido.setLugar(lugar);
		partido.setFecha(fecha);
		partido.setHora(hora);
		partido.setPrecio(precio);
		partido.setCantidadJugadores(cantidadJugadores);
		partido.setCantidadInscriptos(0);
		try {
			ColeccionPartidos partidos=new ColeccionPartidos();
			partido.setID_partido(partidos.getPartidos().size()+1);
			partidos.agregarPartido(partido);
		}catch (IOException e) {
			return "ERROR";
		}
		return "SUCCESS";
	}
	
	public String agregarPartido(){
		return SUCCESS;
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
