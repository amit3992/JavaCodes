package leetCode.Arrays;

public class TrappingRainwater {
	
	public int trapWater(int[] height) {
		
		if(height == null || height.length == 0) {
			return 0;
		}
		
		// left array contains height of tallest bar to the left of left[i]
		int [] left = new int[height.length];
		
		// right array contains height of tallest bar to the right of right[i]
		int [] right = new int[height.length];
		
		int water = 0;
		
		/* Fill left array */
		left[0] = height[0];
		for(int i = 1; i < height.length; i++) {
			left[i] = Math.max(left[i - 1], height[i]);
		}
		
		/* Fill right array */
		right[height.length - 1] = height[height.length - 1];
		for(int i = height.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], height[i]);
		}
		
		for(int i = 0; i < height.length; i++) {
			water += Math.min(left[i], right[i]) - height[i];
		}
		
		return water;
		
	}
	
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
		
		System.out.println("Rainwater with complex method -> " +t.trap(array2));
		System.out.println("Rainwater with easy method -> " +t.trapWater(array2));
	}

}
