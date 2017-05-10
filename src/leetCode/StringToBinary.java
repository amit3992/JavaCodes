package leetCode;
import java.util.*;
import java.io.*;

public class StringToBinary {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		byte[] info = line.getBytes("UTF-8");
		for(byte b : info) {
			System.out.println((char) b + " -> " + Integer.toBinaryString(b));
		}

	}

}
