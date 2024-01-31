import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Set;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
/** 
 *  View-Klasse, Teil des MVC, gestaltet die GUI
 * @author Tijana Belau
 * 
 * 
 */

public class View extends JFrame implements ActionListener {
	

	public View() {
	}

		//Attribute 
		public Controller myController;
		public int wurfergebnis;
		public String Kartentext;
		public Color randomColor;
		Spielfeld feld;
		Spielfeld feld2;

		//Spielerdaten anzeigen
		String[] playerColumnNames = {"Spieler", "Geld"};
	    public DefaultTableModel playerTableModel = new DefaultTableModel(null, playerColumnNames);
	    JTable playerTable = new JTable(playerTableModel);
		
	    //Straßendaten anzeigen
	    String[] feldColumnNames = {"Straße", "Besitzer", "Miete"};
        public DefaultTableModel feldTableModel = new DefaultTableModel(null, feldColumnNames);
        JTable feldTable = new JTable(feldTableModel);
	    
		//Spielerbereich
		private JPanel playerPanel = new JPanel();
		JTextField SpielerName = new JTextField("Dein Name");

		//Buttons
        JButton SpielerHinzufügen = new JButton("Spieler hinzufügen");
        JButton Würfeln = new JButton("Würfel");
        JButton StraßeKaufen = new JButton("Straße kaufen für ");
		JButton HausKaufen = new JButton("Baue ein Haus für ");
		JButton Gefängnis = new JButton("für 50$ frei kommen" );
		JButton KI = new JButton("Computerspieler +");
		
		//ScrollPanes
        private JScrollPane scrollPane = new JScrollPane(playerTable);
        private JScrollPane scrollPane2 = new JScrollPane(feldTable);
		
		//Labels
        private JLabel wurf = new JLabel ("Wurfergebnis ");
		private JLabel Karte = new JLabel ("Deine gezogene Karte ");
		private JLabel Ende = new JLabel ("Pleite");

        //Spielfeld
		private JPanel panel_20 = createColoredPanel("Frei Parken", new Color(252, 199, 211));
		private JPanel panel_19 = createColoredPanel("Berliner Str.", new Color(247, 185, 114));
		private JPanel panel_18 = createColoredPanel("Wiener Str.", new Color(247, 185, 114));
		private JPanel panel_17 = createColoredPanel("G-Karte", Color.WHITE);	
		private JPanel panel_16 = createColoredPanel("Münchener Str.", new Color(247, 185, 114));
		private JPanel panel_15 = createColoredPanel("West-Bhf", new Color(143, 143, 143));
		private JPanel panel_14 = createColoredPanel("Neue Str.", new Color(252, 157, 208));
		private JPanel panel_13 = createColoredPanel("Hafenstr.", new Color(252, 157, 208));
		private JPanel panel_12 = createColoredPanel("Elektrowerk", new Color(207, 204, 206));
		private JPanel panel_11 = createColoredPanel("Seestr.", new Color(252, 157, 208));
		private JPanel panel_10 = createColoredPanel("Gefängnis", Color.ORANGE);
		private JPanel panel_30 = createColoredPanel("Ins Gefängnis", Color.WHITE);
		private JPanel panel_31 = createColoredPanel("Rathausplatz", new Color(166, 245, 168));
		private JPanel panel_32 = createColoredPanel("Hauptstr.", new Color(166, 245, 168));
		private JPanel panel_33 = createColoredPanel("G-Karte", Color.WHITE);
		private JPanel panel_34 = createColoredPanel("Bahnhofstr.", new Color(166, 245, 168));
		private JPanel panel_35 = createColoredPanel("Haupt-Bhf", new Color(143, 143, 143));
		private JPanel panel_36 = createColoredPanel("E-Karte", Color.WHITE);
		private JPanel panel_37 = createColoredPanel("Parkstr.", new Color(169, 178, 212));
		private JPanel panel_38 = createColoredPanel("Zusatzsteuer", Color.WHITE);
		private JPanel panel_39 = createColoredPanel("Schlossallee", new Color(169, 178, 212));
		private JPanel panel_0 = createColoredPanel("Start", new Color(255, 73, 66));		//START
		private JPanel panel_21 = createColoredPanel("Theaterstr.", new Color(250, 132, 132));
		private JPanel panel_22 = createColoredPanel("E-Karte", Color.WHITE);
		private JPanel panel_23 = createColoredPanel("Museumsstr.", new Color(250, 132, 132));
		private JPanel panel_24 = createColoredPanel("Opernplatz", new Color(250, 132, 132));
		private JPanel panel_25 = createColoredPanel("Nord-Bhf", new Color(143, 143, 143));
		private JPanel panel_26 = createColoredPanel("Lessingstr.", new Color(250, 241, 140));
		private JPanel panel_27 = createColoredPanel("Schillerstr.", new Color(250, 241, 140));
		private JPanel panel_28 = createColoredPanel("Wasserwerk", new Color(207, 204, 206));
		private JPanel panel_29 = createColoredPanel("Göthestr.", new Color(250, 241, 140));
		private JPanel panel_9 = createColoredPanel("Poststr.", new Color(218, 239, 240));
		private JPanel panel_8 = createColoredPanel("Elisenstr.", new Color(218, 239, 240));
		private JPanel panel_7 = createColoredPanel("E-Feld", Color.WHITE);	
		private JPanel panel_6 = createColoredPanel("Chausseestr.", new Color(218, 239, 240));			
		private JPanel panel_5 = createColoredPanel("Süd-Bhf", new Color(143, 143, 143));
		private JPanel panel_4 = createColoredPanel("Eink.Steuer", Color.WHITE);	
		private JPanel panel_3 = createColoredPanel("Turmstr.", new Color(186, 144, 117));	
		private JPanel panel_2 = createColoredPanel("G-Feld", Color.WHITE);	
		private JPanel panel_1 = createColoredPanel("Badstr.", new Color(186, 144, 117));

		/**
		 * es wird das PAnel gesucht, auf welchem sich der Spieler befinden müsste
		 * @param id die Position des Spieler
		 * @return das Panel, welches die Position des Spielers darstellt
		 */
		private JPanel setNeuePosition(int id) {
		       	switch (id) {
		            case 0:
		                return panel_0;
		            case 1:
		                return panel_1;
		            case 2:
		                return panel_2;
		            case 3:
		                return panel_3;
		            case 4:
		                return panel_4;
		            case 5:
		                return panel_5;
		            case 6:
		                return panel_6;
		            case 7:
		                return panel_7;
		            case 8:
		                return panel_8;
		            case 9:
		                return panel_9;
		            case 10:
		                return panel_10;
		            case 11:
		                return panel_11;
		            case 12:
		                return panel_12;
		            case 13:
		                return panel_13;    
		            case 14:
		                return panel_14;
		            case 15:
		                return panel_15;
		            case 16:
		                return panel_16;
		            case 17:
		                return panel_17;
		            case 18:
		                return panel_18;
		            case 19:
		                return panel_19;
		            case 20:
		                return panel_20;
		            case 21:
		                return panel_21;
		            case 22:
		                return panel_22;
		            case 23:
		                return panel_23;
		            case 24:
		                return panel_24;
		            case 25:
		                return panel_25;
		            case 26:
		                return panel_26;
		            case 27:
		                return panel_27;
		            case 28:
		                return panel_28;
		            case 29:
		                return panel_29;
		            case 30:
		                return panel_30;
		            case 31:
		                return panel_31;
		            case 32:
		                return panel_32;
		            case 33:
		                return panel_33;
		            case 34:
		                return panel_34;
		            case 35:
		                return panel_35;
		            case 36:
		                return panel_36;
		            case 37:
		                return panel_37;
		            case 38:
		                return panel_38;
		            case 39:
		                return panel_39;  
		            default:
		                // Hier können Sie einen Standardfall behandeln oder eine Ausnahme werfen
		                return null;
		       	} 
		}
	


		/**
		 * Initalisierung der GUI, hier werden die Positionen für alle Panels festgelegt und auch weitere grafische Einstellunge, wie bspw. die Sichtbarkeit der Knöpfe und das aussehen der Umrandungen
		 */
		void init() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
			
			scrollPane.setBounds(1270, 50, 250, 400);
			scrollPane2.setBounds(1270,450, 250, 400 );
			playerPanel.setBounds(1070, 50, 200, 200);
			wurf.setBounds(1070, 300, 200, 50);
			Karte.setBounds(1070, 10, 500, 30);

			Ende.setBounds(900,500 ,300, 100);
			
			panel_20.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_20.setBounds(20, 10, 90, 90);
			
			panel_19.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_19.setBounds(20, 100, 90, 70);
			
			panel_18.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_18.setBounds(20, 170, 90, 70);
			
			panel_17.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_17.setBounds(20, 240, 90, 70);
		
			panel_16.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_16.setBounds(20, 310, 90, 70);
	
			panel_15.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_15.setBounds(20, 380, 90, 70);
			
			panel_14.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_14.setBounds(20, 450, 90, 70);
	
			panel_13.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_13.setBounds(20, 520, 90, 70);
			
			panel_12.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_12.setBounds(20, 590, 90, 70);
		
			panel_11.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_11.setBounds(20, 660, 90, 70);
		
			panel_10.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_10.setBounds(20, 730, 90, 90);
		
			panel_30.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_30.setBounds(740, 10, 90, 90);
			
			panel_31.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_31.setBounds(740, 100, 90, 70);
		
			panel_32.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_32.setBounds(740, 170, 90, 70);
		
			panel_33.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_33.setBounds(740, 240, 90, 70);
		
			panel_34.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_34.setBounds(740, 310, 90, 70);
		
			panel_35.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_35.setBounds(740, 380, 90, 70);
		
			panel_36.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_36.setBounds(740, 450, 90, 70);
			
			panel_37.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_37.setBounds(740, 520, 90, 70);
		
			panel_38.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_38.setBounds(740, 590, 90, 70);
		
			panel_39.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_39.setBounds(740, 660, 90, 70);
			
			panel_0.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_0.setBounds(740, 730, 90, 90);
		
			panel_21.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_21.setBounds(110, 10, 70, 90);
			
			panel_22.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_22.setBounds(180, 10, 70, 90);
		
			panel_23.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_23.setBounds(250, 10, 70, 90);
			
			panel_24.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_24.setBounds(320, 10, 70, 90);	
			
			panel_25.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_25.setBounds(390, 10, 70, 90);	
			
			panel_26.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_26.setBounds(460, 10, 70, 90);	
		
			panel_27.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_27.setBounds(530, 10, 70, 90);
			
			panel_28.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_28.setBounds(600, 10, 70, 90);
			
			panel_29.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_29.setBounds(670, 10, 70, 90);
			
			panel_9.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_9.setBounds(110, 730, 70, 90);
			
			panel_8.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_8.setBounds(180, 730, 70, 90);
			
			panel_7.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_7.setBounds(250, 730, 70, 90);
			
			panel_6.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_6.setBounds(320, 730, 70, 90);
			
			panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_5.setBounds(390, 730, 70, 90);
			
			panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_4.setBounds(460, 730, 70, 90);
			
			panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(530, 730, 70, 90);
			
			panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(600, 730, 70, 90);
			
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(670, 730, 70, 90);
			
			playerPanel.add(SpielerName);
			playerPanel.add(SpielerHinzufügen);
			playerPanel.add(KI);
			playerPanel.add(Würfeln);
			playerPanel.add(StraßeKaufen);
			playerPanel.add(HausKaufen);
			playerPanel.add(Gefängnis);
			getContentPane().add(wurf);
			getContentPane().add(Karte);
			getContentPane().add(scrollPane);
			getContentPane().add(scrollPane2);
			getContentPane().add(playerPanel);
			getContentPane().add(panel_0);
			getContentPane().add(panel_1);
			getContentPane().add(panel_2);
			getContentPane().add(panel_3);
			getContentPane().add(panel_4);
			getContentPane().add(panel_5);
			getContentPane().add(panel_6);
			getContentPane().add(panel_7);
			getContentPane().add(panel_8);
			getContentPane().add(panel_9);
			getContentPane().add(panel_10);
			getContentPane().add(panel_11);
			getContentPane().add(panel_12);
			getContentPane().add(panel_13);
			getContentPane().add(panel_14);
			getContentPane().add(panel_15);
			getContentPane().add(panel_16);
			getContentPane().add(panel_17);
			getContentPane().add(panel_18);
			getContentPane().add(panel_19);
			getContentPane().add(panel_20);
			getContentPane().add(panel_21);
			getContentPane().add(panel_22);
			getContentPane().add(panel_23);
			getContentPane().add(panel_24);
			getContentPane().add(panel_25);
			getContentPane().add(panel_26);
			getContentPane().add(panel_27);
			getContentPane().add(panel_28);
			getContentPane().add(panel_29);
			getContentPane().add(panel_30);		
			getContentPane().add(panel_31);
			getContentPane().add(panel_32);
			getContentPane().add(panel_33);
			getContentPane().add(panel_34);
			getContentPane().add(panel_35);
			getContentPane().add(panel_36);
			getContentPane().add(panel_37);
			getContentPane().add(panel_38);
			getContentPane().add(panel_39);
			getContentPane().add(Ende);
			
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.pack();
			this.setVisible(true);
			StraßeKaufen.setVisible(false);
			Gefängnis.setVisible(false);
			HausKaufen.setVisible(false);
			Ende.setVisible(false);
			
			SpielerHinzufügen.addActionListener(this);
			Würfeln.addActionListener(this);
			StraßeKaufen.addActionListener(this);
			Gefängnis.addActionListener(this);
			KI.addActionListener(this);	
			HausKaufen.addActionListener(this);	
		}
	
		
	/**
	 * Verbindung zur Controller-Klasse
	 * @param myController der welche verknpft wird
	 */
	public void setMyController(Controller myController) {
		this.myController = myController;
	}
	
	/**
	 * Daten werden geupdatet und im ScrollPane nochmal neu geladen und aktuell gehalten
	 * @param spielerList Eine Liste aller Spieler, menschlich und auch computer
	 */
	public void updatePlayerTable(Set<Spieler> spielerList) {
	    // Lösche alle vorhandenen Daten in der Tabelle
	    playerTableModel.setRowCount(0);

	    // Füge die aktualisierten Daten hinzu
	    for (Spieler spieler : spielerList) {
	        playerTableModel.addRow(new Object[]{spieler.getName(), spieler.getGeld()});
	    }
	}

   
	/**
	 * Daten werden geupdatet und im ScrollPane nochmal neu geladen und aktuell gehalten
	 * @param felderListe Eine Liste aller Spielfelder
	 */
	public void updateFeldTable(LinkedList<Spielfeld> felderListe) {
	    // Lösche alle vorhandenen Daten in der Tabelle
	    feldTableModel.setRowCount(0);

	    // Füge die aktualisierten Daten hinzu
	    for (Spielfeld feld : felderListe) {
	        feldTableModel.addRow(new Object[]{feld.getName(), feld.getBesitzer(), feld.getMiete()});
	    }
	}
    
	
    /**
	 * Erstellt ein Jpanel mit Text und Farbe
     * @param text der Text der angezeigt werden soll
     * @param color die Farbe die das Panel haben soll
     * @return das fertige Panel mit Text und in Farbe
     */
    private JPanel createColoredPanel(String text, Color color) {
        JPanel coloredPanel = new JPanel();
        coloredPanel.setBackground(color);
        coloredPanel.setBorder(new TitledBorder(null, text, TitledBorder.LEADING, TitledBorder.TOP, null, null));
     
        JLabel label = new JLabel(text);
        coloredPanel.add(label);

        return coloredPanel;
    }
    
    /**
	 * Damit wird ein String definiert der den Namen für einen neuen Spieler festlegt
     * @return Den eingegebenen Text im JTextField
     */
    public String getSpielerName() {
        return SpielerName.getText();
    }
    
	/**
	 * @return gibt das Attribut feld zurück
	 */
	public Spielfeld getFeld() {
		return feld;
	}

	/**
	 * Gibt zusätzliche Daten um den Text vom Button je nach Spielfeld anzupassen
	 * @param feld aktuellesSPielfeld auf dem sich der Spieler gerade befindet
	 */
	public void setFeld(Spielfeld feld) {
		this.feld = feld;
		StraßeKaufen.setText("Kaufen für " + feld.getKaufpreis());
	}
	 
	/**
	 * Gibt zusätzliche Daten um den Text vom Button je nach Spielfeld anzupassen
	 * @param feld aktuellesSPielfeld auf dem sich der Spieler gerade befindet
	 */
	public void setfeld2(Spielfeld feld) {
		this.feld2 = feld;
		HausKaufen.setText("Haus kaufen für " + ((Strassen) feld).getHauspreis());
	}

    /**
	 * Das Attribut wurfergebnis wird mit dem Wurfergebnis aus dem Model gleichgesetzt und als Ausgabe auf der GUI verwendet
     * @param wurfergebnis Das Ergebnis aus beiden Würfeln die der Spieler geworfen hat
     * @return Genau das gleiche wie der Eingabeparameter
     */
    public int setWurf(int wurfergebnis) {
    	this.wurfergebnis = wurfergebnis;
    	wurf.setText("Ergebnis: " + wurfergebnis);
		return wurfergebnis;
    }

	/**
	 * Das Attribut Kartentext wird mit dem text aus dem Model gleichgesetzt und als Ausgabe auf der GUI verwendet
	 * @param text Text der auf der Karte steht
	 * @return Genau das gleiche wie der Eingabeparameter
	 */
	public String setKarte(String text) {
    	this.Kartentext = text;
    	Karte.setText("Karte: " + text);
		return text;
    }
	
	/**
	 * zeichnet die Spielfiguren
	 */
    public void paint(Graphics g) {
    	super.paint(g);
		Set<Spieler> spielerList = myController.getAlleSpieler();

        for (Spieler spieler : spielerList) {
            g.setColor(spieler.getFarbe());
            int id = spieler.getPosition();
            JPanel positionPanel = setNeuePosition(id);
            g.fillOval(positionPanel.getX() + 35, positionPanel.getY() + 70, 20, 20);
            g.setColor(Color.BLACK);
            g.drawOval(positionPanel.getX() + 35, positionPanel.getY() + 70, 20, 20);
        }
    }	
    
    /**
     * setzt die Sichbarkeit des Buttons auf true
     */
    public void displayStraßeKaufenButton() {
        StraßeKaufen.setVisible(true);
        revalidate();
        repaint();
    }

	/**
     * setzt die Sichbarkeit des Buttons auf false
     */
    public void hideStraßeKaufenButton() {
        StraßeKaufen.setVisible(false);
        revalidate();
        repaint();
    }

	/**
     * setzt die Sichbarkeit des Buttons auf true
     */
	public void displayHausKaufenButton() {
        HausKaufen.setVisible(true);
        revalidate();
        repaint();
    }

    /**
     * setzt die Sichbarkeit des Buttons auf false
     */
	public void hideHausKaufenButton() {
        HausKaufen.setVisible(false);
        revalidate();
        repaint();
    }

	/**
     * setzt die Sichbarkeit des Buttons auf true
     */
	public void displayGefängnisButton() {
        Gefängnis.setVisible(true);
        revalidate();
        repaint();
    }
	/**
     * setzt die Sichbarkeit des Buttons auf false
     */
	public void hideGefängnisButton() {
        Gefängnis.setVisible(false);
        revalidate();
        repaint();
    }
	
	/**
     * setzt die Sichbarkeit des Buttons auf false
     */
	public void hideKIButton() {
        KI.setVisible(false);
        revalidate();
        repaint();
    }

	/**
     * setzt die Sichbarkeit des Labels auf true
     */
	public void displayPleite(String name) {
		Ende.setText( name + " ist Pleite!");
        Ende.setVisible(false);
        revalidate();
        repaint();
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SpielerHinzufügen) {
            myController.SpielerHinzufügen();
	} else if (e.getSource() == Würfeln){
		myController.würfelGeworfen();
	} else if (e.getSource() == StraßeKaufen){
		myController.StraßeKaufen();
	} else if (e.getSource() == Gefängnis){
		myController.GefängnisFrei();
	} else if (e.getSource() == KI){
		myController.ComHinzufügen();
	} else if (e.getSource() == HausKaufen) {
		myController.HausKaufen();
	}
	}
}
