package serializar_empleados;

import java.util.Comparator;

public class OrdenarEmpleadosPorNombre implements Comparator<Empleado> {

	@Override
	public int compare(Empleado o1, Empleado o2) {
		
		// TODO Auto-generated method stub
		return o1.getNombre().compareToIgnoreCase(o2.getNombre());
	}

}
