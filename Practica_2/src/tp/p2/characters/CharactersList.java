package tp.p2.characters;

import tp.p2.game.Game;
import tp.p2.patronFactory.GameObject;

/**Clase que contiene las listas(y sus funciones) de objetos del juego*/
public class CharactersList {
	private final int MAX = 32;
	private GameObject[] lista;
	private int contador;
	
	public CharactersList() {
		this.lista = new GameObject[MAX];
		this.contador=0;
	}
	
	/**Función que añade un objeto a una lista*/
	public void addGameObject(GameObject g) {
		if(this.contador < MAX) {
			this.lista[this.contador] = g;
			this.contador++;
		}
	}
	
	/**Función que elimina objeto de una lista*/
	public void deleteGameObject() {
		for(int i = 0; i < this.contador;++i) {
			if(this.lista[i].getVida() <= 0) {
				for(int j = i+1; j < this.contador;++j) { this.lista[j-1] = this.lista[j];}
				this.contador--; 
			}
		}
	}
	
	public int getContador() {
		return this.contador;
	}

	/**Actualiza el estado de cada objeto de de una lista*/
	public void updateGameObject() {
		for(int i = 0; i < this.contador;++i) {
			this.lista[i].update();
		}
	}
	
	/**Función que reduce la vida de un objeto en determinada posición*/
	public void attackGameObject(int x,int y, int ataque) {
		boolean atacado = false;
		int i = 0;
		while(!atacado && i < this.contador) {
			if(this.lista[i].getX() == x && this.lista[i].getY()==y) {
				this.lista[i].setVida(ataque);
				atacado=true;
			}
			else ++i;
		}
	}
	
	/**Función que devuelve el String de información de un objeto en modo RELEASE*/
	public String infoGameObject(int x, int y) {
		String aux = " ";
		boolean encontrado=false;
		int i = 0;
		
		while(i < this.contador && !encontrado) {
			if(this.lista[i].getX() == x && this.lista[i].getY() == y) {
				encontrado=true;
				aux=this.lista[i].toString();
			}
			else ++i;
		}
		return aux;
	}
	
	/**Función que devuelve el String de información de un objeto en modo DEBUG*/
	public String infoDebug(int i) {
		String aux = "";
		aux = lista[i].toString2();
		return aux;
	}
	
	/**Función que añade un zombie aleatorio*/
	public void addZombie(int fila, Game game) {
		int z = (int) (Math.random() * 3)+1;
		GameObject zaux = null;
		switch(z) {
		case 1: zaux = new ZombieComun(5,1,fila,7,0,game,"Zombie","Z");break;
		case 2: zaux = new Deportista(2,1,fila,7,0,game,"Deportista","X");break;
		case 3: zaux = new Caracubo(8,1,fila,7,0,game,"Caracubo","W");break;
		}
		this.lista[this.contador] = zaux;
		this.contador++;
	}
}
