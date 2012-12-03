package es.cuchi.ear.dia8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QueHace1 {
	public static void main(String[] args) throws Exception{
		String secreto="style";
		System.out.println("Pon la contraseña");
		for (int i=0;i<3;i++){
			if (metodo1().equalsIgnoreCase(secreto)){
				System.out.println("Bienvenido al templo de la sabiduria");
				i=100;
			}
			else{
				System.out.println("Contraseña errónea");
			}	
		}
	}
	
	public static String metodo1() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
		}
	
}
