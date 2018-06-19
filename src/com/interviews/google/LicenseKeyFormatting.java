package com.interviews.google;
import java.util.*;

public class LicenseKeyFormatting {

	
	public String licenseKeyFormatting(String S, int K) {
		
		StringBuilder result = new StringBuilder();
	    int count =0;
	    for(int i=S.length()-1;i>=0;i--){
	        
	        if(S.charAt(i) == '-') continue;
	        else if(count < K & i>=0){
	            
	            result.append(S.substring(i,i+1));
	            count++;
	            
	        }else{
	            count = 0;
	            result.append('-');
	            i++;
	        }
	    }
	    
	    result = result.reverse();
	    return result.toString().toUpperCase();
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LicenseKeyFormatting lkf = new LicenseKeyFormatting();
		String key1 = "5F3Z-2e-9-w";
		String key2 = "2-5g-3-J";
		
		System.out.println("Formatted key -> " + lkf.licenseKeyFormatting(key2, 2));

	}

}
