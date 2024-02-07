package mainApp;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class Level2Serializer {
	
	public Level2Serializer() {
		
	}
	
	public void generateFile() {
		Random random = new Random();
		int xForBarrier = 400;
		ArrayList<GameObject> objects = new ArrayList<GameObject>();

		objects.add(new Barrier(500, 40, 50, 50, 10));

		objects.add(new Barrier(500, 200, 75, 50, 0));

		objects.add(new Barrier(650, 500, 50, 50, 30));

		objects.add(new Barrier(650, 300, 50, 30, 50));

		objects.add(new ElectricBarrier(400, 50, 50, 20, 0, Color.pink));

		objects.add(new Coin(500, 500));

		objects.add(new Coin(700, 0));

		objects.add(new Coin(900, 300));

		objects.add(new Coin(1300, 0));

		objects.add(new Coin(1700, 600));
		
		objects.add(new Missile(400, 75, 50, 40));
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
