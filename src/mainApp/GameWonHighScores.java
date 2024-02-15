package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GameWonHighScores extends JPanel{
	
	int playerScore;
	
	public GameWonHighScores(int playerScore) {
		this.playerScore = playerScore;
		this.loadFile();
	}
	
	ArrayList<Score> highScores = new ArrayList<>();
	
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
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.drawString("High Scores:", 550, 150);
		g.drawString("Your score: " + this.playerScore, 550, 100);
		
		int max = 10;
		System.out.println(highScores.size());
		if (10 > highScores.size()) max = highScores.size();
		for (int i = 0; i < max; i++) {
			g.drawString(highScores.get(i).toString(), 550, 200 + i*30);
		}
	}
	
	public ArrayList<Score> getHighScores() {
		return highScores;
	}

}
