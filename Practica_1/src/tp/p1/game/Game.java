package tp.p1.game;

import java.util.Random;

import tp.p1.Level;
import tp.p1.characters.PeaShooter;
import tp.p1.characters.PeashooterList;
import tp.p1.characters.Sunflower;
import tp.p1.characters.SunflowerList;
import tp.p1.characters.ZombieList;
/**
 * Clase del objeto Game que hace funcionar el juego
 * @author Vadym Batsula y Víctor Ramos
 *
 */
public class Game {
	public SunflowerList listaGirasoles;
	public PeashooterList listaLanzaGuisantes;
	public ZombieList listaZombies;
	private int numCiclos;
	private SuncoinManager numSoles;
	private Random rand;
	private final int numFilas = 4;
	private final int numColumnas = 8;
	private ZombieManager zombieManager;
	private Level level;
	private long seed;
	
	/**
	 * Constructora del juego al inicio de la partida
	 */
	public Game(Level level, long seed){
		this.level = level;
		this.seed = seed;
		init(level, seed);
	}

	public void init(Level level, long seed) {
		this.listaGirasoles = new SunflowerList();
		this.listaLanzaGuisantes = new PeashooterList();
		this.listaZombies = new ZombieList(this.getLevel().getNumZombies());
		this.numCiclos = 0;
		this.numSoles = new SuncoinManager();
		this.rand = new Random(seed);
		this.zombieManager = new ZombieManager(level.getNumZombies(), level.getFrec(), this.rand);
	}

	public Level getLevel() {return this.level;}
	public long getSeed() {return this.seed;}
	
	public boolean update() {
		boolean seguir = true;
		
		//Actualizar Girasol
		this.listaGirasoles.updateSunflowerList(this.numSoles);
		
		 // Actualizar Lanzaguisantes
		this.listaLanzaGuisantes.updatePeashooterList();
		
		 // Actualizar Ciclo de Zombie 
		this.listaZombies.updateCiclosZombies(); 
		//Actualizar Zombie(ataca)
		this.listaZombies.updateZombieList();
		
		
		//Comprobar Muertes
		this.listaGirasoles.comprobarMuertes();
		this.listaLanzaGuisantes.comprobarMuertes();
		this.listaZombies.comprobarMuertes();
		
		 // ¿FINAL?
		if(this.zombieManager.getZombiesleftoappear() == 0 && this.listaZombies.getContador() == 0) {
			seguir = false;
			System.out.println("PLAYER WINS");
		}
		int i = 0;
		while(i < 4 && seguir) {
			String aux = buscarObjetos(i,0);
			if(aux.startsWith("Z")) {
				seguir = false;
				System.out.println("ZOMBIES WINS");
			}
			else ++i;
		}
		 
		return seguir;
	}


	public ZombieList getListaZombies() {
		return this.listaZombies;
	}

	/**
	 * Método para dibujar el tablero
	 */
	public String draw(Game game) {
		String s ="";
		GamePrinter d = new GamePrinter(game,this.numFilas,this.numColumnas);
		s = s + "Number of cycles: " + this.numCiclos + "\n" +
			"Sun coins: " + this.numSoles.getNumSoles() + "\n" +
			"Remaining zombies:" + this.zombieManager.getZombiesleftoappear() + "\n";
		s = s + d.toString();
		return s;
	}


	/**
	 * Añade una planta al juego
	 * @param nombre
	 * @param posx
	 * @param posy
	 */
	public void anadirPlanta(String nombre, int posx, int posy, Game game) {
		if(nombre.equals("sunflower") || nombre.equals("s")) {
			if(this.numSoles.compararSoles(Sunflower.getCoste())) {
				this.listaGirasoles.addSunflower(posx, posy,game);
				this.numSoles.gastarSoles(Sunflower.getCoste());
			}
			else System.out.println("Numero de soles insuficiente");
		}
		else {
			if(this.numSoles.compararSoles(PeaShooter.getCoste())) {
				this.listaLanzaGuisantes.addPeaShooter(posx,posy,game);
				this.numSoles.gastarSoles(PeaShooter.getCoste());
			}
			else System.out.println("Numero de soles insuficiente");
		}
	}
	
	public String buscarObjetos(int x, int y) {
		String msn = " ";
		boolean encontrado = false;
		
		//Buscar Sunflower
		encontrado = this.listaGirasoles.findSunflower(x, y);
		if(encontrado) msn = this.listaGirasoles.infoSunflower(x,y);
		else{
			//Buscar PeaShooter
			encontrado = this.listaLanzaGuisantes.findPeaShooter(x, y);
			if(encontrado) msn = this.listaLanzaGuisantes.infoPeaShooter(x,y);
			else {
				//Buscar Zombie
				encontrado = this.listaZombies.findZombie(x, y);
				if(encontrado)  msn=this.listaZombies.infoZombie(x,y);
			}
		}
		return msn;
	}


	public void sigCiclo() {this.numCiclos++;}


	public void crearZombie(Game game) {
		int num = this.rand.nextInt(4);
		String aux = buscarObjetos(num,7);
		
		if(aux.equals(" ")){
			boolean ok = this.zombieManager.isZombieAdded();
			if(ok)this.listaZombies.anadirZombie(num, game);
		}
	}
}
