/**
 * Klasse Bahnhoefe
 * @author Rudi Gola
 */

import java.util.Collections;
import java.util.LinkedList;

//Klasse "Bahnhoefe" erstellen

public class Bahnhoefe extends Spielfeld {

//Konstruktoren

    public Bahnhoefe (int ID, String Name, int Kaufpreis, int Miete, String Besitzer, boolean Bauen) {
    	super(ID, Name, Kaufpreis, Miete, Besitzer, Bauen);
    }
    
    //Initialisieren der LinkedList "Bahnhoefe"

    private static LinkedList<Bahnhoefe> Bahnhof = new LinkedList<>();
    
   
    //Hinzufuegen der Bahnhoefe

    static {
        Bahnhof.add(new Bahnhoefe(5,"Suedbahnhof",200,25,"Bank", false));
        Bahnhof.add(new Bahnhoefe(15,"Westbahnhof",200,25,"Bank", false));
        Bahnhof.add(new Bahnhoefe(25,"Nordbahnhof",200,25,"Bank", false));
        Bahnhof.add(new Bahnhoefe(35,"Hauptbahnhof",200,25,"Bank", false));
    }  
    
    // Setter-Methoden
     
 /*
 * @param ID des Bahnhofs
 */

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }
    
/*
 * @param Name des Bahnhofs
 */

    @Override
    public void setName (String Name) {
        this.Name = Name;
    }
    
/*
 * @param Kaufpreis des Bahnhofs
 */

    @Override
    public void setKaufpreis (int Kaufpreis) {
        this.Kaufpreis = Kaufpreis;
    }
    
/*
 * @param Miete des Bahnhofs
 */

    @Override
    public void setMiete (int Miete) {
        this.Miete = Miete;
    }

/*
 * @param Besitzer des Bahnhofs
 */

    @Override
    public void setBesitzer (String Besitzer) {
        this.Besitzer = Besitzer;
    }

/*
 * @param Bebauung des Bahnhofs
 */

    @Override
    public void setBauen (boolean Bauen) {
        this.Bauen = Bauen;
    }
    
    // Getter-Methoden
    
/*
 * @return gibt ID des Bahnhofs zurück
 */

    @Override
    public int getID() {
	    return ID;
    }

/*
 * @return gibt Name des Bahnhofs zurück
 */

    @Override
    public String getName () {
        return Name;
    }

/*
 * @return gibt Kaufpreis des Bahnhofs zurück
 */

    @Override
    public int getKaufpreis () {
        return Kaufpreis;
    }
    
/*
 * @return gibt Miete des Bahnhofs zurück
 */

    @Override
    public int getMiete () {
        return Miete;
    }
    
 /*
 * @return gibt Besitzer der Straße zurück
 */

    @Override
    public String getBesitzer () {
        return Besitzer;
    }

/*
 * @return Bebauung des Bahnhofs
 */

    @Override
    public boolean getBauen () {        
        return Bauen;
    }

/*
 * @return die gesamte LinkedList Bahnhoefe
 */    

    public static LinkedList<Bahnhoefe> getBahnhof() {
        return Bahnhof;
    }




}
