package serializar_empleados;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

public  abstract class Empleado implements Comparable<Empleado>,Serializable{
	 String nombre;
	 int edad;
	 double sueldo;
	String codigo;
	
	
	public Empleado(String nombre, int edad, double sueldo, String codigo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
		this.codigo = codigo;
	}

	//metodo abstracto que variaria en funcion del empleado
	public abstract void subirSueldo(int valor);
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public  String getCodigo() {
		return codigo;
	}

	
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + " , codigo " + codigo + "]";
	}
	@Override
	public int compareTo(Empleado o) {
		return this.getCodigo().compareToIgnoreCase(o.getCodigo());
	}
	public void anadirEmpleado(DataOutputStream ficha)throws IOException {
		ficha.writeUTF(nombre);
		ficha.writeInt(edad);
		ficha.writeDouble(sueldo);
	}
	public void leerFichaEmpleado(DataInputStream ficha) throws IOException {
		nombre=ficha.readUTF();
		edad=ficha.readInt();
		sueldo=ficha.readDouble();
	}
}

