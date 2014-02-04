
public class Vaca extends Animal {
	
	public String Golpea(){
		return "MUUUUUU   y buenos dias";
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
