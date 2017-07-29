package actions;

import java.io.IOException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import models.ColeccionPartidos;
import models.Jugador;

public class AgregarJugadorController extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String ID_seleccionado;
	
	private String nombre;
	private String apellido;
	private String dni;
	private Jugador jugador;
	
	public String execute() {
		try {
			jugador = new Jugador(nombre,apellido,dni);
			ColeccionPartidos partidos = new ColeccionPartidos();
			ValueStack stack = ActionContext.getContext().getValueStack();
			stack.push(partidos.getPartidos().get(Integer.parseInt(ID_seleccionado)-1));
			partidos.agregarJugador(jugador, Integer.parseInt(ID_seleccionado)-1);
		}catch(IOException e) {
			return "ERROR";
		}
		return "SUCCESS";
	}

	public String inscripcion()
	{
		try {
			ValueStack stack = ActionContext.getContext().getValueStack();
			ColeccionPartidos partidos = new ColeccionPartidos();
			stack.push(partidos.getPartidos().get(Integer.parseInt(ID_seleccionado)));
		}catch (IOException ex) {
			return "ERROR";
		}
		return "SUCCESS";
	}

	public String getID_seleccionado() {
		return ID_seleccionado;
	}

	public void setID_seleccionado(String iD_seleccionado) {
		ID_seleccionado = iD_seleccionado;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
}
