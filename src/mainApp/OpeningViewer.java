package mainApp;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class OpeningViewer {
	
	protected boolean thing=true;
	
	public void main()
	{
		final String frameTitle="Welcome to the game";
		final int frameWidth = 1200;
        final int frameHeight = 700;
        
		JFrame frame = new JFrame();
        frame.setTitle(frameTitle);
        frame.setSize(frameWidth, frameHeight);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Panel forButtons=new Panel();
        frame.add(forButtons,BorderLayout.SOUTH);
        
        JButton goToGame=new JButton("Go to Game");
        forButtons.add(goToGame);
        
        class goToGame implements ActionListener
        {
        	public void actionPerformed(ActionEvent e) {
				//close this screen and go to game screen
        		frame.setVisible(false);
        		GameLevel game =new GameLevel();
            	game.main();
        		
			}//actionPerformed
        	
        }
      
        goToGame.addActionListener(new goToGame());
        
       
        frame.setVisible(true);
		
	}
	
}
