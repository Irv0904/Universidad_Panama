package Lab_1.prog_3_leer_datos;
import java.util.Scanner;

public class Lectura
{
	public static void main(String[] args) 
	{
		int n1, n2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce un numero entero: ");
		n1 = sc.nextInt();
		
		System.out.println("Introduce un numero entero: ");
		n2 = sc.nextInt();
		
		System.out.println("Usted ha introducido los siguientes numeros: " + n1 + " y " + n2);
		
	}

}