package serializar_empleados;

public class Obrero extends Empleado {

	private Jefe jefe;
	public Obrero(String nombre, int edad, double sueldo,String codigo) {
		super(nombre, edad, sueldo,codigo);
	}
	public Obrero(String nombre, int edad, double sueldo, String codigo, Jefe jefe) {
		super(nombre, edad, sueldo, codigo);
		this.jefe = jefe;
	}

	
	public Jefe getJefe() {
		return jefe;
	}

	public void setJefe(Jefe jefe) {
		this.jefe = jefe;
	}

	@Override
	public void subirSueldo(int valor) {
		// TODO Auto-generated method stub
		if(valor < 0 || valor > 100) {
			System.out.println("Introduce un valor comprendido entre 0 y 100");
		} else {
			double sueldoActual = this.getSueldo();
			setSueldo(sueldoActual + ((sueldoActual*valor)/100));
		}
	}
	
	

}



