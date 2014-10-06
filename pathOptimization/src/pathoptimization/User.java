package pathoptimization;


public class User {
	int options = 0;
	int prefrences = 0;
	String[] optionNames = new String[options];
	boolean[] optionFlags = new boolean[options];
	String username = "";
	/** 
	 * favorite locations
	 * (GPS data type)[] favoriteGPS = new (GPS data type)[how big should it be for a list of "indefinite length"?]
	 * String[] favoriteName = new (String[how big should it be for a list of "indefinite length"?]
	 */
	String[] prefrenceNames = new String[prefrences];
	double[] prefrenceWeight = new double[prefrences]; // each element between 0 and 1. Use a slider for this?
	/**
	 * social connectivity? what's the industry standard for those variables?
	 * login with FB?
	 */
        User (String username, String password) {
            //constructor info
        }
}
