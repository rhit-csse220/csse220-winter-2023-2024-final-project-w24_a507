package mainApp;

import java.io.Serializable;

public class Score implements Serializable{
	
	private int score;
	private String playerName;
	
	public Score(String playerName, int score) {
		this.playerName = playerName;
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public String toString() {
		return playerName + " " + score;
		
	}
}
