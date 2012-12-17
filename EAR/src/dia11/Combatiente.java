package dia11;

public class Combatiente {

	public int edad;
	public int fuerza;
	public int vida;
	public String Nombre;
	public String ataque_fuerte;
	public String ataque_debil;
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Combatiente();

	}

	public Combatiente(){
		
		edad = (int) (Math.random()*120);
		fuerza = 50 + (int) (Math.random()*300);
		vida = 200 +(int) (Math.random()*1000);
		
		//generador de nombres aleatorios
		
	}

	@Override
	public String toString() {
		return "Combatiente [edad=" + edad + ", fuerza=" + fuerza + ", vida="
				+ vida + ", Nombre=" + Nombre + ", ataque_fuerte="
				+ ataque_fuerte + ", ataque_debil=" + ataque_debil + "]";
	}
	
	
	
}
