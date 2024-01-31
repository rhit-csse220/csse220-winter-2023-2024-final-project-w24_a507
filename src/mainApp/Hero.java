package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Class: Hero 
 */

public class Hero{

	private int constSpeed=0;
	protected int x, y, width, height;
	
	public Hero()
	{
		this.constSpeed=20;
		this.x = 100;
		this.y = 100;
		this.width = 50;
		this.height = 50;
	}
	
	
	public void drawOn(Graphics g) {
		Graphics2D g2=(Graphics2D) g;
		
		Rectangle heroBox=new Rectangle(100, 100, 50, 50);
		g2.setColor(Color.BLACK);
		g2.fill(heroBox);
		g2.draw(heroBox);
	}
}