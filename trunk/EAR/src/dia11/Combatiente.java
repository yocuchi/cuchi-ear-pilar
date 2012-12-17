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
		Combatiente c=new Combatiente();
		System.out.println(c);

	}

	public Combatiente(){
		
		edad = (int) (Math.random()*120);
		fuerza = 50 + (int) (Math.random()*300);
		vida = 200 +(int) (Math.random()*1000);
		
		//generador de nombres aleatorios
		String[] Titulo = {"Señor","Gobernador","Asesino", "Caballero", "Mutante"
				,"Chorizo"};
		String[] Nombres = {"Damian","Arturo","Alejandro","Asier","Rafa"};
		
		Nombre=Titulo[(int) (Math.random()*Titulo.length)]+" "+
					  Nombres[(int) (Math.random()*Nombres.length)];
		
		String[] A_fuerte = {"Mandoble","Moco","PanzerFaust","Beretta"};
		ataque_fuerte=A_fuerte[(int) (Math.random()*A_fuerte.length)];
		
		String[] A_debil = {"Colleja","Toba","Uña"};
		ataque_debil=A_debil[(int) (Math.random()*A_debil.length)];
		
		
	}

	@Override
	public String toString() {
		return "Combatiente [edad=" + edad + ", fuerza=" + fuerza + ", vida="
				+ vida + ", Nombre=" + Nombre + ", ataque_fuerte="
				+ ataque_fuerte + ", ataque_debil=" + ataque_debil + "]";
	}
	
	
	
}
