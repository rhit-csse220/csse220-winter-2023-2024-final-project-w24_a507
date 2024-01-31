package mainApp;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class gameComp extends JComponent{
	Hero hero1=new Hero();
	Arraylist<Barrier> barriers = new ArrayList<Barrier>();
	
	public gameComp()
	{
	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		hero1.drawOn(g2);
	}
	
	

}
