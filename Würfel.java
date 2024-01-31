/**
 * Klasse Würfel
 * @author Rudi Gola
 */

import java.util.Random;

//Erstellung der Klasse Würfel

public class Würfel {

//Attribute

	public int ergebnis; 

// Methoden

/*
 * @param Zahlen von 1 bis 6
 */

    public void wuerfeln () {
        Random zufällig = new Random();
        ergebnis = zufällig.nextInt(6) + 1;
    }

/*
 * @return gibt Ergebnis zurück
 */

    public int getErgebnis () {
    	return ergebnis;
    }
	
}
