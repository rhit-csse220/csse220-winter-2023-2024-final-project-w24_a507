package mainApp;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class ScoreSerializer {

	ArrayList<Score> highScores = new ArrayList<>();
	String playerName;
	int score;
	

	public ScoreSerializer(ArrayList<Score> highScores, String playerName, int score) {
		this.highScores = highScores;
		this.playerName = playerName;
		this.score = score;
	}


	private void placeIfHighScore() {
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

	public void generateFile() {
		placeIfHighScore();
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
