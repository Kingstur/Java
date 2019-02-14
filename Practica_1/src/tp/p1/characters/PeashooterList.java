package tp.p1.characters;

import tp.p1.game.Game;

/**
 * Clase que controla los objetos peashooter del juego
 * @author Victor Ramos y Vadym Batsula 
 *
 */
public class PeashooterList {
	private final int MAX = 32;
	private PeaShooter array[];
	private int contador;
	PeaShooter peashooter;
	
	public PeashooterList() {
		this.contador = 0;
		this.array = new PeaShooter[MAX];
		}

	public void addPeaShooter(int posx, int posy, Game game) {
		PeaShooter aux = new PeaShooter(game,posx,posy);
		this.array[this.contador] = aux;
		this.contador++;
	}
	
	public boolean findPeaShooter(int x, int y) {
		boolean ok=false;
		int i = 0;
		while(i < contador && !ok) {
			if(array[i].getposX() == x && array[i].getposY() == y) ok = true;
			else ++i;
		}
		return ok;
	}

	public String infoPeaShooter(int x, int y) {
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
			if(this.array[i].getVida() <= 0) { //Sunflower muerto
				for(int j = i+1; j < this.contador;++j) { //Empezamos en el siguiente
					this.array[j-1] = this.array[j];
				}
				this.contador--; //Eliminar objeto
			}
		}
	}

	public void peaShooterAtacado(int X, int Y) {
		int i = 0;
		boolean encontrado = false;
		while(i < this.contador && !encontrado) {
			if(this.array[i].getposX() == X && this.array[i].getposY() == Y){
				this.array[i].setVida();
				encontrado = true;
			}
			else ++i;
		}		
	}
	
	public void updatePeashooterList() {
		for(int i = 0; i<this.contador;i++) {
			this.array[i].updatePeashooter();
			}
		}
	}


