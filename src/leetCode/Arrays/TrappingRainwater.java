package leetCode.Arrays;

public class TrappingRainwater {
	
	public int trap(int[] height) {
        
        int maxSeenSoFar = -1;
        int[] maxSeenRight = new int[height.length];
        int maxLeftSeen = -1;
        int rainWater = 0;
        
        for(int i = height.length - 1; i >= 0; i--) {
            if(height[i] > maxSeenSoFar) {
                maxSeenSoFar = height[i];
                maxSeenRight[i] = maxSeenSoFar;
            } else {
                maxSeenRight[i] = maxSeenSoFar;
            }
        }
        
        for(int i = 0; i < height.length; i++) {
            rainWater = rainWater + Integer.max(Integer.min(maxLeftSeen, maxSeenRight[i]) - height[i],0);
            if(height[i] > maxLeftSeen) {
                maxLeftSeen = height[i];
            }
        }
        
        return rainWater;
        
    }

	public static void main(String[] args) {
			
		int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
		int[] array2 = {0, 2, 1, 0, 5};
		TrappingRainwater t = new TrappingRainwater();
		
		System.out.println("Rainwater -> " +t.trap(array2));
	}

}
