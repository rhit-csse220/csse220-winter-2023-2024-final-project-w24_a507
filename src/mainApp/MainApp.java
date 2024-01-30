package mainApp;


/**
 * Class: MainApp
 * @author Put your team name here
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp {
	
	
	private void runApp() {
		System.out.println("Write your cool arcade game here!");	
		
		//call opening screen
		OpeningViewer openingScreen = new OpeningViewer();
		openingScreen.main();
		//System.out.println("HELO");
		
	
//		GameLevel game=new GameLevel(1); //game level 1
//		game.main();
		
		
		
		//call each game level
		
	} // runApp

	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
		mainApp.runApp();		
	} // main

}