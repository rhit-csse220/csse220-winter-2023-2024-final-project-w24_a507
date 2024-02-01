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
	ArrayList<Object> objects = new ArrayList<Object>();
	private int xForBarrier=400;
	Random random = new Random();
	
	public gameComp(){
		

		/*
		objects.add(new Barrier(xForBarrier,random.nextInt(700),50,50,0));
		
		objects.add(new Barrier(xForBarrier,100,50,50,0));
		
		objects.add(new Barrier(xForBarrier,random.nextInt(700),50,50,0));
		
		objects.add(new Barrier(xForBarrier,random.nextInt(700),50,50,0));

		objects.add(new ElectricBarrier(xForBarrier,random.nextInt(700),50,50,0,Color.pink));
		
		*/
		
		try {
	        FileInputStream fileIn = new FileInputStream("level.ser");
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
		
		
		
		for(Object i : objects)
		{
			i.drawOn(g2);
		}
	
		
		hero.drawOn(g2);
	}
	
	public void update()
	{
		for (Object b: this.objects) {
			b.update();
		}	
		
		for (Object b: this.objects) {
			if (b.overlapsWith(hero) ) {
				System.out.println("PLAYER WAS HIT");
				
			}
	}
		
		
		for(Object c: this.objects) {
			if(c.overlapsWith(hero))
			{
				System.out.println("Coin was collected");
			}
		}
	}
	
	

}
