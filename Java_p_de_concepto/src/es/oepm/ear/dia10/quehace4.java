package es.oepm.ear.dia10;

public class quehace4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] Equipos = new String [3];
		Equipos[0]="Alfa";
		Equipos[1]="Bravo";
		Equipos[2]="Charlie";
		
		System.out.println("Un punto para el equipo: "+ Equipos[(int) (Math.random()*Equipos.length)]);
	}

}
