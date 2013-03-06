package Cifrado;

public class CifradorLocoHex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Algoritmo
		String texto="Nossa, nossa  Assim voce me mata  Ai se eu te pego, ai ai se eu te pego   Delicia, delicia  Assim voce me mata  Ai se eu te pego, ai ai se eu te pego   Sábado na balada  A galera começou a dançar  E passou a menina mais linda  Tomei coragem e comecei a falar   Nossa, nossa  Assim voce me mata  Ai se eu te pego, ai ai se eu te pego   Delicia, delicia  Assim voce me mata  Ai se eu te pego, ai ai se eu te pego   Sábado na balada  A galera começou a dançar  E passou a menina mais linda  Tomei coragem e comecei a falar   Nossa, nossa  Assim voce me mata  Ai se eu te pego, ai ai se eu te pego   Delicia, delicia  Assim voce me mata  Ai se eu te pego, ai ai se eu te pego   Nossa, nossa  Assim voce me mata  Ai se eu te pego, ai ai se eu te pego   Delicia, delicia  Assim voce me mata  Ai se eu te pego, ai ai se eu te pego";
		System.out.println(texto);
		//System.out.println(cifra(texto,1));
		String cifrado=cifra(texto,22);
		System.out.println(cifrado);
		//System.out.println(cifra(texto,25));
		String result=descifra(cifrado,22);
		System.out.println(result);
		//System.out.println(descifra(cifra(texto,2),25));
		

	}
	
	public static String cifra(String s, int des){
		
		
		String result="";
		for(int i=0; i<s.length(); i++){
		
		String numero=Integer.toHexString((int)(s.charAt(i))+des);
		
		result=result+numero;
		}
		return result;
		
	}
	
	public static String descifra(String s, int des){
		String result="";
		
	    
		for(int i=0; i<s.length(); i=i+2){
			
		String trozo= s.substring(i,i+2);
		result=result+(char)(Integer.parseInt(trozo,16)-des);
		}
		return result;
		
	}

}
