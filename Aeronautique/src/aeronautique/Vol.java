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
public static void main(String[] args) {
		// TODO Auto-generated method stgub


	}

}
