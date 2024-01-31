/**
 * Ereigniskarten-Klasse
 * @author Rudi Gola
 */

import java.util.Collections;
import java.util.LinkedList;

//Klasse Ereigniskarte erstellen und initailisieren der LinkedList "Ereigniskarten"

public class Ereigniskarten implements KarteInterface {
    private static LinkedList<String> Ereigniskarten = new LinkedList<String>();

//Hinzufuegen der Ereigniskarten

static {
    Ereigniskarten.add("Ruecken Sie vor bis zur Schlossallee.");
    Ereigniskarten.add("Machen Sie einen Ausflug zum Suedbahnhof. Wenn Sie ueber Los kommen, ziehen Sie 200 Euro ein");
    Ereigniskarten.add("Ihr Bausparvertrag wird faellig. Sie erhalten 200 Euro.");
    Ereigniskarten.add("Ruecken Sie vor bis zum Opernplatz. Wenn Sie ueber Los kommen, ziehen Sie 200 Euro ein.");
    Ereigniskarten.add("Gehen Sie in das Gefaengnis. Begeben Sie sich direkt dorthin. Gehen Sie nicht ueber Los. Ziehen Sie nicht 200 Euro ein.");
    Ereigniskarten.add("Ruecken Sie vor bis auf Los. (Ziehe 200 Euro ein).");
    Ereigniskarten.add("Die Bank zahlt Ihnen eine Dividende von 50 Euro.");
    Ereigniskarten.add("Ruecken Sie vor bis zur Seestrasse. Wenn Sie ueber Los kommen, ziehen Sie 200 Euro ein.");
    Ereigniskarten.add("Gehen Sie 3 Felder zurueck.");
    Ereigniskarten.add("Strafzettel! Zahlen Sie 15 Euro.");
}

//Methoden

/*
 * @return die gesamte LinkedList Ereigniskarten
 */

public static LinkedList<String> getKarten() {
    return Ereigniskarten;
}

/*
 * @return das Element mit dem Index 0 aus der LinkedList Ereigniskarten
 */

public String obersteKarteZiehen () {
    String obersteKarte = Ereigniskarten.get(0);
    System.out.println("Sie haben folgende Karte gezogen:" + obersteKarte);
    return obersteKarte;
}

/*
 * @return Integer 0, wenn keiner der Cases zutrifft
 */

 /*
 * @param Text der gezogenen Ereigniskarte
 */

public int KartenText(String Text) {
    switch(Text) {
        case "Ruecken Sie vor bis zur Schlossallee.":
            return 1;
        case "Machen Sie einen Ausflug zum Suedbahnhof. Wenn Sie ueber Los kommen, ziehen Sie 200 Euro ein":
            return 2;
        case "Ihr Bausparvertrag wird faellig. Sie erhalten 200 Euro.":
            return 3;
        case "Ruecken Sie vor bis zum Opernplatz. Wenn Sie ueber Los kommen, ziehen Sie 200 Euro ein.":	
            return 4;
        case "Gehen Sie in das Gefaengnis. Begeben Sie sich direkt dorthin. Gehen Sie nicht ueber Los. Ziehen Sie nicht 200 Euro ein.":
            return 5;
        case "Ruecken Sie vor bis auf Los. (Ziehe 200 Euro ein).":
            return 6;
        case "Die Bank zahlt Ihnen eine Dividende von 50 Euro.":
            return 7;
        case "Ruecken Sie vor bis zur Seestrasse. Wenn Sie ueber Los kommen, ziehen Sie 200 Euro ein.":
            return 8;
        case "Gehen Sie 3 Felder zurueck.":
            return 9;
        case "Strafzettel! Zahlen Sie 15 Euro.":
            return 10;

        default: 
            return 0;
    }	
}

 /*
 * @param die LinkedList Ereigniskarten
 */

{
Collections.shuffle (Ereigniskarten);
System.out.println("Der Stapel wurde neu gemischt.");
}

}
