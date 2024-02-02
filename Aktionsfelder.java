import java.util.LinkedList;

public class Aktionsfelder {

    /**
     *
     */
    public int ID;
    public String Name; 

/**
 * @param id
 * @param name
 */
public Aktionsfelder(int id, String name) {
		this.ID = id;
        this.Name = name;	
	}


private static LinkedList<Aktionsfelder> Aktionsfelder = new LinkedList<>();
    
    static {
        Aktionsfelder.add(new Aktionsfelder( 0, "LOS"));
        Aktionsfelder.add(new Aktionsfelder(2,"Gemeinschaftsfeld1"));
        Aktionsfelder.add(new Aktionsfelder(4,"Einkommensteuer"));
        Aktionsfelder.add(new Aktionsfelder(7,"Ereignisfeld1"));
        Aktionsfelder.add(new Aktionsfelder(10,"Gefaengnis"));
        Aktionsfelder.add(new Aktionsfelder(17,"Gemeinschaftsfeld2"));
        Aktionsfelder.add(new Aktionsfelder(20,"Frei Parken"));
        Aktionsfelder.add(new Aktionsfelder(22,"Ereignisfeld2"));
        Aktionsfelder.add(new Aktionsfelder(30,"Gehen Sie in das Gefaengnis"));
        Aktionsfelder.add(new Aktionsfelder(33,"Gemeinschaftsfeld3"));
        Aktionsfelder.add(new Aktionsfelder(36,"Ereignisfeld3"));
        Aktionsfelder.add(new Aktionsfelder(38,"Zusatzsteuer"));
    }  


//Setter-Methoden

/**
 * @param ID
 * @return
 */
public int setID (int ID) {
    this.ID = ID;
    return ID;
}

/**
 * @param Name
 * @return
 */
public String setName (String Name) {
    this.Name = Name;
    return Name;
}

//Getter-Methoden
/**
 * @param Name
 * @return
 */
public String getName (String Name) {
    return Name;
}

/**
 * @return
 */
public int getID() {
	return ID;	
}

}