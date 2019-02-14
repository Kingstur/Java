package tp.p2.patronCommand;

import tp.p2.Controller;
import tp.p2.game.Game;

/**Clase abstracta que hereda de Command con el m�todo abstracto EXECUTE definido para sus hijas*/
public abstract class NoParamsCommand extends Command {

	public NoParamsCommand(String commandText, String commandName, String helpInfo) {
		super(commandText, commandName, helpInfo);
	}
	public abstract void execute(Game game, Controller controller);
	
	/**M�todo que devuelve un objeto tipo Command seg�n el String que le entre por par�metro*/
	public  Command parse(String[] commandWords, Controller controller) {
		Command c= null;
		if(commandWords[0].equals(commandName) || commandWords[0].equals(commandText)) c=this;
		return c;
	}
}
