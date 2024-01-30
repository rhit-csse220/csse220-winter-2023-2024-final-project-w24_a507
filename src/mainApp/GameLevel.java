package mainApp;

import javax.swing.JFrame;

public class GameLevel {
	private int level=0;
	
	public GameLevel(int level)
	{
		this.level=level;
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
       
        
        frame.setVisible(true);
	}

}
