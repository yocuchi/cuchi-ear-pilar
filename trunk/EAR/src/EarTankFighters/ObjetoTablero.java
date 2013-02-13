package EarTankFighters;

import java.awt.Graphics;
import java.awt.Rectangle;



public abstract class ObjetoTablero {
	double x,y;
	double Ancho,Alto;
	boolean Explota;
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public abstract void pintame (Graphics g );
	
	public final Rectangle AreaImpacto( ){
		//el x e Y están en medio
		return new Rectangle((int)(x-Ancho/2),(int) ((int)y-Alto/2),(int)Ancho,(int)Alto);
			
	}
	
	public boolean Colision(ObjetoTablero o ){
		//me aprovecho de las funciones de JAVA 2D
		return o.AreaImpacto().intersects(o.AreaImpacto());
		
		
			
	}
}
