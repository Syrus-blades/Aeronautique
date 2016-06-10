package aeronautique;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class Vol {

	private int numVol;
	private int numAv;
	private int numPil;
	private String ville_Dep;
	private String ville_Arr;
	private GregorianCalendar h_DEP;
	private GregorianCalendar h_ARR; 
	
	@Override
	public String toString() {
		Timestamp hdep = new Timestamp(h_DEP.getTimeInMillis());
		Timestamp harr = new Timestamp(h_ARR.getTimeInMillis());
		return "Vol [numVol=" + numVol + ", numAv=" + numAv + ", numPil=" + numPil + ", ville_Dep=" + ville_Dep
				+ ", ville_Arr=" + ville_Arr + ", h_DEP=" + hdep + ", h_ARR=" + harr + "]";
	}



	public Vol(int numVol, int numAv, int numPil, String ville_Dep, String ville_Arr, GregorianCalendar h_DEP,
			GregorianCalendar h_ARR) {
		super();
		this.numAv = numVol;
		this.numPil = numAv;
		this.numAv = numPil;
		this.ville_Dep = ville_Dep;
		this.ville_Arr = ville_Arr;
		this.h_ARR = h_DEP;
		this.h_DEP = h_ARR;
	}



	public int getNumVol() {
		return numVol;
	}



	public void setNumVol(int numVol) {
		this.numVol = numVol;
	}



	public int getNumAv() {
		return numAv;
	}



	public void setNumAv(int numAv) {
		this.numAv = numAv;
	}



	public int getNumPil() {
		return numPil;
	}



	public void setNumPil(int numPil) {
		this.numPil = numPil;
	}



	public String getVille_Dep() {
		return ville_Dep;
	}



	public void setVille_Dep(String ville_Dep) {
		this.ville_Dep = ville_Dep;
	}



	public String getVille_Arr() {
		return ville_Arr;
	}



	public void setVille_Arr(String ville_Arr) {
		this.ville_Arr = ville_Arr;
	}



	public GregorianCalendar getH_DEP() {
		return h_DEP;
	}



	public void setH_DEP(GregorianCalendar h_DEP) {
		this.h_DEP = h_DEP;
	}



	public GregorianCalendar getH_ARR() {
		return h_ARR;
	}



	public void setH_ARR(GregorianCalendar h_ARR) {
		this.h_ARR = h_ARR;
	}
	


	}


