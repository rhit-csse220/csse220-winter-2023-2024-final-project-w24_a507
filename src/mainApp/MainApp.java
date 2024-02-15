package mainApp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


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
	}
//		GameLevel game=new GameLevel(1); //game level 1
//		game.main();
		
		
		
		//call each game level
		
		// runApp

	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	


	public static void main(String[] args) {
		Level1Serializer level1 = new Level1Serializer();
		Level2Serializer level2 = new Level2Serializer();
		LevelSerializer3 level3 = new LevelSerializer3();
		LevelSerializer4 level4 = new LevelSerializer4();
//		ScoreSerializer hi  = new ScoreSerializer(new ArrayList<Score>(), "Thor", 0);
		
//		hi.generateFile();
		level1.generateFile();
		level2.generateFile();
		level3.generateFile();
		level4.generateFile();
		MainApp mainApp = new MainApp();
		mainApp.runApp();		
	} // main
}
