/** 
 *  main-Klasse, hierrüber wird das Programm ausgeführt
 * @author Tijana Belau
 * 
 * 
 */
public class main {

	/**
	 * stellt die Verknüpfungen des MVC her und führt die init()-Methode aus
	 * @param args
	 */
	public static void main(String[] args) {
		
		Controller myController = new Controller();
		View myView = new View();
		Model myModel = new Model();

		myController.setMyView(myView);
		myController.setMyModel(myModel);
		myView.setMyController(myController);
		
		myView.init();

		
		
	}

}
