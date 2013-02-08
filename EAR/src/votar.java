

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


public class votar{

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	public static String RandomAlphaNumericString(int size){
	    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	    String ret = "";
	    int length = chars.length();
	    for (int i = 0; i < size; i ++){
	        ret += chars.split("")[ (int) (Math.random() * (length - 1)) ];
	    }
	    return ret;
	}

	
	public static void main(String[] args) throws IOException {
	for(int i=0;i<2;i++){
	testComm(RandomAlphaNumericString(26));
	}
	}	
	
	@SuppressWarnings("deprecation")
	public static void testComm (String s)
	{
	try{
		s="llnnt7cc8adf7mg3123123q";
	    URL         url;
	    URLConnection   urlConn;
	    DataOutputStream    printout;
	    DataInputStream input;

	    url = new URL ("http://marca.com");

	    // URL connection channel.
	    urlConn = url.openConnection();

	    // Let the run-time system (RTS) know that we want input.
	    urlConn.setDoInput (true);

	    // Let the RTS know that we want to do output.
	    urlConn.setDoOutput (true);

	    // No caching, we want the real thing.
	    urlConn.setUseCaches (false);

	    // Specify the content type.
	    urlConn.setRequestProperty
	    ("Content-Type", "text/html; charset=UTF-8");
	    
	 
	   
	    // Send POST output.
	    printout = new DataOutputStream (urlConn.getOutputStream ());
	    
	    String content =
	    "field1=" + URLEncoder.encode ("Francisco")+ 
	    "&__auto_check=" + URLEncoder.encode ("") +
	    "&survey_page="+  URLEncoder.encode ("1") +
	    "&token=" +  URLEncoder.encode (s) + 
	    "&submit=" + URLEncoder.encode ("");
	    
	    
	    printout.writeBytes (content);
	    printout.flush ();
	    printout.close ();
        System.out.println(content);
	    // Get response data.
	    input = new DataInputStream (urlConn.getInputStream ());

	    String str;
	    while (null != ((str = input.readLine())))
	    {
	    System.out.println (str);
	    }
        System.out.println (str);
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