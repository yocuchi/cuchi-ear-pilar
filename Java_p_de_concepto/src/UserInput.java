import java.io.BufferedReader;
import java.io.InputStreamReader;


public class UserInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("¿Como te llamas?");
		
		String userName = br.readLine();
		
		System.out.println(userName+" Bienvenido señor")


	}

}
