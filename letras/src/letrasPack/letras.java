package letrasPack;
import java.util.Scanner;

public class letras {
	
	public static void main (String[]args){
		
		String letra;
		int altura;
		Scanner teclado = new Scanner(System.in);
		System.out.println("introduce la letra a dibujar: ");
		letra = teclado.nextLine();
		System.out.println("Escribe la altura de la letra (mayor o igual que 3 e impar): ");
		
		//Haz la comprobación de que es así!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
		
		altura = teclado.nextInt();
		int longitud = letra.length();
		System.out.println(letra);
		
		if (letra.equals("n")){
			dibujaN(altura);
		}
		else if (letra.equals("l")){
			dibujaL(altura);
		}
		else if (letra.equals("o")){
			dibujaO(altura);
		}
		else if (letra.equals("z")){
			dibujaZ(altura);
		}
		else {
			System.out.println("lo siento, no trabajamos esa letra ");

		}
	}
	
	public static void espacios(int desplazamientos) {
        for (int i = 0; i < desplazamientos; ++i) {
            // astuce: remplacez temporairement ' '
            // par '#' pour mieux voir les espaces.
            System.out.print(' ');
        }
    }

    public static void barraHorizontal(int longitud, int desplazamientos) {
        espacios(desplazamientos);
        for (int i = 0; i < longitud; ++i) {
            System.out.print('-');
        }
    }

    public static void barraVertical(int desplazamiento) {
        espacios(desplazamiento);
        System.out.print('|');
    }

    public static void barraOblicuaDerecha(int desplazamiento) {
        espacios(desplazamiento);
        System.out.print('/');
    }

    public static void barraOblicuaIzquierda(int desplazamiento) {
        espacios(desplazamiento);
        // Attention, cette ligne affiche bien UN SEUL caractere \ !
        // En Java, il faut repeter deux fois le caractere \ pour en
        // n'afficher qu'un seul.
        System.out.print('\\');
    }

    public static void finLinea() {
        System.out.println();
    }

    public static void dibujaN(int altura) {
        for (int i = 0; i < altura; ++i) {
            barraVertical(0);
            barraOblicuaIzquierda(i);
            barraVertical(altura - i - 1);
            finLinea();
        }
    }

    public static void dibujaL(int altura) {
        for (int i = 0; i < altura; ++i) {
        	barraVertical(0);
        	finLinea();
        	if (i==altura-1){
        		barraHorizontal(altura,altura-i);
        	}
        	
        }
    }
    
    public static void dibujaO(int altura) {
    	
    }
    public static void dibujaZ(int altura) {
        for (int i = 0; i < altura; ++i) {
        	
        	if (i==0){
        		barraHorizontal(altura,0);
        	}
        	finLinea();
        	barraOblicuaDerecha(altura-i-1);
        	if (i==altura-1){
        		finLinea();
        		barraHorizontal(altura,0);
        	}
        		
        		
        	}
    	
    }
    
  
}



