package mainApp;

import java.io.Serializable;

/**
 * Class: Score
 * 
 * @author Thornton <br>
 *         Purpose: Used to hold Score information (String playerName, int
 *         score) <br>
 *         Restrictions: <br>
 *         For example:
 * 
 *         <pre>
 *         Score score = new Score("Thornton", 100000);
 *         </pre>
 */

public class Score implements Serializable {

	private int score;
	private String playerName;

	public Score(String playerName, int score) {
		this.playerName = playerName;
		this.score = score;
	}

	/**
	 * 
	 * @return Score value
	 */
	public int getScore() {
		return score;
	}

	/**
	 * 
	 * @return Player name string
	 */
	public String getPlayerName() {
		return playerName;
	}

	public String toString() {
		return playerName + " " + score;

	}
}
