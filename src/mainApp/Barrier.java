package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Dimension2D;
import java.io.Serializable;



public class Barrier implements Serializable{
	
	

	private int x,y,width,height,rotation;
	Color colorOfBarrier;
	private int constSpeed;
	
	public Barrier(int x, int y, int width, int height, int rotation)
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.rotation=rotation;
		this.colorOfBarrier=Color.CYAN;
		this.constSpeed=10;
		
		
	}
	
	
	protected void drawOn(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.translate(x, y);
		Rectangle bar = new Rectangle(0,0,width,height);
		g2.setColor(colorOfBarrier);
		g2.fill(bar);
		g2.draw(bar);
		
		g2.translate(-x, -y);
	}
	
	protected void update() //
	{
		x += -constSpeed;
		
		if (x <0) {
			//delete barrier, off screen
			System.out.println("Barrier off screen");
		}
		
	}
	
	public boolean overlapsWith(Hero other) 
	{
		int xDiff =  x - other.x;
		int yDiff =  y - other.y;
		double distance = Math.sqrt(  xDiff*xDiff + yDiff * yDiff );
		return this.width/2 + other.width/2 >= distance;
		
	}//overlapsWith
}
