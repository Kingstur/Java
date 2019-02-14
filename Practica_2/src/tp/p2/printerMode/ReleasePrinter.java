package tp.p2.printerMode;

import tp.p2.game.Game;
import util.MyStringUtils;

/**Clase para pintar el tablero en modo RELEASE*/
public class ReleasePrinter extends BoardPrinter implements GamePrinter {
	int dimX; 
	int dimY;
	String[][] board;
	final String space = " ";
	
	public ReleasePrinter(Game game, int dimX, int dimY) {
		this.dimX = dimX;
		this.dimY = dimY;
		encodegame(game);
	}
	
	/**Método para pintar el tablero y sus datos*/
	public void printGame(Game game) {
		encodegame(game);
		String s ="";
		s = s + "Number of cycles: " + game.getCiclos() + "\n" +
			"Sun coins: " + game.getSoles() + "\n" +
			"Remaining zombies:" + game.getNumZombies() + "\n";
		s = s + toString();
		System.out.println(s);
	}

	/**Método para agregar a cada posicion del array que se utiliza para el tablero un objeto o espacio*/
	public void encodegame(Game game) {
		board = new String[dimX][dimY];
		for(int i = 0; i < dimX; i++) {
			for(int j = 0; j < dimY; j++) {
				String aux = game.buscarObjetos(i, j);
				board[i][j] =  aux;
			}
		}
	}
	
	/**Método para convertir el array en un tablero unificando en un String todos los caracteres*/
	public String toString() {
		
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (dimY * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
		str.append(lineDelimiter);
		
		for(int i=0; i<dimX; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<dimY; j++) {
					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
				}
				str.append(lineDelimiter);
		}
		return str.toString();
	}

}
