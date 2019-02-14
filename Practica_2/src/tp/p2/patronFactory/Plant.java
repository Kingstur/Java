package tp.p2.patronFactory;

import tp.p2.game.Game;

/**Clase abstracta referente a los objetos de tipo PLANTA con sus Métodos*/
public abstract class Plant extends GameObject {
	public int coste;
	
	public Plant(int vida, int danio, int x, int y, int ciclo, Game game, int coste, String nombre, String letra) {
		super(vida, danio, x, y, ciclo, game, nombre,letra);
		this.coste=coste;
	}
	
	public abstract int getCoste();
	public abstract void setGame(Game game);
	public abstract void setFila(int fila);
	public abstract void setColumna(int columna);
	
}
