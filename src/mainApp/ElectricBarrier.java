package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class ElectricBarrier extends Barrier
{
	private Color color;
	public ElectricBarrier(int x, int y, int width, int height, int rotation,Color color)
	{
		super(x,y,width,height,rotation, Color.PINK);
		this.color=color;
	}
	
	@Override
	public void drawOn(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		g2.rotate(Math.toRadians(rotation));
		g2.translate(super.x, super.y);
		Rectangle bar = new Rectangle(0,0,super.width,super.height);
		g2.setColor(color);
		g2.fill(bar);
		g2.draw(bar);
		g2.rotate(Math.toRadians(-rotation));
		g2.translate(-super.x, -super.y);
	}
	
//	protected void update() //
//	{
//		super.x += -super.constSpeed;
//		
//		if (super.x <0) {
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
		return super.width/2 + other.width/2 >= distance;
		
	}//overlapsWith
}



