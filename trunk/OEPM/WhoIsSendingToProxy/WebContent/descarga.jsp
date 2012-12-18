<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    
    %>
    

<%@ page import="java.io.BufferedInputStream"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.FileNotFoundException"%>
<%@ page import="java.io.FileOutputStream"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.net.URLConnection"%>
<%@ page import="java.nio.channels.Channels"%>
<%@ page import="java.nio.channels.ReadableByteChannel"%>
<%@ page import="java.util.Iterator"%>


<%@ page import="javax.imageio.ImageIO"%>
<%@ page import="javax.imageio.ImageReader"%>
<%@ page import="javax.imageio.ImageWriter"%>
<%@ page import="javax.imageio.stream.ImageOutputStream"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prueba de las descargas del proxy</title>
</head>
<body>

<%

/**
 * @param args
 * @throws Exception 
 */

	
	out.println("METODO PARA COMPROBAR LA DESCARGA DE IMAGENES Y EL PASO POR EL PROXY");
	
	out.println("Hace una descargas de la imagen http:/imagensignos.oepm.local/imagenes/000350/JSPTEST1.jpg");
	String url="http://imagensignos.oepm.local/imagenes/000350/JSPTEST1.jpg";
	
	try {
		descargaURL(url,"fich1.jpg");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		if ((e instanceof FileNotFoundException)==false){
		e.printStackTrace();
		}
		
	}
	
	out.println("Y ahora otra con el metodo 2 de http:/imagensignos.oepm.local/imagenes/000350/JSPTEST2.jpg");
	String url2="http://imagensignos.oepm.local/imagenes/000350/JSPTEST2.jpg";
	descargaURL2(url2,"fich2.jpg");
	
	out.println("Y ahora otra con el metodo 3 de http:/imagensignos.oepm.local/imagenes/000350/JSPTEST3.jpg");
	String url3="http://imagensignos.oepm.local/imagenes/000350/JSPTEST3.jpg";
	try {
		descargaURL3(url3,"fich3.jpg");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		if ((e instanceof FileNotFoundException)==false){
		e.printStackTrace();
		}
	}
	
	out.println("FIN");
	

%>

<%!
public static boolean descargaURL3(String url, String destino) throws Exception
{
    
    	
    	URL dir = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(dir.openStream());
        FileOutputStream fos = new FileOutputStream(destino);
        fos.getChannel().transferFrom(rbc, 0, 1 << 24);
        //fos.flush(); no lo pongo para intentar replicar
        fos.close();
        
        
        //CUCHI CODE PARA SABER EL TAMAÑO ANTES DE DESCARGAR
        URLConnection conn;
        int size_url=0;

        HttpURLConnection connection = (HttpURLConnection)dir.openConnection();
        conn = connection;
        size_url = conn.getContentLength();
        connection.disconnect();//linea añadida por cuchi
        
        File f= new File(destino);
        //CUCHI extraigo el tamaño del fichero descargado
        //log("Tamaño url:"+size_url+"| Tamaño descargada:"+f.length());
        
              
    return true;
}
%>
<%! 

public static boolean descargaURL2(String url, String destino)
{
    try
    {
    	URL dir = new URL(url);
    	URLConnection conn;
        int size_url=0;

        HttpURLConnection connection = (HttpURLConnection)dir.openConnection();

        
          
          conn = connection;
          size_url = conn.getContentLength();
          
          /*if(size_url < 0)
             log("Could not determine file size.");
          else
            log(url + " Size: " + size_url);
          
          } */
        
    	
        
        //HttpURLConnection connection = (HttpURLConnection)dir.openConnection();
        connection.setRequestMethod("GET");
        connection.setReadTimeout(15000);
        connection.connect();
        connection.getErrorStream();
        File f = new File(destino);
        f.createNewFile();
        BufferedInputStream is = new BufferedInputStream(connection.getInputStream());
        FileOutputStream out = new FileOutputStream(f, false);
        byte lectura[] = new byte[512];
        for(int leido = 0; (leido = is.read(lectura)) > 0;)
            out.write(lectura, 0, leido);

        is.close();
        out.close();
        
   
        
        
    }
    catch(Exception ex)
    {
        System.out.println((new StringBuilder("BATCH_BOPI: CLASE TratamientoFicheroServiceImpl + METODO descargaURL + EXCEPCION Error en descarga ")).append(url).append(", ").append(ex.getMessage()).append(" ").toString());
        return false;
    }
    
   
    
    return true;
}

%>

<%! 
 
public static boolean descargaURL(String url, String destino) throws Exception
{
        URL dir = new URL(url);
        
        //CUCHI CODE PARA SABER EL TAMAÑO ANTES DE DESCARGAR
        URLConnection conn;
        int size_url=0;

        HttpURLConnection connection = (HttpURLConnection)dir.openConnection();

          
          conn = connection;
          size_url = conn.getContentLength();
          
          /*if(size_url < 0)
             log("Could not determine file size.");
          else
            log(url + " Size: " + size_url);
          
          } */
        
        
        
        connection = (HttpURLConnection)dir.openConnection();
        connection.setRequestMethod("GET");
        connection.setReadTimeout(15000);
        connection.connect();
        connection.getErrorStream();
        File f = new File(destino);
        f.createNewFile();
        javax.imageio.stream.ImageInputStream iis = ImageIO.createImageInputStream(connection.getInputStream());
        Iterator readers = ImageIO.getImageReaders(iis);
        ImageReader imageReader;
        java.awt.image.BufferedImage imagen;
        try{
        imageReader = (ImageReader)readers.next();
        
        	
        	
        	
        //log((new StringBuilder("origen: ")).append(url).toString());
        //log((new StringBuilder("imageReader format: ")).append(imageReader.getFormatName()).toString());
        imageReader.setInput(iis, true);
        imagen = imageReader.read(0);
        } catch(Exception e){
        //System.out.println("CATCH" + url);
        return false;
        }
        Iterator writers = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter imageWriter = (ImageWriter)writers.next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(f);
        imageWriter.setOutput(ios);
        imageWriter.write(imagen);
        ios.close();
        imageWriter.dispose();
        
        //CUCHI extraigo el tamaño del fichero descargado
        
        //log("Tamaño url:"+size_url+"| Tamaño descargada:"+f.length());
        
                    
        
    return true;
}







%>

</body>
</html>