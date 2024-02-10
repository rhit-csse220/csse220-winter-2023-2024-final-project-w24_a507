package mainApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class GameLevel {
	private static final int DELAY = 50;
	private int level = 0;
	
	private JLabel label = new JLabel();

	// Call this to update the text on the label.
	

	public GameLevel() {
		this.level = 1;
		
	
	}

	public void main() {
		String title = "Level " + level;
		final int frameWidth = 1200;
		final int frameHeight = 700;

		
		
		JFrame frame = new JFrame();
		frame.setTitle(title);
		frame.setSize(frameWidth, frameHeight);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(label, BorderLayout.NORTH);
		
		
		gameComp game = new gameComp();
		game.setLabel(this.label);
		game.updateLabel(0,3);
		
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
				System.out.println(e.getKeyChar());
				int keyPressed=e.getKeyChar();
				//System.out.println(keyPressed);
				if(keyPressed==65535)
					{
						//	System.out.println("here");
							game.moveHeroUp();
							
							
					}
				
			}
		};
	
		frame.addKeyListener(goUp);
	
		
		frame.add(game);
		Timer t = new Timer(DELAY, new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				game.update();
				game.removeThings();
				game.repaint();
				
			}
		});
		frame.setVisible(true);
		t.start();

	}

}
