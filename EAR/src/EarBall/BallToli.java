package EarBall;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;

public class BallToli extends BallPlayer {

	

	
	
	@Override
	public Point2D muevete(Proyectil[] Proyectiles, Muro[] Muros,
			Point2D tu_posicion, Point2D su_posicion, boolean izquierda) {
		// TODO Auto-generated method stub
		Proyectil P = Proyectiles[0];
		if (P.y>this.y){
			if (P.velocidad_y>0){//sube
				return new Point(0,10);
			}else
			{//baja
				return new Point(0,5);
			}
			
		}else{
			if (P.velocidad_y>0){//sube
				return new Point(0,5);
			}else
			{//baja
				return new Point(0,10);
			}
			
		}
		
		
	}




	public BallToli() {
		super();
		this.Equipo="FRAN";
		this.Nombre="Toli";
		
		
		
	}

	


	@Override
	public void pintame(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
