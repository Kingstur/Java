package tp.p1.characters;

import tp.p1.game.Game;

public class ZombieList {
	private Zombie array[];
	private int contador;
	
	public ZombieList(int aux) {
		this.contador = 0;
		this.array = new Zombie[aux];
		}
	
	//public Zombie[] getArray() {return this.array;}
	public int getContador() {return this.contador;}
	
	public boolean findZombie(int x, int y) {
		boolean ok=false;
		int i = 0;
		while(i < contador && !ok) {
			if(array[i].getposX() == x && array[i].getposY() == y) ok = true;
			else ++i;
		}
		return ok;
	}

	public void zombiesAtacados(int fila) {
		int i = 0;
		boolean atacado = false;
		while(i < this.contador && !atacado) {
			if(this.array[i].getposX() == fila) {
				this.array[i].setVida(PeaShooter.getDanio());
				atacado = true;
			}
			else ++i;
		}
	}
	
	public void anadirZombie(int x, Game game) {
		this.array[this.contador] = new Zombie(x,7, game);
		this.contador++;
	}

	/**
	 * Devuelve las posiciones de loz zombies al game para que controle cuales deben moverse
	 * @return
	 */


	public String infoZombie(int x, int y) {
		String aux = " ";
		boolean encontrado = false;
		int i = 0;
		while(i < this.array.length && !encontrado) {
			if(this.array[i].getposX() == x && this.array[i].getposY()==y) {
				encontrado = true;
				aux = this.array[i].toString();
			}
			else ++i;
		}
		return aux;
	}

	
	public void comprobarMuertes() {
		for(int i = 0; i < this.contador;++i) {
			if(this.array[i].getVida() <= 0) { //Zombie muerto
				for(int j = i+1; j < this.contador;++j) { //Empezamos en el siguiente
					this.array[j-1] = this.array[j];
				}
				this.contador--; //Eliminar objeto
				if(this.contador == 1) {
					if(array[0].getVida() == 0) {
						array[0] = null;
						this.contador--;
					}
				}
			}
		}
	}
	
	public void updateZombieList() {
		for(int i = 0; i < this.contador;++i) {
			this.array[i].update();
		}
	}

	public void updateCiclosZombies() {
		for(int i = 0; i < this.contador;++i) {
			this.array[i].setCiclo();
		}
		
	}
	
}
