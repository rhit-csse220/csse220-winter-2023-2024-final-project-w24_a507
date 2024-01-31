package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

public abstract class Object {
	private int x, y, constantSpeed;
	private Color color;
	private Shape shape;
	
	public Object(int x, int y, int constantSpeed, Color color, Shape shape)
	{
		this.x = x;
		this.y = y;
		this.constantSpeed = constantSpeed;
		this.color = color;
		this.shape = shape;
	}
	
	public void drawOn(Graphics2D g)
	{
		g.setColor(this.color);
		g.fill(shape);
		g.setColor(Color.BLACK);
		g.draw(shape);
	}
	
	public void update()
	{
		x -= constantSpeed;
		
		if(x < 0)
		{
			System.out.println("Object is off screen");
		}
	}
}