package tp.p2.patronCommand;

import tp.p2.Controller;
import tp.p2.game.Game;

/**Clase  sin parámetros que contiene su respectivo método EXECUTE*/
public class HelpCommand extends NoParamsCommand {
	private static final String commandText = "help";
	private static final String commandName = "h";
	private static final String helpInfo = "Help: Prints a help message.";

	public HelpCommand() {
		super(commandText, commandName, helpInfo);
	}

	public void execute(Game game, Controller controller) {
		System.out.println(CommandParser.commandHelp());
		controller.setNoPrintGameState();
		controller.setNoSigCiclo();
	}

}
