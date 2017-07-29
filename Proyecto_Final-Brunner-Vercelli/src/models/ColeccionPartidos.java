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
//		System.out.println(path);
		File f= new File(path+"/"+fileName);
		if(!f.exists()){
			Writer writer=null;
			try 
			{
			    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));
			} 
			catch (IOException ex) 
			{
				System.out.println(ex.getMessage());
			} 
			finally 
			{
				try 
				{
					writer.close();
				} catch (Exception ex) {System.out.println(ex.getMessage());}
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
        
//        System.out.println(cod);
        while (cod != null) {
            Partido partido = new Partido();
            partido.setID_partido(Integer.parseInt(cod));
            partido.setLugar(archivo.readLine());//String lugar = archivo.readLine();
            partido.setFecha(archivo.readLine());//String fecha = archivo.readLine();
            partido.setHora(archivo.readLine());//String hora = archivo.readLine();
            partido.setPrecio(Integer.parseInt(archivo.readLine()));//String precio = archivo.readLine();
            partido.setCantidadJugadores(Integer.parseInt(archivo.readLine()));//String cantJugadores = archivo.readLine();
	        partido.setCantidadInscriptos(Integer.parseInt(archivo.readLine()));
	            for(int i = 0; i < partido.getCantidadInscriptos(); i++) {
	            	String nombre=archivo.readLine();//System.out.println("nom"+nombre);
	            	String apellido=archivo.readLine();//System.out.println("ape"+apellido);
	            	String dni=archivo.readLine();//System.out.println("dni:"+dni);
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
				System.out.println(ex.getMessage());
			} finally {
			   try {
				   writer.close();
			   } catch (Exception ex) {System.out.println(ex.getMessage());}
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
//            	System.out.println("Guardo los datos del jugador: "+jugador.getDNI());
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

	public void eliminarJugador(int ID_partido, String DNI_jugador) {
		Partido encontre=null;
		for(Partido partido : this.partidos) {
//			System.out.println(partido.getID_partido());
//			System.out.println(ID_partido);
			if(partido.getID_partido()==(ID_partido+1))
			{
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
	
}
