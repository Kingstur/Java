package tp.p2.characters;

import tp.p2.game.Game;
import tp.p2.patronFactory.Plant;

/**
 * Objeto sunflower
 * @author Victor Ramos y Vadym Batsula
 *
 */
public class Sunflower extends Plant{
	
	public Sunflower() {
		super(1, 0, -1, -1, 0, null, 20,"sunflower","s");
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

	/**Método que gestiona la generación de soles del elemento*/
	public void update() {
		this.ciclo++;
		if(this.ciclo > 2) {
			this.game.aumentarSoles(10); 
			this.ciclo=1;
		}
		
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
		return "S[" + this.vida + "]";
	}
	public String toString2() {
		int c = 3 - this.ciclo;
		return "S[l:" + this.vida + ",x:" + this.x + ",y:" + this.y + ",t:" + c + "]";
	}
	
	

}
