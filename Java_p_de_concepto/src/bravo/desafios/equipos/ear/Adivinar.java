package bravo.desafios.equipos.ear;
import java.io.*;
public class Adivinar {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		double aleatorio=Math.random()*100;
		int numero = (int) aleatorio;
		
		//pinta("Pienso en el número "+numero);
		pinta("¿Cómo te llamas?"); 
		String nombre=leelinea();
		pinta("¿Cómo te apellidas?");
		String apellido=leelinea();
		pinta("Hola, bienvenido, "+nombre+" "+apellido+", por favor introduce el número a adivinar");
		
		
		for (int i=0; i<2;){
			int numero_insertado=leelinea_int();
			if (numero_insertado==numero){
				pinta("Perfecto, el número "+numero+" era el que estaba pensando");
				i=i+2;
			} else if(numero_insertado<numero){
				pinta("Has fallado, prueba de nuevo con un número mayor");
			} else if(numero_insertado>numero){
				pinta("Has fallado, prueba de nuevo con un número menor");
			}
		}
		
		pinta("ENHORABUENA, HAS GANADO UN PREMIO, "+nombre+" "+apellido);
		
		
		
		}
	
	public static String leelinea() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nombre= br.readLine();
		return nombre;
	}
	
	public static int leelinea_int() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nombre= br.readLine();
		return Integer.parseInt(nombre);
	}
	
	public static String pinta(String s){
		System.out.println(s);
		return s;
	}
	
}
