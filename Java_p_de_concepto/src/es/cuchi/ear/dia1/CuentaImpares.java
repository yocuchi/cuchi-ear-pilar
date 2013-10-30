package es.cuchi.ear.dia1;

public class CuentaImpares {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*desafio a crear un metodo que imprima por pantalla desde el 100 hasta abajo los
		 * numeros impares una vez y los pares 2 
		 * 
		 * 
		 */
		
		boolean par=true;
		for(int i=100;i>0;i--){
			
			if (par){
				System.out.println("numero="+i+" "+i);
				par=false;
			}else{
				System.out.println("numero="+i);
				par=true;
			}
			
		}

	}

}
