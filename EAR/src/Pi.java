

import java.math.BigDecimal;
import java.math.MathContext;



public class Pi{
	
MathContext mc = new MathContext(300);
	
private static BigDecimal serieArcotangente
(double x, int iteraciones) {
MathContext mc = new MathContext(500);
BigDecimal result = new BigDecimal(0.00, mc);
BigDecimal uno = new BigDecimal(1.00);
for(int i = 0; i < iteraciones; i++){
double div = (2.00*i+1.00) *
(Math.pow(1.00/x, 2.00 * i + 1.00));
BigDecimal divisor = new BigDecimal(div);
if(i % 2 == 0){
result = result.add(uno.divide(divisor, mc));
}else{
result = result.subtract(uno.divide(divisor, mc));
}
}
return result;
}
	public static BigDecimal calculoPiStormer(){
		   BigDecimal pi = serieArcotangente(1.00/8.00, 60)
		      .multiply(new BigDecimal(6.00))
		   .add(serieArcotangente(1.00/57.00, 60)
		      .multiply(new BigDecimal(2.00))
		   .add(serieArcotangente(1.00/239.00, 60)));
		   return pi.multiply(new BigDecimal(4.00));
		}
	public static void main(String[] args) throws Exception {
		 System.out.println("El número PI es "+calculoPiStormer());
	
	
}}