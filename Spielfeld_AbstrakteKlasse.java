/**
 * Abstrakte Klasse Spielfeld
 * @author Rudi Gola
 */

 //Erstellung der abstrakten Klasse Spielfeld

abstract class Spielfeld {

//Attribute

public int ID;
public String Name;
public int Kaufpreis;
public int Miete;
public String Besitzer;
public boolean Bauen;

//Konstruktoren

public Spielfeld (int ID, String Name, int Kaufpreis, int Miete, String Besitzer, boolean Bauen) {
	this.ID = ID;
	this.Name = Name;
	this.Kaufpreis = Kaufpreis;
	this.Miete = Miete;
	this.Besitzer = Besitzer;	
	this.Bauen = Bauen;
}

//Setter-Methoden

 /*
 * @param ID
 */

public abstract void setID(int ID);

 /*
 * @param Name
 */

public abstract void setName(String Name);

 /*
 * @param Kaufpreis
 */

public abstract void setKaufpreis(int Kaufpreis);

 /*
 * @param Miete
 */

public abstract void setMiete(int Miete);

 /*
 * @param Besitzer
 */

public abstract void setBesitzer(String Besitzer);

 /*
 * @param Bauen
 */

public abstract void setBauen(boolean Bauen);

//Getter-Methoden

public abstract int getID();
public abstract String getName();
public abstract int getKaufpreis();
public abstract int getMiete();
public abstract String getBesitzer();
public abstract boolean getBauen();


}