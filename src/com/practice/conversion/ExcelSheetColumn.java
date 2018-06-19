package com.practice.conversion;

public class ExcelSheetColumn {
	
	public long titleToNumber(String s) {
        
        if(s == null || s.length() == 0) {
            return -1;
        }
        
        long result = 0;
        int len = s.length() - 1;
        for(int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	int val = ((int) ch - (int)'A') + 1;
        	result += Math.pow(26, len - i) * val;
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExcelSheetColumn esc = new ExcelSheetColumn();
		System.out.println("Sheet column number -> " + esc.titleToNumber("A"));

	}

}
