package serializar_empleados;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;



public class OrdernarObreroEdada implements Comparator<Map.Entry<Integer, Obrero>> {

	@Override
	public int compare(Entry<Integer, Obrero> o1, Entry<Integer, Obrero> o2) {
		// TODO Auto-generated method stub
		if(o1.getValue().getEdad()==o2.getValue().getEdad()) {
			//return (int) (o1.getSueldo()-o2.getSueldo());
			if(o1.getValue().getSueldo()==o2.getValue().getSueldo()) {
				return o1.getValue().getNombre().compareToIgnoreCase(o2.getValue().getNombre());
			}
			else {
				return (int) (o1.getValue().getSueldo()-o2.getValue().getSueldo());
			}
		}
		else {
			return o1.getValue().getEdad()-o2.getValue().getEdad();
		}
	}

}
