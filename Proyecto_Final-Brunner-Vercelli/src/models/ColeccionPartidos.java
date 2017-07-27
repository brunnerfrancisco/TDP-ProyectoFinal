package models;

import java.io.*;
import java.util.LinkedList;

import org.apache.struts2.ServletActionContext;

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
//            System.out.println(archivo.readLine());
            partido.setID_partido(Integer.parseInt(cod));
            partido.setLugar(archivo.readLine());//String lugar = archivo.readLine();
            partido.setFecha(archivo.readLine());//String fecha = archivo.readLine();
            partido.setHora(archivo.readLine());//String hora = archivo.readLine();
            partido.setPrecio(Integer.parseInt(archivo.readLine()));//String precio = archivo.readLine();
            partido.setCantidadJugadores(Integer.parseInt(archivo.readLine()));//String cantJugadores = archivo.readLine();
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
//        int c=0;
        for(Partido partido : this.partidos)
        {
//            Partido partido=partidos.get(c);
        	fileWriter.write(partido.getID_partido()+"\n");
            fileWriter.write(partido.getLugar()+"\n");
            fileWriter.write(partido.getFecha()+"\n");
            fileWriter.write(partido.getHora()+"\n");
            fileWriter.write(partido.getPrecio()+"\n");
            fileWriter.write(partido.getCantidadJugadores()+"\n");
//            c++;
        }
        fileWriter.close();
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
