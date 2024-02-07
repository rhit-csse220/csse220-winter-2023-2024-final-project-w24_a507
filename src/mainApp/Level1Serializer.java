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
	
	public Level1Serializer() {
		
	}
	
	public void generateFile() {
		Random random = new Random();
		ArrayList<GameObject> objects = new ArrayList<GameObject>();
		
		objects.add(new Barrier(500,600,200,BARRIER_HEIGHT,45));
		
		objects.add(new ElectricBarrier(700,450,100,BARRIER_HEIGHT,45,ELECTRIC_BARRIER));
		
		/*objects.add(new Barrier(650,500,400,50,30));
		
		objects.add(new Barrier(650,200,50,30,50));
		
		objects.add(new ElectricBarrier(400,50,50,20,0,ELECTRIC_BARRIER));*/
		
		objects.add(new Coin(300, 450));
		
		objects.add(new Coin(400, 450));
		
		objects.add(new Coin(500, 450));
		
		for (int i = 1; i <= 4; i++) {
			objects.add(new Coin(700 + i*100, 450 - i*75));
		}
		
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
