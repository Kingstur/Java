package tp.p1.characters;

import tp.p1.game.Game;
import tp.p1.game.SuncoinManager;

public class SunflowerList {
	private final int MAX = 32;
	private Sunflower array[];
	private int contador;
	
	public SunflowerList() {
		this.contador = 0;
		this.array = new Sunflower[MAX]; 
		}
	
	public int getContadorSunflowerList() {return this.contador;}
	public Sunflower[] getArraySunflowerList() {return this.array;}
	
	public void addSunflower(int posX, int posY, Game game){
		Sunflower aux = new Sunflower(posX,posY, game);
		this.array[this.contador] = aux;
		this.contador++;
	}
	
	public boolean findSunflower(int x, int y){
		boolean ok=false;
		int i = 0;
		while(i < contador && !ok) {
			if(array[i].getposX() == x && array[i].getposY() == y) ok = true;
			else ++i;
		}
		return ok;
	}
	
	public void updateSunflowerList(SuncoinManager s) {
		for(int i = 0; i < this.contador;++i) {
			if(this.array[i].getCiclo() <= 2) this.array[i].aumentarCiclo();
			else if(this.array[i].getCiclo()>2) {
				s.aumentarSoles(10);
				this.array[i].setCiclo(1);
			}
		}
	}

	public String infoSunflower(int x, int y) {
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

	public void comprobarMuertes(){
		for(int i = 0; i < this.contador;++i) {
			if(this.array[i].getVida() <= 0) { //Sunflower muerto
				for(int j = i+1; j < this.contador;++j) { //Empezamos en el siguiente
					this.array[j-1] = this.array[j];
				}
				this.contador--; //Eliminar objeto
			}
		}
	}
	
	public void sunflowerAtacado(int X, int Y) {
		int i = 0;
		boolean encontrado = false;
		while(i < this.contador && !encontrado) {
			if(this.array[i].getposX() == X && this.array[i].getposY() == Y) {
				this.array[i].setVida();
				encontrado = true;
			}
			else ++i;
		}	
	}

}
