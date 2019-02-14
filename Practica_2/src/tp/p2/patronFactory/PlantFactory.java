package tp.p2.patronFactory;

import tp.p2.characters.Nuez;
import tp.p2.characters.PeaShooter;
import tp.p2.characters.PetaCereza;
import tp.p2.characters.Sunflower;

/**Clase encargada de gestionar la selección de plantas */
public class PlantFactory {
	/**Plantas disponibles*/
	private static Plant[] availablePlants= {
			new Sunflower(),
			new PeaShooter(),
			new PetaCereza(),
			new Nuez()
	};
	
	/**Método que retorna un objeto planta, específicamente el tipo de planta según el parámetro que recibe*/
	public static Plant getPlant(String plantName) {
		if(plantName.startsWith("s") || plantName.equals("sunflower")) return new Sunflower();
		else if(plantName.startsWith("p") || plantName.equals("peashooter")) return new PeaShooter();
		else if(plantName.startsWith("c") || plantName.equals("petacereza")) return new PetaCereza();
		else if(plantName.startsWith("n") || plantName.equals("nuez")) return new Nuez();
		else return null;
	}
	
	/**Método que devuelve la lista de plantas, utilizada en el comando LIST*/
	public static String listOfAvilablePlants(){
		String x = "Command > List" +" \n";
		String s = "[S]unflower: Cost: 20 suncoins Harm:0 "+"\n";
		String p = "[P]eashooter: Cost:50 suncoins Harm:1 "+"\n";
		String c = "Peta[C]ereza: Cost:50 suncoins Harm:10" + "\n";
		String n = "[N]uez: Cost:50 suncoins Harm:0 "+"\n";
		return x+s+p+c+n;
	}
}
