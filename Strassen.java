/**
 * Klasse Strassen
 * @author Rudi Gola
 */

import java.util.Collections;
import java.util.LinkedList;

//Erstellung der Klasse Strassen

public class Strassen extends Spielfeld {

//Attribute

public int Haus;
public int Hauspreis;

//Konstruktoren

public Strassen (int ID, String Name, int Kaufpreis, int Miete, String Besitzer, boolean Bauen, int Haus, int Hauspreis) {
	super(ID, Name, Kaufpreis, Miete, Besitzer, Bauen);
    this.Haus = Haus;
    this.Hauspreis = Hauspreis;
}
//Initialisieren der LinkedList "Strassen"

public static LinkedList<Strassen> Strasse = new LinkedList<>();

	static {
	Strasse.add(new Strassen(1 ,"Badstrasse" ,60 ,2  ,"Bank", false, 0, 50));
	Strasse.add(new Strassen(3,"Turmstrasse",60,4 ,"Bank", false, 0, 50));
	Strasse.add(new Strassen(6,"Chausseestrasse",100,6 ,"Bank", false, 0, 50));
	Strasse.add(new Strassen(8,"Elisenstrasse",100,6 ,"Bank", false, 0, 50));
	Strasse.add(new Strassen(9,"Poststrasse",120,8 ,"Bank", false, 0, 50));
	Strasse.add(new Strassen(11,"Seestrasse",140,10 ,"Bank", false, 0, 100));
	Strasse.add(new Strassen(13,"Hafenstrasse", 140,10 ,"Bank", false, 0, 100));
	Strasse.add(new Strassen(14,"Neue Strasse", 160, 10 ,"Bank", false, 0, 100));
	Strasse.add(new Strassen(16,"Muenchnerstrasse", 180,14 ,"Bank", false, 0, 100));
	Strasse.add(new Strassen(18,"Wienerstrasse", 180, 14 ,"Bank", false, 0, 100));
	Strasse.add(new Strassen(19,"Berlinerstrasse",200, 16 ,"Bank", false, 0, 100));
	Strasse.add(new Strassen(21,"Theaterstrasse", 220, 18 ,"Bank", false, 0, 150));
    Strasse.add(new Strassen(23,"Museumstrasse", 220, 18,"Bank", false, 0, 150));
    Strasse.add(new Strassen(24,"Opernplatz", 240, 20 ,"Bank", false, 0, 150));
    Strasse.add(new Strassen(26,"Lessingstrasse", 260, 22 ,"Bank", false, 0, 150));
    Strasse.add(new Strassen(27,"Schillerstrasse", 260, 22,"Bank", false, 0, 150));
    Strasse.add(new Strassen(29,"Goethestrasse", 280, 24, "Bank", false, 0, 150));
    Strasse.add(new Strassen(31,"Rathausplatz", 300, 26, "Bank", false, 0, 200));
    Strasse.add(new Strassen(32,"Hauptstrasse", 300, 26, "Bank", false, 0, 200));
    Strasse.add(new Strassen(34,"Bahnhofstrasse", 320, 28, "Bank", false, 0, 200));
    Strasse.add(new Strassen(37,"Parkstrasse", 350, 35, "Bank", false, 0, 200));
    Strasse.add(new Strassen(39,"Schlossallee", 400, 50, "Bank", false, 0, 200));
}
	
// Setter-Methoden

 /*
 * @param ID der Straße
 */

@Override
public void setID (int ID) {
    this.ID = ID;
}

 /*
 * @param Name der Straße
 */

@Override
public void setName (String Name) {
    this.Name = Name;
}

 /*
 * @param Kaufpreis der Straße
 */

@Override
public void setKaufpreis (int Kaufpreis) {
    this.Kaufpreis = Kaufpreis;
}

 /*
 * @param Miete der Straße
 */

@Override
public void setMiete (int Miete) {
    this.Miete = Miete;
} 
 
 /*
 * @param Besitzer der Straße
 */

@Override
public void setBesitzer (String Besitzer) {
    this.Besitzer = Besitzer;
}

 /*
 * @param Bebauung der Straße
 */

@Override
public void setBauen (boolean Bauen) {
    this.Bauen = Bauen;
}

 /*
 * @param Anzahl Häuser
 */

public void setHaus (int Haus) {
    this.Haus = Haus;
}

 /*
 * @param Hauspreis 
 */

public void setHauspreis (int Hauspreis) {
    this.Hauspreis = Hauspreis;
}

// Getter-Methoden

 /*
 * @return gibt ID der Straße zurück
 */

@Override
public int getID () {
    return ID;
}

 /*
 * @return gibt Name der Straße zurück
 */

@Override
public String getName () {
    return Name;
}

 /*
 * @return gibt Kaufpreis der Straße zurück
 */

@Override
public int getKaufpreis () {
    return Kaufpreis;
}

 /*
 * @return gibt Miete der Straße zurück
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
 * @return gibt Wahrheitswert zurück, ob die Straße bebaut wurde
 */

@Override
public boolean getBauen () {
    return Bauen;
}

 /*
 * @return gibt die Anzahl der Häuser zurück
 */

public int getHaus () {
    return Haus;
}

 /*
 * @return gibt den Hauspreis zurück
 */

public int getHauspreis () {
    return Hauspreis;
}

/*
 * @return die gesamte LinkedList Strassen
 */

public static LinkedList<Strassen> getStrasse() {
    return Strasse;
}

}
