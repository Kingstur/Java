package tp.p2.characters;

import tp.p2.game.Game;
import tp.p2.patronFactory.Zombie;

/**
 * Objeto zombie del juego
 * @author Victor Ramos y Vadym Batsula
 *
 */
public class ZombieComun extends Zombie {
	
	public ZombieComun(int vida, int danio, int x, int y, int ciclo, Game game, String nombre, String letra) {
		super(vida, danio, x, y, ciclo, game, nombre,letra);
	}

	public int getCiclo() {
		return this.ciclo;
	}

	/**Método que gestiona el movimiento/ataque del elemento*/
	public void update() {
		this.ciclo++;
		String aux = this.game.buscarObjetos(this.x,this.y-1);
		if(aux.startsWith(" ") && this.ciclo >= 2) {
			this.y -=1;
			this.ciclo = 0;
		}
		else {
			this.game.attackPlant(x, y-1, this.danio);
		}
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
		return "Z[" + this.vida + "]";
	}
	public String toString2() {
		int c = 2 - this.ciclo;
		return "Z[l:" + this.vida + ",x:" + this.x + ",y:" + this.y + ",t:" + c + "]";
	}

}
