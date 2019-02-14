package tp.p2.patronCommand;

import tp.p2.Controller;
import tp.p2.game.Game;
import tp.p2.patronFactory.PlantFactory;

/**Clase sin parámetros que contiene su respectivo método EXECUTE*/
public class ListCommand extends NoParamsCommand {
	private static final String commandText = "list";
	private static final String commandName = "l";
	private static final String helpInfo = "List: Prints the list of available plants.";

	public ListCommand() {
		super(commandText, commandName, helpInfo);
	}

	public void execute(Game game, Controller controller) {
		System.out.println(PlantFactory.listOfAvilablePlants());
		controller.setNoPrintGameState();
		controller.setNoSigCiclo();
	}

}
