package EarTankFighters;

public class Proyectil {

	/**
	 * @param args
	 */
	double x,y;
	double velocidad_x, velocidad_y;
	TankPlayer Lanzador;

	public Proyectil(int velocidad_x, int velocidad_y, TankPlayer lanzador) {
		
		this.velocidad_x = velocidad_x;
		this.velocidad_y = velocidad_y;
		Lanzador = lanzador;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getVelocidad_x() {
		return velocidad_x;
	}
	
	
	public double getVelocidad_y() {
		return velocidad_y;
	}
	
	public void avanza (int ms){
		//avaza x milisegundos
		
		
	}
	public void mueve(int ms){
		//la formula matematica es
		double delta_t= (double)(ms)/1000;
		this.x= (this.x + this.velocidad_x * delta_t);
		this.y= (this.y - this.velocidad_y * delta_t + 4.5*delta_t*delta_t);
		this.velocidad_y= (this.velocidad_y-9*delta_t);
	}
	
	

}
