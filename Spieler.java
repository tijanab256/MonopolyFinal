
import java.awt.Color;
import java.util.Random;

public class Spieler {

    private String name;
    private Color farbe;
    private int geld;
    public int position;
    private boolean imGefaengnis;
    private int gesamtwurf;

    public Spieler(String name) {
        this.name = name;
        this.farbe = zufaelligeFarbe();
        this.setGeld(1500);
        this.position = 0; // Spieler beginnt auf dem Los-Feld
        this.imGefaengnis = false; // Spieler startet nicht im Gefängnis
    }

    
    /**
     * 
     * @return Methode zur Generierung einer zufälligen Farbe
     */
    private Color zufaelligeFarbe() {
        Random rand = new Random();
        // Nimm einen zufälligen RGB-Wert
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        // Erzeuge die Farbe
        return new Color(r, g, b);
    }

    
    /**
     * 
     * @param name Setter_Methoden liefert den Namen, Geld, Positions des Spielers, sowohl ob der Spiele im Gefängnis ist 
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setGeld(int geld) {
        this.geld = geld;
    }

    public void setPosition(int pos) {
        this.position = pos;
    }

    public void setIsImGefaengnis(boolean Gef) {
        this.imGefaengnis = Gef;
    }

   
    /**
     * 
     * @return Getter-Methoden
     */
    public String getName() {
        return name;
    }

    public Color getFarbe() {
        return farbe;
    }

    public int getGeld() {
        return geld;
    }

    public int getPosition() {
        return position;
    }

    public boolean isImGefaengnis() {
        return imGefaengnis;
    }
    /**
     * Aktualisiert die Position des Spielers auf dem Spielfeld basierend auf dem geworfenen Würfelergebnis.
     * Überprüft, ob der Spieler einmal um das Spielfeld gegangen ist und erhöht sein Geld entsprechend.
     * @param spieler  spieler Der Spieler, dessen Position aktualisiert wird.
     */
    public void setPosition(Spieler spieler) {
        position += this.gesamtwurf;

        final int MAX_POSITION = 40;
        if (position >= MAX_POSITION) {
            position -= MAX_POSITION;
            spieler.setGeld(spieler.getGeld() + 200);

        System.out.println(name + " ist einmal um das Spielfeld gegangen!");
        }
        System.out.println(name + " auf dem Position: " + this.getPosition());

    }

    
    /**
 * Simuliert das Würfeln mit zwei Würfeln (jeder Würfel hat 6 Seiten) für den Spieler.
 * Berechnet den Gesamtwurf, speichert ihn und gibt ihn zurück.
 *
 * @return Der Gesamtwurf aus beiden geworfenen Würfeln (eine Zahl zwischen 2 und 12)
 */
    public int würfeln() {
        // Würfeln mit zwei Würfeln (1 bis 6)

        Würfel würfel1 = new Würfel();
        Würfel würfel2 = new Würfel();

        würfel1.wuerfeln();
        würfel2.wuerfeln();
        int gesamtwurf = würfel1.getErgebnis() + würfel2.getErgebnis();

        System.out.println(name + " würfelt eine " + würfel1.getErgebnis() + " und eine " + würfel2.getErgebnis()
                + " (Gesamtwurf: " + gesamtwurf + ")");

        this.gesamtwurf = gesamtwurf;
        return gesamtwurf;
    }
/**
 * Ermöglicht dem Spieler den Kauf eines Hauses auf einer bestimmten Straße,
 * sofern er ausreichend Geld hat. Wenn der Kauf erfolgreich ist, wird das Geld
 * des Spielers reduziert und eine Meldung über den Kauf ausgegeben.
 *
 * @param straße Die Straße, auf der das Haus gekauft werden soll
 */
    public void hausKaufen(String straße) {
        int hauspreis = 100; // Beispielkaufpreis für ein Haus
        if (getGeld() >= hauspreis) {
            setGeld(getGeld() - hauspreis);
            System.out.println(name + " hat ein Haus auf der Straße " + straße + " gekauft.");
        } else {
            System.out.println(name + " hat nicht genug Geld, um ein Haus zu kaufen.");
        }
    }
/**
 * Ermöglicht dem Spieler den Kauf eines Hotels auf einer bestimmten Straße,
 * sofern er ausreichend Geld hat. Wenn der Kauf erfolgreich ist, wird das Geld
 * des Spielers reduziert und eine Meldung über den Kauf ausgegeben.
 *
 * @param straße Die Straße, auf der das Hotel gekauft werden soll
 */
    public void hotelKaufen(String straße) {
        int hotelpreis = 500; // Beispielkaufpreis für ein Hotel
        
        
                if (getGeld() >= hotelpreis) {
                    setGeld(getGeld() - hotelpreis);
            System.out.println(name + " hat ein Hotel auf der Straße " + straße + " gekauft.");
        } else {
            System.out.println(name + " hat nicht genug Geld, um ein Hotel zu kaufen.");
        }
    }
/**
 * Ermöglicht dem Spieler das Zahlen einer Miete in Höhe des angegebenen Betrags an den Empfänger.
 * Der Betrag wird vom Geld des Spielers abgezogen und dem Empfänger gutgeschrieben.
 *
 * @param betrag Der zu zahlende Mietbetrag.
 * @param Empfänger Der Spieler, der die Miete erhält
 */
    public void mieteZahlen(int betrag, Spieler Empfänger) {
        setGeld(getGeld() - betrag);
        Empfänger.setGeld(Empfänger.getGeld() + betrag);
        System.out.println(name + " zahlt Miete in Höhe von " + betrag + " Euro.");
    }

}
