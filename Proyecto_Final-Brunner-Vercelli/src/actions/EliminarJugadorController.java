package actions;

import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;

import models.ColeccionPartidos;

public class EliminarJugadorController extends ActionSupport{
	private String ID_partido_seleccionado;
	private String equipo_seleccionado;
	private String DNI_seleccionado;
	private static final long serialVersionUID = 1L;

	/**
	 * Elimina el jugador de la coleccion
	 * */
	public String execute() {
		try {
			ColeccionPartidos partidos = new ColeccionPartidos();
			partidos.eliminarJugador(Integer.parseInt(ID_partido_seleccionado), equipo_seleccionado, DNI_seleccionado);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}


	public String getID_partido_seleccionado() {
		return ID_partido_seleccionado;
	}

	public void setID_partido_seleccionado(String iD_partido_seleccionado) {
		ID_partido_seleccionado = iD_partido_seleccionado;
	}

	public String getDNI_seleccionado() {
		return DNI_seleccionado;
	}

	public void setDNI_seleccionado(String dNI_seleccionado) {
		DNI_seleccionado = dNI_seleccionado;
	}


	public String getEquipo_seleccionado() {
		return equipo_seleccionado;
	}


	public void setEquipo_seleccionado(String equipo_seleccionado) {
		this.equipo_seleccionado = equipo_seleccionado;
	}
	
	
}
