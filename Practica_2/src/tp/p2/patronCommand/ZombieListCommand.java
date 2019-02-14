package tp.p2.patronCommand;

import tp.p2.Controller;
import tp.p2.game.Game;
import tp.p2.patronFactory.Zombie;

/**Clase  sin parámetros que contiene su respectivo método EXECUTE*/
public class ZombieListCommand extends NoParamsCommand {
	private static final String commandText = "zombielist";
	private static final String commandName = "z";
	private static final String helpInfo = "Zombielist: Prints the list of zombies.";

	public ZombieListCommand() {
		super(commandText, commandName, helpInfo);
	}
	
	public void execute(Game game, Controller controller) {
		System.out.println(Zombie.listOfZombies());
		controller.setNoPrintGameState();
		controller.setNoSigCiclo();
	}
}
