package aeronautique;

public class Avion {
	private int numero;
	private String nom;
	private String loc;
	private int capacite;
	//private int enplus;
	
		///h
	public Avion(int numero, String nom, String loc, int capacite) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.loc = loc;
		this.capacite = capacite;
		//this.enplus =12;
	}
		
	
	
	
	public int getNumero() {
		return numero;
	}




	public void setNumero(int numero) {
		this.numero = numero;
	}




	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getLoc() {
		return loc;
	}




	public void setLoc(String loc) {
		this.loc = loc;
	}




	public int getCapacite() {
		return capacite;
	}




	public void setCapacite(int capacite) {
		capacite = capacite;
	}




	@Override
	public String toString() {
		return "Avion [Numero=" + numero + ", Nom=" + nom + ", Loc=" + loc + ", Capacite=" + capacite + "]";
	}
	
	

}
