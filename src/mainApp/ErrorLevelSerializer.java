package mainApp;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class ErrorLevelSerializer {
	public ErrorLevelSerializer() {

	}

	public void generateFile() {
		Random random = new Random();
		int xForBarrier = 400;
		ArrayList<String> objects = new ArrayList<String>();
		objects.add(new String("hi"));

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
