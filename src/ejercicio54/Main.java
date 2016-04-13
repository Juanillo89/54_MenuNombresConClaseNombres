package ejercicio54;

import java.util.Scanner;

import ejercicio53.Nombres;

public class Main
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String nombre;
		String opcion;
		final int maxNombres = 5;
		Nombres nombres = new Nombres(maxNombres);
		do
		{
			mostrarMenu();
			opcion = sc.nextLine();
			switch(opcion)
			{
			// Introducir nombre.
			case "1":
				if(!nombres.estaLlena())
				{
					System.out.print("Introduce nombre: ");
					nombre = sc.nextLine();
					if(nombres.anadir(nombre))
					{
						System.out.println("Nombre añadido.");
					}
					else
					{
						System.out.println("Nombre repetido.");
					}
				}
				else
				{
					System.out.println("Lista llena.");
				}
				break;
			// Listar nombres.
			case "2":
				for(int i = 0; i < nombres.numNombres(); i++)
				{
					System.out.println(nombres.mostrar(i));
				}
				if(nombres.numNombres() == 0)
				{
					System.out.println("Lista vacía.");
				}
				break;
			// Eliminar nombre.
			case "3":
				if(nombres.numNombres() != 0)
				{
					System.out.println("Introduce el nombre a eliminar: ");
					nombre = sc.nextLine();
					if(nombres.eliminar(nombre))
					{
						System.out.println("Nombre eliminado.");
					}
					else
					{
						System.out.println("Nombre no encontrado.");
					}
				}
				else
				{
					System.out.println("Lista vacía.");
				}
				break;
			// Eliminar todos los nombres.
			case "4":
				if(nombres.numNombres() == 0)
				{
					System.out.println("La lista ya está vacía.");
				}
				else
				{
					nombres.vaciar();
					System.out.println("Lista vaciada.");
				}
				break;
			// Salir.
			case "5":
				System.out.println("Hasta luego.");
				break;
			default:
				System.out.println("Opción incorrecta.");
				break;
			}
		}
		while(!opcion.equals("5"));
		sc.close();
	}
	/**
	 * Muestra el menÃº
	 */
	private static void mostrarMenu()
	{
		System.out.println("Menú:\n" +
			"1.-Introducir nombre.\n" +
			"2.-Listar nombres.\n" +
			"3.-Eliminar nombre.\n" +
			"4.-Eliminar todos los nombres.\n" +
			"5.-Salir.");
		System.out.println();
	}
}
