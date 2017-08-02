package actions;

import java.io.IOException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import models.ColeccionPartidos;
import models.Partido;

public class InscripcionController extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String ID_seleccionado;
	private String equipo_seleccionado;

	public String execute() {
		try {
			ValueStack stack = ActionContext.getContext().getValueStack();
			ColeccionPartidos partidos = new ColeccionPartidos();
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
		}catch (IOException ex) {
			return "ERROR";
		}
		return SUCCESS;
	}

	public String getID_seleccionado() {
		return ID_seleccionado;
	}

	public void setID_seleccionado(String iD_seleccionado) {
		ID_seleccionado = iD_seleccionado;
	}

	public String getEquipo_seleccionado() {
		return equipo_seleccionado;
	}

	public void setEquipo_seleccionado(String equipo_seleccionado) {
		this.equipo_seleccionado = equipo_seleccionado;
	}
}
