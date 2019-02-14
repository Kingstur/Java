package tp.p1.characters;

import tp.p1.game.Game;

/**
 * Objeto sunflower
 * @author Victor Ramos y Vadym Batsula
 *
 */
public class Sunflower {
	private static int coste = 20;
	private int vida;
	private int ciclo;
	private int danio;
	private int x;
	private int y;
	private Game game;
	
	public Sunflower(int x, int y, Game game){
		this.vida = 1;
		this.ciclo = 0;
		this.danio = 0;
		this.x = x;
		this.y = y;
		this.game = game;
	}
	/**
	 * Métodos get de cada atributo del objeto
	 * @return devuelven su valor correspondiente
	 */
	public static int getCoste() { return coste;}
	public int getVida() {return this.vida;}
	public void setVida() {this.vida--;}
	public int getCiclo() {return this.ciclo;}
	public void setCiclo(int num) {this.ciclo = num;}
	public void aumentarCiclo() {this.ciclo++;}
	public int getDanio() {return this.danio;}
	public int getposX() {return this.x;}
	public int getposY() {return this.y;}
	public String toString() {return "S[" + this.vida + "]";}
}
