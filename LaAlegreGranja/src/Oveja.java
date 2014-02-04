
public class Oveja extends Animal {
	
	public String Golpea(){
		return "BEEE te a la mierda";
	}
	public void Alimentar(String Alimento ){
		
		if (Alimento.equalsIgnoreCase("hierba")){
			System.out.println("HUMMM QUE HIERBA MAS RICA");
		} else
		{
			System.out.println("Que asco....Me has dado "+ Alimento);	
		}
		
	}

}
