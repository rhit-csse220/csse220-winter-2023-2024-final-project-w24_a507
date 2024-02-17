package mainApp;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class: ScoreSerializer
 * 
 * @author Thornton <br>
 *         Purpose: Used to save the new high score list to the Scores.ser file
 *         <br>
 *         Restrictions: <br>
 *         For example:
 * 
 *         <pre>
 *         ScoreSerializer s = new ScoreSerializer(Scores, "Thornton", 1000);
 *         s.generateFile();
 *         </pre>
 */
public class ScoreSerializer {

	ArrayList<Score> highScores = new ArrayList<>();
	String playerName;
	int score;

	public ScoreSerializer(ArrayList<Score> highScores, String playerName, int score) {
		this.highScores = highScores;
		this.playerName = playerName;
		this.score = score;
	}

	/**
	 * ensures: The player score is sorted into the descending list of scores
	 */
	private void placeHighScore() {
		if (highScores.size() == 0)
			highScores.add(new Score(playerName, score));
		else {
			for (int i = 0; i < highScores.size(); i++) {
				if (score > highScores.get(i).getScore()) {
					highScores.add(i, new Score(playerName, score));
					return;
				}
			}
			highScores.add(new Score(playerName, score));
		}
	}

	/**
	 * ensures: The new high score list is saved to Scores.ser
	 */
	public void generateFile() {
		placeHighScore();
		try {
			FileOutputStream fileOut = new FileOutputStream("Scores.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(highScores);

			out.close();
			fileOut.close();
			System.out.print("Serialized data is saved in /tmp/Scores.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}
