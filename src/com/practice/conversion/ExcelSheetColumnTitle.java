package com.practice.conversion;

public class ExcelSheetColumnTitle {
		
	public String getColumnTitle(int n) {
		
		 StringBuilder result = new StringBuilder();

	        while(n>0){
	            n--;
	            System.out.println("Rem -> " + n % 26);
	            result.insert(0, (char)('A' + n % 26));
	            n /= 26;
	        }

	        return result.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();
		System.out.println("Column title -> " + esct.getColumnTitle(26));

	}

}
