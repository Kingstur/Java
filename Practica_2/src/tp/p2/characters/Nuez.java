package tp.p2.characters;

import tp.p2.game.Game;
import tp.p2.patronFactory.Plant;

public class Nuez extends Plant {

	public Nuez() {
		super(10, 0, -1, -1, 0, null, 50,"nuez","n");
		// TODO Auto-generated constructor stub
	}

	public int getCoste() {
		return this.coste;
	}

	public void setGame(Game game) {
		this.game=game;
	}

	public void setFila(int fila) {
		this.x=fila;
	}
	
	public void setColumna(int columna) {
		this.y=columna;
	}

	public void update() {
		//No hace nada
	}
	
	public int getCiclo() {
		return this.ciclo;
	}

	public void setVida(int ataque) {
		this.vida-=ataque;
	}

	public int getVida() {
		return this.vida;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	

	/**Métodos que devuelven un String con la información del elemento*/
	public String toString() {
		return "N[" + this.vida + "]";
	}
	public String toString2() {
		return "N[l:" + this.vida + ",x:" + this.x + ",y:" + this.y + ",t:" + this.ciclo + "]";
	}

}
