package Cifrado;

public class CifradorLocobits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Algoritmo
		String texto="Tengo el honor de estar hoy aqu� con vosotros en vuestro comienzo en una de las mejores universidades del mundo. La verdad sea dicha, yo nunca me gradu�.A decir verdad, esto es lo m�s cerca que jam�s he estado de una graduaci�n universitaria.Hoy os quiero contar tres historias de mi vida. Nada especial. S�lo tres historias.La primera historia versa sobre \"conectar los puntos\".Dej� la Universidad de Reed tras los seis primeros meses, pero despu�s segu� vagando por all� otros 18 meses, m�s o menos, antes de dejarlo del todo. Entonces, �por qu� lo dej�?Comenz� antes de que yo naciera.Mi madre biol�gica era una estudiante joven y soltera, y decidi� darme en adopci�n. Ella ten�a muy claro que quienes me adoptaran tendr�an que ser titulados universitarios, de modo que todo se prepar� para que fuese adoptado al nacer por un abogado y su mujer.Solo que cuando yo nac� decidieron en el �ltimo momento que lo que de verdad quer�an era una ni�a.As� que mis padres, que estaban en lista de espera, recibieron una llamada a medianoche preguntando:�Tenemos un ni�o no esperado; �lo quer�is?��Por supuesto�, dijeron ellos.Mi madre biol�gica se enter� de que mi madre no ten�a titulaci�n universitaria, y que mi padre ni siquiera hab�a terminado el bachillerato, as� que se neg� a firmar los documentos de adopci�n. S�lo cedi�, meses m�s tarde, cuando mis padres prometieron que alg�n d�a yo ir�a a la universidad.Y 17 a�os m�s tarde fui a la universidad. Pero de forma descuidada eleg� una universidad que era casi tan cara como Stanford, y todos los ahorros de mis padres, de clase trabajadora, los estaba gastando en mi matr�cula.Despu�s de seis meses, no le ve�a prop�sito alguno. No ten�a idea de qu� quer�a hacer con mi vida, y menos a�n de c�mo la universidad me iba a ayudar a averiguarlo.Y me estaba gastando todos los ahorros que mis padres hab�an conseguido a lo largo de su vida. As� que decid� dejarlo, y confiar en que las cosas saldr�an bien.En su momento me dio miedo, pero en retrospectiva fue una de las mejores decisiones que nunca haya tomado.En el momento en que lo dej�, ya no fui m�s a las clases obligatorias que no me interesaban y comenc� a meterme en las que parec�an interesantes. No era id�lico. No ten�a dormitorio, as� que dorm�a en el suelo de las habitaciones de mis amigos, devolv�a botellas de Coca Cola por los 5 c�ntimos del envase para conseguir dinero para comer, y caminaba m�s de 10 Km los domingos por la noche para comer bien una vez por semana en el templo de los Hare Krishna.Me encantaba.Y muchas cosas con las que me fui topando al seguir mi curiosidad e intuici�n resultaron no tener precio m�s adelante.Os dar� un ejemplo.En aquella �poca la Universidad de Reed ofrec�a la que quiz� fuese la mejor formaci�n en caligraf�a del pa�s. En todas partes del campus, todos los p�ster, todas las etiquetas de todos los cajones, estaban bellamente caligrafiadas a mano.Como ya no estaba matriculado y no ten�a clases obligatorias, decid� atender al curso de caligraf�a para aprender c�mo se hac�a.Aprend� cosas sobre el serif y tipograf�as sans serif, sobre los espacios variables entre letras, sobre qu� hace realmente grande a una gran tipograf�a.Era sutilmente bello, hist�rica y art�sticamente, de una forma que la ciencia no puede capturar, y lo encontr� fascinante. Nada de esto ten�a ni la m�s m�nima esperanza de aplicaci�n pr�ctica en mi vida. Pero diez a�os m�s tarde, cuando est�bamos dise�ando el primer ordenador Macintosh, todo eso volvi� a m�.Y dise�amos el Mac con eso en su esencia. Fue el primer ordenador con tipograf�as bellas. Si nunca me hubiera dejado caer por aqu�l curso concreto en la universidad, el Mac jam�s habr�a tenido m�ltiples tipograf�as, ni caracteres con espaciado proporcional. Y como Windows no hizo m�s que copiar el Mac, es probable que ning�n ordenador personal los tuviera ahora. Si nunca hubiera decidido dejarlo, no habr�a entrado en esa clase de caligraf�a y los ordenadores personales no tendr�an la maravillosa tipograf�a que poseen.Por supuesto, era imposible conectar los puntos mirando hacia el futuro cuando estaba en clase, pero fue muy, muy claro al mirar atr�s diez a�os m�s tarde.Lo dir� otra vez: no puedes conectar los puntos hacia adelante, s�lo puedes hacerlo hacia atr�s. As� que ten�is que confiar en que los puntos se conectar�n alguna vez en el futuro. Tienes que confiar en algo, tu instinto, el destino, la vida, el karma, lo que sea.Esta forma de actuar nunca me ha dejado tirado, y ha marcado la diferencia en mi vida.";
		System.out.println(texto);
		//System.out.println(cifra(texto,1));
		String cifrado=cifra(texto,9);
		System.out.println(cifrado);
		//System.out.println(cifra(texto,25));
		String result=descifra(cifrado,9);
		System.out.println(result);
		//System.out.println(descifra(cifra(texto,2),25));
		

	}
	
	public static String cifra(String s, int des){
		
		
		String result="";
		for(int i=0; i<s.length(); i++){
		
		String numero=Integer.toBinaryString((int)(s.charAt(i))+des);
		
		result=result+";"+numero;
		}
		return result+";";
		
	}
	
	public static String descifra(String s, int des){
		String result="";
		
	    
		for(int i=0; s.indexOf(";", i+1)>=0; i=s.indexOf(";", i+1)){
			
		String trozo= s.substring(i+1,s.indexOf(";", i+1));
		
		System.out.println(trozo.length());
		result=result+(char)(Integer.parseInt(trozo,2)-des);
		//System.out.println(result);
		}
		return result;
		
	}

}
