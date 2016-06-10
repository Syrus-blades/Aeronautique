package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aeronautique.Pilote;



public class PiloteDAO extends DAO<Pilote> {
	private static final String TABLE = "Pilote";
	private static final String CLE_PRIMAIRE = "numPil";
	@Override
	public boolean create(Pilote pl) {
		boolean rep= true;
		try {
			String requete= "INSERT INTO "+TABLE+" (nomPil,adr,sal) VALUES (?,?,?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setString(1,pl.getNomPil());
			pst.setString(2,pl.getAdr());
			pst.setInt(3,pl.getSal());
			pst.executeUpdate();

			//MAJ identifiant
			pl.setNumPil(Connexion.getMaxId(CLE_PRIMAIRE, TABLE));

		} catch (SQLException e) {
			rep=false;
			e.printStackTrace();
		}
		return rep;
	}

	@Override
	public boolean delete(Pilote pl) {
		boolean rep= true;
		try {
			int id  = pl.getNumPil();
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
	public boolean update(Pilote pl) {
		boolean rep = true;
		try {
			String requete= "UPDATE "+TABLE+" SET nomPil = ?, adr = ?, sal =?" 
					+"WHERE "+CLE_PRIMAIRE+"= ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);

			pst.setString(1,pl.getNomPil());
			pst.setString(2,pl.getAdr());
			pst.setInt(3,pl.getSal());
			pst.setInt(4,pl.getNumPil());
			pst.executeUpdate();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

			rep= false;
		}
		return rep;
	}

	@Override
	public Pilote find(int id) {
		Pilote pilote = null;
		try {
			String requete= "SELECT* FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
			ResultSet rs = Connexion.executeQuery(requete);
			rs.next();
			String nomPil = rs.getString("nomPil");
			String adr = rs.getString("adr");
			int sal = rs.getInt("sal");
			pilote = new Pilote (id, nomPil, adr ,sal);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pilote;
	}
}

