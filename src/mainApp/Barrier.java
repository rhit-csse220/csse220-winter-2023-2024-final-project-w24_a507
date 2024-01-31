package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Dimension2D;
import java.io.Serializable;



public class Barrier extends Object implements Serializable{
	
	

	protected int width,height,rotation;
	Color colorOfBarrier = Color.CYAN;
	protected int constSpeed;
	
	public Barrier(int x, int y, int width, int height, int rotation)
	{
		super(x, y, Color.CYAN, 10);
		this.width=width;
		this.height=height;
		this.rotation=rotation;
	}
	
	protected void drawOn(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.translate(super.x, super.y);
		Rectangle bar = new Rectangle(0,0,width,height);
		g2.setColor(colorOfBarrier);
		g2.fill(bar);
		g2.draw(bar);
		
		g2.translate(-super.x, -super.y);
	}
	
//	protected void update() //
//	{
//		x += -constSpeed;
//		
//		if (x <0) {
//			//delete barrier, off screen
//			System.out.println("Barrier off screen");
//		}
//		
//	}
	
	public boolean overlapsWith(Hero other) 
	{
		int xDiff =  super.x - other.x;
		int yDiff =  super.y - other.y;
		double distance = Math.sqrt(  xDiff*xDiff + yDiff * yDiff );
		return this.width/2 + other.width/2 >= distance;
		
	}//overlapsWith
}
