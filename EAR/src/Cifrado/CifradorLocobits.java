package Cifrado;

public class CifradorLocobits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Algoritmo
		String texto="Tengo el honor de estar hoy aquí con vosotros en vuestro comienzo en una de las mejores universidades del mundo. La verdad sea dicha, yo nunca me gradué.A decir verdad, esto es lo más cerca que jamás he estado de una graduación universitaria.Hoy os quiero contar tres historias de mi vida. Nada especial. Sólo tres historias.La primera historia versa sobre \"conectar los puntos\".Dejé la Universidad de Reed tras los seis primeros meses, pero después seguí vagando por allí otros 18 meses, más o menos, antes de dejarlo del todo. Entonces, ¿por qué lo dejé?Comenzó antes de que yo naciera.Mi madre biológica era una estudiante joven y soltera, y decidió darme en adopción. Ella tenía muy claro que quienes me adoptaran tendrían que ser titulados universitarios, de modo que todo se preparó para que fuese adoptado al nacer por un abogado y su mujer.Solo que cuando yo nací decidieron en el último momento que lo que de verdad querían era una niña.Así que mis padres, que estaban en lista de espera, recibieron una llamada a medianoche preguntando:“Tenemos un niño no esperado; ¿lo queréis?”“Por supuesto”, dijeron ellos.Mi madre biológica se enteró de que mi madre no tenía titulación universitaria, y que mi padre ni siquiera había terminado el bachillerato, así que se negó a firmar los documentos de adopción. Sólo cedió, meses más tarde, cuando mis padres prometieron que algún día yo iría a la universidad.Y 17 años más tarde fui a la universidad. Pero de forma descuidada elegí una universidad que era casi tan cara como Stanford, y todos los ahorros de mis padres, de clase trabajadora, los estaba gastando en mi matrícula.Después de seis meses, no le veía propósito alguno. No tenía idea de qué quería hacer con mi vida, y menos aún de cómo la universidad me iba a ayudar a averiguarlo.Y me estaba gastando todos los ahorros que mis padres habían conseguido a lo largo de su vida. Así que decidí dejarlo, y confiar en que las cosas saldrían bien.En su momento me dio miedo, pero en retrospectiva fue una de las mejores decisiones que nunca haya tomado.En el momento en que lo dejé, ya no fui más a las clases obligatorias que no me interesaban y comencé a meterme en las que parecían interesantes. No era idílico. No tenía dormitorio, así que dormía en el suelo de las habitaciones de mis amigos, devolvía botellas de Coca Cola por los 5 céntimos del envase para conseguir dinero para comer, y caminaba más de 10 Km los domingos por la noche para comer bien una vez por semana en el templo de los Hare Krishna.Me encantaba.Y muchas cosas con las que me fui topando al seguir mi curiosidad e intuición resultaron no tener precio más adelante.Os daré un ejemplo.En aquella época la Universidad de Reed ofrecía la que quizá fuese la mejor formación en caligrafía del país. En todas partes del campus, todos los póster, todas las etiquetas de todos los cajones, estaban bellamente caligrafiadas a mano.Como ya no estaba matriculado y no tenía clases obligatorias, decidí atender al curso de caligrafía para aprender cómo se hacía.Aprendí cosas sobre el serif y tipografías sans serif, sobre los espacios variables entre letras, sobre qué hace realmente grande a una gran tipografía.Era sutilmente bello, histórica y artísticamente, de una forma que la ciencia no puede capturar, y lo encontré fascinante. Nada de esto tenía ni la más mínima esperanza de aplicación práctica en mi vida. Pero diez años más tarde, cuando estábamos diseñando el primer ordenador Macintosh, todo eso volvió a mí.Y diseñamos el Mac con eso en su esencia. Fue el primer ordenador con tipografías bellas. Si nunca me hubiera dejado caer por aquél curso concreto en la universidad, el Mac jamás habría tenido múltiples tipografías, ni caracteres con espaciado proporcional. Y como Windows no hizo más que copiar el Mac, es probable que ningún ordenador personal los tuviera ahora. Si nunca hubiera decidido dejarlo, no habría entrado en esa clase de caligrafía y los ordenadores personales no tendrían la maravillosa tipografía que poseen.Por supuesto, era imposible conectar los puntos mirando hacia el futuro cuando estaba en clase, pero fue muy, muy claro al mirar atrás diez años más tarde.Lo diré otra vez: no puedes conectar los puntos hacia adelante, sólo puedes hacerlo hacia atrás. Así que tenéis que confiar en que los puntos se conectarán alguna vez en el futuro. Tienes que confiar en algo, tu instinto, el destino, la vida, el karma, lo que sea.Esta forma de actuar nunca me ha dejado tirado, y ha marcado la diferencia en mi vida.";
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
