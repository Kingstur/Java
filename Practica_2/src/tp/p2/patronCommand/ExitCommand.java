package tp.p2.patronCommand;

import tp.p2.Controller;
import tp.p2.game.Game;

/**Clase sin parámetros que contiene su respectivo método EXECUTE*/
public class ExitCommand extends NoParamsCommand {
	private static final String commandText = "exit";
	private static final String commandName = "e";
	private static final String helpInfo = "Exit: Terminates the program.";

	public ExitCommand() {
		super(commandText, commandName, helpInfo);
	}

	public void execute(Game game, Controller controller) {
		controller.setExitGame();
		controller.setNoPrintGameState();
		controller.setNoSigCiclo();
	}
}
