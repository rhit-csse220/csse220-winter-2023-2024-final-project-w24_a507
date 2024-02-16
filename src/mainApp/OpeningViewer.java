package mainApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class: OpeningViewer
 * 
 * @author 507 group <br>
 *         Purpose: used to control the opening screen <br>
 *         For example:
 * 
 *         <pre>
 *         OpeningViewer openScreen = new OpeningViewer();
 *         </pre>
 */
public class OpeningViewer {

	protected boolean thing = true;
	protected Color color = new Color(97, 75, 164);

	/**
	 * ensures: needs to be called in order for the opening screen to be displayed
	 */
	public void main() {
		final String frameTitle = "Welcome to the game";
		final int frameWidth = 600;
		final int frameHeight = 200;

		JFrame frame = new JFrame();
		frame.setTitle(frameTitle);
		frame.setSize(frameWidth, frameHeight);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel forGameBut = new JPanel();

		JButton goToGame = new JButton("Go to Game");
		goToGame.setBackground(Color.white);
		forGameBut.add(goToGame);

		JLabel pickHeroColor = new JLabel();
		pickHeroColor.setText(
				"<html><font color='black'>Pick the color of your player. If no color is selected, the player will be purple.</font></HTML>");
		pickHeroColor.setFont(new Font("Verdana", Font.BOLD, 12));

		JPanel forHeroBut = new JPanel();

		ImageIcon backgroundImage = new ImageIcon("Images\\grass.jpg");

		JLabel forImage = new JLabel();
		forImage.setIcon(backgroundImage);
		forImage.setSize(600, 200);

		forImage.setLayout(new BorderLayout());
		forHeroBut.setOpaque(false);
		forGameBut.setOpaque(false);
		pickHeroColor.setOpaque(false);

		forImage.add(forHeroBut, BorderLayout.WEST);

		forImage.add(forGameBut, BorderLayout.SOUTH);
		forImage.add(pickHeroColor, BorderLayout.NORTH);

		frame.add(forImage);

		frame.setVisible(true);

		JButton colorP = new JButton("Purple");
		colorP.setBackground(Color.white);
		JButton colorB = new JButton("Blue");
		colorB.setBackground(Color.white);
		JButton colorR = new JButton("Red");
		colorR.setBackground(Color.white);
		JButton colorG = new JButton("Green");
		colorG.setBackground(Color.white);
		JButton colorO = new JButton("Orange");
		colorO.setBackground(Color.white);

		forHeroBut.add(colorO);
		forHeroBut.add(colorG);
		forHeroBut.add(colorR);
		forHeroBut.add(colorB);
		forHeroBut.add(colorP);

		/**
		 * ensures: makes the color purple
		 */
		class colorP implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				color = new Color(97, 75, 164);

			}
		}

		colorP.addActionListener(new colorP());

		/**
		 * ensures: makes the color blue
		 */
		class colorB implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				color = new Color(28, 47, 170);

			}
		}

		colorB.addActionListener(new colorB());

		/**
		 * ensures: makes the color orange
		 */
		class colorO implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				color = new Color(240, 163, 22);

			}
		}

		colorO.addActionListener(new colorO());

		/**
		 * ensures: makes the color red
		 */
		class colorR implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				color = new Color(210, 58, 22);

			}
		}

		colorR.addActionListener(new colorR());

		/**
		 * ensures: makes the color green
		 */
		class colorG implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				color = new Color(23, 144, 18);

			}
		}

		colorG.addActionListener(new colorG());

		/**
		 * ensures: when the player wants to go to the game this screen needs to
		 * disappear
		 */
		class goToGame implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				// close this screen and go to game screen
				frame.setVisible(false);
				GameLevel game = new GameLevel(color);
				game.main();

			}// actionPerformed

		}

		goToGame.addActionListener(new goToGame());

	}// main

}// OpeningViewer
