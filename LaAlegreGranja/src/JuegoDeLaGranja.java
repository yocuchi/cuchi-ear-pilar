import java.util.Scanner;


public class JuegoDeLaGranja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("HOLA Y BIENVENIDO A LA ALEGRE GRANJA");
		
		//crear un animal al azar
		Animal BichoAlAzar = null;
		int numero_al_azar= (int) (Math.random()*3);
		if (numero_al_azar==0){
			BichoAlAzar=new Gallina();
		}else if (numero_al_azar==1){
			BichoAlAzar=new Oveja();
		}else if (numero_al_azar==2){
			BichoAlAzar=new Vaca();
		}
		System.out.println("le golpeas y dice:"+BichoAlAzar.Golpea());
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Ahora alimentalo niño cansino");
		String Alimento=scan.nextLine();
		BichoAlAzar.Alimentar(Alimento);
			
		
		
	}

}
