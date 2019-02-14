package tp.p1.characters;

import tp.p1.game.Game;

/**
 * Objeto peashooter
 * @author Victor Ramos y Vadym Batsula
 *
 */
public class PeaShooter {
	private static int coste = 50;
	private int vida;
	private static int danio = 1;
	private int x;
	private int y;
	private Game game;
	
	public PeaShooter(Game game, int posx, int posy){
		this.x = posx;
		this.y = posy;
		this.vida = 3;
		this.game = game;
		
	}
	/**
	 * Métodos get de cada atributo del objeto
	 * @return devuelven su valor correspondiente
	 */
	public static int getCoste() { return coste;}
	public static int getDanio() { return danio;}
	public int getVida() {return this.vida;}
	public void setVida() {this.vida--;}
	public int getposX() {return this.x;}
	public int getposY() {return this.y;}
	public String toString() {return "P[" + this.vida + "]";}
	
	public void updatePeashooter() {
			this.game.getListaZombies().zombiesAtacados(this.x);
	}
}
