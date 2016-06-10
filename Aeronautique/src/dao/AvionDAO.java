package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import aeronautique.Avion;

public class AvionDAO extends DAO<Avion> {
	private static final String TABLE = "Avion";
	private static final String CLE_PRIMAIRE = "numAv";

	@Override
	public boolean create(Avion av) {
		boolean rep= true;
		try {
			String requete= "INSERT INTO "+TABLE+" (nomAv,LOC,CAP) VALUES (?,?,?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setString(1,av.getNom());
			pst.setString(2,av.getLoc());
			pst.setInt(3,av.getCapacite());
			pst.executeUpdate();

			//MAJ identifiant
			av.setNumero(Connexion.getMaxId(CLE_PRIMAIRE, TABLE));

		} catch (SQLException e) {
			rep=false;
			e.printStackTrace();
		}
		return rep;
	}



	@Override
	public boolean delete(Avion av) {
		boolean rep= true;
		try {
			int id  = av.getNumero();
			String requete= "DELETE* FROM "+TABLE+" WHERE"+CLE_PRIMAIRE+"= ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1,id);
			pst.executeUpdate();
		} catch (SQLException e) {
			rep=false;
			e.printStackTrace();
		}
		return rep;
	}

	@Override
	public boolean update(Avion av) {
		boolean rep = true;

		try {
			String requete= "UPDATE "+TABLE+" SET nomAv = ?, LOC = ?, CAP =?"+" WHERE "+CLE_PRIMAIRE+"= ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);

			pst.setString(1,av.getNom());
			pst.setString(2,av.getLoc());
			pst.setInt(3,av.getCapacite());
			pst.setInt(4,av.getNumero());
			pst.executeUpdate();



		} catch (SQLException e) {

			System.out.println(e.getMessage());

			rep= false;

		}
		return rep;
	}

	@Override
	public Avion find(int id) { 
		Avion avion = null;
		try {
			String requete= "SELECT* FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
			ResultSet rs = Connexion.executeQuery(requete);
			rs.next();
			String nom = rs.getString("nomAv");
			String loc = rs.getString("LOC");
			int capacite= rs.getInt("CAP");
			avion = new Avion (id, nom, loc , capacite);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return avion;
	}
	
	
	public void afficheSelectEtoileAvion() {
		 		System.out.println("--- Avion non utilisé ---");
		 		String clauseWhere = "numav NOT IN (SELECT numAv From Vol)";
		 	
		 
		 		System.out.println("--- Avion contraint par Vol --- ");
		 		clauseWhere = "numav IN (SELECT numAv From Vol)";
		 		Connexion.afficheSelectEtoile("Avion", clauseWhere);
		 		
		 	}
	
	
	
	
	
	
	
}
