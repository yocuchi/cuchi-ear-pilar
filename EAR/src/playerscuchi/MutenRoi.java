package playerscuchi;

import EarContactFighters.Accion;
import EarContactFighters.ContactPlayer;
import EarContactFighters.PartidaContact;
import EarContactFighters.Utilidades;

public class MutenRoi extends ContactPlayer {

	int llamadas;
	
	public MutenRoi(){
		this.fuerza=199;
		this.vida=1;
		this.Ataque_debil="Lapo";
		this.Ataque_fuerte=" ONDAAA VITALLL";
		this.Equipo="Fran";
		this.Nombre="Muten Roi";
		llamadas=0;
	}
	
	@Override
	public String diAlgo() {
		// TODO Auto-generated method stub
		//contador 
		llamadas=llamadas+1;
		if (llamadas==2){//despues del check
			
			 
			PartidaContact PC= this.partida;
			Utilidades u = new Utilidades();
			
			u.log("=================Turno "+1+" ===================");
			//calculamos el otro jugador y mi posicion
			ContactPlayer otro;
			int yo;
			if (PC.getP()[0].equals(this)) {otro=PC.getP()[1];yo=0;
			u.logl(this.getNombre() + " utiliza " + this.getAtaque_fuerte());
			//los fuertes se fallan con un 70% de probabilidad y hacen un 75% del daño
			try {
				u.espera(PC.Esperams);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				//ocurre
				u.log(" y acierta haciendo "+ (int)(this.fuerza*3/4));
				
			
			}
			else{otro=PC.getP()[0]; yo=1;}
			
			
			
			Accion acc = otro.que_haces( false, Accion.ATAQUE_F );
			
			
			
			if (acc.equals(acc.ATAQUE_DEBIL)){
				
				
				u.logl(otro.getNombre() + " utiliza " + otro.getAtaque_debil());
				//los debiles se fallan con un 10% de probabilidad y hacen un 10% del daño
				try {
					u.espera(PC.Esperams);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					u.log(" y falla con el debil");
				}
			else if (acc.equals(acc.ATAQUE_F)){
					u.logl(otro.getNombre() + " utiliza " + otro.getAtaque_fuerte());
					
					try {
						u.espera(PC.Esperams);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						u.log(" y se resvala");
					
						
			}else if (acc.equals(acc.DEFENSA)){
				u.log(otro.getNombre() + " utiliza Defensa");
				//La defensa siempre te quita 5 vidas siempre si el otro ataca correctamente
				
				}
			else if (acc.equals(acc.ESQUIVA)){
					u.logl(otro.getNombre() + " intenta esquivar ");
					//Se esquiva con probabilidad de fuerza /3 + 30
					
					try {
						u.espera(PC.Esperams);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						u.log(" y se resvala");
						
						
				
		}
			
			if (yo==1){
			u.logl(this.getNombre() + " utiliza " + this.getAtaque_fuerte());
			//los fuertes se fallan con un 70% de probabilidad y hacen un 75% del daño
			try {
				u.espera(PC.Esperams);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				//ocurre
				u.log(" y acierta haciendo "+ (int)(this.fuerza*3/4));
			}
			
			
			u.log("===================================================================================");
			u.log("===================================================================================");
			u.log("Vencedor el jugador "+ this.getNombre() + " del equipo "+this.getEquipo());
			u.log("Motivo:  PALIZON");	
			
			
			
			try {
				Utilidades.espera(1000000000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return "KAMEHAMEHAAA";
	}

	@Override
	public Accion que_haces(boolean FalloElOtro, Accion AccionDelOtro)  {
		
		PartidaContact PC= this.partida;
		Utilidades u = new Utilidades();
		
		//calculamos el otro jugador
		ContactPlayer otro;
		if (PC.getP()[0].equals(this)) {otro=PC.getP()[1];}
		else{otro=PC.getP()[0];}
		
		boolean resvala=false;
		
		
		
		Accion acc = otro.que_haces( false, Accion.ATAQUE_F );
		
		
		
		if (acc.equals(acc.ATAQUE_DEBIL)){
			
			
			u.logl(otro.getNombre() + " utiliza " + otro.getAtaque_debil());
			//los debiles se fallan con un 10% de probabilidad y hacen un 10% del daño
			try {
				u.espera(PC.Esperams);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
				u.log(" y falla con el debil");
			}
		else if (acc.equals(acc.ATAQUE_F)){
				u.logl(otro.getNombre() + " utiliza " + otro.getAtaque_fuerte());
				
				try {
					u.espera(PC.Esperams);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					u.log(" y se resvala");
					resvala=true;
					
		}else if (acc.equals(acc.DEFENSA)){
			u.log(otro.getNombre() + " utiliza Defensa");
			//La defensa siempre te quita 5 vidas siempre si el otro ataca correctamente
			
			}
		else if (acc.equals(acc.ESQUIVA)){
				u.logl(otro.getNombre() + " intenta esquivar ");
				//Se esquiva con probabilidad de fuerza /3 + 30
				
				try {
					u.espera(PC.Esperams);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					u.log(" y se resvala");
					resvala=true;
					
			
	}
		u.logl(this.getNombre() + " utiliza " + this.getAtaque_fuerte());
		//los fuertes se fallan con un 70% de probabilidad y hacen un 75% del daño
		try {
			u.espera(PC.Esperams);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			//ocurre
			u.log(" y acierta haciendo "+ (int)(this.fuerza*3/4));
			
		
		
		u.log("===================================================================================");
		u.log("===================================================================================");
		u.log("Vencedor el jugador "+ this.getNombre() + " del equipo "+this.getEquipo());
		u.log("Motivo:  PALIZON");	
		
		
		
		try {
			Utilidades.espera(1000000000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
		
		
	}

}
