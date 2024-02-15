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

public class GameWon {
	
	int playerScore;
	
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
		forButton.setPreferredSize(new Dimension(1200,700));
		frame.add(forButton);

		JButton restartGame = new JButton("Restart Game");
		restartGame.setBackground(Color.white);
		restartGame.setPreferredSize(new Dimension(150, 50));
		forButton.add(restartGame);
		
		JButton savePlayerScore = new JButton("Save Score");
		savePlayerScore.setBackground(Color.white);
		savePlayerScore.setPreferredSize(new Dimension(150, 50));
		forButton.add(savePlayerScore);
		
		JTextField playerName = new JTextField("Type your name here", 25);
		forButton.add(playerName);

		ImageIcon backgroundImage = new ImageIcon(
				"C:\\Users\\wilhelk\\git\\csse220-winter-2023-2024-final-project-w24_a507\\Images\\pexels-sebastian-sørensen-1276518.jpg");

		JLabel forImage = new JLabel();
		forImage.setIcon(backgroundImage);
		forImage.setSize(1200, 700);

		forImage.setLayout(new BorderLayout());

		forButton.setOpaque(false);
		forImage.add(forButton);

		frame.add(forImage);

		frame.setVisible(true);

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
		
		class savePlayerScore implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				ScoreSerializer file = new ScoreSerializer(forButton.getHighScores(), playerName.getText(), playerScore);
				file.generateFile();
			}
			
		}
		
		savePlayerScore.addActionListener(new savePlayerScore());

		frame.setVisible(true);
	}

}
