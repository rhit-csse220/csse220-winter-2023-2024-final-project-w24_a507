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





public class gameComp extends JComponent{
	Hero hero=new Hero();
	ArrayList<Barrier> barriers = new ArrayList<Barrier>();
	ArrayList<DontTouch1> coins=new ArrayList<DontTouch1>();
	private int xForBarrier=400;
	Random random = new Random();
	
	public gameComp()
	{
		

		/*
		barriers.add(new Barrier(xForBarrier,random.nextInt(700),50,50,0));
		
		barriers.add(new Barrier(xForBarrier,100,50,50,0));
		
		barriers.add(new Barrier(xForBarrier,random.nextInt(700),50,50,0));
		
		barriers.add(new Barrier(xForBarrier,random.nextInt(700),50,50,0));

		barriers.add(new ElectricBarrier(xForBarrier,random.nextInt(700),50,50,0,Color.pink));
		
		*/
		coins.add(new DontTouch1(500,100));
		
		try {
	        FileInputStream fileIn = new FileInputStream("level.ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        ArrayList<Barrier> e = (ArrayList<Barrier>) in.readObject();
	        barriers = e;
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
		
		
		
		for(int i=0;i<barriers.size();i++)
		{
			barriers.get(i).drawOn(g);
			
		}
	//	System.out.println(coins.size());
		for(int j=0;j<coins.size();j++)
		{
			coins.get(j).drawOn(g);
			//System.out.println("herllo");
		}
		
		hero.drawOn(g2);
	}
	
	public void update()
	{
		
		for (Barrier b: this.barriers) {
			b.update();
			
		}
		
		for(DontTouch1 c: this.coins)
		{
			c.update();
		}
		
		for (Barrier b: this.barriers) {
			if (b.overlapsWith(hero) ) {
			//	System.out.println("PLAYER WAS HIT");
			}
		}
		for(DontTouch1 c: this.coins) {
			if(c.overlapsWith(hero))
			{
				//delete coin bc hero collected it	
			//	System.out.println("Coin was collected");
			}
		}
	}
	
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


public void moveHero()
{
		hero.update();
}
}

