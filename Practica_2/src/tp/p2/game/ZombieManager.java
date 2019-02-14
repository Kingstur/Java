package tp.p2.game;

import java.util.Random;

/**
 * Clase que controla los zombies que faltan por meter en el juego
 * @author Vadym Batsula y Victor Ramos
 *
 */
public class ZombieManager {
	private int zombiesleftoappear;
	Random rand;
	private double frec;
	
	public ZombieManager(int numZ, double frec, Random rand) {
		this.zombiesleftoappear = numZ;
		this.rand = rand;
		this.frec = frec;
	}
	
	public void setZombiesleftoappear(int zombiesleftoappear) {
		this.zombiesleftoappear = zombiesleftoappear;
	}

	public int getZombiesleftoappear() {return this.zombiesleftoappear;}
	
	public static Double formatearDecimales(Double numero, Integer numeroDecimales) {
		return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
		}
	
	/**Método que controla si un zombie se añade o no*/
	public boolean isZombieAdded(){
		boolean crear = false;
		if(this.zombiesleftoappear > 0) {
			double n = this.rand.nextDouble();
			n = formatearDecimales(n,1);
			if(n <= this.frec) { 
				this.zombiesleftoappear--;
				crear = true;
			}
			
		}
		return crear;
	}
	
}
