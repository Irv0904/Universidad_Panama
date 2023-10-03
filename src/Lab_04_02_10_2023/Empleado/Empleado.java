package Lab_04_02_10_2023.Empleado;
import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;
import java.util.*;

public class Empleado
{
    Scanner entrada = new Scanner(System.in);
    protected String nombre;
    protected String nempleado;
    protected int salario;

    public Empleado(String nombre, String nempleado, int salario)
    {
        super();
        this.nombre = nombre;
        this.nempleado = nempleado;
        this.salario = salario;
    }

    public void obtener_datos()
    {
        System.out.println("El nombre del empleado es"+nombre);
        System.out.println("Numero de empleado "+nempleado);
        System.out.println("El salario del empleado es"+salario);
    }

/*public void procesar_salario() {


}*/
}