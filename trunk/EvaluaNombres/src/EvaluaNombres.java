import java.util.Scanner;

class EvaluaNombres {

	public static void main(String[] args) {
		// pide que escribas tu nombre
		char c;
		char c_pub =' ';
		boolean printErr = false;
		int longitud;
		int i;
		Scanner leedor = new Scanner (System.in);
		System.out.println ("escribe tu nombre, pero no valen los caracteres !''·$%&/()=");
		String nombre = leedor.nextLine();
		longitud = nombre.length();
		
		//comenzamos a analizar el nombre
		for (i=0; i<longitud; i++){
			c=nombre.charAt(i);
			if (c=='!'||c=='"'||c=='·'||c=='$'||c=='%'||c=='&'||c=='/'||c=='('||c==')'||c=='='){
					c_pub = c;
					printErr = true;
			}
			
		}
		
		if (printErr){
		System.out.println ("Caracteres como "+c_pub+" no se aceptan. NO se permiten !,'',·,$,%,&,/,(,),=");
		}
		
		else {
		System.out.println("Hola "+nombre);
		}
		leedor.close();
	}
}



