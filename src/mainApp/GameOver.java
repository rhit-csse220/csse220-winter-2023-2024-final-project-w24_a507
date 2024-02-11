package mainApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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
		frame.add(forButton, BorderLayout.SOUTH);
		
		
		JButton restartGame=new JButton("Restart Game");
        forButton.add(restartGame);
        
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
