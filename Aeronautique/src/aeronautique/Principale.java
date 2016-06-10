package aeronautique;

import dao.AvionDAO;
import dao.Connexion;

public class Principale {

	public static void main(String[] args) {
		//Connexion.afficheSelectEtoile("Avion");
		/*Avion avion = new Avion ( 747, "SR3", "rennes", 770);
		(new AvionDAO()).create(avion);
		System.out.println(avion);
		Connexion.afficheSelectEtoile("Avion");
		Avion avion2 = new Avion (-1,"airbus", "caen" , 322);
		(new AvionDAO()).create(avion2);
		System.out.println(avion);
		System.out.println(avion2);
		*/
		
		Avion Ravion =(new AvionDAO()).find(744);
		System.out.println("avion recherché "+ Ravion);
	//	Connexion.afficheSelectEtoile("Avion");
		Connexion.afficheSelectEtoile("VOL");
		Connexion.fermer();

	}

}
