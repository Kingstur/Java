package tp.p2.patronCommand;

import tp.p2.Controller;
import tp.p2.game.Game;

/**Clase principal abstracta de los comandos del juego*/
public abstract class Command {
	protected String helpText;
	protected String commandText;
	protected final String commandName;
	
	public Command(String commandText, String commandInfo, String helpInfo){
		this.commandText = commandInfo;
		this.helpText = helpInfo;
		this.commandName = commandText;
	}

	/**Métodos abstractos del hilo de clases que las utilizan*/
	public abstract void execute(Game game, Controller controller);
	
	public abstract Command parse(String[] commandWords, Controller controller);
	
	public String helpText(){return " " + commandText + ": " + helpText;}
}
