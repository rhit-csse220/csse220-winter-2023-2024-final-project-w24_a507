package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Class: GameWonHighScores
 * 
 * @author Thornton <br>
 *         Purpose: Used to get the list of high score and draw them on the
 *         screen <br>
 *         Restrictions: Cannot save the new list of high scores <br>
 *         For example:
 * 
 *         <pre>
 *         GameWonHighScores g = new GameWonHighScores(10000);
 *         </pre>
 */
public class GameWonHighScores extends JPanel {

	int playerScore;
	ArrayList<Score> highScores = new ArrayList<>();

	public GameWonHighScores(int playerScore) {
		this.playerScore = playerScore;
		this.loadFile();
	}

	/**
	 * ensures: The high score file is loaded in and the scores are put into the
	 * highSCores array list
	 */
	public void loadFile() {
		try {
			FileInputStream fileIn = new FileInputStream("Scores.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList<Score> e = (ArrayList<Score>) in.readObject();
			highScores = e;
			in.close();
			fileIn.close();

		} catch (FileNotFoundException e) {
			System.err.println("File not found for Scores");
			ArrayList<Score> empty = new ArrayList<>();
			ScoreSerializer newHighScores = new ScoreSerializer(empty, "None", 0);
			newHighScores.generateFile();
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Class not found");
		}

	}

	/**
	 * Draws the players score and below are the top 10 (or less) of the high scores
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawString("High Scores:", 550, 150);
		g.drawString("Your score: " + this.playerScore, 550, 100);

		int max = 10;
		System.out.println(highScores.size());
		if (10 > highScores.size())
			max = highScores.size();
		for (int i = 0; i < max; i++) {
			g.drawString(highScores.get(i).toString(), 550, 200 + i * 30);
		}
	}

	/**
	 * 
	 * @return The Array list of high scores
	 */
	public ArrayList<Score> getHighScores() {
		return highScores;
	}

}
