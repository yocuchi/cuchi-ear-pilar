package EarTankFighters;

public class Proyectil {

	/**
	 * @param args
	 */
	int x,y,velocidad_x, velocidad_y;
	TankPlayer Lanzador;

	public Proyectil(int velocidad_x, int velocidad_y, TankPlayer lanzador) {
		
		this.velocidad_x = velocidad_x;
		this.velocidad_y = velocidad_y;
		Lanzador = lanzador;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getVelocidad_x() {
		return velocidad_x;
	}
	
	
	public int getVelocidad_y() {
		return velocidad_y;
	}
	
	public void avanza (int ms){
		//avaza x milisegundos
		
		
	}
	public void mueve(int ms){
		//la formula matematica es
		double delta_t= (double)(ms)/1000;
		this.x=(int) (this.x+this.velocidad_x*delta_t);
		this.y=(int) (this.y-this.velocidad_y*delta_t+4.5*delta_t*delta_t);
	}
	
	

}
