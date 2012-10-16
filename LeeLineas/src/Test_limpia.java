
import java.lang.*;
import java.io.Console;

public class Test_limpia {
        public void ClearConsole() {
                Console console = System.console();        
                if (console == null)
                        System.out.println("Couldn't get Console object !");
               
        }
    
        public static void main(String[] args) {
                new Test_limpia().ClearConsole();
        }
}


