package code;

import java.io.*;
import java.util.*;


public class BufferedReaderTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
			File file = new File(args[0]);
	        BufferedReader buffer = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = buffer.readLine()) != null) {
	            line = line.trim();
	            // Process line of input Here
	            System.out.println(line);
	}

}
}
