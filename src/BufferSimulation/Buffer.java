package BufferSimulation;

import java.util.*;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

public class Buffer {

	//Variables
	public static int size;
	public static ArrayList<Integer> finish_time;
	
	// Buffer
	public Buffer(int size) {
		this.size = size;
		this.finish_time  = new ArrayList<Integer>();
		System.out.println("=======================================");
		System.out.println("Buffer created of size -> " + this.size);
	}
	
	public static boolean isFull() {
		int len = finish_time.size();
		if(len == size)
			return true;
		else
			return false;
	}
	
	public static boolean isEmpty() {
		int len = finish_time.size();
		if(len == 0) 
			return true;
		else
			return false;
	}
	
	public static int getLastFinishTime() {
		int len = finish_time.size();
		return finish_time.get(len - 1);
	}
	
	public static void cleanProcessedPackets(Request req) {
		while(finish_time.size() > 0) {
			if(finish_time.get(0) <= req.arrival_time) {
				finish_time.remove(0);
			}
			else
				break;
		}
	}
	
	public static Response ProcessPacket(Request request) {
		//Code to edit
		
		cleanProcessedPackets(request);
		
		if(isFull())
			return new Response(true, -1);
		
		if(isEmpty()) {
			int f_t = request.arrival_time + request.processing_time;
			finish_time.add(f_t);
			return  new Response(false, request.arrival_time);
		}
		
		Response response = new Response(false, getLastFinishTime());
		finish_time.add(getLastFinishTime() + request.processing_time);
		
		return response;	
	}
}
