package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;

/**
 * Class: Hero 
 */

public class Hero implements Serializable{

	private int constSpeed=10;
	protected int x, y, width, height;
	
	public Hero()
	{
		this.constSpeed=20;
		this.x = 100;
		this.y = 100;
		this.width = 50;
		this.height = 50;
	}
	
	
	public void drawOn(Graphics g) {
		Graphics2D g2=(Graphics2D) g;
		
		Rectangle heroBox=new Rectangle(x, y, 50, 50);
		g2.setColor(Color.BLACK);
		g2.fill(heroBox);
		g2.draw(heroBox);
	}
	

	public void update() //
	{
		y -= constSpeed;
		
		if(y < 0)
		{
			y=0;
			System.out.println("WEEE is off screen");
		}
		
	}
	
	  
	
}