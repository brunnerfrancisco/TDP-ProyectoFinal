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
	
	public ColeccionPartidos() throws IOException
    {
		String path = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/"+folderName);
		File f= new File(path+"/"+fileName);
		if(!f.exists()){
			Writer writer=null;
			try 
			{
			    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));
			} 
			catch (IOException ex) 
			{
				ex.printStackTrace();
			} 
			finally 
			{
				try 
				{
					writer.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
		FileReader fileReader=new FileReader(path+"/"+fileName);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        this.cantPartidos=0;
        this.partidos=new LinkedList<Partido>();
        this.cargar(bufferedReader);
    }
	
	private void cargar(BufferedReader archivo) throws IOException {
        String cod = archivo.readLine();
        while (cod != null) {
            Partido partido = new Partido();
            partido.setID_partido(Integer.parseInt(cod));
            partido.setLugar(archivo.readLine());
            partido.setFecha(archivo.readLine());
            partido.setHora(archivo.readLine());
            partido.setPrecio(Integer.parseInt(archivo.readLine()));
            partido.setCantidadJugadores(Integer.parseInt(archivo.readLine()));
	        partido.setCantidadInscriptos(Integer.parseInt(archivo.readLine()));
	            for(int i = 0; i < partido.getCantidadInscriptos(); i++) {
	            	String nombre=archivo.readLine();
	            	String apellido=archivo.readLine();
	            	String dni=archivo.readLine();
	            	partido.agregarJugador(new Jugador(nombre,apellido,dni));
	            }
	        
            this.partidos.add(partido);
            this.cantPartidos++;
            cod = archivo.readLine();
        }
    }
	
	public void agregarPartido(Partido p) throws IOException{
        this.partidos.add(p);
        this.cantPartidos++;
        this.guardar();
    }
	
	private void guardar() throws IOException
    {
    	String path=ServletActionContext.getServletContext().getRealPath(folderName);
		File f= new File(path);
		if(!f.exists()){
			Writer writer=null;
			try {
			    writer = new BufferedWriter(new OutputStreamWriter(
			          new FileOutputStream(fileName), "utf-8"));
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
			
		FileWriter fileWriter=new FileWriter(path+"/"+fileName);
        for(Partido partido : this.partidos)
        {
        	fileWriter.write(partido.getID_partido()+"\n");
            fileWriter.write(partido.getLugar()+"\n");
            fileWriter.write(partido.getFecha()+"\n");
            fileWriter.write(partido.getHora()+"\n");
            fileWriter.write(partido.getPrecio()+"\n");
            fileWriter.write(partido.getCantidadJugadores()+"\n");
            fileWriter.write(partido.getCantidadInscriptos()+"\n");
            
            for(Jugador jugador : partido.getInscriptos()) {
            	fileWriter.write(jugador.getNombre()+"\n");
            	fileWriter.write(jugador.getApellido()+"\n");
            	fileWriter.write(jugador.getDNI()+"\n");
            }
        }
        fileWriter.close();
    }
	
	public void agregarJugador(Jugador jugador, int ID_partido) {
		ValueStack stack = ActionContext.getContext().getValueStack();
        Partido partido = (Partido) stack.peek();
		partido.agregarJugador(jugador);
		partido.setCantidadInscriptos(partido.getCantidadInscriptos()+1);
		try {
			guardar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarJugador(int ID_partido, String DNI_jugador) {
		Partido encontre=null;
		for(Partido partido : this.partidos) {
			if(partido.getID_partido()==(ID_partido+1)) {
				encontre=partido;
				break;
			}
		}
		if(encontre!=null)
		{
			for(Jugador jugador : encontre.getInscriptos()) {
				if(jugador.getDNI().equals(DNI_jugador)) {
					encontre.getInscriptos().remove(jugador);
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

	public void eliminarPartido(int ID_partido) {
		for(Partido partido : this.partidos) {
			if(partido.getID_partido()==(ID_partido)) {
				partidos.remove(partido);
				break;
			}
		}
		try {
			guardar();
		} catch (IOException e) {
			e.printStackTrace();
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
