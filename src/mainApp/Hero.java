package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;

/**
 * Class: Hero 
 */

public class Hero extends GameObject implements Serializable{
	private boolean up=false;
	
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
		if(up)
		{
		y -= super.constantSpeed;
		
		if(y < 0)
		{
			y=0;
			System.out.println("WEEE is off screen");
		}
		}
		else 
		{
			y+=5;
			if(y>700-85)
			{
				y=700-85;
			}
		}
		this.up=false;
		
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
	
	protected void isUp(boolean up)
	{
		this.up=up;
	}

}