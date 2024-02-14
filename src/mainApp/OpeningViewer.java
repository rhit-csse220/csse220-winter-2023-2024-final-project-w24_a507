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
       // frame.add(forGameBut,BorderLayout.SOUTH);
        
        JButton goToGame=new JButton("Go to Game");
        goToGame.setBackground(Color.white);
        forGameBut.add(goToGame);
     
        JLabel pickHeroColor= new JLabel();
        pickHeroColor.setText("<html><font color='black'>Pick the color of your player. If no color is selected, the player will be purple.</font></HTML>");
        pickHeroColor.setFont(new Font("Verdana", Font.BOLD, 12));
        //     frame.add(pickHeroColor,BorderLayout.NORTH);
        
        JPanel forHeroBut=new JPanel();
        //frame.add(forHeroBut,BorderLayout.WEST);
        
      //  ImageIcon backgroundImage=new ImageIcon("C:\\Users\\wilhelk\\git\\csse220-winter-2023-2024-final-project-w24_a507\\src\\mainApp\\flowers.jpg");
//      
       //testing smthg
//        JPanel imageP = new JPanel()
//		{			
//			protected void paintComponent(Graphics g)
//			{
//				//  Dispaly image at full size
//				g.drawImage(backgroundImage.getImage(), 0, 0, null); 	
//				super.paintComponent(g);
//			}
//		};
//		imageP.setOpaque( false );
//		imageP.setPreferredSize( new Dimension(600, 200) );	
//		frame.add( imageP ); 
//		imageP.setLayout(new BorderLayout()); 		
        
       ImageIcon backgroundImage=new ImageIcon("C:\\Users\\wilhelk\\git\\csse220-winter-2023-2024-final-project-w24_a507\\Images\\grass.jpg");
        
        JLabel forImage=new JLabel();
        forImage.setIcon(backgroundImage);
        forImage.setSize(600,200);
       
        forImage.setLayout(new BorderLayout());
        forHeroBut.setOpaque(false);
        forGameBut.setOpaque(false);
        pickHeroColor.setOpaque(false);
        
        forImage.add(forHeroBut,BorderLayout.WEST);
        
        forImage.add(forGameBut,BorderLayout.SOUTH);
        forImage.add(pickHeroColor,BorderLayout.NORTH);
       
      
       
        frame.add(forImage);
		
		
	
        frame.setVisible(true);
		
        
        JButton colorP=new JButton("Purple");
        colorP.setBackground(Color.white);
        JButton colorB=new JButton("Blue");
        colorB.setBackground(Color.white);
        JButton colorR=new JButton("Red");
        colorR.setBackground(Color.white);
        JButton colorG=new JButton("Green");
        colorG.setBackground(Color.white);
        JButton colorO=new JButton("Orange");
        colorO.setBackground(Color.white);
        
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
        
       
    
	}
	
}
