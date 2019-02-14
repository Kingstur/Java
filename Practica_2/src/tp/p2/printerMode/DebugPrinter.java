package tp.p2.printerMode;

import tp.p2.game.Game;
import util.MyStringUtils;

/**Clase para pintar el tablero en modo DEBUG*/
public class DebugPrinter extends BoardPrinter implements GamePrinter {
	int dim;
	int dimObjetos;
	String[] board;
	final String space = " ";
	
	
	public DebugPrinter(Game game, int dimX, int dimY) {
		this.dim = dimX*dimY;
		this.dimObjetos = 0;
		encodegame(game);
	}


	/**Método para pintar el tablero y sus datos*/
	public void printGame(Game game) {
		encodegame(game);
		String s = "";
		s = s + "Number of cycles: " + game.getCiclos() + "\n" +
				"Sun coins: " + game.getSoles() + "\n" +
				"Remaining zombies:" + game.getNumZombies() + "\n" +
				"Level:" + game.getLevel() + "\n" + 
				"Seed: " +game.getSeed() + "\n";
			s = s + toString();
			System.out.println(s);
	}

	/**Método para agregar a cada posicion del array que se utiliza para el tablero un objeto*/
	public void encodegame(Game game) {
		board = new String[dim];
		int dimP = game.getContP(); 
		int dimZ =	game.getContZ();
		dimObjetos =  dimP + dimZ;
		int cont = 0;
		if(dimP == 0 && dimZ == 0) this.board = null;
		else{
			for(int i = 0; i < dimP; i++) {
				String aux = game.getDebugP(i);
				board[i] =  aux;
				cont = i + 1;
			}
			for (int j = 0; j < dimZ; j++) {
				String aux = game.getDebugZ(j);
				board[cont] = aux;
				cont++;
			}
		}
	}
	
	/**Método para convertir el array en un tablero unificando en un String todos los caracteres*/
	public String toString() {
		
		int cellSize = 18;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (dimObjetos * (cellSize + 1)) - 1);
		String rowDelimiter2 = MyStringUtils.repeat(hDelimiter, cellSize);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
		String lineDelimiter2 = String.format("%n%s%s%n", margin + space, rowDelimiter2);
		
		StringBuilder str = new StringBuilder();
		
		if(board == null) {
			str.append(lineDelimiter2);
			str.append(margin).append(vDelimiter).append(MyStringUtils.repeat(space, cellSize)).append(vDelimiter);
			str.append(lineDelimiter2);
		}
		else {
				str.append(lineDelimiter);
				str.append(margin).append(vDelimiter);
					for (int j=0; j<dimObjetos; j++) {
					str.append(board[j]).append(vDelimiter);
					}
				str.append(lineDelimiter);
		}
		return str.toString();
	}

}
