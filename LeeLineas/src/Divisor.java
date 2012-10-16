import java.io.*;


public class Divisor {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int resultado= 4/Integer.parseInt(args[0]);
		System.out.println(resultado);
		System.out.println("pon tu nombre:");
		String nombre;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nombre=br.readLine();
		System.out.println("Tu nombre es " + nombre);
		System.out.println("Lerelele");
		
	
	}

}
