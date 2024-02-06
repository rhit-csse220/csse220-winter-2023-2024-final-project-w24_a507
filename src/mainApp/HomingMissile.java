package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;

public class HomingMissile extends Missile {
	
	public HomingMissile(int y, int width, int height, int constantSpeed)
	{
		super(y, width, height, Color.RED, constantSpeed);
	}
}
