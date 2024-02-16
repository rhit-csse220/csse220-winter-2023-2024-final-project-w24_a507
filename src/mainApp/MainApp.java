package mainApp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Class: MainApp
 * 
 * @author 507 <br>
 *         Purpose: Top level class for CSSE220 Project containing main method
 *         used to set up each level and open the opening screen <br>
 *         Restrictions: None
 */
public class MainApp {

	/**
	 * ensures: starts the game by opening the first screen
	 */
	private void runApp() {
		System.out.println("Write your cool arcade game here!");
		OpeningViewer openingScreen = new OpeningViewer();
		openingScreen.main();
	}// runApp

	/**
	 * ensures: sets up each level to run
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) {
		Level1Serializer level1 = new Level1Serializer();
		Level2Serializer level2 = new Level2Serializer();
		LevelSerializer3 level3 = new LevelSerializer3();
		LevelSerializer4 level4 = new LevelSerializer4();
		level1.generateFile();
		level2.generateFile();
		level3.generateFile();
		level4.generateFile();
		MainApp mainApp = new MainApp();
		mainApp.runApp();
	} // main
}// MainApp
