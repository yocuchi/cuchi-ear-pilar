package dia11;

public class MiniPokemon {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Utilidades.log("Creando tu combatiente");
		Utilidades.espera(2);
		Combatiente combat=new Combatiente();
		Utilidades.log("Combatiente="+combat);
		
		
		int vida_e = 0,fuerza_e = 0;
		String ataquefuerte = null, ataquedebil = null;
		
		vida_e=combat.vida;
		fuerza_e=combat.fuerza;
		ataquefuerte=combat.ataque_fuerte;
		ataquedebil=combat.ataque_debil;
		
		
		/*
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
		*/
		
		
		int vida=600;
		int daño=0;
		boolean defensa=false;
		
		while ((vida>0) && (vida_e>0)){
		defensa=false;
		Utilidades.log("TU: "+ vida+"    |"+combat.Nombre+": "+vida_e);
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
			Utilidades.pinta(combat.Nombre);
			Utilidades.log("GANASTE!!!");
			
		}else {
			Utilidades.log("TE GANE");
			Utilidades.pinta(combat.Nombre);
			Utilidades.log("JAJAJAJAJAJAJAJAJ");
			
			
		}
		
		

	}

	
	
}
