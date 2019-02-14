package tp.p2.characters;

import tp.p2.game.Game;
import tp.p2.patronFactory.Plant;

/**
 * Objeto peashooter
 * @author Victor Ramos y Vadym Batsula
 *
 */
public class PeaShooter extends Plant {

	public PeaShooter() {
		super(5, 1, -1, -1, 0, null, 50,"peashooter","p");
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


	/**Método que gestiona el ataque del elemento*/
	public void update() {
		int i = this.y + 1; //No se va a disparar a si mismo
		boolean disparar=false;
		while(i < this.game.numColumnas && !disparar) {
			String aux = this.game.buscarObjetos(this.x, i);
			if(aux.startsWith("S") ||aux.startsWith("X") || aux.startsWith("W") ) {
				disparar=true;
				this.game.attackZombie(this.x, i, this.danio);
			}
			else ++i;
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
		return "P[" + this.vida + "]";
	}
	public String toString2() {
		return "P[l:" + this.vida + ",x:" + this.x + ",y:" + this.y + ",t:" + this.ciclo + "]";
	}
	
}
