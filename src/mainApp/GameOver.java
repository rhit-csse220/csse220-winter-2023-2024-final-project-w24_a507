package mainApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class: GameOver
 * 
 * @author 507 group <br>
 *         Purpose: the screen/what happens with all lives are lost <br>
 *         For example:
 * 
 *         <pre>
 *         GameOver gameOverCall = new GameOver();
 *         </pre>
 */
public class GameOver {

	/**
	 * ensures: the method that needs to be called in order for the game over screen
	 * to appear.
	 * 
	 */
	public void main() {
		String title = "GAME OVER";
		final int frameWidth = 1200;
		final int frameHeight = 700;

		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.setSize(frameWidth, frameHeight);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel forButton = new JPanel();
		forButton.setBackground(Color.white);

		JLabel gameOverText = new JLabel();
		gameOverText.setText("<html><font color='white'>GAME OVER!</font></HTML>");
		gameOverText.setFont(new Font("Verdana", Font.BOLD, 60));

		JPanel forText = new JPanel();
		forText.add(gameOverText, BorderLayout.CENTER);

		JButton restartGame = new JButton("Restart Game");
		restartGame.setBackground(Color.white);
		restartGame.setPreferredSize(new Dimension(150, 50));
		forButton.add(restartGame, BorderLayout.CENTER);

		ImageIcon backgroundImage = new ImageIcon("Images\\pexels-sebastian-sørensen-1276518.jpg");

		JLabel forImage = new JLabel();
		forImage.setIcon(backgroundImage);
		forImage.setSize(1200, 700);

		forImage.setLayout(new BorderLayout());

		forButton.setOpaque(false);
		forText.setOpaque(false);
		forImage.add(forText, BorderLayout.NORTH);
		forImage.add(forButton, BorderLayout.SOUTH);

		frame.add(forImage);

		frame.setVisible(true);

		/**
		 * ensures: the game over screen goes away and the game restarts when the
		 * restart button is pressed
		 */
		class restartGame implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				// close this screen and go to game screen
				frame.setVisible(false);

				GameLevel game = new GameLevel();

				game.main();
				return;

			}// actionPerformed

		}// restartGame

		restartGame.addActionListener(new restartGame());

		frame.setVisible(true);
	}// main

}// GameOver
