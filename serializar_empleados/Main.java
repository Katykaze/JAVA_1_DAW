package serializar_empleados;
import java.util.ArrayList;
import java.util.Scanner;
/*[!]AÚN SIN FINALIZAR EL PROGRAMA. PARA PROBAR LOS EJERCICIOS DE INTERFACES COMPARATOR Y COMPARABLE ELEGIR OPCION 9 Y OPCION 10
 * AMBAS VIENEN CON EJEMPLOS DE OBREROS Y JEFES [!]*/

public class Main {
	static Scanner sc = new Scanner(System.in);
	//static Scanner scL = new Scanner(System.in);
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Empresa empleadosVarios = new Empresa ();
		//ArrayList <Obrero> listaObreros = null;
		
		int eleccion=0;

		while(eleccion != 7){
			
			imprimirMenu();
			
			try {
				eleccion = Integer.parseInt(sc.nextLine()); 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("[!] Introduzca un número válido!");
				continue;
			}

			switch (eleccion) {
				case 1 -> {
					System.out.println("Elija si quiere añadir Jefe J u Obrero O");
					String opcionJO = sc.nextLine();
					if (opcionJO.equalsIgnoreCase("J")) {
						System.out.println("Introduce nombre");
						String nombre = sc.nextLine();
						if (empleadosVarios.validarNombre(nombre)) {
							System.out.println("No se incluirá este empleado");
						} else {
							System.out.println("Introduce edad");
							int edad = Integer.parseInt(sc.nextLine()); // CONTROLAR EXCEpCIONES
							System.out.println("Introduce sueldo");
							double saldo = Double.parseDouble(sc.nextLine()); // CONTROLAR EXCEpCIONES
							empleadosVarios.anyadirJefe(nombre, edad, saldo);
						}
					} else {
						if (opcionJO.equalsIgnoreCase("O")) {

							System.out.println("Introduce nombre");
							String nombre = sc.nextLine();
							empleadosVarios.validarNombre(nombre);
							System.out.println("Introduce edad");
							int edad = Integer.parseInt(sc.nextLine()); // CONTROLAR EXCEpCIONES
							System.out.println("Introduce sueldo");
							double saldo = Double.parseDouble(sc.nextLine()); // CONTROLAR EXCEpCIONES
							System.out.println("Introduce el codigo de tu jefe");
							String codigoJefe = sc.nextLine();
							int buscarCodigoJefe = empleadosVarios.buscarEmpleado(codigoJefe);
							if (buscarCodigoJefe == -1) {
								empleadosVarios.anyadairObrero(nombre, edad, saldo, null);
								System.out.println(
										"**El codigo introducido no existe. Procedemos a dar de alta con Jefe a Null**");

							} else {
								Jefe jefeAux = (Jefe) empleadosVarios.getEmpleado(buscarCodigoJefe);
								System.out.println("----------" + jefeAux.toString());
								empleadosVarios.anyadairObrero(nombre, edad, saldo, jefeAux);

							}

						} else {
							System.out.println();
						}
					}
				}
				case 2 -> {
					insertarEmpleados(empleadosVarios);
					System.out.println("Introduzca la cantidad de porcentaje a subir a los empleados");
					int opcion = Integer.parseInt(sc.nextLine()); // CONTROLAR EXCEpCIONES
					empleadosVarios.subirSueldos(opcion);
				}
				case 3 -> { //listar oberos de un jefe , solo nombres. pedir codigo
					insertarEmpleados(empleadosVarios);
					System.out.println("Introduzca el codigo del jefe para listar los nombres de los obreros a su cargo");
					String codigoJefe = sc.nextLine();
					int posicionCJefe = empleadosVarios.buscarEmpleado(codigoJefe);
					if (posicionCJefe == -1) {
						System.err.println("El codigo de jefe no existe");
					} else {
						Jefe jefe = (Jefe) empleadosVarios.getEmpleado(posicionCJefe);
						if (jefe.getListaObreros().isEmpty()) {
							System.err.println("El jefe no dispone de empleados");

						} else {
							jefe.listarNombresObreros();
						}

					}
				}
				case 4 -> { //listar jefe, pidiendo codigo de obrero, si existe, listar nombre y codigo jefe
					insertarEmpleados(empleadosVarios);
					System.out.println("Introduzca el codigo del obrero para listar los datos de su jefe");
					String codigoO = sc.nextLine();
					int posicionO = empleadosVarios.buscarEmpleado(codigoO);
					if (posicionO == -1) {
						System.err.println("El código de empleado no existe");
					} else {

						Obrero obrero = (Obrero) empleadosVarios.getEmpleado(posicionO);
						//para controlar cuando el obrero tiene jefe a null
						if (obrero.getJefe() == null) {
							System.out.println("El obrero no tiene asignado Jefe");
						} else {
							System.out.println(obrero.getJefe().getNombre());
						}


					}
				}
				case 5 ->
					//insertarEmpleados(empleadosVarios);
						empleadosVarios.listarDatos();
				case 6 -> {
					insertarEmpleados(empleadosVarios);
					System.out.println("Introduzca el código del empleado a borrar:");
					String codigoEmpleado = sc.nextLine();
					int posicionEmpleado = empleadosVarios.buscarEmpleado(codigoEmpleado);
					if (posicionEmpleado == -1) {
						System.err.println("[!] El empleado no existe!");
					} else {
						Empleado empleado = empleadosVarios.getEmpleado(posicionEmpleado);
						System.out.println(empleado.toString());
						System.out.println("[*] Confirmar borrado de empleadao (S/N):");
						String confirmacion = sc.nextLine();
						if (!confirmacion.equalsIgnoreCase("S")) {
							System.out.println("[*] Cancelando borrado de empleado");
						} else {
							if (empleado instanceof Jefe) {
								ArrayList<Obrero> obreros = ((Jefe) empleado).getListaObreros();
								for (Obrero obrero : obreros) {
									obrero.setJefe(null);
								}
							} else {
								Jefe jefe = ((Obrero) empleado).getJefe();
								if (jefe != null) {
									jefe.borrarEmpleadoObrero(empleado.getCodigo());
								}
							}

							empleadosVarios.borrarEmpleado(posicionEmpleado);
						}
					}
				}
				case 7 -> {
				}
				case 8 -> {
					insertarEmpleados(empleadosVarios);
					System.out.println("Introduzca nombre si quiere ordenar por nombre, sueldo si quiere ordenar por sueldo"
							+ " o codigo si quiere ordenar por codigo");
					String ordenar = sc.nextLine();
					//al poner las exclamaciones se invierte todo
					switch (ordenar) {
						case "nombre" -> {
							empleadosVarios.ordenarPorNombre();
							empleadosVarios.listarDatos();
						}
						case "sueldo" -> {
							empleadosVarios.ordenarPorSueldo();
							empleadosVarios.listarDatos();
						}
						case "codigo" -> {
							empleadosVarios.ordenar();
							empleadosVarios.listarDatos();
						}
						default -> System.err.println("[!]Introduzca una opcion correcta");
					}
				}
				case 9 -> {
					insertarEmpleados(empleadosVarios);
					empleadosVarios.ordenarPorEdad();
					empleadosVarios.listarDatos();
					System.out.println("----------------");
				}
				case 10 -> {
					insertarEmpleados(empleadosVarios);
					empleadosVarios.ordenarEdadInversa();
					empleadosVarios.listarDatos();
					System.out.println("----------------");
				}
				case 11 -> {
					insertarEmpleados(empleadosVarios);
					empleadosVarios.mostrarEmpleados2000();
				}
				case 12 -> {
					insertarEmpleados(empleadosVarios);
					empleadosVarios.mostrarEmpleados3000();
				}
				case 13 -> {
					//insertarEmpleados(empleadosVarios);
					System.out.println("introduzcael codigo del empleado a borrar");
					String codigo = sc.nextLine();
					empleadosVarios.borrarEmpleadoIterator(codigo);
					empleadosVarios.listarDatos();
				}
				default -> System.err.println("[!] Introduzca un número válido!");
			}
			
		}
	
		
	}
	
	private static void imprimirMenu() {
		System.out.println("""
				Introduce lo que deseas realizar siguiendo la siguiente informacion :\s
				1-->añadir empleado
				2-->subir sueldo\s
				3-->listar obreros\s
				4-->mostrar jefe de obrero\s
				5-->listar datos
				6-->borrar empleado\s
				7-->salir y finalizar programa\s
				8---->ordenar los empleados\s
				9---->ordenar empleados por edad\s
				10----> ordenar por edad de manera inversa""");
	}
	//metodo para tener obreros y jefes para probar los metodos.[!]Aqui no se están añadiendo a listas de obreros del arrayList de empleados, ni jefes
	//a los obreros [!]
	private static void insertarEmpleados(Empresa empresa) {
		empresa.anyadirJefe("Lorena", 40, 4000);
		empresa.anyadirJefe("Roberto", 25, 5000);
		empresa.anyadairObrero("Marta", 30, 2000,null);
		empresa.anyadairObrero("Marcos", 40, 2000,null);
		empresa.anyadirJefe("Ricardo", 25, 5000);
		empresa.anyadirJefe("Carlos", 36, 6000);
		empresa.anyadirJefe("Carlos", 38, 6000);
		empresa.anyadairObrero("Lorenzo", 56, 3000, null);
	}
	
}


