package tp.p2;

import java.util.Scanner;

import tp.p2.game.Game;
import tp.p2.patronCommand.Command;
import tp.p2.patronCommand.CommandParser;
/**
 * Clase del objeto controller que maneja las acciones del juego
 * @author Vadym Batsula y Víctor Ramos
 *
 */
public class Controller {
	private Game game;
	private Scanner sc;
	private boolean print;
	private String prompt;
	private boolean seguir;
	public String[] words;
	private boolean sigCiclo;
	
	public Controller(Game g) {
		this.game = g;
		this.sc = new Scanner(System.in);
		this.print=true;
		this.prompt="Command >";
		this.seguir = true;
		this.sigCiclo = true;
		}
	
	/**
	 * Bucle principal de la aplicacion
	 */
	public void run() {
		while(seguir) {
			if(this.print)this.game.draw();
			System.out.println(prompt);
			words = this.sc.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandParser.parseCommand(words, this);
			if (command != null){
				command.execute(game, this);
				if(this.sigCiclo){
					if(this.game.update()) {
					computerAction();
					}
					else seguir = false;
				}
			}
			else {
				System.err.println("Comando erróneo");				
				setNoPrintGameState();
			}
		}
	}
	
	/**Métodos para gestionar si pintar o no el tablero*/
	public void setNoPrintGameState() {
		this.print = false;
	}
	public void setPrintGameState() {
		this.print=true;
	}
	/**Métodos para gestionar el avance de los ciclos*/
	public void setNoSigCiclo() {
		this.sigCiclo = false;
	}
	public void setSigCiclo() {
		this.sigCiclo=true;
	}
	/**Método para indicar el fin de partida*/
	public void setExitGame() {
		this.seguir = false;
		System.out.println("GAME OVER.");
	}
	/**
	 * Comportamiento pseudoaleatorio del ordenador
	 */
	private void computerAction() {
		this.game.crearZombie();
	}
}
