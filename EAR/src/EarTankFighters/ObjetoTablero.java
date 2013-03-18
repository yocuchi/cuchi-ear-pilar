package EarTankFighters;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Polygon;



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
	public double getAncho() {
		return Ancho;
	}
	
	public double getAlto() {
		return Alto;
	}
	
	
	public abstract void pintame (Graphics g );
	
	public final Rectangle AreaImpacto( ){
		//el x e Y están en medio
		return new Rectangle((int)(x-Ancho/2), (int) ((int)y-Alto/2), (int)Ancho, (int)Alto);
			
	}
	
	public abstract boolean Colision(ObjetoTablero o );
}
