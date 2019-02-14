package tp.p2.patronCommand;

import tp.p2.Controller;
import tp.p2.game.Game;
import tp.p2.patronFactory.Plant;
import tp.p2.patronFactory.PlantFactory;

/**Clase que extiende de Command que se ocupa de gestionar la opción de añadir plantas*/
public class AddCommand extends Command {
	private static final String commandText = "add";
	private static final String commandName = "a";
	private static final String helpInfo = "Add <plant> <x> <y>: Adds a plant in position x, y.";

	public AddCommand() {
		super(commandText, commandName, helpInfo);
	}

	/**Método que ejecuta la opción de añadir planta en caso de ser posible*/
	public void execute(Game game, Controller controller) {
		String aux = "";
		Plant plant = PlantFactory.getPlant(controller.words[1]);
		aux = game.buscarObjetos(Integer.parseInt(controller.words[2]), Integer.parseInt(controller.words[3]));
		if(aux == " "){
		game.anadirPlanta(plant, Integer.parseInt(controller.words[2]), Integer.parseInt(controller.words[3]), controller);
		}
		else {
			System.out.println();
			System.err.println("Ya hay un objeto ahí");
			controller.setNoPrintGameState();
			controller.setNoSigCiclo();
		}
	}

	/**Método que retorna un objeto de tipo Commando. NULL en el caso de no ser el mismo*/
	public Command parse(String[] commandWords, Controller controller) {
		if(commandWords[0].equals(this.commandName) || commandWords[0].equals(this.commandText)) {
			Plant plant = PlantFactory.getPlant(commandWords[1]);
			if(plant != null) {
				if(Integer.parseInt(commandWords[2]) >= 0 && Integer.parseInt(commandWords[2]) < 4 && Integer.parseInt(commandWords[3]) >= 0 && Integer.parseInt(commandWords[3]) < 7) {
					return this;
				}
				else return null;
			}
			else return null;
		}
		else return null;
	}
}
