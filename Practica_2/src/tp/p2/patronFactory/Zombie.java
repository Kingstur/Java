package tp.p2.patronFactory;

import tp.p2.game.Game;

/**Clase abstracta referente a los objetos de tipo ZOMBIE*/
public abstract class Zombie extends GameObject{
	public Zombie(int vida, int danio, int x, int y, int ciclo, Game game, String nombre, String letra) {
		super(vida, danio, x, y, ciclo, game, nombre,letra);
	}
	
	/**Método que devuelve la lista de zombies, utilizada en el comando ZOMBIELIST*/
	public static String listOfZombies(){
		String s = "Command > Zombielist\n" +
				 "[Z]ombie comun: speed: 2 Harm: 1 Life: 5\n" +
				 "[Z]ombie deportista: speed: 1 Harm: 1 Life: 2\n" +
				 "[Z]ombie caracubo: speed: 4 Harm: 1 Life: 8\n";
		return s;
	}
}
