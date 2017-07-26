package models;

public class Jugador {
	private String nombre;
	private String apellido;
	private int DNI;
	
	public Jugador(String fname, String lname, int dni) {
		this.nombre = fname;
		this.apellido = lname;
		this.DNI = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}
}
