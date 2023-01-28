package serializar_empleados;

import java.util.Comparator;

public class OrdenarEmpleadoPorEdad implements Comparator<Empleado> {

	@Override
	public int compare(Empleado o1, Empleado o2) {
		if(o1.getEdad()==o2.getEdad()) {
			//return (int) (o1.getSueldo()-o2.getSueldo());
			if(o1.getSueldo()==o2.getSueldo()) {
				return o1.getNombre().compareToIgnoreCase(o2.getNombre());
			}
			else {
				return (int) (o1.getSueldo()-o2.getSueldo());
			}
		}
		else {
			return o1.getEdad()-o2.getEdad();
		}
		

	}
}


