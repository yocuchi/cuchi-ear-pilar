package es.oepm.ear.dia10;

public class Quehace3 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String s="All your base \n are belong to us";
		
		for (int i=0; i<s.length();i++){
			
			for (int x=0; x<=i/3;x++){
			System.out.print(s.charAt(i));
			Utilidades.espera(1);
			}
			
		}

	}

}
