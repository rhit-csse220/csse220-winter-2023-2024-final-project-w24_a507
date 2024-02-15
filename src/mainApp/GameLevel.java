package mainApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

public class GameLevel {
	private static final int DELAY = 50;
	private int level = 0;
	protected Color heroColor;
	
	private JLabel label = new JLabel();

	// Call this to update the text on the label.
	

	public GameLevel(Color heroColor) {
		this.level = 1;
		
		this.heroColor=heroColor;
	
	}
	
	public GameLevel()
	{
		
	}

	public void main() {
		String title = "Have Fun!";
		final int frameWidth = 1200;
		final int frameHeight = 700;

		
		
		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.setSize(frameWidth, frameHeight);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//	frame.add(label, BorderLayout.NORTH);
		
		//thing
		gameComp game = new gameComp();
		
		game.setLabel(this.label);
		game.updateLabel(0,3);
		game.hColor(heroColor);
		
		//new stuff
		game.setBounds(0, 0, frameWidth, frameHeight); // Sets the game's size to 1200 x 700

		JLayeredPane layeredPane = new JLayeredPane();  // Creates a new LayeredPane for the object stacking                  // In theory it's not needed, but I'll keep it
		//frame.add(layeredPane);
		// Add the pane to the frame

		label.setLocation(0, 0);
	// Positions the label to the top left corner
		label.setBounds(0, 0, 100, 50);                 // The label has space to be drawn in the corner

		layeredPane.setLocation(0, 0);                  // Move the pane to the top left corner of the screen
		layeredPane.add(label,2);                      // Add the label to the layer above
		layeredPane.add(game, 1); 
		
		
		
		ImageIcon gameImage=new ImageIcon("Images\\Trees.png");
        
        JLabel forImage=new JLabel();
        forImage.setIcon(gameImage);
        forImage.setSize(1200,700);
       
        forImage.setLayout(new BorderLayout());
        
        game.setOpaque(false);
        layeredPane.setOpaque(false);
        forImage.add(game);
        forImage.add(layeredPane);
        
       
        frame.add(forImage);
		
		
		
		
		
		
		frame.setVisible(true);
		// Add the game to the current layer
		
		KeyListener goUp=new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e.getKeyChar());
				int keyPressed=e.getKeyChar();
				//System.out.println(keyPressed);
				if(keyPressed==65535)
					{
						//	System.out.println("here");
							game.moveHeroUp();
							
							
					}
				else if(e.getKeyCode()==KeyEvent.VK_U)
				{
						//System.out.println("here");
					game.level++;
						game.loadFile(game.level);
						
						
				}
				else if(e.getKeyCode()==KeyEvent.VK_D)
				{
						//System.out.println("here");
					game.level--;
						game.loadFile(game.level);
						
						
				}
				
			}
		};
	
		frame.addKeyListener(goUp);
	
		
	//	frame.add(game);
		Timer t = new Timer(DELAY, new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				if (game.level <= game.MAX_LEVEL) game.update();					

				if(game.livesLeft==0 || game.level > game.MAX_LEVEL)
				{
					frame.setVisible(false);
					
					return;
				}
				game.removeThings();
				game.repaint();
				
			}
		});
	
		t.start();

	}

}
