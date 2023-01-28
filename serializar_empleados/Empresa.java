package serializar_empleados;

/*import java.io.DataOutputStream;
import java.io.IOException;*/
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
//import java.util.Comparator;
import java.util.Iterator;

public class Empresa {

	private int numeroObreros, numeroJefes;
	ArrayList<Empleado> empleados;
	// ArrayList <Obrero> listaObreros = new ArrayList <> ();
	// ArrayList <Jefe> listaJefes = new ArrayList <> ();

	public Empresa() {
		this.numeroObreros = 0;
		this.numeroJefes = 0;
		this.empleados = new ArrayList<>();
	}
	

	public void anyadirJefe(String nombre, int edad, double sueldo) {
		numeroJefes++;
		String codigo = "J" + numeroJefes;
		Jefe jefe = new Jefe(nombre, edad, sueldo, codigo);
		empleados.add(jefe);
	}

	public void anyadairObrero(String nombre, int edad, double sueldo, Jefe jefe) {
		numeroObreros++;
		String codigo = "O" + numeroObreros;
		Obrero obrero = new Obrero(nombre, edad, sueldo, codigo, jefe);
		empleados.add(obrero);
		/* he anadido un if para controlar que si esta null le meta ese obrero */
		if (jefe != null) {
			jefe.anyadirEmpleado(obrero);
		}
	}

	public int buscarEmpleado(String codigoEmpleado) {
		int posicionEmpleado = -1;
		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.get(i).getCodigo().equalsIgnoreCase(codigoEmpleado)) {
				posicionEmpleado = i;
				break;
			}
		}
		return posicionEmpleado;
	}

	//// ESTE METODO .REMOVE(INDEX) ES PROPIO DE ARRAYLIST
	public void borrarEmpleado(int index) {
		empleados.remove(index);
	}

	// ESTE METODO .GET(INDEX) ES PROPIO DE ARRAYLIST
	public Empleado getEmpleado(int index) {
		return empleados.get(index);
	}

	public boolean validarNombre(String nombre) {
		for (Empleado empleado : empleados) {
			// empleados.get(i).getNombre();
			if (empleado.getNombre().equalsIgnoreCase(nombre)) {
				System.err.println("El nombre ya existe, Por favor, elija otro nombre");
				// realmente no estoy segura, pero la idea es que si es así, no le deje seguir
				// con el resto del proceso

				return true;
			}

		}
		return false;

	}

	// metodo subida de sueldos general
	public void subirSueldos(int porcentaje) {

		for (Empleado empleado : empleados) {
			empleado.subirSueldo(porcentaje);
		}

	}

	// metodo para listar datos codigo,nombre, edad, sueldo de todos los empleados
	public void listarDatos() {
		for (Empleado empleado : empleados) {
			System.out.println(empleado.toString());
		}
		/*
		 * for (Empleado empleado : empleados) {
		 * System.out.println(empleado.toString()); }
		 */
	}

	/*
	 * CREAMOS METODOS PARA LLAMAR LOS METODOS DE LAS OTRAS CLASES YA QUE EMPRESA ES
	 * LA CLASE GESTORA!!!! POR ESO ES IMPORTANTE PONERLAS AQUI, ASI DESDE EL MAIN
	 * SE LLAMARAN CON OBJETO DE CLASE EMPRESA metodo creadoe n clase empleado que
	 * ordenara naturalmente por codigos
	 */
	public void ordenar() {
		Collections.sort(empleados);

	}

	// metodo de clase Ordenar...
	public void ordenarPorSueldo() {
		Collections.sort(empleados, new OrdenarEmpleadoPorSueldo());
		// Collections.sort(empleados, Collections.reverseOrder(new
		// OrdenarEmpleadosPorSuelod()));
	}

	// metodo de clase Ordenar...
	public void ordenarPorNombre() {
		Collections.sort(empleados, new OrdenarEmpleadosPorNombre());
	}

	// metodo para ordenar por edad
	public void ordenarPorEdad() {
		Collections.sort(empleados, new OrdenarEmpleadoPorEdad());

	}

	// metodo para ordenar por edad inversa
	public void ordenarEdadInversa() {
		Collections.sort(empleados, new OrdenarInversaPorEdad());
	}

	// mostrar empleados con mayor de 2000 euros
	public void mostrarEmpleados2000() {
		for (Empleado empleado : empleados) {
			if (empleado.getSueldo() > 2000) {
				System.out.println(empleado);
			}
		}
	}

	// mostrar empleados con mayor de 3000
	public void mostrarEmpleados3000() {
		// Iterator<Empleado> it = empleados.iterator();
		/*
		 * while (it.hasNext()) { Empleado empleado = (Empleado)it.next();
		 * if(empleado.getSueldo()>3000) { System.out.println(empleado.toString()); } }
		 */
		for (Empleado empleado : empleados) {
			if (empleado.getSueldo() > 3000) {
				System.out.println(empleado.toString());
			}
		}
	}

	public void borrarEmpleadoIterator(String codigo) {
		int posicion = buscarEmpleado(codigo);
		if (posicion == -1) {
			System.err.println("No existe este empleado, por favor introduzca un codigo correcto");
		} else {
			// empleados.remove(posicion);
			Iterator<Empleado> it = empleados.iterator();
			while (it.hasNext()) {
				Empleado empleado = (Empleado) it.next();
				it.remove();
			}
		}
	}
}
