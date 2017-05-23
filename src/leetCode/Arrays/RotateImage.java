package leetCode.Arrays;

public class RotateImage {
	
	public void printImage(int[][] image) {
		for(int i = 0; i < image.length; i++) {
			for(int j = 0; j < image[0].length; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] img = {{1, 2, 3}, 
						{4, 5, 6}, 
						{7, 8, 9}};

	}

}
