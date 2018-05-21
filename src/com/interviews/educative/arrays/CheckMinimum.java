package com.interviews.educative.arrays;

class CheckMinimum{
	  
	   public static int findMinimum(int[] arr){
	    
	        /* Null check */
	        if(arr == null || arr.length == 0) {
	          return -1;
	        }
	        
	        int min = arr[0];
	        for(int i = 1; i < arr.length; i++) {
	          if(arr[i] < min) {
	            min = arr[i];
	          }
	        }
	     
	        return min;        
	    }
	}