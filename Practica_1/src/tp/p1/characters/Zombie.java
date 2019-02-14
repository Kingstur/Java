package tp.p1.characters;

import tp.p1.game.Game;

/**
 * Objeto zombie del juego
 * @author Victor Ramos y Vadym Batsula
 *
 */
public class Zombie {
	private int vida;
	private int danio;
	private int x;
	private int y;
	private int ciclo;
	private Game game;
	
	public Zombie(int x, int y, Game game){
		this.vida = 5;
		this.x=x;
		this.y=y;
		this.game=game;
		this.ciclo = 0;
	}
	/**
	 * Métodos get de cada atributo del objeto
	 * @return devuelven su valor correspondiente
	 */
	public int getVida() {return this.vida;}
	public void setVida(int ataque) {this.vida -= ataque;}
	public int getDanio() {return this.danio;}
	public int getposX() {return this.x;}
	public int getposY() {return this.y;}
	public int getCiclo() {return this.ciclo;}
	public void setCiclo() {this.ciclo++;}
	public String toString() {return "Z[" + this.vida + "]";}
	
	public void update() {
		String aux = this.game.buscarObjetos(this.x,this.y-1);
		if(aux.startsWith("S")) this.game.listaGirasoles.sunflowerAtacado(this.x, this.y-1);
		else if(aux.startsWith("P")) this.game.listaLanzaGuisantes.peaShooterAtacado(this.x, this.y-1);
		else if(aux.startsWith(" ") && this.ciclo >= 2) {
			this.y -=1;
			this.ciclo = 0;
		}
	}

}
