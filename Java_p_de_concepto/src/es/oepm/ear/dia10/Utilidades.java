package es.oepm.ear.dia10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utilidades {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("esto nunca deberia ocurrir");
	}

	public static int resto (int numerador, int denominador){
		return numerador % denominador;
	}

	public static int Aleatorio (int numero){
		return (int) (Math.random()*numero);
	}
	
	public static void log(String s){
	System.out.println(s);	
	}
	
	public static String leelinea() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
		}
	
	public static void espera(int segundos) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Thread.sleep(1000L*segundos);
		}
	
	public static void pinta (String s){
		
		 if (s.equals("alien")){
			 System.out.println("														");
			 System.out.println(".     .       .  .   . .   .   . .    +  .             " );
			 System.out.println("  .     .  :     .    .. :. .___---------___.          " );
			 System.out.println("       .  .   .    .  :.:. _\".^ .^ ^.  '.. :\"-_. .     " );
			 System.out.println("    .  :       .  .  .:../:            . .^  :.:\\.     " );
			 System.out.println("        .   . :: +. :.:/: .   .    .        . . .:\\    " );
			 System.out.println(" .  :    .     . _ :::/:               .  ^ .  . .:\\   " );
			 System.out.println("  .. . .   . - : :.:./.                        .  .:\\  " );
			 System.out.println("  .      .     . :..|:                    .  .  ^. .:| " );
			 System.out.println("    .       . : : ..||        .                . . !:| " );
			 System.out.println("  .     . . . ::. ::\\(                           . :)/ " );
			 System.out.println(" .   .     : . : .:.|. ######              .#######::| " );
			 System.out.println("  :.. .  :-  : .:  ::|.#######           ..########:|  " );
			 System.out.println(" .  .  .  ..  .  .. :\\ ########          :######## :/  " );
			 System.out.println("  .        .+ :: : -.:\\ ########       . ########.:/   " );
			 System.out.println("    .  .+   . . . . :.:\\. #######       #######..:/    " );
			 System.out.println("      :: . . . . ::.:..:.\\           .   .   ..:/      " );
			 System.out.println("   .   .   .  .. :  -::::.\\.       | |     . .:/       " );
			 System.out.println("      .  :  .  .  .-:.\":.::.\\             ..:/         " );
			 System.out.println(" .      -.   . . . .: .:::.:.\\.           .:/          " );
			 System.out.println(".   .   .  :      : ....::_:..:\\   ___.  :/            " );
			 System.out.println("   .   .  .   .:. .. .  .: :.:.:\\       :/             " );
			 System.out.println("     +   .   .   : . ::. :.:. .:.|\\  .:/|              " );
			 System.out.println("     .         +   .  .  ...:: ..|  --.:|              " );
			 System.out.println(".      . . .   .  .  . ... :..:..\"(  ..)\"              " );
			 System.out.println(" .   .       .      :  .   .: ::/  .  .::\\             " );
			 System.out.println("                                                       " );
			 
		 }else if (s.equals("rana")){
			 System.out.println("    _    _     ");
			 System.out.println("    (o)--(o)   ");
			 System.out.println("   /.______.\\  ");
			 System.out.println("   \\________/  ");
			 System.out.println("  ./        \\. ");
			 System.out.println(" ( .        , )");
			 System.out.println("  \\ \\_\\\\//_/ / ");
			 System.out.println("   ~~  ~~  ~~  ");
			 
		 }
		
		
	}
	
}
