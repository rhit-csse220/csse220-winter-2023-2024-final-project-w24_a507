package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;

import org.w3c.dom.css.RGBColor;

/**
 * Class: Hero 
 */

public class Hero extends GameObject implements Serializable{
	private boolean up=false;
	private Color heroColor = new Color(97, 75, 164);
	private boolean isOffScreen = false;
	
	public Hero(int x, int y, int width, int height, int constSpeed)
	{
		super(x, y, width, height, Color.BLACK, constSpeed);
	}
	
	public void drawOn(Graphics2D g) {
		
		Rectangle heroBox=new Rectangle(x, y, 50, 50);
		g.setColor(heroColor);
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
			//System.out.println("WEEE is off screen");
		}
		}
		else 
		{
			y+=20;
			if(y>700-120)

			y+=10;
			if(y>620)
			{
				y=620;
			}
		}
		this.up=false;
		
		if(super.x + super.width < 0)
		{
			isOffScreen = true;
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
	
	protected void isUp(boolean up)
	{
		this.up=up;
	}
	protected void setColor(Color color)
	{
		this.heroColor=color;
	}
	
	public boolean getIsOffScreen()
	{
		return isOffScreen;
	}

}