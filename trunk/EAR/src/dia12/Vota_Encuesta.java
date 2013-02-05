package dia12;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Vota_Encuesta {

	/**
	 * @param args
	 */
	 /**
     * Pretend you're a script...
     */
	public static void main(String args[]){
		
		for (int i=0; i<100;i++){
			
			int m =(int)Math.random()*100000;
			//vota("6eba9qvllnnt7cc8adf7mgqf80");
			vota(m+"llnnt7cc8adf7mgq"+i);
		}
		
	}
	
    @SuppressWarnings("deprecation")
	public static void vota( String token) {
        

        URL url = null;
        try {
            url = new URL("http://yocuchi.questionform.com/public/Desafio-EAR");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Vota_Encuesta.class.getName()).log(Level.SEVERE, null, ex);
        }

        HttpURLConnection urlConn = null;
        try {
            // URL connection channel.
            urlConn = (HttpURLConnection) url.openConnection();
        } catch (IOException ex) {
            Logger.getLogger(Vota_Encuesta.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Let the run-time system (RTS) know that we want input.
        urlConn.setDoInput (true);

        // Let the RTS know that we want to do output.
        urlConn.setDoOutput (true);

        // No caching, we want the real thing.
        urlConn.setUseCaches (false);

        try {
            urlConn.setRequestMethod("POST");
        } catch (ProtocolException ex) {
            Logger.getLogger(Vota_Encuesta.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            urlConn.connect();
        } catch (IOException ex) {
            Logger.getLogger(Vota_Encuesta.class.getName()).log(Level.SEVERE, null, ex);
        }

        DataOutputStream output = null;
        DataInputStream input = null;

        try {
            output = new DataOutputStream(urlConn.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Vota_Encuesta.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Specify the content type if needed.
        //urlConn.setRequestProperty("Content-Type",
        //  "application/x-www-form-urlencoded");

        // Construct the POST data.
        String content =
          "field1=" + "Francisco" +
          "&__auto_check=" + "" +
          "&survey_page=" + "1" +
          "&token=" + token +
          "&submit=" + "";

        
        // Send the request data.
        try {
            output.writeBytes(content);
            output.flush();
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(Vota_Encuesta.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Get response data.
        String str = null;
        try {
            input = new DataInputStream (urlConn.getInputStream());
            while (null != ((str = input.readLine()))) {
                System.out.println(str);
            }
            input.close ();
        } catch (IOException ex) {
            Logger.getLogger(Vota_Encuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
