package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Dimension2D;
import java.io.Serializable;

public class Barrier extends Object implements Serializable{
	
	protected int rotation;
	Color colorOfBarrier = Color.CYAN;
	
	public Barrier(int x, int y, int width, int height, int rotation)
	{
		super(x, y, width, height, Color.CYAN, 10);
		this.rotation=rotation;
	}
	
	public Barrier(int x, int y, int width, int height, int rotation, Color colorOfBarrier)
	{
		super(x, y, width, height, colorOfBarrier, 10);
		this.rotation=rotation;
	}
	
	@Override
	public void drawOn(Graphics2D g) {
		g.translate(super.x, super.y);
		g.rotate(Math.toRadians(rotation));
		Rectangle bar = new Rectangle(0,0,super.width,super.height);
		g.setColor(colorOfBarrier);
		g.fill(bar);
		g.draw(bar);
		g.rotate(Math.toRadians(-rotation));
		g.translate(-super.x, -super.y);
	}
	
	@Override
	public boolean overlapsWith(Hero other) {
		int xDiff =  super.x - other.x;
		int yDiff =  super.y - other.y;
		double distance = Math.sqrt(  xDiff*xDiff + yDiff * yDiff );
		return this.width/2 + other.width/2 >= distance;
		
	}//overlapsWith
	
	@Override
	protected void overlapping() {
		System.out.println("PLAYER WAS HIT");		
	}

	@Override
	protected boolean isCoin() {
		return false;
	}
}
