
public class RestaTiempos {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		/*
		String Saldo="-2:57";
		String SaldoE="3:37";
*/

		String Saldo="-2:25";
		String SaldoE="-2:44";
		
		System.out.println(Restalos(Saldo,SaldoE));
		
		
	}
	public static String Restalos(String Saldo, String SaldoE)throws Exception{
		
		
		Long mins= getMins(Saldo)+getMins(SaldoE);
		
		System.out.println( "Total Mins=" + mins);
		
		
        long timeInSeconds = Math.abs(mins) * 60 ;
        long hours;
		long minutes;
		
        hours = timeInSeconds / 3600;
        timeInSeconds = timeInSeconds - (hours * 3600);
        minutes = timeInSeconds / 60;
        
        
        String signo="";
        if (mins<0)signo="-";
        String diffTime = signo + (hours<10 ? "0" + hours : hours) + ":" + (minutes < 10 ? "0" + minutes : minutes)  + " h";
		
        return diffTime;
	}
	public static long getMins(String horas_min) throws Exception{
		
		long result=0;
		
		//saco el signohttp://www.mihai-nita.net/eclipse
		boolean negativo= false;
		
		if (horas_min.charAt(0)=='-'){negativo=true;}
		long signo=1;
		//saco las horas
		long horas=0;
		if (negativo){
			horas= Long.parseLong( (String) horas_min.subSequence(1, horas_min.indexOf(":")));
			signo=-1;
		}else{
			horas= Long.parseLong( (String) horas_min.subSequence(0, horas_min.indexOf(":")));
		}
		
		System.out.println("Horas"+horas);
		long minutos= Long.parseLong( (String) horas_min.subSequence(horas_min.indexOf(":")+1, horas_min.length()));
		System.out.println("Minutos"+minutos);
		
		result=(horas*60+minutos) * signo;
		
		return result;
		
	}

}
