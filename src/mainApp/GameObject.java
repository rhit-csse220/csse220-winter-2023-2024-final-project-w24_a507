 package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public abstract class GameObject implements Serializable {
	protected int x, y, constantSpeed, width, height;
	protected Color color;
	protected boolean offScreen;
	
	public GameObject(int x, int y, int width, int height, Color color, int constantSpeed)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.constantSpeed = constantSpeed;
		this.offScreen=false;
	}
	
	abstract public void drawOn(Graphics2D g);
	
	public void update()
	{
		x -= constantSpeed;
		
		if(x < 0)
		{
			offScreen=true;
		//	System.out.println("Object is off screen");
		}
	}
	
	protected boolean isOffScreen() {
		return offScreen;
	}

	protected abstract boolean overlapsWith(Hero hero);
	protected abstract void overlapping();
	protected boolean isCoin()
	{
		return false;
	}
	
	protected boolean isHomingMissile()
	{
		return false;
	}
}
