package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

public class gameComp extends JComponent {
	Hero hero = new Hero();
	ArrayList<Object> objects = new ArrayList<Object>();
	private int xForBarrier = 400;
	Random random = new Random();


	public gameComp(int level) {

		try {
			FileInputStream fileIn = new FileInputStream("level" + level + ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList<Object> e = (ArrayList<Object>) in.readObject();
			objects = e;
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		for (Object i : objects) {
			i.drawOn(g2);
		}

		hero.drawOn(g2);
	}
<<<<<<< HEAD
	
	public void update()
	{
		
		for (Barrier b: this.barriers) {
=======

	public void update() {
		for (Object b : this.objects) {
>>>>>>> branch 'master' of https://github.com/rhit-csse220/csse220-winter-2023-2024-final-project-w24_a507.git
			b.update();
<<<<<<< HEAD
			
		}
		
		for(DontTouch1 c: this.coins)
		{
			c.update();
=======
>>>>>>> branch 'master' of https://github.com/rhit-csse220/csse220-winter-2023-2024-final-project-w24_a507.git
		}
<<<<<<< HEAD
		
		for (Barrier b: this.barriers) {
			if (b.overlapsWith(hero) ) {
			//	System.out.println("PLAYER WAS HIT");
=======

		for (Object b : this.objects) {
			if (b.overlapsWith(hero)) {
				System.out.println("PLAYER WAS HIT");

>>>>>>> branch 'master' of https://github.com/rhit-csse220/csse220-winter-2023-2024-final-project-w24_a507.git
			}
		}
<<<<<<< HEAD
		for(DontTouch1 c: this.coins) {
			if(c.overlapsWith(hero))
			{
				//delete coin bc hero collected it	
			//	System.out.println("Coin was collected");
=======

		for (Object c : this.objects) {
			if (c.overlapsWith(hero)) {
				System.out.println("Coin was collected");
>>>>>>> branch 'master' of https://github.com/rhit-csse220/csse220-winter-2023-2024-final-project-w24_a507.git
			}
		}
	}
<<<<<<< HEAD
	
public void removeThings()
{
	
	for(int b=0;b<barriers.size();b++)
	{
		if(barriers.get(b).offScreen)
		{
			barriers.remove(b);
			//remove
		}
	}
	//System.out.println(barriers.size());
	
	
	for(int c=0;c<coins.size();c++)
		if(coins.get(c).overlapsWith(hero))
		{
			coins.remove(c);
			//delete coin bc hero collected it	
		}
	}
=======
>>>>>>> branch 'master' of https://github.com/rhit-csse220/csse220-winter-2023-2024-final-project-w24_a507.git


public void moveHero()
{
		hero.update();
}
}

