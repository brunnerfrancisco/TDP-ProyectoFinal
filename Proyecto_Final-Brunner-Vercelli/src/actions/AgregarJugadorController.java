package actions;

import java.io.IOException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import models.ColeccionPartidos;
import models.Jugador;
import models.Partido;

public class AgregarJugadorController extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String ID_seleccionado;
	private String equipo_seleccionado;
	
	private String nombre;
	private String apellido;
	private String dni;
	private Jugador jugador;
	
	/**
	 * execute(): String | 
	 * Recupera el partido seleccionado, lo coloca en el tope de la pila y agrega el nuevo jugador a la coleccion
	 * */
	public String execute() {
		try {
			jugador = new Jugador(nombre,apellido,dni);
			ColeccionPartidos partidos = new ColeccionPartidos();
			ValueStack stack = ActionContext.getContext().getValueStack();
			Partido aInscribir=null;
			for(Partido partido : partidos.getPartidos()) {
				if(partido.getID_partido()==Integer.parseInt(ID_seleccionado)) {
					aInscribir=partido;
				}
			}
			if(aInscribir!=null) {
				stack.push(aInscribir);
			}else {
				return "ERROR";
			}
			partidos.agregarJugador(jugador, Integer.parseInt(ID_seleccionado), equipo_seleccionado);
		}catch(IOException ex) {
			return "ERROR";
		}
		return SUCCESS;
	}

	public void validate() {
		if(nombre.length()==0) {
			addFieldError("nombre","El nombre es un campo requerido");
		}else if(apellido.length()==0) {
			addFieldError("apellido","El apellido es un campo obligatorio");
		}else if(dni.length()==0) {
			addFieldError("dni","El DNI es un campo obligatorio");
		}else {
			try {
				Integer.parseInt(dni);
			}catch(NumberFormatException e) {
				addFieldError("dni","El DNI debe ser un numero entero");
			}
		}
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

	public String getEquipo_seleccionado() {
		return equipo_seleccionado;
	}

	public void setEquipo_seleccionado(String equipo_seleccionado) {
		this.equipo_seleccionado = equipo_seleccionado;
	}
	
}
