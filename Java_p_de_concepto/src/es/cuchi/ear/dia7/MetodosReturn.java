package es.cuchi.ear.dia7;

public class MetodosReturn {

	public static void main(String[] args) {
		
		Pinta("La mitad de 1348 es "+Mitad(1348));
		
	}
	public static int Mitad(int i){
		int resultado;
		resultado=i/2;
		return resultado;
}
	public static void Pinta(String s){
		System.out.println(s);
	}

}
