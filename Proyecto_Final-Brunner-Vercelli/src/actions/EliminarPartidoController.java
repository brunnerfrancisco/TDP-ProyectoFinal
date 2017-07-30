package actions;

import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;

import models.ColeccionPartidos;

public class EliminarPartidoController extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String ID_partido_seleccionado;

	/**
	 * Elimina el partido de la coleccion
	 * */
	public String execute() {
		try {
			ColeccionPartidos partidos = new ColeccionPartidos();
			partidos.eliminarPartido(Integer.parseInt(ID_partido_seleccionado));
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
}
