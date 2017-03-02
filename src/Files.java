import java.io.File;
import java.util.*;

public class Files {
		
	private static String removeVersion(String fileName) {
		
		int len = fileName.length();
		String file = fileName.substring(0,len-4);
        String editedString = "";
        
        if(fileName.contains("HG_ACCESSORIES_V26")) {
        	editedString = fileName.replace("HG_ACCESSORIES_V26","HG_ACCESSORIES_");
        }
        
        else if(fileName.contains("HG_COVERAGE_V6")) {
        	editedString = fileName.replace("HG_COVERAGE_V6","HG_COVERAGE_");
        }
        
        else if(fileName.contains("HG_GPR_V3")) {
        	editedString = fileName.replace("HG_GPR_V3","HG_GPR_");
        }
        
        else if(fileName.contains("HG_HOME_PHONE_V5")) {
        	editedString = fileName.replace("HG_HOME_PHONE_V5","HG_HOME_PHONE_");
        }
        
        else if(fileName.contains("HG_MI_V12")) {
        	editedString = fileName.replace("HG_MI_V12","HG_MI_");
        }
        
        else if(fileName.contains("HG_HANDSETS_V27")) {
        	editedString = fileName.replace("HG_HANDSETS_V27","HG_HANDSETS_");
        }
        
        else if(fileName.contains("HG_SIM_V11")) {
        	editedString = fileName.replace("HG_SIM_V11","HG_SIM_");
        }
        
        else if(fileName.contains("HG_TABLETS_V16")) {
        	editedString = fileName.replace("HG_TABLETS_V16","HG_TABLETS_");
        }
        
        else if(fileName.contains("HG_VOUCHERS_V17")) {
        	editedString = fileName.replace("HG_VOUCHERS_V17","HG_VOUCHERS_");
        }
        
        else if(fileName.contains("HG_WEARABLE_V11")) {
        	editedString = fileName.replace("HG_WEARABLE_V11","HG_WEARABLE_");
        }
        
       return editedString;
	}
	
	private static boolean renameFiles(String sqlFolderPath) {
		
		//String absolutePath = "C:\\Users\\eamikul\\Documents\Projects\EPC\ORDToECMTest\ORD Library\December\12.16\\Output_\\SQL";
        File dir = new File(sqlFolderPath);
        File[] filesInDir = dir.listFiles();
        int i = 0;
        for(File file:filesInDir) {
            i++;
            System.out.println("============================================");
            String name = file.getName();
            System.out.println("File name processing: " + name);
            //String newName = "my_file_" + i + ".sql";
            String newName = removeVersion(name);
            String newPath = sqlFolderPath + "\\" + newName;
            file.renameTo(new File(newPath));
            System.out.println(name + " changed to " + newName);
        }
        
        System.out.println("\nTotal files renamed: " + i);
        
        return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//listFileNames();
		if(renameFiles("F:\\Projects\\EPC\\ORDToECMTest\\ORD Library\\DeltaTest\\SQL"))
			System.out.println("Conversion complete!");

	}

}
