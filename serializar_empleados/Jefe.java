package serializar_empleados;

import java.util.ArrayList;
import java.util.Iterator;

public class Jefe extends Empleado {
	
	ArrayList <Obrero> listaObreros;


	public Jefe(String nombre, int edad, double sueldo, String codigo) {
		super(nombre, edad, sueldo, codigo);
		// TODO Auto-generated constructor stub
		this.listaObreros = new ArrayList<>();
	}


	public ArrayList<Obrero> getListaObreros() {
		return listaObreros;
	}
	

	public void setListaObreros(ArrayList<Obrero> listaObreros) {
		this.listaObreros = listaObreros;
	}


	public void anyadirEmpleado(Obrero obrero) {
		listaObreros.add(obrero);
	}

	public void borrarEmpleadoObrero(String codigoEmpleado) {
		for (int i = 0; i < listaObreros.size(); i++) {
			if(codigoEmpleado.equalsIgnoreCase(listaObreros.get(i).getCodigo())){
				listaObreros.remove(i);
				break;
			}
		}
	}

	@Override
	public void subirSueldo(int valor) {
		// TODO Auto-generated method stub
		if(valor < 0 || valor > 100) {
			System.out.println("Introduce un valor comprendido entre 0 y 100");
		} else {
			double sueldoActual = this.getSueldo();
			setSueldo(sueldoActual + ((sueldoActual*valor)/100) + 120);
		}
	}
	/* he hecho un metodo para imprimir los nombres de su lista de obreros*/
	public void listarNombresObreros() {
		for(int i = 0; i< listaObreros.size();i++) {
			System.out.println(listaObreros.get(i).getNombre());
		}

	}
	/*
	 * • Utiliza la interfaz Iterator para recorrer los obreros de un jefe con un
	 * bucle while-hasNext().
	 */
	public void recorrerObrerosJefes() {
		Iterator<Obrero> it = listaObreros.iterator();
		while (it.hasNext()) {
			Obrero obrero = (Obrero) it.next();
			System.out.println(obrero.toString());
		}
	}

}


