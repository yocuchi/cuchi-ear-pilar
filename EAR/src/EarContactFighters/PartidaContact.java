package EarContactFighters;

import playerscuchi.*;

public class PartidaContact {

	ContactPlayer [] P;
	ContactPlayer Vencedor;
	
	public String texto_victoria; 
	
	public int [] Vida;
	
	public int [] Fuerza;
	
	public int [] Daño;
	
	public boolean [] Fallo;
	public boolean [] Esquiva;
	public boolean [] Defensa;
	
	 int Turno=0;
	
	
	static Utilidades u;
	
	public int Esperams=100;
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		PartidaContact PC= new PartidaContact(new Toli(), new Manute());
		PC.Esperams=1000;
		u=new Utilidades();
		PC.JuegaPartida();
		
		
		
		
	}
	
	public void JuegaPartida() throws Exception{
		
		
		u.log(toString());
		 hablen_jugadores();
		 
		//checks iniciales
		CheckInicial();
		if (this.texto_victoria != null){Pinta_Vencedor();return;}
		u.log(" Jugadores limpios.  Va a comenzar el combate");
		 hablen_jugadores();
		
		//turnos
		
		 while(Vida[0]>0 && Vida[1]>0){
			 Turno++;
			 u.log("=================Turno "+Turno+" ===================");

			 //reseteo los esquivadores
			 this.Daño = new int [2];
 			 this.Esquiva = new boolean [2];
			this.Defensa = new boolean [2];
						
			 
			 int otro=1;
			 for (int i=0; i<2; i++ ){
				 Acciona(i,otro);
				 otro--;
			 }
			 //gestiono los daños
			  otro=1;
			 for (int i=0; i<2; i++ ){
				 if (Daño[i]>0){
					 //hay ataque, a ver la defensa
					 if (Defensa[otro]==true){
						 Vida[otro]=Vida[otro]-5;
					 }else if (Esquiva[otro]==true){
						 //nada
					 }else{
						 Vida[otro]=Vida[otro]-Daño[i];
					 }
					 
				 }
				 
				 otro --;
			 }
			 //pinto como va
			 u.log(this.toString());
			 
		 }
		 //el vencedor es el jugador con mas vida
		 if (Vida[0]>=Vida[1]){Vencedor=P[0];}
		 else {Vencedor=P[1];}
		 this.texto_victoria="Victoria por golpes del jugador "+Vencedor;
		 Pinta_Vencedor();
		
		
	}
	
	
	public void Pinta_Vencedor(){
		
		 u.log("*****************************************");
		 u.log("******       GANADOR             ********");
		 u.log("******\t\t"+Vencedor.getNombre()+"\t\t ********");
		 u.log("******                           ********");
		 u.log("*****************************************");
	}
	
	public void Acciona(int p, int e) throws Exception{
		//la i es el jugador y la e el enemigo
		//devuelve true si se ha resvalado
		
		if (Fallo[p]){
			Fallo[p]=false;
			return;
		}
		
		Accion acc = P[p].que_haces();
		
		if (acc.equals(acc.ATAQUE_DEBIL)){
			u.logl(P[p].getNombre() + " utiliza " + P[p].getAtaque_debil());
			//los debiles se fallan con un 10% de probabilidad y hacen un 10% del daño
			if (probabilidad(90)){
				//ocurre
				u.log(" y acierta haciendo "+ (int)(Fuerza[p]/10));
				Daño[p]=(int)(Fuerza[p]/10);
				
			}
			else{ //nunca te resbalas con un debil
				u.log(" y falla con el debil");
			}}
		else if (acc.equals(acc.ATAQUE_F)){
				u.logl(P[p].getNombre() + " utiliza " + P[p].getAtaque_fuerte());
				//los fuertes se fallan con un 75% de probabilidad y hacen un 75% del daño
				if (probabilidad(25)){
					//ocurre
					u.log(" y acierta haciendo "+ (int)(Fuerza[p]/4));
					Daño[p]=(int)(Fuerza[p]/4);
					
				}
				else{ 
					u.log(" y se resvala");
					Fallo[p]=true;
				}	
		}else if (acc.equals(acc.DEFENSA)){
			u.log(P[p].getNombre() + " utiliza Defensa");
			//La defensa siempre te quita 5 vidas siempre si el otro ataca correctamente
			Defensa[p]=true;
			
			}
		else if (acc.equals(acc.ESQUIVA)){
				u.logl(P[p].getNombre() + " intenta esquivar ");
				//Se esquiva con probabilidad de fuerza /3 + 30
				if (probabilidad(Fuerza[p]+30)){
					//esquiva
					u.log(" y lo hace correctamente");
					Esquiva[p]=true;
					
				}
				else{ 
					u.log(" y se resvala");
					Fallo[p]=true;
				}	
			
	}
		
		
		
		//
		
	}
	

	public boolean probabilidad(int i) throws Exception{
		//devuelve true si ha ocurrido lo que tiene un i% de probabilidades de ocurrir
		u.espera(this.Esperams);
		return (int) (Math.random()*100) <=i;
	}
	
	public void CheckInicial(){
		
		int otro=1;
		for (int i=0;i<2;i++){  
			if (P[i].getFuerza()+P[i].getVida()>200){
				texto_victoria=(" *** Jugador "+P[i].getNombre()+" con valores erroneos " + P[i].getVida()+P[i].getFuerza()+"***");
				u.log(texto_victoria);				
				Vencedor=P[otro];
				
				
			}
			otro--;
		  }  
		
		
	}
	
	
	
	public void Victoria (){
		
		u.log("===================================================================================");
		u.log("===================================================================================");
		u.log("Vencedor el jugador "+ Vencedor.getNombre() + " del equipo "+Vencedor.getEquipo());
		u.log("Motivo:"+texto_victoria);
		
	}
	
	
	
	
	public PartidaContact(ContactPlayer P1, ContactPlayer P2){
		
		this.P=new ContactPlayer[2];
		P[0]=P1;
		P[1]=P2;
		this.Vida = new int [2];
		Vida[0]=P1.getVida();
		Vida[1]=P2.getVida();
		
		this.Fuerza = new int [2];
		Fuerza[0]=P1.getFuerza();
		Fuerza[1]=P2.getFuerza();
		
		
		this.Fallo = new boolean [2];
		Fallo[0]=false;
		Fallo[1]=false;
		this.Daño = new int [2];
		this.Esquiva = new boolean [2];
		this.Defensa = new boolean [2];
				
	}
	
	public void  hablen_jugadores(){
		u.log(P[0].getNombre() +" dice: "+P[0].diAlgo());
		u.log(P[1].getNombre() +" dice: "+P[1].diAlgo());
	}



	
	public String toString() {
		return "PartidaContact [P1="  +P[0].getNombre() + " Vida=" +Vida[0]+
				", F_P1=" + Fallo[0]+ "\t || " +
				"P2=" + P[1].getNombre() + ", Vida= " + Vida[1]  
								+ ", Fallo_P2=" + Fallo[1] + "]";
	}
	
	
	

}
