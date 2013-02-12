package EarContactFighters;

import playerscuchi.Manute;
import playerscuchi.Toli;

public class Juegamaspartidas {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ContactPlayer p1,p2;
		p1=new Toli();
		p2=new Manute();
		
		int[] victorias = new int[2];
		
		for (int i =0; i<10;i++){
			PartidaContact p=new PartidaContact(p1,p2);
			p.Esperams=1; // a toda leche
			p.JuegaPartida();
			
			if (p.Vencedor.getNombre().equalsIgnoreCase(p1.getNombre())){
				victorias[0]++;
							
			}else{
				victorias[1]++;
			}
		}
		
		System.out.println(p1.getNombre()+"="+victorias[0]);
		System.out.println(p2.getNombre()+"="+victorias[1]);
	}
	
	

}
