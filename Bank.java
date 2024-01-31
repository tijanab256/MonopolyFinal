
	public class Bank {
		
		
		private static final int MAXGUTHABEN = 15000000;
		private int guthaben;
		private int hauser;
		private int hotels;
	
		// Konstruktor für die Bank
	    public Bank() {
	        this.guthaben = MAXGUTHABEN; 
	        this.hauser = 32;   
	        this.hotels = 12;  
	    }
		
	    public void setGuthaben(int betrag) {
	    	guthaben = betrag;
	    }
	    
	    public int getGuthaben() {
	    	return guthaben;
	    }
	    
	    // Methode, um Geld von der Bank zu erhalten
	    public void geldBekommen(int betrag) {
	        if (betrag > 0 && betrag <= guthaben) {
	            guthaben += betrag;
	            
	        } else {
	            System.out.println("Ungültiger Betrag oder nicht genügend Guthaben in der Bank.");
	        }
	    }
	    
	 // Methode, um Geld an die Bank zurückzugeben
	    public void geldGeben(Spieler spieler, int betrag) {
	        if (betrag > 0) {
	            guthaben -= betrag;
	            spieler.setGeld(spieler.getGeld() + betrag);
	        } else {
	            System.out.println("Ungültiger Betrag.");
	        }
	    }
	 // Methode, um die Anzahl der Häuser zu verringern
	    public void HausMinus(int anzahl) {
	        if (anzahl > 0 && anzahl <= hauser) {
	            hauser -= anzahl;
	        } else {
	            System.out.println("Ungültige Anzahl oder nicht genügend Häuser in der Bank.");
	        }
	    }
	 // Methode, um die Anzahl der Häuser zu erhöhen
	    public void HausPlus(int anzahl) {
	        if (anzahl > 0) {
	            hauser += anzahl;
	        } else {
	            System.out.println("Ungültige Anzahl.");
	        }
	    }
	 // Methode, um die Anzahl der Hotels zu verringern
	    public void HotelMinus(int anzahl) {
	        if (anzahl > 0 && anzahl <= hotels) {
	            hotels -= anzahl;
	        } else {
	            System.out.println("Ungültige Anzahl oder nicht genügend Hotels in der Bank.");
	        }
	    }
	 // Methode, um die Anzahl der Hotels zu erhöhen
	    public void HotelPlus(int anzahl) {
	        if (anzahl > 0) {
	            hotels += anzahl;
	        } else {
	            System.out.println("Ungültige Anzahl.");
	        }
	    }
		
	}

