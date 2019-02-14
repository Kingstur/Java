package tp.p1;

import java.util.Scanner;

import tp.p1.game.Game;
/**
 * Clase del objeto controller que maneja las acciones del juego
 * @author Vadym Batsula y Víctor Ramos
 *
 */
public class Controller {
	private Game game;
	private Scanner sc;
	private boolean seguir;
	private boolean sigCiclo;
	private boolean rst;
	
	public Controller(Game g) {
		this.game = g;
		this.sc = new Scanner(System.in);
		this.sigCiclo = true;
		this.seguir = true;
		this.rst = false;
		}
	
	/**
	 * Bucle principal de la aplicacion
	 */
	public void run() {
		while(this.seguir){
			if(this.sigCiclo)this.seguir = this.game.update();
			if(this.seguir) {
				if(this.sigCiclo)System.out.println(this.game.draw(this.game));
				addCommand();
				if(this.sigCiclo && !this.rst)computerAction();
			}
			if(this.sigCiclo && !this.rst)this.game.sigCiclo();
			else this.rst = false;
			}
		if(!this.seguir) System.out.println(this.game.draw(this.game));
	}
	
	/**
	 * Comportamiento pseudoaleatorio del ordenador
	 */
	private void computerAction() {
		this.game.crearZombie(this.game);
	}
	
	/**
	 * Solicita un comando por pantalla y ejecuta su acción
	 */
	private void addCommand() {

			System.out.println("Command > ");
			String respuesta = sc.nextLine();
			String[] msn = respuesta.toLowerCase().split(" ");
			if((msn[0].equals("add") || msn[0].equals("a")) && msn.length == 4) {
				if(!ponerPlanta(msn)) this.sigCiclo = false;
				else this.sigCiclo = true;
			}
			else if(msn[0].equals("reset") || msn[0].equals("r")) {
				resetPartida();
				this.sigCiclo = true;
				this.rst = true;
			}
			else if(msn[0].equals("list") || msn[0].equals("l")) {
				mostrarLista();
				this.sigCiclo = false;
			}
			else if(msn[0].equals("help") || msn[0].equals("h")) {
				mostrarAyuda();
				this.sigCiclo = false;
			}
			else if(msn[0].equals("none") || msn[0].equals("n") || respuesta.equals("")) {
				System.out.println("None -> siguiente ciclo");
				this.sigCiclo = true;
			}
			else if(msn[0].equals("exit") || msn[0].equals("e")) {
				this.seguir = false;
				System.out.println("GAME OVER.");
			}
			else {
				System.out.println("Unknown Command");
				this.sigCiclo = false;
			}
	}
	
	/**
	 * Devuelve la partida al estado inicial
	 */
	private void resetPartida() {
		//metodo init de game
		game.init(game.getLevel(), game.getSeed());
	}


	/**
	 * Muestra la ayuda del juego
	 */
	private static void mostrarAyuda() {
		
		System.out.println("Command > Help");
		System.out.println("Add <plant> <x> <y>: Adds a plant in position x, y.");
		System.out.println("List: Prints the list of available plants.");
		System.out.println("Reset: Starts a new game.");
		System.out.println("Help: Prints this help message.");
		System.out.println("Exit: Terminates the program.");
		System.out.println("[none]: Skips cycle.");
	}

	/**
	 * Muestra la lista de plantas disponibles del juego
	 */
	private static void mostrarLista() {
		System.out.println("Command > List");
		System.out.println("[S]unflower: Cost: 20 suncoins Harm:0");
		System.out.println("[P]eashooter: Cost:50 suncoins Harm:1");
	}

	/**
	 * Añade si los datos son correctos una planta al juego
	 * @param msn datos por teclado
	 * @return ¿se puede?
	 */
	public boolean ponerPlanta(String[] msn){
		boolean end = false;
		if(msn[1].equals("peashooter") || msn[1].equals("p") ||msn[1].equals("sunflower") || msn[1].equals("s")) {
			if(Integer.parseInt(msn[2]) >= 0 && Integer.parseInt(msn[3]) >= 0 && Integer.parseInt(msn[2]) < 4 && Integer.parseInt(msn[3]) < 8) {
				//Si los datos son correctos comprobamos posicion libre
				String aux;
				aux = this.game.buscarObjetos(Integer.parseInt(msn[2]), Integer.parseInt(msn[3]));
				if(aux.equals(" ")) {
					this.game.anadirPlanta(msn[1],Integer.parseInt(msn[2]), Integer.parseInt(msn[3]), this.game);
					end = true;
					}
				
				else System.out.println("Invalid Position");
			}
			else System.out.println("Invalid Position");
		}
		else System.out.println("Invalid Object");
		return end;
	}
	
}
