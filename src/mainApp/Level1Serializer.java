package mainApp;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class Level1Serializer {
	
	private final int BARRIER_HEIGHT = 30;
	private final Color ELECTRIC_BARRIER = Color.pink;
	private final int COIN_GROUND = 625;
	private final int MISSILE_WIDTH = 75;
	private final int MISSILE_HEIGHT = 50;
	
	public Level1Serializer() {
		
	}
	
	public void generateFile() {
		Random random = new Random();
		ArrayList<GameObject> objects = new ArrayList<GameObject>();
		
		objects.add(new Barrier(700,600,200,BARRIER_HEIGHT,0));
		
		objects.add(new ElectricBarrier(1050,450,100,BARRIER_HEIGHT,25,ELECTRIC_BARRIER));
		
		objects.add(new Barrier(1500,20,150,BARRIER_HEIGHT,-20));
		
		for (int i = 1; i <= 3; i++) {
			objects.add(new Coin(500+i*100, 450));
		}
		
		for (int i = 1; i <= 4; i++) {
			objects.add(new Coin(900 + i*100, 450 - i*75));
		}
		
		//Player Rest for 500 Pixels ************************************************//
		
		for (int i = 1; i <= 4; i++) {
			objects.add(new Coin(1700 + i*100, COIN_GROUND));
		}
		
		objects.add(new Barrier(2200,700,200,BARRIER_HEIGHT,40));
		
		objects.add(new Barrier(2300, 200, 300, BARRIER_HEIGHT, -20));
		
		objects.add(new ElectricBarrier(2600, 500, 400, BARRIER_HEIGHT, 0, ELECTRIC_BARRIER));
		
		for(int i = 1; i<=4; i++) {
			objects.add(new Coin(2600 + 100*i, 400));
		}
		
		for(int i = 1; i<=8; i++) {
			objects.add(new Coin(3000 + i*100, 400-i*50));
			objects.add(new Coin(3050 + i*100, 450-i*50));
		}
		
		objects.add(new ElectricBarrier(3250,450,500,BARRIER_HEIGHT,25,ELECTRIC_BARRIER));
		
		objects.add(new HomingMissile(MISSILE_WIDTH, MISSILE_HEIGHT, 40));
		
		
		try {
	         FileOutputStream fileOut = new FileOutputStream("level1.ser");
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
