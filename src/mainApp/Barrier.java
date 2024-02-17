package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Dimension2D;
import java.io.Serializable;

public class Barrier extends GameObject implements Serializable{
	
	protected int rotation;
	Color colorOfBarrier;
	private double firstXCoord;
	private double firstYCoord;
	private double secondXCoord;
	private double secondYCoord;
	public static boolean isMoving = true;
	
	public Barrier(int x, int y, int width, int height, int rotation)
	{
		super(x, y, width, height, Color.CYAN, 10);
		this.rotation=-rotation;
		this.colorOfBarrier = Color.CYAN;
	}
	
	public Barrier(int x, int y, int width, int height, int rotation, Color colorOfBarrier)
	{
		super(x, y, width, height, colorOfBarrier, 10);
		this.rotation=-rotation;
		this.colorOfBarrier = colorOfBarrier;
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
	
	public void update()
	{
		if(isMoving)
		{
			super.x -= super.constantSpeed;
			
			if(super.x + super.width * Math.cos(Math.toRadians(rotation)) < 0)
			{
				offScreen=true;
			//	System.out.println("Object is off screen");
			}
		}
	}
	
	@Override
	public boolean overlapsWith(Hero hero)
	{
		return false;
	}//overlapsWith
	
	public boolean overlapsWithTopLeft(Hero other)
	{
		firstXCoord = super.x + Math.sin(Math.toRadians(rotation)) * super.height;
		firstYCoord = super.y + Math.cos(Math.toRadians(rotation)) * super.height;
		
		secondXCoord = firstXCoord + Math.cos(Math.toRadians(rotation)) * super.width;
		secondYCoord = firstYCoord + Math.tan(Math.toRadians(rotation)) * (other.x - firstXCoord);
		
		if(other.x >= firstXCoord && other.x <= secondXCoord && other.y <= firstYCoord && other.y >= secondYCoord)
		{
			return true;
		}
		else
		{
			return false;
		}
			
	}
	
	public boolean overlapsWithTopRight(Hero other)
	{
		int heroXRight = other.x + other.width;
		
		firstXCoord = super.x - Math.sin(Math.toRadians(rotation)) * super.height;
		firstYCoord = super.y + Math.cos(Math.toRadians(rotation)) * super.height;
		
		secondXCoord = firstXCoord + Math.cos(Math.toRadians(rotation)) * super.width;
		secondYCoord = firstYCoord + Math.tan(Math.toRadians(rotation)) * (heroXRight - firstXCoord);
		
		if(heroXRight >= firstXCoord && heroXRight <= secondXCoord && other.y >= firstYCoord && other.y <= secondYCoord)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean overlapsWithBottomLeft(Hero other)
	{
		int heroYBottom = other.y + other.height;
		
		secondXCoord = super.x + Math.cos(Math.toRadians(rotation)) * super.width;
		secondYCoord = super.y + Math.tan(Math.toRadians(rotation)) * (other.x - super.x);
		
		if(other.x >= super.x && other.x <= secondXCoord && heroYBottom >= super.y && heroYBottom <= secondYCoord)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean overlapsWithBottomRight(Hero other)
	{
		int heroXRight = other.x + other.width;
		int heroYBottom = other.y + other.height;
		
		secondXCoord = super.x + Math.cos(Math.toRadians(rotation)) * super.width;
		secondYCoord = super.y + Math.tan(Math.toRadians(rotation)) * (heroXRight - super.x);
		
		if(heroXRight >= super.x && heroXRight <= secondXCoord && heroYBottom <= super.y && heroYBottom >= secondYCoord)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean overlapsWithRight(Hero other)
	{
		int heroXRight = other.x + other.width;
		int heroYBottom = other.y + other.height;
		
		if(heroXRight >= super.x && other.x <= super.x &&
				other.y <= super.y && heroYBottom >= super.y ||
				heroXRight >= firstXCoord && other.x <= super.x &&
				other.y <= firstYCoord && heroYBottom >= firstYCoord)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean overlapsWithTop(Hero other)
	{
		int heroXRight = other.x + other.width;
		int heroYBottom = other.y + other.height;
		
		if(heroXRight >= super.x && other.x <= super.x + super.width &&
				heroYBottom >= super.y && heroYBottom <= super.y + super.height && rotation == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean overlapsWithBottom(Hero other)
	{
		int heroXRight = other.x + other.width;
		
		if(heroXRight >= super.x && other.x <= super.x + super.width &&
				other.y <= super.y + super.height && other.y >= super.y && rotation == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	protected void overlapping() {
	//	System.out.println("PLAYER WAS HIT");		
	}
	
	protected boolean isBarrier()
	{
		return true;
	}
	
	public int getSecondYCoord()
	{
		return (int) secondYCoord;
	}
}
