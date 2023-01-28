package serializar_empleados;

import java.util.Comparator;

public class OrdenarInversaPorEdad implements Comparator<Empleado> {
	/*•	Ordenar por edad inversa, si ésta es igual por sueldo inverso y si éste es igual por nombre inverso. 
	 * Es  decir, orden antinatural, primero el de mayor edad, si igual el de mayor sueldo y si edad nombre por
	 *  orden alfabético inverso.*/
	/*HE COMPROBADO QUE ES LO MISMO -(o2.getEdad()-o1.getEdad())  que invertir y escribir primero el objeto2. Como entiendo mejor
	 * la segunda manera, prefiero dejarlo asi*/

	@Override
	public int compare(Empleado o1, Empleado o2) {
		// TODO Auto-generated method stub
		
		if(o1.getEdad()==o2.getEdad()) {
			if(o1.getSueldo()==o2.getSueldo()) {
				return o2.getNombre().compareToIgnoreCase(o1.getNombre());
			}
			else {
				return (int) (o2.getSueldo()-o1.getSueldo());
			}
		}
		else {
			return o2.getEdad()-o1.getEdad();
		}
		
	}

}
