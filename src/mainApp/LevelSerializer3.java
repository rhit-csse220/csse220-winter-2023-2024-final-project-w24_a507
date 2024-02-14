package mainApp;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class LevelSerializer3 {
	private final int height=30;
	
	public LevelSerializer3() {
		
	}
	
	public void generateFile() {
		Random random = new Random();
		int xForBarrier = 400;
		ArrayList<GameObject> objects = new ArrayList<GameObject>();

		//on screen
		objects.add(new Barrier(200, 0, 300, 2*height, 0,Color.black)); //long top
		
		objects.add(new Barrier(500, 4*height, 200, 2*height, 0,Color.black)); //long top
		
		objects.add(new Barrier(250, 300, 100, 2*height, 25,Color.black)); //diagnoal down
		
		
		objects.add(new Barrier(200, 500, 200, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(250, 500-2*height, 100, 2*height, 0,Color.black)); //middle big
		
		objects.add(new Barrier(100, 700-2*height, 300, 2*height, 25,Color.black)); //bottom
	
		
		

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
		
		objects.add(new Barrier(1200, 550, 100, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(1250, 550+2*height, 200, 2*height, 0,Color.black)); //long top
		
		
		
		objects.add(new Barrier(800, 500, 200, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(850, 500+2*height, 100, 2*height, 0,Color.black)); //long top
		
		
		objects.add(new ElectricBarrier(1300, 220, 150, 2*height, 0, Color.cyan));
		objects.add(new ElectricBarrier(1400, 220+2*height, 50, 2*height, 0, Color.cyan));
		
		objects.add(new ElectricBarrier(1600, 500, 300, 2*height, 0, Color.BLUE));
		objects.add(new ElectricBarrier(1650, 500+2*height, 200, 2*height, 0, Color.BLUE));
		
		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<3;j++)
			{
				objects.add(new Coin(2100+(30*i), 350+(30*j)));
			}
		}
		
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<6;j++)
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
		
		objects.add(new Barrier(1900, 550, 100, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(1950, 550+2*height, 200, 2*height, 0,Color.black)); //long top
		
		
		
		
		objects.add(new Barrier(1900, 250, 200, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(1950, 250+2*height, 100, 2*height, 0,Color.black)); //long top
		
		//objects.add(new Barrier(1900, 400, 100, 2*height, 0,Color.black)); //long top
	
		

		objects.add(new ElectricBarrier(1900, 0, 200, 2*height, 0, Color.magenta));
		objects.add(new ElectricBarrier(2000, 2*height, 150, 2*height, 0, Color.magenta));
		
		objects.add(new ElectricBarrier(2100, 450, 200, 2*height, 0, Color.ORANGE));
		objects.add(new ElectricBarrier(2150, 450+2*height, 200, 2*height, 0, Color.ORANGE));
		
		
		//further off screen
		
		objects.add(new Barrier(2200, 200, 250, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(2300, 200+2*height, 300, 2*height, 0,Color.black)); //long top
		
		objects.add(new Barrier(2200, 580, 200, 2*height, 0,Color.black)); //long top
		objects.add(new Barrier(2350, 580+2*height, 350, 2*height, 0,Color.black)); //long top
		
		
		objects.add(new Barrier(2450, 320, 150, 2*height, 0,Color.black)); //long top
	
		objects.add(new ElectricBarrier(2800, 150, 200, 2*height, 0, Color.magenta));
		objects.add(new ElectricBarrier(2900, 150+2*height, 100, 2*height, 0, Color.magenta));

		objects.add(new Barrier(2600, 0, 250, 2*height, 0, Color.black));
		objects.add(new Barrier(2800, 250+2*height, 150, 2*height, 0, Color.black));
		
		objects.add(new ElectricBarrier(3000, 450, 300, 2*height, 0, Color.BLUE));
		objects.add(new ElectricBarrier(3100, 450+2*height, 250, 2*height, 0, Color.BLUE));
		
		
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<4;j++)
			{
				objects.add(new Coin(3000+(30*i), 20+(30*j)));
			}
		}
		
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<5;j++)
			{
				objects.add(new Coin(2800+(30*i), 450+(30*j)));
			}
		}
	
		
	//	objects.add(new Missile(400, 75, 50, 40));
		
		
		
		try {
			FileOutputStream fileOut = new FileOutputStream("level3.ser");
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