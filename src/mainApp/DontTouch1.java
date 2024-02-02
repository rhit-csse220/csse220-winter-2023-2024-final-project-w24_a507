package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

public class DontTouch1 extends Object implements Serializable{ //coin

	private static int width=20;
	private static int height=20;
	
	public DontTouch1(int x,int y)
	{
		super(x, y, width, height, Color.YELLOW,10);
	}
	
	@Override
	public void drawOn(Graphics2D g)
	{
		Graphics2D g2=(Graphics2D) g;
		Ellipse2D.Double coin1=new Ellipse2D.Double(super.x, super.y, width, height);
		g2.setColor(super.color);
		g2.fill(coin1);
		g2.draw(coin1);
	}

	@Override
	protected boolean overlapsWith(Hero hero) {
		int xDiff =  super.x - hero.x;
		int yDiff =  super.y - hero.y;
		double distance = Math.sqrt(  xDiff*xDiff + yDiff * yDiff );
		return this.width/2 + hero.width/2 >= distance;
	
	}

	@Override
	protected void overlapping() {
		System.out.println("Coin was collected");
	}
}
