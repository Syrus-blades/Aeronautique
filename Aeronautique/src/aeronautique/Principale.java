package aeronautique;

import java.util.GregorianCalendar;

import dao.AvionDAO;
import dao.Connexion;
import dao.VolDAO;

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
		
		
		*//*
		*****************************************************
		Avion avion = new Avion(744,"X-23","brest",1200);
        Avion av52 = (new AvionDAO()).find(avion.getNumero());
        System.out.println("AVT updateAVIOn "+ av52);
        boolean succes =(new AvionDAO()).update(avion);
        av52 = (new AvionDAO()).find(avion.getNumero());
        System.out.println("APRES updateAVIOn "+ av52);
        *****************************************************
        */
		GregorianCalendar tD = new GregorianCalendar(2016,05,10,12,00,00);
		GregorianCalendar tA = new GregorianCalendar(2016,05,10,15,00,00);
		Vol vol = new Vol (-1,740, 1003 , "paris","rennes",tD,tA);
		(new VolDAO()).create(vol);
		 Connexion.afficheSelectEtoile("VOL");
		
	//	Avion Ravion =(new AvionDAO()).find(744);
	//	System.out.println("avion recherché "+ Ravion);
		
	//	Connexion.afficheSelectEtoile("Avion");
	//  Connexion.afficheSelectEtoile("VOL");
	//	Connexion.afficheSelectEtoile("Pilote");
		
		 
		 
		 
		 
		 
		 Connexion.fermer();
		
		
		
		
		
		

	}

}
