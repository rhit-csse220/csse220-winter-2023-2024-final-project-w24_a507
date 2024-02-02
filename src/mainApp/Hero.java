package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Class: Hero 
 */

public class Hero extends Object{
	
	public Hero(int x, int y, int width, int height, int constSpeed)
	{
		super(x, y, width, height, Color.BLACK, constSpeed);
	}
	
	
	public void drawOn(Graphics2D g) {
		Rectangle heroBox=new Rectangle(100, 100, 50, 50);
		g.setColor(Color.BLACK);
		g.fill(heroBox);
		g.draw(heroBox);
	}
	
	public void update() //
	{
		y += super.constantSpeed;
		
		if (y <0||y>1200) {
			
			//delete barrier, off screen
			System.out.println("Barrier off screen");
		}
		
	}
	
	public boolean overlapsWith(Hero hero)
	{
		return true;
	}
}