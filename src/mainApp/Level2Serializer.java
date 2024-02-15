package mainApp;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class Level2Serializer {
	private final int height=30;
	private final int MISSILE_WIDTH = 75;
	private final int MISSILE_HEIGHT = 50;
	
	public Level2Serializer() {
		
	}
	
	public void generateFile() {
		Random random = new Random();
		int xForBarrier = 400;
		ArrayList<GameObject> objects = new ArrayList<GameObject>();

		//on screen
		objects.add(new Barrier(300, 0, 500, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(350, 2*height, 200, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(650, 2*height, 100, 2*height, 0,Color.black)); //long top
		
		objects.add(new Barrier(800, 610, 200, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(850, 610-2*height, 100, 2*height, 0,Color.black)); //long top
		
		objects.add(new Barrier(900, 200, 100, 2*height, 25,Color.black)); //long top
	

		objects.add(new ElectricBarrier(650, 320, 100, 2*height, 0, Color.pink));
		objects.add(new ElectricBarrier(700, 320+2*height, 50, 2*height, 0, Color.pink));
		
		objects.add(new ElectricBarrier(1000, 400, 300, 2*height, 0, Color.green));
		objects.add(new ElectricBarrier(1100, 400+2*height, 200, 2*height, 0, Color.green));
		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<5;j++)
			{
				objects.add(new Coin(500+(30*i), 150+(30*j)));
			}
		}
		
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<2;j++)
			{
				objects.add(new Coin(1050+(30*i), 30+(30*j)));
			}
		}
		
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<3;j++)
			{
				objects.add(new Coin(1100+(30*i), 300+(30*j)));
			}
		}
		
		
		//off screen
		objects.add(new Barrier(1200, 100, 500, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(1300, 100+2*height, 200, 2*height, 0,Color.black)); //long top
		
//		objects.add(new Barrier(1200, 610-2*height, 100, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(1250, 610, 300, 2*height, 0,Color.black)); //long top
		
		
//		
//		objects.add(new Barrier(800, 500, 200, 2*height, 0,Color.black)); //long top
//		objects.add(new Barrier(850, 610, 100, 2*height, 0,Color.black)); //long top
		
//		
//		objects.add(new ElectricBarrier(1500, 220, 150, 2*height, 0, Color.cyan));
//		objects.add(new ElectricBarrier(1600, 220+2*height, 100, 2*height, 0, Color.cyan));
		
		objects.add(new ElectricBarrier(1600, 610-2*height, 300, 2*height, 0, Color.BLUE));
		objects.add(new ElectricBarrier(1650, 610, 200, 2*height, 0, Color.BLUE));
		
		objects.add(new Missile(2000, 300, MISSILE_HEIGHT, MISSILE_HEIGHT, 20));
		objects.add(new Missile(1000, 500, MISSILE_HEIGHT, MISSILE_HEIGHT, 20));
		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<3;j++)
			{
				objects.add(new Coin(2100+(30*i), 350+(30*j)));
			}
		}
		
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<5;j++)
			{
				objects.add(new Coin(2450+(30*i), 450+(30*j)));
			}
		}
		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<4;j++)
			{
				objects.add(new Coin(2200+(30*i), 50+(30*j)));
			}
		}
		
		
		objects.add(new Barrier(1700, 250, 400, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(1850, 250+2*height, 200, 2*height, 0,Color.black)); //long top
		
//	objects.add(new Barrier(1900, 610-2*height, 100, 2*height, 0,Color.black)); //long top
//	objects.add(new Barrier(1950, 610, 200, 2*height, 0,Color.black)); //long top
//		
//		
		
		
		objects.add(new Barrier(1900, 250, 200, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(1950, 250+2*height, 100, 2*height, 0,Color.black)); //long top
		
		//objects.add(new Barrier(1900, 400, 100, 2*height, 0,Color.black)); //long top
	
		

		objects.add(new ElectricBarrier(1900, 0, 200, 2*height, 0, Color.magenta));
		objects.add(new ElectricBarrier(2000, 2*height, 150, 2*height, 0, Color.magenta));
		
		objects.add(new ElectricBarrier(2100, 610-2*height, 200, 2*height, 0, Color.ORANGE));
		objects.add(new ElectricBarrier(2150, 610, 200, 2*height, 0, Color.ORANGE));
		
		
		//further off screen
		
		objects.add(new Barrier(2200, 200, 250, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(2300, 200+2*height, 300, 2*height, 0,Color.black)); //long top
		
//		objects.add(new Barrier(2200, 580, 200, 2*height, 0,Color.black)); //long top
//		objects.add(new Barrier(2350, 580+2*height, 350, 2*height, 0,Color.black)); //long top
//		
		
		objects.add(new Barrier(2450, 320, 150, 2*height, 0,Color.black)); //long top
	
		objects.add(new ElectricBarrier(3000, 200, 200, 2*height, 0, Color.magenta));
		objects.add(new ElectricBarrier(3100, 200+2*height, 100, 2*height, 0, Color.magenta));

		objects.add(new Barrier(2600, 0, 250, 2*height, 0, Color.black));
		objects.add(new Barrier(2800, 250+2*height, 150, 2*height, 0, Color.black));
		
		objects.add(new ElectricBarrier(2700, 610-2*height, 300, 2*height, 0, Color.BLUE));
		objects.add(new ElectricBarrier(2800, 610, 250, 2*height, 0, Color.BLUE));
		
		
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<4;j++)
			{
				objects.add(new Coin(3000+(30*i), 20+(30*j)));
			}
		}
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++)
			{
				objects.add(new Coin(1600+(40*i), 370+(40*j)));
			}
		}
	
//		
	//	objects.add(new Missile(400, 75, 50, 40));
		
		
		
		try {
			FileOutputStream fileOut = new FileOutputStream("level2.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(objects);

			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in /tmp/level.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}
