package tp.p2.patronCommand;

import tp.p2.Controller;
import tp.p2.game.Game;

/**Clase  sin parámetros que contiene su respectivo método EXECUTE*/
public class NoneCommand extends NoParamsCommand {
	private static final String commandText = "none";
	private static final String commandName = "n";
	private static final String helpInfo = "None: Skips cycle.";

	public NoneCommand() {
		super(commandText, commandName, helpInfo);
	}

	public void execute(Game game, Controller controller) {
		System.out.println("COMANDO NONE EJECUTADO SIN CAMBIOS");
		controller.setPrintGameState();
		controller.setSigCiclo();
	}

}
