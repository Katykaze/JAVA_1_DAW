package serializar_empleados;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;





public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//
		TreeMap<Integer, Obrero> mapaObreros= new TreeMap<>(); ;
		//File archivo=null;
		Jefe jefe= new Jefe("Marta", 40, 3000, "j1");
		Obrero obrero = new Obrero("Lorena", 29, 1800, "o1");
		mapaObreros.put(1, obrero);
		//listaObreros.add(obrero);
		Obrero obrero2 =new Obrero("Clara", 20, 3500,"o1");
		mapaObreros.put(2, obrero2);
		//listaObreros.add(obrero2);
		System.out.println("imprimimos mapa antes de mneter en fichero");
		System.out.println(mapaObreros);

		File archivo; 
		ObjectInputStream oin;
		FileOutputStream fili;
		BufferedOutputStream bout;
		DataOutputStream daout;
		ObjectOutputStream oout;
		FileInputStream filin;
		BufferedInputStream bin;
		DataInputStream din;
		
		 
		try{
			archivo = new File("empleados.txt");
			
			fili = new FileOutputStream(archivo);
			bout = new BufferedOutputStream(fili);
			daout = new DataOutputStream (bout);
			
			//oout = new ObjectOutputStream(bout);
			daout.writeUTF(obrero.getNombre());
			daout.writeInt(obrero.getEdad());
			daout.writeDouble(obrero.getSueldo());
			daout.writeUTF(obrero.getCodigo());
			daout.writeUTF(obrero2.getNombre());
			daout.writeInt(obrero2.getEdad());
			daout.writeDouble(obrero2.getSueldo());
			daout.writeUTF(obrero2.getCodigo());
			daout.flush();
			//daout.close();
			//para leerlos
			 filin = new FileInputStream(archivo);
			 bin = new BufferedInputStream (filin);
			 din = new DataInputStream(bin);
			 
			 
			 
			
			
			System.out.println(daout.size()+ "tamano");
			 
			 System.out.println("nombre" + din.readUTF());
			 System.out.println("edad " + din.readInt());
			 System.out.println("su sueldo es " +din.readDouble() );
			 System.out.println("su codigo es " + din.readUTF());
			 System.out.println("-------------------------");
			 System.out.println("nombre " + din.readUTF());
			 System.out.println("edad " + din.readInt());
			 System.out.println("su sueldo es " +din.readDouble() );
			 System.out.println("su codigo es " + din.readUTF());
			 //meterlos en un mapa  y leerlos con object y escribirlos
			 //din.close();
			 oout= new ObjectOutputStream (bout);
			 oout.writeObject(mapaObreros);
			oout.flush();
			//para leerlo
			oin = new ObjectInputStream(bin);
			mapaObreros = (TreeMap<Integer, Obrero>)oin.readObject();
			System.out.println("aqui imprimimos el fichero de objetos ");
			System.out.println(mapaObreros);
			Set <Map.Entry<Integer,Obrero>> listaConvert= mapaObreros.entrySet();
			List <Map.Entry<Integer,Obrero>> listaMapa= new ArrayList(listaConvert);
			Collections.sort(listaMapa,new OrdernarObreroEdada());
			System.out.println("imprimiendo la lista concvertida de mapa en otro orden");
			System.out.println(listaMapa);
		
			//conjunto de claves exclusivamente 
			Set<Integer> conjuntoClaves= mapaObreros.keySet();
			System.out.println(conjuntoClaves);
			//coleccion de valores del mapa
			Collection<Obrero> coleccionObreros= mapaObreros.values();
			System.out.println(coleccionObreros);
			//MIRAR IMPRIMIR EMPLEADO
			//borrar empleado
			Iterator<Entry<Integer,Obrero>> itObrero = listaConvert.iterator();
			while(itObrero.hasNext()) {
				Entry<Integer,Obrero> obreroA = itObrero.next();
				if(obreroA.getValue().getEdad() >25) {
					System.out.println(obreroA + " --------");
				}
				/*if(itObrero.next().getValue().getEdad() >25) {
					itObrero.remove();
				}*/
		
		}
			System.out.println(coleccionObreros);
			
			daout.close();
			din.close();
			bout.close();
			oout.close(); 
			bin.close();
			oin.close();
			
				
		}catch(IOException e) {
			
			System.err.println(e.getMessage());
		}catch(IndexOutOfBoundsException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
