package tp.p2.patronCommand;

import tp.p2.Controller;
import tp.p2.game.Game;
import tp.p2.printerMode.DebugPrinter;
import tp.p2.printerMode.ReleasePrinter;

/**Clase que extiente de Command que se ocupa de gestionar la opción de pintado*/
public class PrintModeCommand extends Command {
	private static final String commandText = "print";
	private static final String commandName = "p";
	private static final String helpInfo = "PrintMode: change print mode [Release|Debug]";

	public PrintModeCommand() {
		super(commandText, commandName, helpInfo);
	}

	/**Método que ejecuta la opción correcta de pintado*/
	public void execute(Game game, Controller controller){
		if(controller.words[1].equals("release") || controller.words[1].equals("r")) {
			ReleasePrinter aux= new ReleasePrinter(game,game.numFilas,game.numColumnas);
			game.setBoard(aux);
			controller.setPrintGameState();
			controller.setNoSigCiclo();
			
		}
		else if(controller.words[1].equals("debug") || controller.words[1].equals("d")) {
			DebugPrinter aux = new DebugPrinter(game,game.numFilas,game.numColumnas);
			game.setBoard(aux);
			controller.setPrintGameState();
			controller.setNoSigCiclo();
		}
	}

	/**Método que retorna un objeto de tipo Commando. NULL en el caso de no ser el mismo*/
	public Command parse(String[] commandWords, Controller controller) {
		if(commandWords[0].equals(this.commandName) || commandWords[0].equals(this.commandText)) {
			if(commandWords[1].equals("release") || commandWords[1].equals("r") || commandWords[1].equals("debug") || commandWords[1].equals("d")) return this;
			else return null;
		}
		else return null;
	}

}
