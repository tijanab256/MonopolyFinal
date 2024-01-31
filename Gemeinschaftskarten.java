/**
 * Gemeinschaftskarten-Klasse
 * @author Rudi Gola
 */

import java.util.Collections;
import java.util.LinkedList;

//Klasse Gemeinschaftskarten erstellen und initialisieren der LinkedList "Gemeinschaftskarten"

public class Gemeinschaftskarten implements KarteInterface {
    private static LinkedList<String> Gemeinschaftskarten = new LinkedList<String>();

//Hinzufuegen der Gemeinschaftskarten

static {
    Gemeinschaftskarten.add("Schulgeld. Zahlen Sie 50 Euro");
    Gemeinschaftskarten.add("Urlaubsgeld! Sie erhalten 100 Euro.");
    Gemeinschaftskarten.add("Ihre Lebensversicherung wird fällig. Sie erhalten 100 Euro.");
    Gemeinschaftskarten.add("Arzt-Kosten. Zahlen Sie 50 Euro.");
    Gemeinschaftskarten.add("Einkommenssteuerrückerstattung. Sie erhalten 20 Euro");
    Gemeinschaftskarten.add("Krankenhausgebühren. Zahlen Sie 100 Euro.");
    Gemeinschaftskarten.add("Gehen Sie in das Gefängnis. Begeben Sie sich direkt dorthin. Gehen Sie nicht über Los. Ziehen Sie nicht 200 Euro ein.");
    Gemeinschaftskarten.add("Sie erhalten auf Vorzugs-Aktien 7% Dividende: 25 Euro.");
    Gemeinschaftskarten.add("Sie erben 100 Euro.");
    Gemeinschaftskarten.add("Aus Lagerverkäufen erhalten Sie 50 Euro.");
    Gemeinschaftskarten.add("Zweiter Preis im Schönheitswettbewerb. Sie erhalten 10 Euro.");
    Gemeinschaftskarten.add("Rücken Sie vor bis auf Los. (Ziehe 200 Euro ein).");
    Gemeinschaftskarten.add("Bank-Irrtum zu Ihren Gunsten. Ziehen Sie 200 Euro ein");
}

//Methoden

/*
 * @return die gesamte LinkedList Gemeinschaftskarten
 */

public static LinkedList<String> getKarten() {
    return Gemeinschaftskarten;
}

/*
 * @return das Element mit dem Index 0 aus der LinkedList Gemeinschaftskarten
 */

public String obersteKarteZiehen () {
    String obersteKarteZiehen = Gemeinschaftskarten.get(0);
    System.out.println("Sie haben folgende Karte gezogen:" + obersteKarteZiehen);
    return obersteKarteZiehen;

}

/*
 * @return Integer 0, wenn keiner der Cases zutrifft
 */

 /*
 * @param Text der gezogenen Gemeinschaftskarte
 */

public int KartenText(String Text) {
    switch(Text) {
        case "Schulgeld. Zahlen Sie 50 Euro":
            return 1;
        case "Urlaubsgeld! Sie erhalten 100 Euro.":
            return 2;
        case "Ihre Lebensversicherung wird fällig. Sie erhalten 100 Euro.":
            return 3;
        case "Arzt-Kosten. Zahlen Sie 50 Euro.":	
            return 4;
        case "Einkommenssteuerrückerstattung. Sie erhalten 20 Euro":
            return 5;
        case "Krankenhausgebühren. Zahlen Sie 100 Euro.":
            return 6;
        case "Gehen Sie in das Gefängnis. Begeben Sie sich direkt dorthin. Gehen Sie nicht über Los. Ziehen Sie nicht 200 Euro ein.":
            return 7;
        case "Sie erhalten auf Vorzugs-Aktien 7% Dividende: 25 Euro.":
            return 8;
        case "Sie erben 100 Euro.":
            return 9;
        case "Aus Lagerverkäufen erhalten Sie 50 Euro.":
            return 10;
        case "Zweiter Preis im Schönheitswettbewerb. Sie erhalten 10 Euro.":
            return 11;
        case "Rücken Sie vor bis auf Los. (Ziehe 200 Euro ein).":
            return 12;
        case "Bank-Irrtum zu Ihren Gunsten. Ziehen Sie 200 Euro ein":
            return 13;
        default: 
            return 0;
    }	
}


 /*
 * @param die LinkedList Gemeinschaftskarten
 */

{
    Collections.shuffle (Gemeinschaftskarten);
    System.out.println("Der Stapel wurde gemischt:" + Gemeinschaftskarten);
    }
}