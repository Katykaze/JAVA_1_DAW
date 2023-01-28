package serializar_empleados;

import java.util.Comparator;

public class OrdenarEmpleadoPorSueldo implements Comparator<Empleado> {

	@Override
	public int compare(Empleado o1, Empleado o2) {
		/*
		if(o1.getSueldo() == o2.getSueldo()) {
			return o1.getCodigo().compareTo(o2.getCodigo());
		} else if(o1.getSueldo() > o2.getSueldo()) {
			return 1;
		} else {
			return -1;
		}*/
		
		if(o1.getSueldo() == o2.getSueldo()) {
			return o1.getCodigo().compareTo(o2.getCodigo());
		} else {
			return (int) (o1.getSueldo() - o2.getSueldo());
		}
	}

}
