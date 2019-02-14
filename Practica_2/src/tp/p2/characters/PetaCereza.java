package tp.p2.characters;

import tp.p2.game.Game;
import tp.p2.patronFactory.Plant;

public class PetaCereza extends Plant{

	public PetaCereza() {
		super(2, 10, -1, -1, 0, null, 50,"petacereza","p");
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
		this.ciclo++;
		if(ciclo > 2) {
			if(this.game.buscarObjetos(this.x-1, y) != "") this.game.attackZombie(this.x-1, this.y, this.danio);
			if(this.game.buscarObjetos(this.x+1, y) != "") this.game.attackZombie(this.x+1, this.y, this.danio);
			if(this.game.buscarObjetos(this.x, y-1) != "") this.game.attackZombie(this.x, this.y-1, this.danio);
			if(this.game.buscarObjetos(this.x, y+1) != "") this.game.attackZombie(this.x, this.y+1, this.danio);
			this.vida=0;
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
		return "C[" + this.vida + "]";
	}
	public String toString2() {
		int c = 3 - this.ciclo;
		return "C[l:" + this.vida + ",x:" + this.x + ",y:" + this.y + ",t:" + c + "]";
	}
}
