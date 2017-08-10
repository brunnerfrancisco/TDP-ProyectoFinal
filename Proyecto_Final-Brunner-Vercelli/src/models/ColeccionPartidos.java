package models;

import java.io.*;
import java.util.LinkedList;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class ColeccionPartidos {
	private static final String folderName="WEB-INF/files";
	private static final String fileName="partido.txt";
	private LinkedList<Partido> partidos;
	private int cantPartidos;

	/**
	 * ColeccionPartidos()
	 * Constructor: Abre el achivo en modo lectura donde estan almacenados los datos de los partidos y jugadores
	 * 		y prepara las estructuras para cargar los datos del archivo
	 * */
	public ColeccionPartidos() throws IOException {
		String path = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/"+folderName);
		File file = new File(path+"/"+fileName);
		if(!file.exists()) {
			Writer writer=null;
			try {
			    writer = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(fileName), "utf-8" ) );
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				try {
					writer.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
		FileReader fileReader = new FileReader(path+"/"+fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        this.cantPartidos = 0;
        this.partidos = new LinkedList<Partido>();
        this.cargar(bufferedReader);
    }

	/**
	 * cargar(BufferdReader archivo): void
	 * Carga los datos de archivo y los inserta dentro de las estructuras
	 * */
	private void cargar(BufferedReader archivo) throws IOException {
        String cod = archivo.readLine();
        //System.out.println("------------------------");
        while (cod != null) {
            Partido partido = new Partido();
            partido.setID_partido(Integer.parseInt(cod));
            partido.setLugar(archivo.readLine());
            partido.setFecha(archivo.readLine());
            partido.setHora(archivo.readLine());
            partido.setPrecio(Integer.parseInt(archivo.readLine()));
            partido.setCantidadJugadores(Integer.parseInt(archivo.readLine()));
	        partido.setCantidadInscriptos(Integer.parseInt(archivo.readLine()));
	            //System.out.println("Lugar Partido: "+partido.getLugar());
	        	for(int i = 0; i<2;i++) {
	        		String nombreEquipo = archivo.readLine();//System.out.println("Nombre Equipo: "+nombreEquipo);
	        		String cantidadJugadoresEquipo = archivo.readLine();//System.out.println("Cant Juga: "+cantidadJugadoresEquipo);
	        		String cantidadInscriptosEquipo = archivo.readLine();//System.out.println("Cant Insc: "+cantidadInscriptosEquipo);
	        		partido.setEquipo(new Equipo(nombreEquipo,Integer.parseInt(cantidadJugadoresEquipo),Integer.parseInt(cantidadInscriptosEquipo)),i);
	        		//System.out.println("Equipos.getCantidadInscriptos(): "+partido.getEquipo(i).getCantidadInscriptos());
	        		for(int j = 0; j < partido.getEquipo(i).getCantidadInscriptos(); j++) {
		            	String nombre = archivo.readLine();//System.out.println("Jugador Nombre: "+nombre);
		            	String apellido = archivo.readLine();//System.out.println("Jugador Apellido: "+apellido);
		            	String dni = archivo.readLine();//System.out.println("Jugador DNI: "+dni);
		            	partido.agregarJugador( new Jugador( nombre, apellido, dni ), nombreEquipo );
		            }
	        	}
	          
            this.partidos.add(partido);
            this.cantPartidos++;
            cod = archivo.readLine();
        }
    }
	/**
	 * guardar(): void
	 * Abre el achivo en modo escritura donde estan almacenados los datos de los partidos y jugadores
	 * 		y guarda los archivos cargados en las estructuras de la coleccion
	 * */
	private void guardar() throws IOException
    {
    	String path = ServletActionContext.getServletContext().getRealPath(folderName);
		File file = new File(path);
		if(!file.exists()) {
			Writer writer=null;
			try {
				writer = new BufferedWriter( new OutputStreamWriter( new FileOutputStream( fileName ), "utf-8" ) );
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				try {
					writer.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		FileWriter fileWriter = new FileWriter(path+"/"+fileName);
		int i=0;
        for( Partido partido : this.partidos )
        {
        	fileWriter.write(i+"\n");
            fileWriter.write(partido.getLugar()+"\n");
            fileWriter.write(partido.getFecha()+"\n");
            fileWriter.write(partido.getHora()+"\n");
            fileWriter.write(partido.getPrecio()+"\n");
            fileWriter.write(partido.getCantidadJugadores()+"\n");
            fileWriter.write(partido.getCantidadInscriptos()+"\n");
            for(Equipo equipo : partido.getEquipos()) {
            	fileWriter.write(equipo.getNombre()+"\n");
            	fileWriter.write(equipo.getCantidadJugadores()+"\n");
            	fileWriter.write(equipo.getCantidadInscriptos()+"\n");
	            for(Jugador jugador : equipo.getJugadores()) {
	            	fileWriter.write(jugador.getNombre()+"\n");
	            	fileWriter.write(jugador.getApellido()+"\n");
	            	fileWriter.write(jugador.getDNI()+"\n");
	            }
            }
            i++;
        }
        fileWriter.close();
    }

	/**
	 * agregarPartido(Partido partido)
	 * @param partido: partido a ser agregado
	 * Agrega el partido a la lista de partidos y lo guarda en el archivo
	 * */
	public void agregarPartido(Partido partido) throws IOException{
        this.partidos.add(partido);
        this.cantPartidos++;
        this.guardar();
    }

	/**
	 * eliminarPartido(int ID_partido)
	 * @param ID_partido: ID del partido a ser eliminado
	 * Elimina el partido a la lista de partidos y guarda los datos en el archivo
	 * */
	public void eliminarPartido(int ID_partido) {
		for(Partido partido : this.partidos) {
			if(partido.getID_partido()==(ID_partido)) {
				partidos.remove(partido);
				this.cantPartidos--;
				break;
			}
		}
		try {
			guardar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * agregarJugador(Jugador jugador, int ID_partido)
	 * @param jugador: jugador a ser agregado
	 * @param ID_partido: ID del partido donde va a ser agregado el jugador
	 * Agrega el jugador a la lista de jugadores del partido ID_partido y lo guarda en el archivo
	 * */
	public void agregarJugador(Jugador jugador, int ID_partido, String nombreEquipo) {
		ValueStack stack = ActionContext.getContext().getValueStack();
        Partido partido = (Partido) stack.peek();
		partido.agregarJugador(jugador, nombreEquipo);
		partido.setCantidadInscriptos(partido.getCantidadInscriptos()+1);
		if(partido.getEquipo(0).getNombre().equals(nombreEquipo))
			partido.getEquipo(0).setCantidadInscriptos(partido.getEquipo(0).getCantidadInscriptos()+1);
		else
			if(partido.getEquipo(1).getNombre().equals(nombreEquipo))
				partido.getEquipo(1).setCantidadInscriptos(partido.getEquipo(1).getCantidadInscriptos()+1);
		try {
			guardar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * eliminarJugador(int ID_partido, String DNI_jugador)
	 * @param ID_partido: ID del partido donde se encuentra el jugador a ser eliminado
	 * @param DNI_jugador: DNI del jugador a ser eliminado
	 * Elimina el jugador de la lista de jugadores del partido ID_partido y guarda los datos en el archivo
	 * */
	public void eliminarJugador(int ID_partido,String nombreEquipo, String DNI_jugador) {
		Partido encontre=null;
		for(Partido partido : this.partidos) {
			if(partido.getID_partido()==(ID_partido)) {
				encontre = partido;
				break;
			}
		}
		Equipo equipo=null;
		for(Equipo e : encontre.getEquipos())
			if(e.getNombre().equals(nombreEquipo))
				equipo=e;
		if(encontre!=null && equipo!=null) {
			for(Jugador jugador : equipo.getJugadores()) {
				if(jugador.getDNI().equals(DNI_jugador)) {
					equipo.getJugadores().remove(jugador);
					equipo.setCantidadInscriptos(equipo.getCantidadInscriptos()-1);
					encontre.setCantidadInscriptos(encontre.getCantidadInscriptos()-1);
					break;
				}
			}
			try {
				guardar();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public LinkedList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(LinkedList<Partido> partidos) {
		this.partidos = partidos;
	}

	public int getCantPartidos() {
		return cantPartidos;
	}

	public void setCantPartidos(int cantPartidos) {
		this.cantPartidos = cantPartidos;
	}

}
