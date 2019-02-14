package tp.p1;

/**
 * Enumerado sobre el nivel del juego
 * @author ImNotTortillero
 *
 */
public enum Level {
	EASY,HARD,INSANE;

	public int getNumZombies() {
		if(this == EASY) return 3;
		else if(this == HARD) return 5;
		else if(this == INSANE) return 10;
		else return -1;
	}
	
	public double getFrec() {
		if(this == EASY) return 0.1;
		else if(this == HARD) return 0.2;
		else if(this == INSANE) return 0.3;
		else return -1;
	}
}
