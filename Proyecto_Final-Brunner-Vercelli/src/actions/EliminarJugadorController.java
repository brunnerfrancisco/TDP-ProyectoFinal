package actions;

import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;

import models.ColeccionPartidos;

public class EliminarJugadorController extends ActionSupport{
	private int ID_partido_seleccionado;
	private String DNI_seleccionado;
	private static final long serialVersionUID = 1L;

	public String execute() {
//	System.out.println(DNI_seleccionado);
//		System.out.println(ID_partido_seleccionado);
		try {
			ColeccionPartidos partidos = new ColeccionPartidos();
			partidos.eliminarJugador(ID_partido_seleccionado, DNI_seleccionado);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}


	public int getID_partido_seleccionado() {
		return ID_partido_seleccionado;
	}

	public void setID_partido_seleccionado(int iD_partido_seleccionado) {
		ID_partido_seleccionado = iD_partido_seleccionado;
	}

	public String getDNI_seleccionado() {
		return DNI_seleccionado;
	}

	public void setDNI_seleccionado(String dNI_seleccionado) {
		DNI_seleccionado = dNI_seleccionado;
	}
	
	
}
