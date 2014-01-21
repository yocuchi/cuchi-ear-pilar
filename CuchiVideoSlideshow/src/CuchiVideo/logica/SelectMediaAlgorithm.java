package CuchiVideo.logica;

import java.io.File;
import java.io.FilenameFilter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import CuchiVideo.Init;
import CuchiVideo.VideoOutputInterface;

public class SelectMediaAlgorithm {
	static Statement stmt = null;
	
	/**
	 * @param args
	 * 
	 * 0 Carpeta y subcarpetas para buscar
	 * 1 Duracion del video
	 * 2 Duracion de los trozos de fotos
	 * 3 Duracion media de los trozos de video
	 * @throws Exception 

	 */
	
	
public static void RandomSelect( Connection  x,Object objOutputInterface, String [] args  ) throws Exception{
	
	VideoOutputInterface OutI=(VideoOutputInterface)objOutputInterface;
	
	
	//Ordeno por Orden de fecha y asigno duracion:
	//-- a las fotos, la duracion de la foto del args
	//-- al video, la duracion del video
	//Select File,datetime(Date),5 from Images UNION select File,datetime(Date),Lenght from Videos ORDER By datetime(Date)
	
	double DuracionFoto= Double.parseDouble(args[2])*1000; //milisegundos
	double DuracionVideo= Double.parseDouble(args[3])*1000;
	double DuracionTotal= Double.parseDouble(args[1])*1000; 
	
	//calculo del total de la carpeta, el porcentaje de video VS Foto
	
	double DuracionTotalBD= (double) (Init.DuracionTotalVideos+Init.NumFotos*DuracionFoto);
	
	double PorcentageVideo=Init.DuracionTotalVideos/DuracionTotalBD;
	double PorcentageFoto=Init.NumFotos*DuracionFoto/DuracionTotalBD;
	
	//Ahora numero de videos a elegir y numero de fotos a elegir
	
	int NumFotos=(int)(DuracionTotal*PorcentageFoto/DuracionFoto);
	int NumVideos=(int)(DuracionTotal*PorcentageVideo/DuracionVideo);
	
	//Loggin
	
	System.out.println("Se elegir�n "+ NumFotos+ " fotos con una duracion de "+DuracionFoto +" por foto; y "+NumVideos +" Videos con una duracion de "+DuracionVideo);
	
	//PREPARO BD
	Statement stmt = x.createStatement();
	System.out.println("==========\nSELECCIONANDO FOTOS");
	//FOTOS
	MediaAleatorio(Init.NumFotos, NumFotos,"UPDATE IMAGES SET SELECCIONADA =1 WHERE ROWID = ", stmt);
	
	System.out.println("==========\nSELECCIONANDO VIDEOS");
	//VIDEOS
	MediaAleatorio(Init.NumVideos, NumVideos,"UPDATE VIDEOS SET SELECCIONADA =1 WHERE ROWID = ", stmt);
		
	//AHORA FUSIONO ALL Y LO ORDENO POR DATE Y QUE EMPIECE LA FIESHTA
	String sql="Select File,datetime(Date),"+ DuracionFoto +",'IMAGE',SELECCIONADA,0,0"+
			 " from Images where SELECCIONADA=1 UNION select File,datetime(Date),Lenght,'VIDEO',SELECCIONADA,WIDTH,HEIGHT from Videos "+
			 "where SELECCIONADA=1 ORDER By datetime(Date)";
	//System.out.println(sql);
	ResultSet rs = stmt.executeQuery(sql );
		
	
	
	while (rs.next()){	
		if (rs.getString(4).equalsIgnoreCase("IMAGE")){
			//ojo en segundos
			OutI.AddImage(new File(rs.getString(1)), DuracionFoto/1000);
		}
		else if (rs.getString(4).equalsIgnoreCase("VIDEO"))
		{
			double inicio=0;
			if (rs.getDouble(3)>DuracionVideo)inicio=(double)(Math.random() * (rs.getDouble(3)-DuracionVideo));
			//ojo en SEGUNDOS
			OutI.AddVideo(new File(rs.getString(1)), rs.getDouble(3)/1000,
					inicio/1000,(inicio+DuracionVideo)/1000,
					rs.getInt(6),rs.getInt(7)); 
		}
	}
	 
	//MUSICA
	
	File dir = new File(args[5]);
	FilenameFilter mp3Filter = new FilenameFilter() {
	    public boolean accept(File file, String name) {
	        if (name.endsWith(".mp3")) {
	            // filters files whose extension is .mp3
	            return true;
	        } else {
	            return false;
	        }
	    }
	};
	File[] Mp3files = dir.listFiles(mp3Filter);
	OutI.AddMusic(Mp3files[(int) (Mp3files.length*Math.random())], 0); //todo Get real duration
	
	
	OutI.Write();
	
}


public static void MediaAleatorio(int NumTotal,int NumToSelect,String query,  Statement stmt) throws Exception{
	
	//si hay que sacar mas de las que hay que elegir, elijo todas
	
	if (NumToSelect>NumTotal)NumToSelect=NumTotal;
	
	//A elegir las fotos que entran, Marco en la Base de Datos
	//divido las fotos totales entre el total de fotos a elegir
	
	
	
	double ratioFotos= (double)NumTotal/(double)NumToSelect;
	
	
	//primer rowid es 1 http://www.sqlite.org/autoinc.html
	
	
	double inicio=1;
	
	
	//un slot es el la division del total real y del resultado
	double slotReal = (double)NumTotal/ratioFotos;
		
	//cantidades en todos los slots
	int cantidad_slot_normal=(int)(NumToSelect/ratioFotos);
	//numero slots normales
	int numero_slots_normales=(int) Math.floor(ratioFotos);
	//cantidad en el ultimo
	int cantidad_slot_ultimo=(int) (cantidad_slot_normal * (ratioFotos-numero_slots_normales));
	//correccion para cuando es 0,2
	if (cantidad_slot_ultimo==0)cantidad_slot_ultimo=1;
	if (cantidad_slot_normal==0)cantidad_slot_normal=1;
	
	
	for (int i=0; i<ratioFotos;i++){
		
		int [] FotosElegidas;
		//si es el ultimo
		if(i<numero_slots_normales){//es uno normal
			FotosElegidas=DistribuyeAleatorio((int)inicio, (int)(inicio+slotReal),cantidad_slot_normal);	
			
		} else{// ES EL ULTIMO
			System.out.println("ULTIMO SLOT");
			FotosElegidas=DistribuyeAleatorio((int)inicio,(int)(NumTotal),cantidad_slot_ultimo);
		}	
		
		//marco las fotos elegidas
		
		for (int ii=0; ii< FotosElegidas.length;ii++) {

			String sql = query + FotosElegidas[ii];
			//System.out.println(sql);
			stmt.executeUpdate(sql);
				
		}
		//avanzo el bloque
		inicio=inicio+slotReal;
	}
	
}


public static int[] DistribuyeAleatorio(int inicio, int fin, int cantidadAElegir){
	
	
	
	int [] resultado= new int[cantidadAElegir];
	
	
	//Creo el ArrayLis
	ArrayList<Integer> Numeros = new ArrayList<Integer>();
	
	//lo pueblo
	for(int p=inicio;p<=fin;p++){
		Numeros.add(p);
	}
		
	//ahora saco valores al azar y los vacion
	
	for (int i=0; i<cantidadAElegir;i++){
		int ValorRandom=(int)(Math.random()*Numeros.size());

		resultado[i]=Numeros.get(ValorRandom);
		Numeros.remove(ValorRandom);
	}
	System.out.println("Proceso Aleatorio: inicio="+ inicio+" fin="+fin+" cantidad="+cantidadAElegir + " "+ Arrays.toString(resultado));
	
	return resultado;
	
	
	
	
}

}
