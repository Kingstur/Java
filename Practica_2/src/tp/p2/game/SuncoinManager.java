package tp.p2.game;

/**
 * Clase que controla el numero de soles del juego
 * @author Vadym Batsula y Victor Ramos 
 *
 */
public class SuncoinManager {
	private int numSoles;
	
	/**Métodos de gestión de SOLES*/
	public SuncoinManager() {this.numSoles = 50;}

	public int getNumSoles() {
		return numSoles;
	}
	public void setNumsoles(int n) {this.numSoles = n;}

	public void gastarSoles(int numSoles) {
		this.numSoles -= numSoles;
	}
	public void aumentarSoles(int numSoles) {
		this.numSoles += numSoles;
	}
	
	public boolean compararSoles(int num) {
		if(num <= this.numSoles) return true;
		else return false;
	}
	
}
