package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Hero {

	private int constSpeed=0;
	
	
	public Hero()
	{
		this.constSpeed=20;
	}
	
	
	public void drawOn(Graphics g) {
		Graphics2D g2=(Graphics2D) g;
		
		Rectangle heroBox=new Rectangle(100, 100, 50, 50);
		g2.setColor(Color.BLACK);
		g2.fill(heroBox);
		g2.draw(heroBox);
	}
}