import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


public class pruebavotaellos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testComm ();

	}
	
	public static void testComm ()
	{
	try
	    {
	    URL         url;
	    HttpURLConnection   urlConn;
	    DataOutputStream    printout;
	    DataInputStream input;

	    System.out.println("hola");
	    
	    url = new URL ("http://marca.com");

	    // URL connection channel.
	    urlConn = (HttpURLConnection) url.openConnection();

	    // Let the run-time system (RTS) know that we want input.
	    urlConn.setDoInput (true);

	    // Let the RTS know that we want to do output.
	    urlConn.setDoOutput (true);

	    // No caching, we want the real thing.
	    urlConn.setUseCaches (false);
	    
	    

	    // Specify the content type.
	    urlConn.setRequestProperty
	    ("Content-Type", "application/x-www-form-urlencoded");

	    // Send POST output.
	    printout = new DataOutputStream (urlConn.getOutputStream ());

	    String content =
	    "txtLevelName=" + URLEncoder.encode ("level1") +
	    "&txtLevelData=" + URLEncoder.encode ("abcd");

	    printout.writeBytes (content);
	    printout.flush ();
	    printout.close ();

	    // Get response data.
	    input = new DataInputStream (urlConn.getInputStream ());

	    String str;
	    while (null != ((str = input.readLine())))
	    {
	    System.out.println (str);
	    }

	    input.close ();

	    }
	catch (MalformedURLException me)
	    {
	    System.err.println("MalformedURLException: " + me);
	    }
	catch (IOException ioe)
	    {
	    System.err.println("IOException: " + ioe.getMessage());
	    }
	}   

}
