package leetCode.Arrays;

public class PlusOne {
	
	public int [] addOne(int [] digits) {
		
		for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] == 9){
                digits[i] = 0;
            }else {
                digits[i]++;
                return digits;
            }  
		}
    
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		System.arraycopy(digits, 0, res, 1, digits.length);
    
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// int [] digits = {1, 2, 4};
		int [] digits = {9, 9, 9};
		
		PlusOne add = new PlusOne();
		
		int [] result = add.addOne(digits);
		for(int i : result) {
			System.out.print(i);
		}

	}

}
