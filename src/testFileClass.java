import java.util.*;
import java.io.*;

public class testFileClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File logFile = new File("F:/My Learning Stuff/Java Project/logFile.2017-02-27.log");
		int count = 0;
		try {
			Scanner sc = new Scanner(logFile);
			StringBuilder sb = new StringBuilder("errors: 0");
			
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				if(line.indexOf(sb.toString()) != -1) {
					count++;
				}
			}
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}
		System.out.println("Count: " + count);

	}

}
