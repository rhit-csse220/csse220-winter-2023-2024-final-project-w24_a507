package mainApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class: GameWon
 * 
 * @author Thornton <br>
 *         Purpose: Used to create the end screen for when the player beats the
 *         game and to save a high score <br>
 *         Restrictions: Is not when the player looses <br>
 *         For example:
 * 
 *         <pre>
 *         GameWon gameWon = new GameWon(100000);
 *         gameWon.main();
 *         </pre>
 */

public class GameWon {

	int playerScore;

	/**
	 * 
	 * @param playerScore
	 */
	public GameWon(int playerScore) {
		this.playerScore = playerScore;
	}

	public void main() {
		String title = "GAME WON";
		final int frameWidth = 1200;
		final int frameHeight = 700;

		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.setSize(frameWidth, frameHeight);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		GameWonHighScores forButton = new GameWonHighScores(playerScore);
		forButton.setBackground(Color.white);
		forButton.setPreferredSize(new Dimension(1200, 400));
		frame.add(forButton);

		JButton restartGame = new JButton("Restart Game");
		restartGame.setBackground(Color.white);

		JTextField playerName = new JTextField("Type your name here", 25);
		forButton.add(playerName);

		JButton savePlayerScore = new JButton("Save Score");
		savePlayerScore.setBackground(Color.white);
		forButton.add(savePlayerScore);

		forButton.add(restartGame, BorderLayout.SOUTH);

		ImageIcon backgroundImage = new ImageIcon("Images\\pexels-sebastian-sørensen-1276518.jpg");

		JLabel forImage = new JLabel();
		forImage.setIcon(backgroundImage);
		forImage.setSize(1200, 700);

		forImage.setLayout(new BorderLayout());

		forButton.setOpaque(false);
		forImage.add(forButton, BorderLayout.NORTH);

		frame.add(forImage);

		frame.setVisible(true);

		// Creates a new game and closes GameWon when restart is pressed
		class restartGame implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				// close this screen and go to game screen
				frame.setVisible(false);

				GameLevel game = new GameLevel();

				game.main();
				return;

			}// actionPerformed

		}

		restartGame.addActionListener(new restartGame());

		// Saves the player score and player name when save is clicked
		class savePlayerScore implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				ScoreSerializer file = new ScoreSerializer(forButton.getHighScores(), playerName.getText(),
						playerScore);
				file.generateFile();
			}

		}

		savePlayerScore.addActionListener(new savePlayerScore());

		frame.setVisible(true);
	}

}
