import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
/** 
 *  Model-Klasse, Teil des MVC, enthält die Daten die erwendet werden
 * @author Tijana Belau
 * 
 * 
 */
public class Model {

	//Alle Spielerlisten
	private LinkedList<Spieler> Rundenablauf = new LinkedList<Spieler>();
	private LinkedList<Spieler> ComSpieler = new LinkedList<Spieler>();
	private Set<Spieler> AlleSpieler = new LinkedHashSet<>();

	//Kartenlisten
	private static LinkedList<String> gkartenListe = Gemeinschaftskarten.getKarten();
	private static LinkedList<String> ekartenListe = Ereigniskarten.getKarten();
	
	//Spielfeldlisten
	private LinkedList<Strassen> strassenListe = Strassen.getStrasse();
	private LinkedList<Werke> werkListe = Werke.getWerk();
	private LinkedList<Bahnhoefe> bahnhofListe = Bahnhoefe.getBahnhof();
	private LinkedList<Spielfeld> spielfeldListe = new LinkedList<>();

	{
	spielfeldListe.addAll(strassenListe);
    spielfeldListe.addAll(werkListe);
    spielfeldListe.addAll(bahnhofListe);
	}
    
	//Attribute
	public Bank bank = new Bank();
	private int aktuellerWurf = 0;
	int wurfergebnis;
	
	//Methoden

	/**
	 * @return eine Bank die das Geld und die Häuser verwaltet
	 */
	public Bank getBank() {
		return bank;
	}

	/**
	 * @return eine Liste aller realen Spieler
	 */
	public LinkedList<Spieler> getRundenablauf() {
		return Rundenablauf;
	}

	/**
	 * @return eine Liste aller Computerspieler
	 */
	public LinkedList<Spieler> getComSpieler() {
		return ComSpieler;
	}

	/**
	 * @return eine Liste aller Spieler kombiniert
	 */
	public Set<Spieler> getAlleSpieler() {
		return AlleSpieler;
	}

	/**
	 * @return Eine Liste aller Gemeinschaftskarten
	 */
	public LinkedList<String> getGKarte() {
		return gkartenListe;
	}

	/**
	 * @return eine Liste aller Ereigniskarten
	 */
	public LinkedList<String> getEKarte() {
		return ekartenListe;
	}

	/**
	 * @param text Text der im Controller gezogenen Gemeinschftskarte
	 * @return Eine Gemeinschaftskarte mit dem gleichen Text wie der eingabe Parameter
	 */
	public int getGKarteByText(String text) {
		Gemeinschaftskarten gemeinschaftskarten = new Gemeinschaftskarten();
		return gemeinschaftskarten.KartenText(text);
	}

	/**
	 * @param text Text der im Controller gezogenen Ereigniskarte
	 * @return Eine Ereigniskarte mit dem gleichen Text wie der eingabe Parameter
	 */
	public int getEKarteByText(String text) {
		Ereigniskarten ereigniskarten = new Ereigniskarten();
		return ereigniskarten.KartenText(text);
	}

	/**
	 * @return das erste Element in der Gemeinschaftskartenliste
	 */
	public String zieheGKarte() {
		Gemeinschaftskarten gemeinschaftskarten = new Gemeinschaftskarten();
		return gemeinschaftskarten.obersteKarteZiehen();
	}

	/**
	 * @return das erste Element in der Ereigniskartenliste;
	 */
	public String zieheEKarte() {
		Ereigniskarten ereigniskarten = new Ereigniskarten();
		return ereigniskarten.obersteKarteZiehen();
	}

	/**
	 * @return eine Liste aller Strassen
	 */
	public LinkedList<Strassen> getStrassen() {
		return strassenListe;
	}

	/**
	 * @return eine Liste aller Werke
	 */
	public LinkedList<Werke> getWerke() {
	 	return werkListe;
	}

	/**
	 * @return eine Liste aller Bahnhöfe
	 */
	public LinkedList<Bahnhoefe> getBahnhof() {
		return bahnhofListe;
    }

	/**
	 * @return eine Liste aller Spielfelder, die zur akbstrakten Klasse Spielfeld gehören
	 */
    public LinkedList<Spielfeld> getFeld() {
	return spielfeldListe;
	}


	/**
	 * @param spieler der aktuelle Spieler
	 */
	public void spielerHinzufuegen(Spieler spieler) {
		Rundenablauf.add(spieler);
		bank.setGuthaben(bank.getGuthaben() - 1500);
	}


	/**
	 * @param spieler ein neuer angelegter Computerspieler
	 */
	public void comHinzufuegen(Spieler spieler) {
		ComSpieler.add(spieler);
		bank.setGuthaben(bank.getGuthaben() - 1500);
	}

	/**
	 * initalisiert die kombinierte Spielerliste
	 */
	public void setAlleSpieler () {
		AlleSpieler.addAll(Rundenablauf);
		AlleSpieler.addAll(ComSpieler);
	}

	/**
	 *  zählt den Wurf mit hoch als hilfsvariable
	 */
	public void setAktuellerWurf() {
		this.aktuellerWurf++;
	}

	/**
	 * @param kaufen prüft ob der Spieler gewürfelt hat oder etwas kauft, es soll nicht hochgezählt werden wenn er kauft
	 * @return gibt den aktuellen Spieler zurück in dem die Liste von oben nach unten durchlaufen wird
	 */
	public Spieler getAktuellerSpieler(boolean kaufen) {
		Spieler aktuellerSpieler = Rundenablauf.get(aktuellerWurf % Rundenablauf.size());
		if (kaufen) {
				aktuellerSpieler = Rundenablauf.get((aktuellerWurf -1 ) % Rundenablauf.size());
		} else {
			aktuellerSpieler = Rundenablauf.get(aktuellerWurf % Rundenablauf.size());
		}
		return aktuellerSpieler;
	}

	/**
	 * @return gibt das Ergebnis von beiden Würfeln des Spieler kombiniert zurück
	 */
	public int wuerfelnAktuellerSpieler() {
		Spieler aktuellerSpieler = Rundenablauf.get(aktuellerWurf % Rundenablauf.size());
		int gesamtwurf = aktuellerSpieler.würfeln();

		this.aktuellerWurf++;
		wurfergebnis = gesamtwurf;
		return gesamtwurf;
	}

	/**
	 * @param id das Feld auf dem der Spieler sich gerade befindet und nachdem gesucht werden soll
	 * @return das feld dessen id mit dem Eingabeparameter übereinstimmt
	 * 
	 */
	public Spielfeld getFeldById(int id) {
		System.out.println("Runde get Street: " + aktuellerWurf);
		for (Spielfeld feld : spielfeldListe) {
			if (feld.getID() == id) {
				return feld;
			}
		}
		System.out.println("Straße mit der angegebenen ID nicht gefunden " + id);
		System.out.println(spielfeldListe);
		return null;
	}


	/**
	 * @param name Name der überprüft werden soll
	 * @return gefundener Spieler der diesen Namen hat
	 */
	public Spieler findSpielerByName(String name) {
		for (Spieler spieler : Rundenablauf) {
			if (spieler.getName().equals(name)) {
				return spieler;

			}
		}
		// Spieler mit dem angegebenen Namen wurde nicht gefunden
		return null;
	}

	/**
	 * zum anpassen der Mieten unter verschiedenen Bedingungen, beim Häuser und Hotels kaufen, wenn Straßenzüge voll sind, wenn man mehrere Bahnhöfe besitz, wenn man beide Werke besitzt 
	 */
	public void MietenAnpassen() {
		Werke werk1 = werkListe.get(0);
		Werke werk2 = werkListe.get(1);
		werk1.setMiete( 4 * wurfergebnis);
		werk2.setMiete( 4 * wurfergebnis);
		if (werk1.getBesitzer().equals(werk2.getBesitzer()) && werk1.getBesitzer() != "Bank") {
			werk1.setMiete(10 * wurfergebnis);
			werk2.setMiete(10 * wurfergebnis);	
		}
		Bahnhoefe bahnhof1 = bahnhofListe.get(0);
		Bahnhoefe bahnhof2 = bahnhofListe.get(1);
		Bahnhoefe bahnhof3 = bahnhofListe.get(2);
		Bahnhoefe bahnhof4 = bahnhofListe.get(3);
		//Besitz 2 Bahnhöfe
		if (bahnhof1.getBesitzer().equals(bahnhof2.getBesitzer()) && bahnhof1.getBesitzer() != "Bank"){
			bahnhof1.setMiete(50);
			bahnhof2.setMiete(50);
		} else if (bahnhof1.getBesitzer().equals(bahnhof3.getBesitzer()) && bahnhof1.getBesitzer() != "Bank"){
			bahnhof1.setMiete(50);
			bahnhof3.setMiete(50);
		} else if (bahnhof1.getBesitzer().equals(bahnhof4.getBesitzer()) && bahnhof1.getBesitzer() != "Bank"){
			bahnhof1.setMiete(50);
			bahnhof4.setMiete(50);
		} else if (bahnhof2.getBesitzer().equals(bahnhof3.getBesitzer()) && bahnhof2.getBesitzer() != "Bank"){
			bahnhof2.setMiete(50);
			bahnhof3.setMiete(50);
		} else if (bahnhof2.getBesitzer().equals(bahnhof4.getBesitzer()) && bahnhof2.getBesitzer() != "Bank"){
			bahnhof2.setMiete(50);
			bahnhof4.setMiete(50);
		} else if (bahnhof3.getBesitzer().equals(bahnhof4.getBesitzer()) && bahnhof3.getBesitzer() != "Bank"){
			bahnhof3.setMiete(50);
			bahnhof4.setMiete(50);
		} 
		//Besitz 3 Bahnhöfe
		else if (bahnhof1.getBesitzer().equals(bahnhof2.getBesitzer()) && bahnhof1.getBesitzer().equals(bahnhof3.getBesitzer()) && bahnhof1.getBesitzer() != "Bank") {
			bahnhof1.setMiete(75);
			bahnhof2.setMiete(75);
			bahnhof3.setMiete(75);
		} else if (bahnhof1.getBesitzer().equals(bahnhof2.getBesitzer()) && bahnhof1.getBesitzer().equals(bahnhof4.getBesitzer()) && bahnhof1.getBesitzer() != "Bank") {
			bahnhof1.setMiete(75);
			bahnhof2.setMiete(75);
			bahnhof4.setMiete(75);
		} else if (bahnhof1.getBesitzer().equals(bahnhof3.getBesitzer()) && bahnhof1.getBesitzer().equals(bahnhof4.getBesitzer()) && bahnhof1.getBesitzer() != "Bank") {
			bahnhof1.setMiete(75);
			bahnhof3.setMiete(75);
			bahnhof4.setMiete(75);
		} else if (bahnhof2.getBesitzer().equals(bahnhof3.getBesitzer()) && bahnhof2.getBesitzer().equals(bahnhof4.getBesitzer()) && bahnhof2.getBesitzer() != "Bank") {
			bahnhof2.setMiete(75);
			bahnhof3.setMiete(75);
			bahnhof4.setMiete(75);
		} 
		//BesitzAlle Bahnhöfe
		else if (bahnhof1.getBesitzer().equals(bahnhof2.getBesitzer()) && bahnhof1.getBesitzer().equals(bahnhof3.getBesitzer()) && bahnhof1.getBesitzer().equals(bahnhof4.getBesitzer())  && bahnhof1.getBesitzer() != "Bank") {
			bahnhof1.setMiete(100);
			bahnhof2.setMiete(100);
			bahnhof3.setMiete(100);
			bahnhof4.setMiete(100);
		}
		//Besitz ganzer Straßenzug
		Strassen braun1 = strassenListe.get(0);
		Strassen braun2 = strassenListe.get(1);
		int hausanzahl1 = braun1.getHaus();
		switch (hausanzahl1) {
			case 1:
				braun1.setMiete(10);
				break;
			case 2:
				braun1.setMiete(30);
				break;
			case 3: 
				braun1.setMiete(90);
				break;
			case 4:
				braun1.setMiete(160);
				break;
			case 5:
				braun1.setMiete(250);
				break;
			default:
				break;
		}
		int hausanzahl2 = braun2.getHaus();
		switch (hausanzahl2) {
			case 1:
				braun2.setMiete(20);
				break;
			case 2:
				braun2.setMiete(60);
				break;
			case 3: 
				braun2.setMiete(180);
				break;
			case 4:
				braun2.setMiete(320);
				break;
			case 5:
				braun2.setMiete(450);
				break;
			default:
				break;
		}
		if (braun1.getBesitzer().equals(braun2.getBesitzer()) && braun1.getBesitzer() != "Bank") {
			braun1.setMiete(4);
			braun2.setMiete(8);
			braun1.setBauen(true);
			braun2.setBauen(true);
		}
		Strassen hellblau1 = strassenListe.get(2); 
		Strassen hellblau2 = strassenListe.get(3);
		Strassen hellblau3 = strassenListe.get(4);
		int hausanzahl3 = hellblau1.getHaus();
		switch (hausanzahl3) {
			case 1:
				hellblau1.setMiete(30);
				break;
			case 2:
				hellblau1.setMiete(90);
				break;
			case 3: 
				hellblau1.setMiete(270);
				break;
			case 4:
				hellblau1.setMiete(400);
				break;
			case 5:
				hellblau1.setMiete(550);
				break;
			default:
				break;
		}
		int hausanzahl4 = hellblau2.getHaus();
		switch (hausanzahl4) {
			case 1:
				hellblau1.setMiete(30);
				break;
			case 2:
				hellblau1.setMiete(90);
				break;
			case 3: 
				hellblau1.setMiete(270);
				break;
			case 4:
				hellblau1.setMiete(400);
				break;
			case 5:
				hellblau1.setMiete(550);
				break;
			default:
				break;
		}
		int hausanzahl5 = hellblau3.getHaus();
		switch (hausanzahl5) {
			case 1:
				hellblau3.setMiete(40);
				break;
			case 2:
				hellblau3.setMiete(100);
				break;
			case 3: 
				hellblau3.setMiete(300);
				break;
			case 4:
				hellblau3.setMiete(450);
				break;
			case 5:
				hellblau3.setMiete(600);
				break;
			default:
				break;
		}
		if (hellblau1.getBesitzer().equals(hellblau2.getBesitzer()) && hellblau1.getBesitzer().equals(hellblau3.getBesitzer()) && hellblau1.getBesitzer() != "Bank") {
			hellblau1.setMiete(12);
			hellblau2.setMiete(12);
			hellblau3.setMiete(16);
			hellblau1.setBauen(true);
			hellblau2.setBauen(true);
			hellblau3.setBauen(true);
		}
		Strassen pink1 = strassenListe.get(5);
		Strassen pink2 = strassenListe.get(6);
		Strassen pink3 = strassenListe.get(7);
		int hausanzahl6 = pink1.getHaus();
		switch (hausanzahl6) {
			case 1:
				pink1.setMiete(50);
				break;
			case 2:
				pink1.setMiete(150);
				break;
			case 3: 
				pink1.setMiete(450);
				break;
			case 4:
				pink1.setMiete(625);
				break;
			case 5:
				pink1.setMiete(750);
				break;
			default:
				break;
		}
		int hausanzahl7 = pink2.getHaus();
		switch (hausanzahl7) {
			case 1:
				pink2.setMiete(50);
				break;
			case 2:
				pink2.setMiete(150);
				break;
			case 3: 
				pink2.setMiete(450);
				break;
			case 4:
				pink2.setMiete(625);
				break;
			case 5:
				pink2.setMiete(750);
				break;
			default:
				break;
		}
		int hausanzahl8 = pink3.getHaus();
		switch (hausanzahl8) {
			case 1:
				pink3.setMiete(60);
				break;
			case 2:
				pink3.setMiete(180);
				break;
			case 3: 
				pink3.setMiete(500);
				break;
			case 4:
				pink3.setMiete(700);
				break;
			case 5:
				pink3.setMiete(900);
				break;
			default:
				break;
		}
		if (pink1.getBesitzer().equals(pink2.getBesitzer()) && pink1.getBesitzer().equals(pink3.getBesitzer()) && pink1.getBesitzer() != "Bank") {
			pink1.setMiete(20);
			pink2.setMiete(20);
			pink3.setMiete(24);
			pink1.setBauen(true);
			pink2.setBauen(true);
			pink3.setBauen(true);
		}
		Strassen orange1 = strassenListe.get(8);
		Strassen orange2 = strassenListe.get(9);
		Strassen orange3 = strassenListe.get(10);
		int hausanzahl9 = orange1.getHaus();
		switch (hausanzahl9) {
			case 1:
				orange1.setMiete(70);
				break;
			case 2:
				orange1.setMiete(200);
				break;
			case 3: 
				orange1.setMiete(550);
				break;
			case 4:
				orange1.setMiete(750);
				break;
			case 5:
				orange1.setMiete(950);
				break;
			default:
				break;
		}
		int hausanzahl10 = orange2.getHaus();
		switch (hausanzahl10) {
			case 1:
				orange2.setMiete(70);
				break;
			case 2:
				orange2.setMiete(200);
				break;
			case 3: 
				orange2.setMiete(550);
				break;
			case 4:
				orange2.setMiete(750);
				break;
			case 5:
				orange2.setMiete(950);
				break;
			default:
				break;
		}
		int hausanzahl11 = orange3.getHaus();
		switch (hausanzahl11) {
			case 1:
				orange3.setMiete(80);
				break;
			case 2:
				orange3.setMiete(220);
				break;
			case 3: 
				orange3.setMiete(600);
				break;
			case 4:
				orange3.setMiete(800);
				break;
			case 5:
				orange3.setMiete(1000);
				break;
			default:
				break;
		}
		if (orange1.getBesitzer().equals(orange2.getBesitzer()) && orange1.getBesitzer().equals(orange3.getBesitzer()) && orange1.getBesitzer() != "Bank") {
			orange1.setMiete(28);
			orange2.setMiete(28);
			orange3.setMiete(32);
			orange1.setBauen(true);
			orange2.setBauen(true);
			orange3.setBauen(true);
		}
		Strassen rot1 = strassenListe.get(11);
		Strassen rot2 = strassenListe.get(12);
		Strassen rot3 = strassenListe.get(13);
		int hausanzahl12 = rot1.getHaus();
		switch (hausanzahl12) {
			case 1:
				rot1.setMiete(90);
				break;
			case 2:
				rot1.setMiete(250);
				break;
			case 3: 
				rot1.setMiete(700);
				break;
			case 4:
				rot1.setMiete(875);
				break;
			case 5:
				rot1.setMiete(1050);
				break;
			default:
				break;
		}
		int hausanzahl13 = rot2.getHaus();
		switch (hausanzahl13) {
			case 1:
				rot2.setMiete(90);
				break;
			case 2:
				rot2.setMiete(250);
				break;
			case 3: 
				rot2.setMiete(700);
				break;
			case 4:
				rot2.setMiete(875);
				break;
			case 5:
				rot2.setMiete(1050);
				break;
			default:
				break;
		}
		int hausanzahl14 = rot3.getHaus();
		switch (hausanzahl14) {
			case 1:
				rot3.setMiete(100);
				break;
			case 2:
				rot3.setMiete(300);
				break;
			case 3: 
				rot3.setMiete(750);
				break;
			case 4:
				rot3.setMiete(925);
				break;
			case 5:
				rot3.setMiete(1100);
				break;
			default:
				break;
		}
		if (rot1.getBesitzer().equals(rot2.getBesitzer()) && rot1.getBesitzer().equals(rot3.getBesitzer()) && rot1.getBesitzer() != "Bank") {
			rot1.setMiete(36);
			rot2.setMiete(36);
			rot3.setMiete(40);
			rot1.setBauen(true);
			rot2.setBauen(true);
			rot3.setBauen(true);
		}
		Strassen gelb1 = strassenListe.get(14);
		Strassen gelb2 = strassenListe.get(15);
		Strassen gelb3 = strassenListe.get(16);
		int hausanzahl15 = gelb1.getHaus();
		switch (hausanzahl15) {
			case 1:
				gelb1.setMiete(110);
				break;
			case 2:
				gelb1.setMiete(330);
				break;
			case 3: 
				gelb1.setMiete(800);
				break;
			case 4:
				gelb1.setMiete(975);
				break;
			case 5:
				gelb1.setMiete(1150);
				break;
			default:
				break;
		}
		int hausanzahl16 = gelb2.getHaus();
		switch (hausanzahl16) {
			case 1:
				gelb2.setMiete(110);
				break;
			case 2:
				gelb2.setMiete(330);
				break;
			case 3: 
				gelb2.setMiete(800);
				break;
			case 4:
				gelb2.setMiete(975);
				break;
			case 5:
				gelb2.setMiete(1150);
				break;
			default:
				break;
		}
		int hausanzahl17 = gelb3.getHaus();
		switch (hausanzahl17) {
			case 1:
				gelb3.setMiete(120);
				break;
			case 2:
				gelb3.setMiete(360);
				break;
			case 3: 
				gelb3.setMiete(850);
				break;
			case 4:
				gelb3.setMiete(1025);
				break;
			case 5:
				gelb3.setMiete(1200);
				break;
			default:
				break;
		}
		if (gelb1.getBesitzer().equals(gelb2.getBesitzer()) && gelb1.getBesitzer().equals(gelb3.getBesitzer()) && gelb1.getBesitzer() != "Bank") {
			gelb1.setMiete(44);
			gelb2.setMiete(44);
			gelb3.setMiete(48);
			gelb1.setBauen(true);
			gelb2.setBauen(true);
			gelb3.setBauen(true);
		}
		Strassen grün1 = strassenListe.get(17);
		Strassen grün2 = strassenListe.get(18);
		Strassen grün3 = strassenListe.get(19);
		int hausanzahl18 = grün1.getHaus();
		switch (hausanzahl18) {
			case 1:
				grün1.setMiete(130);
				break;
			case 2:
				grün1.setMiete(390);
				break;
			case 3: 
				grün1.setMiete(900);
				break;
			case 4:
				grün1.setMiete(1100);
				break;
			case 5:
				grün1.setMiete(1275);
				break;
			default:
				break;
		}
		int hausanzahl19 = grün2.getHaus();
		switch (hausanzahl19) {
			case 1:
				grün2.setMiete(130);
				break;
			case 2:
				grün2.setMiete(390);
				break;
			case 3: 
				grün2.setMiete(900);
				break;
			case 4:
				grün2.setMiete(1100);
				break;
			case 5:
				grün2.setMiete(1275);
				break;
			default:
				break;
		}
		int hausanzahl20 = grün3.getHaus();
		switch (hausanzahl20) {
			case 1:
				grün3.setMiete(150);
				break;
			case 2:
				grün3.setMiete(450);
				break;
			case 3: 
				grün3.setMiete(1000);
				break;
			case 4:
				grün3.setMiete(1200);
				break;
			case 5:
				grün3.setMiete(1400);
				break;
			default:
				break;
		}
		if (grün1.getBesitzer().equals(grün2.getBesitzer()) && grün1.getBesitzer().equals(grün3.getBesitzer()) && grün1.getBesitzer() != "Bank") {
			grün1.setMiete(52);
			grün2.setMiete(52);
			grün3.setMiete(56);
			grün1.setBauen(true);
			grün2.setBauen(true);
			grün3.setBauen(true);
		}
		Strassen blau1 = strassenListe.get(20);
		Strassen blau2 = strassenListe.get(21);
		int hausanzahl21 = blau1.getHaus();
		switch (hausanzahl21) {
			case 1:
				blau1.setMiete(175);
				break;
			case 2:
				blau1.setMiete(500);
				break;
			case 3: 
				blau1.setMiete(1100);
				break;
			case 4:
				blau1.setMiete(1300);
				break;
			case 5:
				blau1.setMiete(1500);
				break;
			default:
				break;
		}
		int hausanzahl22 = blau2.getHaus();
		switch (hausanzahl22) {
			case 1:
				blau2.setMiete(200);
				break;
			case 2:
				blau2.setMiete(600);
				break;
			case 3: 
				blau2.setMiete(1400);
				break;
			case 4:
				blau2.setMiete(1700);
				break;
			case 5:
				blau2.setMiete(2000);
				break;
			default:
				break;
		}
		if (blau1.getBesitzer().equals(blau2.getBesitzer()) && blau1.getBesitzer() != "Bank") {
			blau1.setMiete(70);
			blau2.setMiete(100);
			blau1.setBauen(true);
			blau2.setBauen(true);
		}
	}

}
