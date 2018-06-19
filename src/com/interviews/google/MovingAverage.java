package com.interviews.google;
import java.util.*;

public class MovingAverage {
	
	LinkedList<Integer> queue;
	int size;
	double avg;
	
	public MovingAverage(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		queue = new LinkedList<>();
	}
	
	public double next(int val) {
        if(queue.size()<this.size){
            
        	queue.offer(val);
            
            int sum=0;
            
            for(int i: queue){
                sum+=i;
            }
            
            avg = (double)sum/queue.size();
 
            return avg;
        }else{
            
        	int head = queue.poll();
            
            double minus = (double)head/this.size;
            queue.offer(val);
            
            double add = (double)val/this.size;
            avg = avg + add - minus;
            
            return avg;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
