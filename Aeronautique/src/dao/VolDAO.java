package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.GregorianCalendar;


import aeronautique.Vol;

public class VolDAO extends DAO<Vol> {
	private static final String TABLE = "Vol";
	private static final String CLE_PRIMAIRE = "numVol";
	@Override
	public boolean create(Vol vol) {
		boolean rep= true;
		try {
			String requete= "INSERT INTO "+TABLE+" (nomAv,numPil,ville_DEP,ville_ARR,H_DEP,H_ARR) VALUES (?,?,?)";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
			pst.setInt(1,vol.getNumAv());
			pst.setInt(2,vol.getNumPil());
			pst.setString(3,vol.getVille_Dep());
			pst.setString(4,vol.getVille_Arr());
			Timestamp tD = new Timestamp (vol.getH_DEP().getTimeInMillis());
			Timestamp tA = new Timestamp (vol.getH_ARR().getTimeInMillis());
			pst.setTimestamp(5,tD); 
			pst.setTimestamp(6,tA); 
			pst.executeUpdate();

			//MAJ identifiant
			vol.setNumPil(Connexion.getMaxId(CLE_PRIMAIRE, TABLE));

		} catch (SQLException e) {
			rep=false;
			e.printStackTrace();
		}
		return rep;
	}


	@Override
	public boolean delete(Vol vol) {
		boolean rep= true;
		try {
			int id  = vol.getNumVol();
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
	public boolean update(Vol vol) {
		boolean rep = true;
		try {
			String requete= "UPDATE "+TABLE+" SET nomAV = ?, numPil = ?, Ville_Dep =?, Ville_ARR = ?, H_DEP = ?, H_ARR =?" 
					+"WHERE "+CLE_PRIMAIRE+"= ?";
			PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);

			pst.setInt(1,vol.getNumAv());
			pst.setInt(2,vol.getNumPil());
			pst.setString(3,vol.getVille_Dep());
			pst.setString(4,vol.getVille_Arr());
			Timestamp tD = new Timestamp (vol.getH_DEP().getTimeInMillis());
			Timestamp tA = new Timestamp (vol.getH_ARR().getTimeInMillis());
			pst.setTimestamp(5,tD); 
			pst.setTimestamp(6,tA);
			pst.setInt(7,vol.getNumVol());
			pst.executeUpdate();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

			rep= false;
		}
		return rep;
	}
	@Override
	public Vol find(int id) {
		Vol vol = null;
		try {
			String requete= "SELECT* FROM "+TABLE+" WHERE "+CLE_PRIMAIRE+" = "+id;
			ResultSet rs = Connexion.executeQuery(requete);
			rs.next();
			int numAv = rs.getInt("numAv");
			int numPil = rs.getInt("numPil");
			String ville_Dep = rs.getString("Ville_DEP");
			String ville_Arr = rs.getString("ville_ARR");
			GregorianCalendar h_DEP = new GregorianCalendar();
			h_DEP.setTimeInMillis (rs.getTimestamp("H_DEP").getTime());
			GregorianCalendar h_ARR = new GregorianCalendar();
			h_ARR.setTimeInMillis (rs.getTimestamp("H_ARR").getTime());
			
			vol = new Vol(id, numAv, numPil, ville_Dep, ville_Arr, h_DEP, h_ARR );		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vol;
	}

}
