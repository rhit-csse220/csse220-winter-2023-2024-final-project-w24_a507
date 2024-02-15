package mainApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOver {
	
	public void main() {
		String title = "GAME OVER";
		final int frameWidth = 1200;
		final int frameHeight = 700;

		
		
		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.setSize(frameWidth, frameHeight);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel forButton=new JPanel();
		forButton.setBackground(Color.white);
		//frame.add(forButton, BorderLayout.SOUTH);
		
		
		
		
		
		JButton restartGame=new JButton("Restart Game");
		restartGame.setBackground(Color.white);
		restartGame.setPreferredSize(new Dimension(150, 50));
        forButton.add(restartGame, BorderLayout.CENTER);
        
        
        
        ImageIcon backgroundImage=new ImageIcon("Images\\pexels-sebastian-sørensen-1276518.jpg");
        
        JLabel forImage=new JLabel();
        forImage.setIcon(backgroundImage);
        forImage.setSize(1200,700);
       
        forImage.setLayout(new BorderLayout());
      
        forButton.setOpaque(false);
        forImage.add(forButton,BorderLayout.SOUTH);
       
        frame.add(forImage);
		
		
	
        frame.setVisible(true);
        
        
        class restartGame implements ActionListener
        {
        	public void actionPerformed(ActionEvent e) {
				//close this screen and go to game screen
        		frame.setVisible(false);
        		
        		GameLevel game =new GameLevel();
        		
            	game.main();
            	return;
        		
			}//actionPerformed
        	
        }
      
        restartGame.addActionListener(new restartGame());
        

        frame.setVisible(true);
	}

}
