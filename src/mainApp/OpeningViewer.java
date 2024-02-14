package mainApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OpeningViewer {
	
	protected boolean thing=true;
	protected Color color=new Color(97, 75, 164);
	
	public void main()
	{
		final String frameTitle="Welcome to the game";
		final int frameWidth = 600;
        final int frameHeight = 200;
        
		JFrame frame = new JFrame();
        frame.setTitle(frameTitle);
        frame.setSize(frameWidth, frameHeight);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel forGameBut=new JPanel();
        frame.add(forGameBut,BorderLayout.SOUTH);
        
        JButton goToGame=new JButton("Go to Game");
        forGameBut.add(goToGame);
     
        JLabel pickHeroColor= new JLabel();
        pickHeroColor.setText("<html>Pick the color of your player. If no color is selected, the player will be purple.</HTML>");
        frame.add(pickHeroColor,BorderLayout.NORTH);
        
        JPanel forHeroBut=new JPanel();
        frame.add(forHeroBut,BorderLayout.WEST);
        
        
       //testing smthg
        
        ImageIcon backgroundImage=new ImageIcon(this.getClass().getResource());
        
        JLabel forImage=new JLabel(backgroundImage);
        forImage.setSize(600,200);
        
        forImage.add(forHeroBut);
        forImage.add(forGameBut);
        forImage.add(pickHeroColor);
        
        
        
        
        JButton colorP=new JButton("Purple");
        JButton colorB=new JButton("Blue");
        JButton colorR=new JButton("Red");
        JButton colorG=new JButton("Green");
        JButton colorO=new JButton("Orange");
        
        forHeroBut.add(colorO);
        forHeroBut.add(colorG);
        forHeroBut.add(colorR);
        forHeroBut.add(colorB);
        forHeroBut.add(colorP);
        
        class colorP implements ActionListener
        {
        	public void actionPerformed(ActionEvent e) {
        	
        		color=new Color(97, 75, 164);
        		
        	}
        }
        
        colorP.addActionListener(new colorP());
        
        class colorB implements ActionListener
        {
        	public void actionPerformed(ActionEvent e) {
        	
        		color=new Color(28, 47, 170);
        		
        	}
        }
        
        colorB.addActionListener(new colorB());
        
        class colorO implements ActionListener
        {
        	public void actionPerformed(ActionEvent e) {
        	
        		color=new Color(240, 163, 22);
        		
        	}
        }
        
        colorO.addActionListener(new colorO());
       
        class colorR implements ActionListener
        {
        	public void actionPerformed(ActionEvent e) {
        	
        		color=new Color(210, 58, 22);
        		
        	}
        }
        
        colorR.addActionListener(new colorR());
        
        
        class colorG implements ActionListener
        {
        	public void actionPerformed(ActionEvent e) {
        	
        		color=new Color(23, 144, 18);
        		
        	}
        }
        
        colorG.addActionListener(new colorG());
        
        
        
        
        
        
        class goToGame implements ActionListener
        {
        	public void actionPerformed(ActionEvent e) {
				//close this screen and go to game screen
        		frame.setVisible(false);
        		GameLevel game =new GameLevel(color);
            	game.main();
        		
			}//actionPerformed
        	
        }
      
        goToGame.addActionListener(new goToGame());
        
       
        frame.setVisible(true);
		
	}
	
}
