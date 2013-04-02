package Cifrado;

public class CifradorLocoDuetos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Algoritmo
		String texto="PATER NOSTER, qui es in caelis, sanctificetur nomen tuum. Adveniat regnum tuum. Fiat voluntas tua, sicut in caelo et in terra. Panem nostrum quotidianum da nobis hodie, et dimitte nobis debita nostra sicut et nos dimittimus debitoribus nostris. Et ne nos inducas in tentationem, sed libera nos a malo. Amen.";
		texto="qu";
		System.out.println(texto);
		//System.out.println(cifra(texto,1));
		String cifrado=cifra(texto,1);
		
		System.out.println("cifrado="+cifrado);
		
		//System.out.println(cifra(texto,25));
		String result=descifra(cifrado,1);
		System.out.println(result);
		//System.out.println(descifra(cifra(texto,2),25));
		

	}
	
	public static String cifra(String s, int des){
		
		
		String result="";
		for(int i=0; i<s.length()-1; i=i+2){
		
			System.out.println(s.charAt(i)+":"+s.charAt(i+1));
			System.out.println((int)s.charAt(i)+":"+(int)s.charAt(i+1));
			System.out.println("HES="+Integer.toHexString((int)s.charAt(i))+":"+
			Integer.toHexString((int)s.charAt(i+1)));
			
			
		String numero=Integer.toHexString(
				Integer.parseInt((int)s.charAt(i)+""+(int)s.charAt(i+1))+des);
		numero=String.format("%06x", Integer.parseInt((int)s.charAt(i)+""+(int)s.charAt(i+1))+des);
		
		result=result+";"+numero;
		}
		return result+";";
		
	}
	
	public static String descifra(String s, int des){
		String result="";
		
		for(int i=0; s.indexOf(";", i+1)>=0; i=s.indexOf(";", i+1)){
			
			String trozo= s.substring(i+1,s.indexOf(";", i+1));
			
			System.out.println("trozo="+trozo);
			trozo=(Integer.parseInt(trozo,16)-des)+"";
			
			System.out.println(trozo.substring(0, 2));
			System.out.println((char)(Integer.parseInt(trozo.substring(0, 2))));
	//		System.out.println((char)(Integer.parseInt("58",16)));
			
			result=result+(char)(Integer.parseInt(trozo.substring(0, 2)))
						+(char)(Integer.parseInt(trozo.substring(2, 4)));
			//System.out.println(result);
			}
			return result;
			
		}
	    
		
		

}
