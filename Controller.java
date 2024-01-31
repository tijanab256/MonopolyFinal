import java.util.LinkedList;
import java.util.Set;
/** 
 *  Controller-Klasse, Teil des MVC, stellt die Verbindung zwischen Model und View dar und führt die Funktionen aus
 * @author Tijana Belau
 * 
 * 
 */

public class Controller {
	//Attribute
	public View myView;
	public Model myModel;
	public int i= 1;
	public Bank Hilfsbank = new Bank();
    

	/**
	 * setzt die Verknüpfung zur View.java
	 * @param myView die View, welche hier verknüpftt werden soll
	 */
	public void setMyView(View myView) {
		this.myView = myView;
	}

	/**
	 * setzt die Verknüpfung zur Model.java
	 * @param myModel das Model, welches hier verknüpft und verwndet werden soll
	 */
	public void setMyModel(Model myModel) {
		this.myModel = myModel;
	}
		
	/**
	 * @return gibt die Liste mit allen Spielern ausm Model zurück
	 */
	public Set<Spieler> getAlleSpieler() {
		return myModel.getAlleSpieler();
	}
	
	/**
	 * Wenn der Button aus der View gedrückt wird, soll ein neuer Spieler zur LinkedList im Model hinzugefügt werden
	 */
	public void SpielerHinzufügen() {
		String spielerName = myView.getSpielerName();
		Spieler hilfe = new Spieler(spielerName);
	    myModel.spielerHinzufuegen(hilfe);
		myModel.setAlleSpieler();
	    System.out.print(myModel.getAlleSpieler());
	    myView.updatePlayerTable(myModel.getAlleSpieler());
	    myView.updateFeldTable(myModel.getFeld());
		myView.repaint();
	}

	/**
	 * 
	 */
	public void ComHinzufügen() {
		String spielerName = "com" + i;
		Spieler hilfe = new Spieler(spielerName);
	    myModel.comHinzufuegen(hilfe);
		myModel.setAlleSpieler();
	    System.out.print(myModel.getAlleSpieler());
	    myView.updatePlayerTable(myModel.getAlleSpieler());
	    myView.updateFeldTable(myModel.getFeld());
		myView.repaint();
		i++;
		if (i == 4) {
			myView.hideKIButton();
		}
	}
	
	/**
	 * Das ist die große Funktion, hier wird der Spielzug definiert, wenn ein physischer Spieler den würfel-Button drückt wird all das ausgeführt, zuerst für den Spieler der gerade dran ist und danach dann für alle Computerspieler
	 */
	public void würfelGeworfen() { 
		myView.hideHausKaufenButton();
		myView.hideStraßeKaufenButton();
		myModel.MietenAnpassen();
		Spieler Hilfe = myModel.getAktuellerSpieler(false);
		//Prüfen ob der Spieler pleite ist
		if (Hilfe.getGeld() <= 0) {
			myView.displayPleite(Hilfe.getName());
			myView.repaint();
	        myView.revalidate();
			return;
		}
		//Prüfen ob der Spieler im Gefängnis ist
		int alteId = Hilfe.getPosition(); 
		if (alteId == 10 && Hilfe.isImGefaengnis() == true) {
			myModel.setAktuellerWurf();
			myView.displayGefängnisButton();
			return;
		}
		//Würfeln
		int wurfergebnis= myModel.wuerfelnAktuellerSpieler();
		Hilfe.setPosition(Hilfe);
		int id = Hilfe.getPosition();
		myView.setWurf(wurfergebnis);
		myView.repaint();
		//Prüfen ob der Spieler auf einem Spielfeld oder Aktionsfeld steht
		if ( id != 0 && id != 2 && id != 4 && id != 7 && id != 10 && id != 17 && id != 20 && id != 22 && id != 30 && id != 33 && id != 36 && id != 38) {
			Spielfeld aktuellesFeld = myModel.getFeldById(id);
			System.out.println(aktuellesFeld);
			myView.setFeld(aktuellesFeld);
			//Prüfen ob das Feld schon verkauft ist
			if (aktuellesFeld != null && ("Bank".equals(aktuellesFeld.getBesitzer()) || aktuellesFeld.getBesitzer() == null)) {
	            myView.displayStraßeKaufenButton();
	            myView.repaint();
	            myView.revalidate();
	        } else {
				//Prüfen ob und an wen Miete gezahlt werden muss
	        	myView.hideStraßeKaufenButton();
	        	int Miete = aktuellesFeld.getMiete();
	        	String hilft = aktuellesFeld.getBesitzer();
	        		if (Hilfe.getName().equals(hilft)) {
	        			System.out.println(" Straße gehört dir selbst ");
						if (aktuellesFeld.getBauen() == true) {
							myView.setfeld2(aktuellesFeld);
							myView.displayHausKaufenButton();
						}
	        		} else {
	        			Spieler Empfänger = myModel.findSpielerByName(hilft);
	        			Hilfe.mieteZahlen(Miete, Empfänger);
	        		}
	        }

		} else if ( id == 2 || id == 17 || id == 33) {
			//Zufällige Gemeinschaftskarte und Aktion ausführen
			String GkarteText = myModel.zieheGKarte();
			int fall = myModel.getGKarteByText(GkarteText);
			myView.setKarte(GkarteText);
			System.out.println(fall + GkarteText);
			System.out.println(Hilfe.getGeld());
			switch (fall) {
				case 1:
					Hilfe.setGeld(Hilfe.getGeld() - 50);
					Hilfsbank.geldBekommen(50);
					break;
				case 2:
					Hilfsbank.geldGeben(Hilfe, 100);
					break;
				case 3:
					Hilfsbank.geldGeben(Hilfe, 100);
					break;
				case 4: 
					Hilfe.setGeld(Hilfe.getGeld() - 50);
					Hilfsbank.geldBekommen(50);
					break;
				case 5:
					Hilfsbank.geldGeben(Hilfe, 20);
					break;
				case 6: 
					Hilfe.setGeld(Hilfe.getGeld() - 100);
					Hilfsbank.geldBekommen(100);
					break;
				case 7:
					Hilfe.setIsImGefaengnis(true);
					Hilfe.setPosition(10);
					break;
				case 8:
					Hilfsbank.geldGeben(Hilfe, 25);
					break;
				case 9:
					Hilfsbank.geldGeben(Hilfe, 100);
					break;
				case 10:
					Hilfsbank.geldGeben(Hilfe, 50);
					break;
				case 11:
					Hilfsbank.geldGeben(Hilfe, 10);
					break;
				case 12: 
					Hilfe.setPosition(0);
					Hilfsbank.geldGeben(Hilfe, 200);
					break;
				case 13:
					Hilfsbank.geldGeben(Hilfe, 200);
					break;
				default:
					break;
			} 

		}  else if ( id == 7 || id == 22 || id == 36) {
			//Zufällige Ereigniskarte und AKtion ausführen
			String EkarteText = myModel.zieheEKarte();
			int fall = myModel.getEKarteByText(EkarteText);
			myView.setKarte(EkarteText);
			System.out.println(fall + EkarteText);
			System.out.println(Hilfe.getGeld());
			switch (fall) {
				case 1:
					Hilfe.setPosition(39);
					break;
				case 2:
					if(Hilfe.getPosition() > 5) {
						Hilfsbank.geldGeben(Hilfe, 200);
					}
					Hilfe.setPosition(5);
					break;
				case 3:
					Hilfsbank.geldGeben(Hilfe, 200);
					break;
				case 4: 
					if(Hilfe.getPosition() > 24) {
						Hilfsbank.geldGeben(Hilfe, 200);
					}
					Hilfe.setPosition(24);
					break;
				case 5:
					Hilfe.setIsImGefaengnis(true);
					Hilfe.setPosition(10);
					break;
				case 6: 
					Hilfe.setPosition(0);
					Hilfsbank.geldGeben(Hilfe, 200);
					break;
				case 7:
					Hilfsbank.geldGeben(Hilfe, 50);
					break;
				case 8:
					if(Hilfe.getPosition() > 11) {
						Hilfsbank.geldGeben(Hilfe, 200);
					}
					Hilfe.setPosition(11);
					break;
				case 9:
					Hilfe.setPosition(Hilfe.getPosition() - 3);
					break;
				case 10:
					Hilfe.setGeld(Hilfe.getGeld() - 15);
					Hilfsbank.geldBekommen(15);
					break;
				default:
					break;
			}
		} else if (id == 4){
			//Steuern zahlen
			Hilfe.setGeld(Hilfe.getGeld() - 150);
			System.out.println(Hilfe.getGeld());
		} else if (id == 38){
			//Steuern zahlen
			Hilfe.setGeld(Hilfe.getGeld() - 200);
			System.out.println(Hilfe.getGeld());
		} else if (id == 30) {
			//Ins Gefängnis gehen
			Hilfe.setIsImGefaengnis(true);
			Hilfe.setPosition(10);
		}

		myView.updatePlayerTable(myModel.getAlleSpieler());
	    myView.updateFeldTable(myModel.getFeld());
		myView.repaint();

		//for-SCheife um alle Computerspieler zusetzen
		for( int j = 0; j< myModel.getComSpieler().size(); j++) {
			LinkedList<Spieler> Computer = myModel.getComSpieler();
			Spieler aktuelleCom = Computer.get(j);
			//Prüfen ob der Spieler Peite ist
			if (aktuelleCom.getGeld() <= 0) {
				myView.displayPleite(Hilfe.getName());
				return;
			}
			int alteComID = aktuelleCom.getPosition();
			//Prüfen ob der Spieler im Gefängnis ist
			if (alteComID == 10 && aktuelleCom.isImGefaengnis() == true) {
				myModel.setAktuellerWurf();
				aktuelleCom.setGeld(aktuelleCom.getGeld() - 50);
				aktuelleCom.setIsImGefaengnis(false);
				return;
			}
			//Würfeln
			int ComWurf = aktuelleCom.würfeln();
			aktuelleCom.setPosition(aktuelleCom);
			int ComId = aktuelleCom.getPosition();
			System.out.println(ComId);
			myView.repaint();
	        myView.revalidate();
			//Prüfen ob man auf einem Spielfeld oder AKtionsfeld steht
			if ( ComId != 0 && ComId != 2 && ComId != 4 && ComId != 7 && ComId != 10 && ComId != 17 && ComId != 20 && ComId != 22 && ComId != 30 && ComId != 33 && ComId != 36 && ComId != 38) {
				Spielfeld aktuellesCOMFeld = myModel.getFeldById(ComId);
				System.out.println(aktuellesCOMFeld);
				//Prüfen ob das Spielfeld gekauft werden kann
				if (aktuellesCOMFeld != null && ("Bank".equals(aktuellesCOMFeld.getBesitzer()) || aktuellesCOMFeld.getBesitzer() == null) && aktuelleCom.getGeld() > aktuellesCOMFeld.getKaufpreis()) {
					aktuellesCOMFeld.setBesitzer(aktuelleCom.getName());
					aktuelleCom.setGeld(aktuelleCom.getGeld() - aktuellesCOMFeld.getKaufpreis() );
					Hilfsbank.geldBekommen(aktuellesCOMFeld.getKaufpreis());

					myView.repaint();
	            	myView.revalidate();
				} else {
					//Prüfen ob und an wen Miete gezahlt werden muss
					int Miete = aktuellesCOMFeld.getMiete();
					String hilft = aktuellesCOMFeld.getBesitzer();
						if (aktuelleCom.getName().equals(hilft)) {
							System.out.println(" Straße gehört dir selbst ");
							if (aktuellesCOMFeld.getBauen() == true && aktuelleCom.getGeld() > ((Strassen) aktuellesCOMFeld).getHauspreis()) {
								System.out.println(" einHaus gekauft");
							}
						} else {
							Spieler Empfänger = myModel.findSpielerByName(hilft);
							aktuelleCom.mieteZahlen(Miete, Empfänger);
						}
				}

			} else if ( ComId == 2 || ComId == 17 || ComId == 33) {
				//Zufällige Gemeinschaftskarte wird gezogen und Aktion ausgeführt
				String GkarteText = myModel.zieheGKarte();
				int fallCom = myModel.getGKarteByText(GkarteText);
				myView.setKarte(GkarteText);
				System.out.println(fallCom + GkarteText);
				System.out.println(aktuelleCom.getGeld());
				switch (fallCom) {
					case 1:
						aktuelleCom.setGeld(aktuelleCom.getGeld() - 50);
						Hilfsbank.geldBekommen(50);
						break;
					case 2:
						Hilfsbank.geldGeben(aktuelleCom, 100);
						break;
					case 3:
						Hilfsbank.geldGeben(aktuelleCom, 100);
						break;
					case 4: 
						aktuelleCom.setGeld(aktuelleCom.getGeld() - 50);
						Hilfsbank.geldBekommen(50);
						break;
					case 5:
						Hilfsbank.geldGeben(aktuelleCom, 20);
						break;
					case 6: 
						aktuelleCom.setGeld(aktuelleCom.getGeld() - 100);
						Hilfsbank.geldBekommen(100);
						break;
					case 7:
						aktuelleCom.setIsImGefaengnis(true);
						aktuelleCom.setPosition(10);
						break;
					case 8:
						Hilfsbank.geldGeben(aktuelleCom, 25);
						break;
					case 9:
						Hilfsbank.geldGeben(aktuelleCom, 100);
						break;
					case 10:
						Hilfsbank.geldGeben(aktuelleCom, 50);
						break;
					case 11:
						Hilfsbank.geldGeben(aktuelleCom, 10);
						break;
					case 12: 
						aktuelleCom.setPosition(0);
						Hilfsbank.geldGeben(aktuelleCom, 200);
						break;
					case 13:
						Hilfsbank.geldGeben(aktuelleCom, 200);
						break;
					default:
						break;
				}

			}  else if ( ComId == 7 || ComId == 22 || ComId == 36) {
				//Zufällige Ereigniskarte wird gezogen und Aktion ausgeführt
				String EkarteText = myModel.zieheEKarte();
				int fallCom = myModel.getEKarteByText(EkarteText);
				myView.setKarte(EkarteText);
				System.out.println(fallCom + EkarteText);
				System.out.println(aktuelleCom.getGeld());
				switch (fallCom) {
					case 1:
						aktuelleCom.setPosition(39);
						break;
					case 2:
						if(aktuelleCom.getPosition() > 5) {
							Hilfsbank.geldGeben(aktuelleCom, 200);
						}
						aktuelleCom.setPosition(5);
						break;
					case 3:
						Hilfsbank.geldGeben(aktuelleCom, 200);
						break;
					case 4: 
						if(aktuelleCom.getPosition() > 24) {
							Hilfsbank.geldGeben(aktuelleCom, 200);
						}
						aktuelleCom.setPosition(24);
						break;
					case 5:
						aktuelleCom.setIsImGefaengnis(true);
						aktuelleCom.setPosition(10);
						break;
					case 6: 
						aktuelleCom.setPosition(0);
						Hilfsbank.geldGeben(aktuelleCom, 200);
						break;
					case 7:
						Hilfsbank.geldGeben(aktuelleCom, 50);
						break;
					case 8:
						if(aktuelleCom.getPosition() > 11) {
							Hilfsbank.geldGeben(aktuelleCom, 200);
						}
						aktuelleCom.setPosition(11);
						break;
					case 9:
						aktuelleCom.setPosition(aktuelleCom.getPosition() - 3);
						break;
					case 10:
						aktuelleCom.setGeld(aktuelleCom.getGeld() - 15);
						Hilfsbank.geldBekommen(15);
						break;
					default:
						break;
				}
			} else if (ComId == 4){
				//Steuern zahlen
				aktuelleCom.setGeld(aktuelleCom.getGeld() - 150);
				System.out.println(aktuelleCom.getGeld());
			} else if (ComId == 38){
				//Steuern zahlen
				aktuelleCom.setGeld(aktuelleCom.getGeld() - 200);
				System.out.println(aktuelleCom.getGeld());
			} else if (ComId == 30) {
				//Gehe ins Gefängnis
				aktuelleCom.setIsImGefaengnis(true);
				aktuelleCom.setPosition(10);
			}

			myView.updatePlayerTable(myModel.getAlleSpieler());
			myView.updateFeldTable(myModel.getFeld());
			myView.repaint();

			}
	}
	
	
	/**
	 * Funktion um eine Straße zu kaufen
	 */
	public void StraßeKaufen() {
		Spieler Hilfe = myModel.getAktuellerSpieler(true);
		int id = Hilfe.getPosition();
		Spielfeld aktuellesFeld = myModel.getFeldById(id);
		int preis = aktuellesFeld.getKaufpreis();

		Hilfe.setGeld(Hilfe.getGeld() - preis);
		Hilfsbank.geldBekommen(preis);
		aktuellesFeld.setBesitzer(Hilfe.getName());

		myView.updatePlayerTable(myModel.getAlleSpieler());
	    myView.updateFeldTable(myModel.getFeld());
		myView.hideStraßeKaufenButton();
	    myView.repaint();
        myView.revalidate();
	}

	/**
	 * Funktion um ein Haus oder Hotel zu kaufen
	 */
	public void HausKaufen() {
		Spieler Hilfe = myModel.getAktuellerSpieler(true);
		int id = Hilfe.getPosition();
		Spielfeld aktuellesFeld = myModel.getFeldById(id);
		int Hauspreis = (((Strassen) aktuellesFeld).getHauspreis());

		if (((Strassen) aktuellesFeld).getHaus() < 4) {
			//Hauskaufen bis zu 4 Stück
			Hilfe.setGeld(Hilfe.getGeld() - Hauspreis);
			Hilfsbank.geldBekommen(Hauspreis);
			Hilfsbank.HausMinus(1); 
			((Strassen) aktuellesFeld).setHaus(((Strassen) aktuellesFeld).getHaus() + 1);
		} else if (((Strassen) aktuellesFeld).getHaus() == 4) {
			//Hotelkaufen 
			Hilfe.setGeld(Hilfe.getGeld() - Hauspreis);
			Hilfsbank.geldBekommen(Hauspreis);
			Hilfsbank.HausPlus(4);
			Hilfsbank.HotelMinus(1); 
			((Strassen) aktuellesFeld).setHaus(((Strassen) aktuellesFeld).getHaus() + 1);
		} else {
			myView.hideHausKaufenButton();
		}
		myModel.MietenAnpassen();
		myView.updatePlayerTable(myModel.getAlleSpieler());
	    myView.updateFeldTable(myModel.getFeld());
	    myView.repaint();
        myView.revalidate();
	}

	/**
	 * Aus dem Gefängnis sich frei kaufen für 50$
	 */
	public void GefängnisFrei() {
		Spieler Hilfe = myModel.getAktuellerSpieler(true);
		Hilfe.setGeld(Hilfe.getGeld() - 50);
		Hilfe.setIsImGefaengnis(false);
		myView.hideGefängnisButton();
	}
	
	
}
