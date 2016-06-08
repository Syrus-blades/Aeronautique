package aeronautique;

public class Avion {
	private int Numero;
	private String Nom;
	private String Loc;
	private int Capacite;
	
		///h
	public Avion(int numero, String nom, String loc, int capacite) {
		super();
		Numero = numero;
		Nom = nom;
		Loc = loc;
		Capacite = capacite;
	}
		
	
	
	
	public int getNumero() {
		return Numero;
	}




	public void setNumero(int numero) {
		Numero = numero;
	}




	public String getNom() {
		return Nom;
	}




	public void setNom(String nom) {
		Nom = nom;
	}




	public String getLoc() {
		return Loc;
	}




	public void setLoc(String loc) {
		Loc = loc;
	}




	public int getCapacite() {
		return Capacite;
	}




	public void setCapacite(int capacite) {
		Capacite = capacite;
	}




	@Override
	public String toString() {
		return "Avion [Numero=" + Numero + ", Nom=" + Nom + ", Loc=" + Loc + ", Capacite=" + Capacite + "]";
	}
	
	

}
