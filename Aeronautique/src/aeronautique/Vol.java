package aeronautique;

import java.util.GregorianCalendar;

public class Vol {

	private int NumVol;
	private int NumAv;
	private int NumPil;
	private String Ville_Dep;
	private String Ville_Arr;
	private GregorianCalendar H_DEP;
	private GregorianCalendar H_ARR; 
	
	
	


	public Vol(int numVol, int numAv, int numPil, String ville_Dep, String ville_Arr, GregorianCalendar h_DEP,
			GregorianCalendar h_ARR) {
		super();
		NumVol = numVol;
		NumAv = numAv;
		NumPil = numPil;
		Ville_Dep = ville_Dep;
		Ville_Arr = ville_Arr;
		H_DEP = h_DEP;
		H_ARR = h_ARR;
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stgub


	}

}
