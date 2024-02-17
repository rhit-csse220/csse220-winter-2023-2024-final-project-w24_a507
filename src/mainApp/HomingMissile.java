package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;

/**
 * Class: HomingMissile
 * 
 * @author Bennett <br>
 *         Purpose: Used to create Homing Missiles <br>
 *         Restrictions: Cannot be used for regular Missiles <br>
 *         For example:
 * 
 *         <pre>
 *         HomingMissile missile = new Missile(2000, 500, 50, 1000);
 *         </pre>
 */

public class HomingMissile extends Missile {

	private int timer;

	public HomingMissile(int width, int height, int constantSpeed, int timer) {
		super(width, height, Color.RED, constantSpeed);
		this.timer = timer;
	}

	/**
	 * ensures: If the timer is greater than 0 the missile warning is set to the
	 * hero y and decrease timer is called
	 * 
	 * @param hero
	 * @return The result of decreaseTimer();
	 */
	public int updateWarning(Hero hero) {
		if (timer <= 0)
			return 0;
		super.y = hero.y;
		return decreaseTimer();
	}

	/**
	 * ensures: Returns true because it is a Homing Missile
	 */
	protected boolean isHomingMissile() {
		return true;
	}

	/**
	 * @return timer - 1
	 */
	public int decreaseTimer() {
		timer -= 1;
		return timer;
	}

	/**
	 * @return y coordinate of the homing missile
	 */
	public int yCord() {
		return super.y;
	}
}
