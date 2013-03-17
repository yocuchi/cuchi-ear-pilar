package Cifrado;

public class CifradorLocoAscii {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Algoritmo
		String texto="En aquel tiempo dijo Jesús a los judíos que habían creído en él: «Si os mantenéis en mi Palabra, seréis verdaderamente mis discípulos, y conoceréis la verdad y la verdad os hará libres». Ellos le respondieron: «Nosotros somos descendencia de Abraham y nunca hemos sido esclavos de nadie. ¿Cómo dices tú: Os haréis libres?» Jesús les respondió: «En verdad, en verdad os digo: todo el que comete pecado es un esclavo. Y el esclavo no se queda en casa para siempre; mientras el hijo se queda para siempre. Si, pues, el Hijo os da la libertad, seréis realmente libres. Ya sé que sois descendencia de Abraham; pero tratáis de matarme, porque mi Palabra no prende en vosotros. Yo hablo lo que he visto donde mi Padre; y vosotros hacéis lo que habéis oído donde vuestro padre». Ellos le respondieron: «Nuestro padre es Abraham». Jesús les dice: «Si sois hijos de Abraham, haced las obras de Abraham. Pero tratáis de matarme, a mí que os he dicho la verdad que oí de Dios. Eso no lo hizo Abraham. Vosotros hacéis las obras de vuestro padre». Ellos le dijeron: «Nosotros no hemos nacido de la prostitución; no tenemos más padre que a Dios». Jesús les respondió: «Si Dios fuera vuestro Padre, me amaríais a mí, porque yo he salido y vengo de Dios; no he venido por mi cuenta, sino que Él me ha enviado";
		System.out.println(texto);
		//System.out.println(cifra(texto,1));
		System.out.println(cifra(texto,10));
		//System.out.println(cifra(texto,25));
		
		//System.out.println(descifra(cifra(texto,2),25));
		

	}
	
	public static String cifra(String s, int des){
		
		String result="";
		for(int i=0; i<s.length(); i++){
		int numero=(int)(s.charAt(i))+des;
		
		result=result+String.format("%03d", numero);
		}
		return result;
		
	}
	
	public static String descifra(String s, int des){
		String result="";
		
		for(int i=0; i<s.length(); i=i+3){
			
		String trozo= s.substring(i,i+3);
		result=result+(char)(Integer.parseInt(trozo)-des);
		}
		return result;
		
	}

}
