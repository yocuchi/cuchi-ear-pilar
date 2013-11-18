import java.util.Scanner;

class funcionesMal {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

			System.out.println("Cálculo de la puntuación de una partida");
			System.out.println("Recopilación de datos del primer jugador");
			double numerodePuntos = 0.0;
			
			do{
				System.out.print("    Introduce el número de puntos (0-100): ");
				numerodePuntos = scan.nextDouble();
			} while ((numerodePuntos < 0.0)||(numerodePuntos >100.0));
			
			double tiempo = 0.0;
			
			do {
				System.out.print("     Introduce el tiempo realizado (1-60): ");
				tiempo = scan.nextDouble();
			} while ((tiempo <1.0)||(tiempo>60.0));
			
			double puntuacionJugador1 = 0.0;
			if (tiempo!=0.0) {
				puntuacionJugador1 = (int)(1000*numerodePuntos/tiempo);
			}
			
			System.out.println ("Recopilación de datos del segundo jugador :");
			
			numerodePuntos = 0.0;
			do{
				System.out.print("    Introduce el número de puntos (0-100): ");
				numerodePuntos = scan.nextDouble();
			} while ((numerodePuntos < 0.0)||(numerodePuntos >100.0));
			
			tiempo = 0.0;
			
			do {
				System.out.print("     Introduce el tiempo realizado (1-60): ");
				tiempo = scan.nextDouble();
			} while ((tiempo <1.0)||(tiempo>60.0));
			
			double puntuacionJugador2 = 0.0;
			if (tiempo!=0.0) {
				puntuacionJugador2 = (int)(1000*numerodePuntos/tiempo);
			}
			
			System.out.println("  Resultados:");
			System.out.println("     Jugador 1: "+ puntuacionJugador1);
			System.out.println("     Jugador 2: "+ puntuacionJugador2);
			System.out.print("---->");
			
			if (puntuacionJugador1<puntuacionJugador2){
				System.out.print("Gana el jugador 2");
			} else if (puntuacionJugador1 != puntuacionJugador2){
				System.out.print("Gana el jugador 1");
			}else{
				System.out.print("Empate");
			}
			System.out.println (" !");
			
	}

}
