package Cifrado;

public class CifradorLocoDuetos_Bad {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Algoritmo
		String texto="PATER NOSTER, qui es in caelis, sanctificetur nomen tuum. Adveniat regnum tuum. Fiat voluntas tua, sicut in caelo et in terra. Panem nostrum quotidianum da nobis hodie, et dimitte nobis debita nostra sicut et nos dimittimus debitoribus nostris. Et ne nos inducas in tentationem, sed libera nos a malo. Amen.";
		texto="Ihr naht euch wieder, schwankende Gestalten!\nDie fr�h sich einst dem tr�ben Blick gezeigt.\nVersuch� ich wohl euch diesmal fest zu halten?\nF�hl� ich mein Herz noch jenem Wahn geneigt?\nIhr dr�ngt euch zu! nun gut, so m�gt ihr walten,\nWie ihr aus Dunst und Nebel um mich steigt;\nMein Busen f�hlt sich jugendlich ersch�ttert\nVom Zauberhauch der euren Zug umwittert.\n\nIhr bringt mit euch die Bilder froher Tage,\nUnd manche liebe Schatten steigen auf;\nGleich einer alten, halbverklungnen Sage,\nKommt erste Lieb� und Freundschaft mit herauf;\nDer Schmerz wird neu, es wiederholt die Klage\nDes Lebens labyrinthisch irren Lauf,\nUnd nennt die Guten, die, um sch�ne Stunden\nVom Gl�ck get�uscht, vor mir hinweggeschwunden.\n\n[6]Sie h�ren nicht die folgenden Ges�nge,\nDie Seelen, denen ich die ersten sang,\nZerstoben ist das freundliche Gedr�nge,\nVerklungen ach! der erste Wiederklang.\nMein Leid ert�nt der unbekannten Menge,\nIhr Beyfall selbst macht meinem Herzen bang,\nUnd was sich sonst an meinem Lied erfreuet,\nWenn es noch lebt, irrt in der Welt zerstreuet.\n\nUnd mich ergreift ein l�ngst entw�hntes Sehnen\nNach jenem stillen, ernsten Geisterreich,\nEs schwebet nun, in unbestimmten T�nen,\nMein lispelnd Lied, der Aeolsharfe gleich,\nEin Schauer fa�t mich, Thr�ne folgt den Thr�nen,\nDas strenge Herz es f�hlt sich mild und weich;\nWas ich besitze seh� ich wie im weiten,\nUnd was verschwand wird mir zu Wirklichkeiten.";
		System.out.println(texto);
		//System.out.println(cifra(texto,1));
		String cifrado=cifra(texto,14);
		
		System.out.println("cifrado="+cifrado);
		
		//System.out.println(cifra(texto,25));
		String result=descifra(cifrado,4);
		System.out.println(result);
		//System.out.println(descifra(cifra(texto,2),25));
		

	}
	
	public static String cifra(String s, int des){
		
		
		String result="";
		//Convierto el primero a ascii y luego al resto le voy sumando el primero hasta el des
		
		for(int i=0; i<s.length()-des; i=i+des){
		
			String miniresult=(int) s.charAt(i)+"";
			int charanterior=(int) s.charAt(i);
			for (int j=1;j<des;j++){
				miniresult=miniresult+((int) s.charAt(i+j)+charanterior);
				System.out.println(miniresult);
			}
		
		result=result+";"+miniresult;
		System.out.println("result="+result);
		
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
