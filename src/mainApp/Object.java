package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public abstract class Object implements Serializable{
	protected int x, y, constantSpeed;
	protected Color color;
	
	public Object(int x, int y, Color color, int constantSpeed)
	{
		this.x = x;
		this.y = y;
		this.color = color;
		this.constantSpeed = constantSpeed;
	}
	
	public void drawOn(Graphics2D g)
	{
		
	}
	
	public void update()
	{
		x -= constantSpeed;
		
		if(x < 0)
		{
			System.out.println("Object is off screen");
		}
	}

	protected abstract boolean overlapsWith(Hero hero);
}