package tp.p2.game;

import java.util.Random;
import tp.p2.Controller;
import tp.p2.Level;
import tp.p2.characters.CharactersList;
import tp.p2.patronFactory.Plant;
import tp.p2.printerMode.GamePrinter;
import tp.p2.printerMode.ReleasePrinter;
/**
 * Clase del objeto Game que hace funcionar el juego
 * @author Vadym Batsula y Víctor Ramos
 *
 */
public class Game {
	private CharactersList listaPlantas; 
	private CharactersList listaZombies; 
	private int numCiclos;
	private SuncoinManager numSoles;
	private Random rand;
	public static final int numFilas = 4;
	public static final int numColumnas = 8;
	private ZombieManager zombieManager;
	private Level level;
	private long seed;
	private GamePrinter board;
	/**
	 * Constructora del juego al inicio de la partida
	 */
	public Game(Level level, long seed){
		this.level = level;
		this.seed = seed;
		init(level, seed);
	}

	/**Método para inicializar los elementos de la partida*/
	public void init(Level level, long seed) {
		this.listaPlantas = new CharactersList();
		this.listaZombies = new CharactersList();
		this.numCiclos = 0;
		this.numSoles = new SuncoinManager();
		this.rand = new Random(seed);
		this.zombieManager = new ZombieManager(level.getNumZombies(), level.getFrec(), this.rand);
		this.board = new ReleasePrinter(this,this.numFilas,this.numColumnas);
	}
	
	public void setBoard(GamePrinter b) {
		this.board=b;
	}
	public int getCiclos() {
		return this.numCiclos;
	}
	public int getSoles() {
		return this.numSoles.getNumSoles();
	}
	public int getNumZombies() {
		return this.zombieManager.getZombiesleftoappear();
	}
	public int getContZ() {
		return listaZombies.getContador();
	}
	public int getContP() {
		return listaPlantas.getContador();
	}
	public String getDebugP(int i) {
		return listaPlantas.infoDebug(i);
	}
	public String getDebugZ(int i) {
		return listaZombies.infoDebug(i);
	}
	
	public void aumentarSoles(int num) {
		this.numSoles.aumentarSoles(num);
	}

	public Level getLevel() {return this.level;}
	public long getSeed() {return this.seed;}
	
	/**Método que actualiza en orden todos los elementos del juego*/
	public boolean update() {
		boolean seguir = true;
		
		//Actualizar Plantas
		this.listaPlantas.updateGameObject();
		//Actualizar Zombies
		this.listaZombies.updateGameObject();
		//Comprobar Muertes
		this.listaPlantas.deleteGameObject();
		this.listaZombies.deleteGameObject();
		
		sigCiclo();
		
		seguir = !isFinished();
		 
		return seguir;
	}
	
	/**Método que comprueba si el juego ha finalizado ya sea por victoria del jugador o de la máquina*/
	public boolean isFinished() {
		boolean fin = false;
		int i = 0;
		 // ¿FINAL?
		if(this.zombieManager.getZombiesleftoappear() == 0 && this.listaZombies.getContador() == 0) {
			fin = true;
			System.out.println("PLAYER WINS");
			draw();
		}
		while(i < 4 && !fin) {
			String aux = buscarObjetos(i,0);
			if(aux.startsWith("Z") || aux.startsWith("X") || aux.startsWith("W")) {
				fin = true;
				System.out.println("ZOMBIES WINS");
				draw();
			}
			else ++i;
		}
		return fin;
	}


	/**
	 * Método para dibujar el tablero
	 */
	public void draw() {
		this.board.printGame(this);
	}


	/**
	 * Añade una planta al juego
	 * @param planta
	 * @param posx
	 * @param posy
	 */
	public void anadirPlanta(Plant planta, int fila, int columna, Controller controller) {
		planta.setFila(fila);
		planta.setColumna(columna);
		planta.setGame(this);
		if(this.numSoles.getNumSoles() >= planta.getCoste()){
			this.numSoles.gastarSoles(planta.getCoste());
			this.listaPlantas.addGameObject(planta);
			controller.setPrintGameState();
			controller.setSigCiclo();
		}
		else {
			System.out.println();
			System.err.println("Soles insuficientes");
			controller.setNoPrintGameState();
			controller.setNoSigCiclo();
		}
	}
	
	/**Método que retorna un String con los datos de un objeto en una posición. NULL si no existe*/
	public String buscarObjetos(int x, int y){
		String msn = " ";
		msn=this.listaPlantas.infoGameObject(x, y);
		if(msn.equals(" ")) msn=this.listaZombies.infoGameObject(x, y);
		return msn;
	}
	
	/**Métodos para atacar a los objetos del juego y restarles vida*/
	public void attackZombie(int x, int y, int ataque) {
		this.listaZombies.attackGameObject(x, y, ataque);
	}
	public void attackPlant(int x, int y, int ataque) {
		this.listaPlantas.attackGameObject(x, y, ataque);
	}
	/**Metodo que aumenta el ciclo del juego */
	public void sigCiclo() {this.numCiclos++;}

	/**Método que genera un ZOMBIE aleatorio en cualquiera de las casillas de la derecha*/
	public void crearZombie() {
		int num = this.rand.nextInt(4);
		String aux = buscarObjetos(num,7);
		
		if(aux.equals(" ")){
			boolean ok = this.zombieManager.isZombieAdded();
			if(ok)this.listaZombies.addZombie(num, this);
		}
	}
}
