package packComparaNumeros;
import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		
		Scanner keyb = new Scanner(System.in);
		System.out.println("Teclea un n�mero entero, brib�n");
		int n = keyb.nextInt();
		
		if (n==0){
			System.out.println("el n�mero tecleado es 0");
		}
		if ((n>0)&&(n%2==0)){
			System.out.println("el n�mero es positivo y es par");
		}
		if ((n>0)&&(n%2!=0)){
			System.out.println("el n�mero es positivo y es impar");
		}
		if ((n<0)&&(n%2==0)){
			System.out.println("el n�mero es negativo y es par");
		}
		if ((n<0)&&(n%2!=0)){
			System.out.println("el n�mero es negativo y es impar");
		}
	}

}
