package mainApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class gameComp extends JComponent {
	Hero hero = new Hero(100, 500, 50, 50, 20);
	JLabel label;

	ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private int xForBarrier = 400;
	Random random = new Random();
	protected int level = 1;
	final int MAX_LEVEL = 5;
	private int counterCoin = 0;
	protected int livesLeft = 3;

	public gameComp() {
		this.loadFile(1);
	}

	public void loadFile(int level) {
		try {
			FileInputStream fileIn = new FileInputStream("level" + level + ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList<GameObject> e = (ArrayList<GameObject>) in.readObject();
			objects = e;
			in.close();
			fileIn.close();

		} catch (FileNotFoundException e) {
			System.err.println("File not found for level " + level);
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Class not found");
		}

	}

	public boolean levelOver() {
		System.out.println(objects.size());
		return objects.size() == 0;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		for (GameObject i : objects) {
			i.drawOn(g2);
		}

		hero.drawOn(g2);
	}

	public void update() {
		
		for (GameObject b : this.objects) {
			b.update();
			
			if(hero.x < 100)
			{
				hero.x += 1;
			}
			
			if(hero.getIsOffScreen())
			{
				subtractLife();
			}
		}
		
		for (GameObject b : this.objects) {

			if(b.overlapsWith(hero))
			{
			b.overlapping();
			}
			
			
			if(b.isHomingMissile())
			{
				if(((HomingMissile) b).decreaseTimer() == 0)
				{
					objects.add(new Missile(((HomingMissile) b).yCord(),1300, 75, 50, 40));
					objects.remove(objects.indexOf(b));
				}
				
				if (((HomingMissile) b).updateWarning(hero) > 0) {
					continue;
				}
				
			}
		
			if (b.overlapsWith(hero)) {				
				
				b.overlapping();
				
				if (b.isMissile()) {
					this.loadFile(level);
					System.out.println("Missle Hit *************************************\nRestart Level");
					
					subtractLife();
				}
				
			}
			
			if(b.isBarrier())
			{
				
				if(((Barrier) b).overlapsWithTop(hero))
				{
					hero.y = b.y - 70;
					
//					if(((Barrier) b).isElectricBarrier())
//					{
//						subtractLife();
//					}
				}
				else if(((Barrier) b).overlapsWithBottom(hero))
				{
					hero.y = b.y + b.height - 10;
					
//					if(((Barrier) b).isElectricBarrier())
//					{
//						subtractLife();
//					}
				}
				else if(((Barrier) b).overlapsWithRight(hero))
				{
					hero.x = b.x - 51;
					
//					if(((Barrier) b).isElectricBarrier())
//					{
//						subtractLife();
//					}
				}
				
				if(((Barrier) b).overlapsWithTopLeft(hero) || ((Barrier) b).overlapsWithTopRight(hero))
				{
					hero.y = ((Barrier) b).getSecondYCoord();
					
//					if(((Barrier) b).isElectricBarrier())
//					{
//						subtractLife();
//					}
				}
				else if(((Barrier) b).overlapsWithBottomLeft(hero) || ((Barrier) b).overlapsWithBottomRight(hero))
				{
					hero.y = ((Barrier) b).getSecondYCoord() - hero.height - 20;
					
//					if(((Barrier) b).isElectricBarrier())
//					{
//						subtractLife();
//					}
				}
			}
			
		}
		
		if (objects.size() == 0) {
			level++;
			if (level <= MAX_LEVEL) {
				this.loadFile(level);
			}
			else {
				System.out.println("Game won!!!");
				GameWon won = new GameWon(counterCoin + MAX_LEVEL*100);
				won.main();
			}
		}
		
		hero.update();
			
	}
	


	public void removeThings() {
		
		ArrayList<GameObject> removeMeObjects = new ArrayList<GameObject>();
		
		// Mark them in this loop which is over objects.
				for (int i = 0; i < objects.size(); i++) {
					if (objects.get(i).overlapsWith(hero) && objects.get(i).isCoin()) {
//						objects.remove(i);
						removeMeObjects.add(objects.get(i));
						this.counterCoin++;
						this.updateLabel(counterCoin,livesLeft);
					}
					if (objects.get(i).isOffScreen()) {
						objects.remove(i);
						
					}
				}
				
				// Remove them in this loop which is over removeMeObjects
				for(GameObject objs:removeMeObjects)
				{
					objects.remove(objs);
				}
	}

	public void moveHeroUp() {
		hero.isUp(true);
		hero.update();
	}
	
	public void setLabel(JLabel label)
	{
		this.label = label;
	}
	
	public void hColor(Color heroColor)
	{
		hero.setColor(heroColor);
	}
	
	public void subtractLife()
	{
		livesLeft--;
		if(livesLeft==0)
		{
			System.out.println("GAME OVER");
			GameOver over=new GameOver();
			over.main();
		}
		this.updateLabel(counterCoin,livesLeft);
	}
	
	//thing
	public void updateLabel(int coins, int lives) {
		this.label.setText("<html><font color='white'>Coins: " + coins + "<br />Lives: " + lives + "</font></HTML>");
		 this.label.setFont(new Font("Verdana", Font.BOLD, 14));
	}//updateLabel
}
