package Cifrado;

public class CifradorLocoAscii {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Algoritmo
		String texto="En aquel tiempo dijo Jes�s a los jud�os que hab�an cre�do en �l: �Si os manten�is en mi Palabra, ser�is verdaderamente mis disc�pulos, y conocer�is la verdad y la verdad os har� libres�. Ellos le respondieron: �Nosotros somos descendencia de Abraham y nunca hemos sido esclavos de nadie. �C�mo dices t�: Os har�is libres?� Jes�s les respondi�: �En verdad, en verdad os digo: todo el que comete pecado es un esclavo. Y el esclavo no se queda en casa para siempre; mientras el hijo se queda para siempre. Si, pues, el Hijo os da la libertad, ser�is realmente libres. Ya s� que sois descendencia de Abraham; pero trat�is de matarme, porque mi Palabra no prende en vosotros. Yo hablo lo que he visto donde mi Padre; y vosotros hac�is lo que hab�is o�do donde vuestro padre�. Ellos le respondieron: �Nuestro padre es Abraham�. Jes�s les dice: �Si sois hijos de Abraham, haced las obras de Abraham. Pero trat�is de matarme, a m� que os he dicho la verdad que o� de Dios. Eso no lo hizo Abraham. Vosotros hac�is las obras de vuestro padre�. Ellos le dijeron: �Nosotros no hemos nacido de la prostituci�n; no tenemos m�s padre que a Dios�. Jes�s les respondi�: �Si Dios fuera vuestro Padre, me amar�ais a m�, porque yo he salido y vengo de Dios; no he venido por mi cuenta, sino que �l me ha enviado";
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
