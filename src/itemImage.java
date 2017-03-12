import java.util.*;
import java.io.*;

public class itemImage {
	
	public static String replaceString(String displayName) {
		
		displayName = displayName.replace("&", "'||'&'||'");
        displayName = displayName.replace("'", "' || '''' || '");
        displayName = displayName.replace("’", "' || '''' || '");
        
        return displayName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File logFile = new File("F:/My Learning Stuff/Java Project/itemimage.txt");
		int count = 0;
		int pCount = 0;
		try {
			Scanner sc = new Scanner(logFile);
			StringBuilder sb = new StringBuilder("SQL Error: ORA-00917: missing comma");
			//StringBuilder sb1 = new StringBuilder("'sku_color_image_path'");
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				if(line.indexOf(sb.toString()) != -1) {
					
					count++;
				}
			}
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}
		System.out.println("count: " + count);

		String s = "B&O PLAY Bang & Olufsen Beoplay A2 Portable Bluetooth Speaker - Grey & Natural";
		System.out.println("Converted String -> " + replaceString(s));
	}

}
