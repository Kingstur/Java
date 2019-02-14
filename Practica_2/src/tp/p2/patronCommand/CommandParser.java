package tp.p2.patronCommand;

import tp.p2.Controller;


/**Clase que convierte la entrada del usuario a un objeto ejecutable de la clase Command*/
public class CommandParser {
	/**Comandos disponibles*/
	private static Command[] availableCommands = {
			new AddCommand(),
			new PrintModeCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new ListCommand(),
			new NoneCommand(), 			
			new ZombieListCommand()
			};

	/**Método que devuelve un objeto del tipo Comando para proceder a su ejecución*/
	public static Command parseCommand(String[] words, Controller Controller) {
		Command c = null;
		boolean encontrado=false;
		int i = 0;
		while(i < availableCommands.length && !encontrado){
			c=availableCommands[i].parse(words, Controller);
			if(c != null) {encontrado=true;}
			else++i;
		}
		return c;
	}
	
	/**Método que imprime el texto de ayuda de cada comando existente*/
	public static String commandHelp() {
		String msg = "";
		for(int i = 0; i < availableCommands.length;++i) {
			msg += availableCommands[i].helpText() + "\n";
		}
		return msg;
	}
}
