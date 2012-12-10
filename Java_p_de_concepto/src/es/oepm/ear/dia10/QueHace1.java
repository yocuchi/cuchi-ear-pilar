package es.oepm.ear.dia10;

public class QueHace1 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Utilidades.log("Contra quien quieres pelear: [Alien o Rana]?");
		String enemigo = Utilidades.leelinea();
		int vida_e = 0,fuerza_e = 0;
		String ataquefuerte = null, ataquedebil = null;
		
		if (enemigo.equalsIgnoreCase("alien")){
			vida_e=600;
			fuerza_e=200;
			ataquefuerte="Rayo Espacial";
			ataquedebil="Cabezazo Alien";
			Utilidades.pinta("alien");
			Utilidades.log("You are gonna die!!!");
		}else if (enemigo.equalsIgnoreCase("rana")){
			vida_e=1500;
			fuerza_e=80;
			ataquefuerte="Veneno de sapo";
			ataquedebil="Lenguetazo";
			Utilidades.pinta("rana");
			Utilidades.log("Cua CUA CUA CROG vas a morir");
		}
		
		
		
		int vida=1000;
		int daño=0;
		boolean defensa=false;
		
		while ((vida>0) && (vida_e>0)){
		defensa=false;
		Utilidades.log("TU: "+ vida+"    |"+enemigo+": "+vida_e);
		Utilidades.log("Elige tu ataque: mano pie o defensa [ M P D]");
		String juega_ataque = Utilidades.leelinea();
		
		int ataque=(int) (Math.random()*100);
		if (juega_ataque.equalsIgnoreCase("M")){
			if (ataque>50){
			Utilidades.log("Atacas con Mano, le quitas 40");
			vida_e=vida_e-40;
			}else{
			Utilidades.log("Atacas con la mano y fallaste");	
			}
		}else if (juega_ataque.equalsIgnoreCase("P")){
			if (ataque>75){
			Utilidades.log("Atacas con Patada, le quitas 200");
			vida_e=vida_e-200;
			}else{
			Utilidades.log("Atacas con la patada y te resbalaste");	
			}
		}else if (juega_ataque.equalsIgnoreCase("D")){
			Utilidades.log("Eliges Defenderte...");
			defensa=true;
		}
		Utilidades.log("a ver que hace el enemigo");
		Utilidades.espera(2);
		
		int ataque_e=(int) (Math.random()*100);
		if (ataque_e<30){
			Utilidades.log("Tu enemigo se ha resbalado");
			daño=0;
		}else if (ataque_e<70){
			Utilidades.log("Tu enemigo te ataca con "+ataquedebil);
			daño=fuerza_e/4;
		}else {
			Utilidades.log("Tu enemigo te ataca con "+ataquefuerte);
			daño=fuerza_e;
		}
		
		if (defensa==false){
			vida=vida-daño;
		}
		
		}
		
		if (vida_e<0){
			Utilidades.log("GANASTE!!!");
			Utilidades.pinta(enemigo);
			Utilidades.log("GANASTE!!!");
			
		}else {
			Utilidades.log("TE GANE");
			Utilidades.pinta(enemigo);
			Utilidades.log("JAJAJAJAJAJAJAJAJ");
			
			
		}
		
		

	}

	
	
}
