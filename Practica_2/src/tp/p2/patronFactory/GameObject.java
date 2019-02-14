package tp.p2.patronFactory;

import tp.p2.game.Game;

/**Clase principal abstracta de los objetos del juego*/
public abstract class GameObject {
	protected String nombre;
	protected String letra;
	protected int vida;
	protected int danio;
	protected int x;
	protected int y;
	protected int ciclo;
	protected Game game;
	
	public GameObject(int vida, int danio, int x, int y, int ciclo, Game game, String nombre, String letra) {
		this.vida = vida;
		this.danio = danio;
		this.x = x;
		this.y = y;
		this.ciclo = ciclo;
		this.game = game;
		this.nombre=nombre;
		this.letra=letra;
	}
	
	/**Métodos abstractos del hilo de clases que las utilizan*/
	public abstract void update();
	public abstract int getCiclo();
	public abstract void setVida(int vida);
	public abstract int getVida();
	public abstract int getX();
	public abstract int getY();
	public abstract String toString();
	public abstract String toString2();
	
}
