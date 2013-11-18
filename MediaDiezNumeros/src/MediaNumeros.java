import java.util.Scanner;

public class MediaNumeros {
	
	public static void main (String[] args){
		Scanner leedor = new Scanner(System.in);
		int i;
		int pos = 0, neg = 0;
		int[]numeros = new int[10];
		double sumaPos=0, sumaNeg=0;
		
		// Se leen los datos y con ellos se rellena el array
		System.out.println ("Lectura de elementos del array: ");
		 for (i = 0; i < 10; i++) {
	            System.out.print("numeros[" + i + "]= ");
	            numeros[i]=leedor.nextInt();
	        }
		 
		 // Se recorre el array sumando por separado positivos y negativos
		 for (i = 0; i < 10; i++) {
	            if (numeros[i] > 0){ //sumar positivos
	                sumaPos += numeros[i];
	                pos++;
	            } else if (numeros[i] < 0){ //sumar negativos
	                sumaNeg += numeros[i];
	                neg++;
	            }
	        }
		 
		 // Calcular y mostrar las medias
		 
		 if (pos != 0) {
	            System.out.println("Media de los valores positivos: " + sumaPos / pos);
	        } else {
	            System.out.println("No ha introducido numeros positivos");
	        }
	        if (neg != 0) {
	            System.out.println("Media de los valores negativos: " + sumaNeg / neg);
	        } else {
	            System.out.println("No ha introducido numeros negativos");
	        }
	}
	
}