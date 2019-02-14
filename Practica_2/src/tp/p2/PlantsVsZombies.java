/*Víctor Ramos y Vadym Batsula*/

package tp.p2;

import java.util.Random;

import tp.p2.game.Game;

public class PlantsVsZombies {

	/**
	 * Método main de la aplicacion que lanza el juego y el controlador
	 * @param args
	 */
	public static void main(String[] args) {
		Level level;
		long seed;
		
		if(args.length < 1 || args.length > 2) System.out.println("Error, parámetros incorrectos");
		else {
			level = Level.valueOf(args[0]);
			if(args.length == 2) seed = Long.parseLong(args[1]);
			else seed = new Random().nextInt();
			
			Game g = new Game(level,seed); 
			Controller ctrl = new Controller(g);
			ctrl.run();
		}
		
	}
	

}
