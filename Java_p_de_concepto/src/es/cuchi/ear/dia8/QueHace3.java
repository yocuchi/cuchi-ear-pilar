package es.cuchi.ear.dia8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QueHace3 {
	public static void main(String[] args) throws Exception{
		
		System.out.println("cuanto dinero quieres");
		int dinero=Integer.parseInt(metodo1());
		
		
		while (dinero>0){
			System.out.println("Tienes "+dinero +"€");
			System.out.println("A que numero de la ruleta quieres apostar? [0 al 36]");
			int num_apuesta=Integer.parseInt(metodo1());
			
			System.out.println("Que cantidad quieres apostar?");
			int apuesta=Integer.parseInt(metodo1());
			
			dinero=dinero-apuesta;
			System.out.println("No hay mas apuestas....");
			Thread.sleep(2000L);
			int resultado = (int) (Math.random()*36);
			System.out.println("Ha salido el "+resultado);
			
			if (resultado==num_apuesta){
				int premio=apuesta *36;
				System.out.println("Ha acertado el caballero, se lleva " + premio +"€");
				dinero=dinero+premio;
			}
			else{
				System.out.println("Gana la banca.");
				
				
			}
			
			
		}
		System.out.println("Te arruinaste chaval....");
	}
	
	public static String metodo1() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
		}
	
}
