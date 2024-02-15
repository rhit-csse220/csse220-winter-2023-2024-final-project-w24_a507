package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;

public class HomingMissile extends Missile {
	
	private int timer;
	
	public HomingMissile(int width, int height, int constantSpeed, int timer)
	{
		super(width, height, Color.RED, constantSpeed);
		this.timer = timer;
	}
	
	public int updateWarning(Hero hero)
	{
		if (timer <= 0)
			return 0;
		super.y = hero.y;
		return decreaseTimer();
	}
	
	protected boolean isHomingMissile()
	{
		return true;
	}
	
	public int decreaseTimer()
	{
		timer -= 1;
		return timer;
	}
	
	public int yCord()
	{
		return super.y;
	}
}
