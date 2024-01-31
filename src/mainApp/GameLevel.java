package mainApp;

import javax.swing.JFrame;

public class GameLevel {
	private int level=0;
	
	public GameLevel()
	{
		this.level=1;
	}
	
	public void main()
	{
		String title="Level "+level;
		final int frameWidth = 1200;
        final int frameHeight = 700;
        
		JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(frameWidth, frameHeight);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameComp game=new gameComp();
        frame.add(game);
        game.repaint();
       
        
        //create while loop that updates level and expands level text file to get barriers
        
        
        
        frame.setVisible(true);
	}

}
