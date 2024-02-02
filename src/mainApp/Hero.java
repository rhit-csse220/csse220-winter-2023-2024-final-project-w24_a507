package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;

/**
 * Class: Hero 
 */

public class Hero extends Object implements Serializable{
	
	public Hero(int x, int y, int width, int height, int constSpeed)
	{
		super(x, y, width, height, Color.BLACK, constSpeed);
	}
	
	public void drawOn(Graphics2D g) {
		
		Rectangle heroBox=new Rectangle(x, y, 50, 50);
		g.setColor(Color.BLACK);
		g.fill(heroBox);
		g.draw(heroBox);

	}
	
	public void update() //
	{

		y += super.constantSpeed;
		
		if(y < 0)
		{
			y=0;
			System.out.println("WEEE is off screen");
		}
		
	}
	
	public boolean overlapsWith(Hero hero)
	{
		return true;
	}

	@Override
	protected void overlapping() {
		return;
	}

	@Override
	protected boolean isCoin() {
		// TODO Auto-generated method stub
		return false;
	}
}