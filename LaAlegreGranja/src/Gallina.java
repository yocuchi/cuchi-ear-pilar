
public class Gallina extends Animal {
	
	public String Golpea(){
		return "KOKOROKO";
	}
	public void Alimentar(String Alimento ){
		
		if (Alimento.equalsIgnoreCase("trigo")){
			System.out.println("HUMMM QUE "+Alimento+" MAS ESTUPENDO");
		} else
		{
			System.out.println("Que asco....Me has dado "+ Alimento);	
		}
		
	}

}
