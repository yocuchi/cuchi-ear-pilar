
public class Multiplica {

	public static void main(String[] args) {
		int i;
		int j;
		int resultado;
	
		for (i=0; i<=10; i++){
			System.out.println("tabla del "+i);
			for (j=0; j<=10; j++){
				resultado = i*j;
				System.out.println(i+"*"+j+"="+resultado);
			}
		}
	}

}
