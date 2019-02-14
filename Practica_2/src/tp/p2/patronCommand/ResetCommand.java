package tp.p2.patronCommand;

import tp.p2.Controller;
import tp.p2.game.Game;

/**Clase  sin parámetros que contiene su respectivo método EXECUTE*/
public class ResetCommand extends NoParamsCommand {
	private static final String commandText = "reset";
	private static final String commandName = "r";
	private static final String helpInfo = "Reset: Starts a new game.";

	public ResetCommand() {
		super(commandText, commandName, helpInfo);
	}

	public void execute(Game game, Controller controller) {
		game.init(game.getLevel(), game.getSeed());
		controller.setPrintGameState();
		controller.setNoSigCiclo();
	}

}
