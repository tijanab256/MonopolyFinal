/**
 * Klasse Werke
 * @author Rudi Gola
 */
import java.util.Collections;
import java.util.LinkedList;

//Klasse "Werke" erstellen

public class Werke extends Spielfeld {
	
//Konstruktoren

    public Werke (int ID, String Name, int Kaufpreis, int Miete, String Besitzer, boolean Bauen) {
		super(ID, Name, Kaufpreis, Miete, Besitzer, Bauen);
    }
	
//Initailisieren der LinkedList "Werk"

    static LinkedList<Werke> Werk = new LinkedList<>();

    static {

    Werk.add (new Werke(12 ,"Elektrizitaetswerk" ,150 ,0 ,"Bank", false));
    Werk.add(new Werke(28 ,"Wasserwerk" ,150 ,0 ,"Bank", false));
    
    }
    
// Setter-Methoden
  
/*
* @param ID des Werks
*/

    @Override
    public void setID (int ID) {
        this.ID = ID;
    }

/*
 * @param Name des Werks
 */
 

    @Override
    public void setName (String Name) {
        this.Name = Name;
    }

/*
 * @param Kaufpreis des Werks
 */

    @Override
    public void setKaufpreis (int Kaufpreis) {
        this.Kaufpreis = Kaufpreis;
    }

/*
 * @param Miete des Werks
 */

    @Override
    public void setMiete (int Miete) {
        this.Miete = Miete;
    } 

/*
 * @param Besitzer des Werks
 */

    @Override
    public void setBesitzer (String Besitzer) {
        this.Besitzer = Besitzer;
    }

/*
 * @param Bebauung des Werks
 */

    @Override
    public void setBauen (boolean Bauen) {
        this.Bauen = Bauen;
    }


// Getter-Methoden

 /*
 * @return gibt ID des Werks zurück
 */

    @Override
    public int getID() {
        return ID;
    }

/*
 * @return gibt Name des Werks zurück
 */

    @Override
    public String getName () {
        return Name;
    }
    
/*
 * @return gibt Kaufpreis des Werks zurück
 */

    @Override
    public int getKaufpreis () {
        return Kaufpreis;
    }
    
/*
 * @return gibt Miete des Werks zurück
 */

    @Override
    public int getMiete () {
        return Miete;
    }

/*
 * @return gibt Besitzer des Werks zurück
 */

    @Override
    public String getBesitzer () {
        return Besitzer;
    }

/*
 * @return gibt Bebauung des Werks zurück
 */

    @Override
    public boolean getBauen () {
        return Bauen;
    }

/*
 * @return die gesamte LinkedList Werke
 */    

    public static LinkedList<Werke> getWerk() {
        return Werk;
    }

}

