package leetCode.String;

public class RemoveConsecutiveDupicates {

	public int removeDuplicatesSlow(char input[]){
        
		int slow = 0;
        int fast = 0;
        int index = 0;
        
        while(fast < input.length){
            while(fast < input.length && input[slow] == input[fast]){
                fast++;
            }
            input[index++] = input[slow];
            slow = fast;
        }
        
        return index;
    }
    
	public static void ShortenString(String s, String ans, int index, int count) {
		
		//System.out.println(ans.length());
		
		if(count >= 3 ){
			
			ans=ans.substring(0,ans.length()-3);
			//System.out.println(ans);
			
		}
		
		if(index == s.length()) {
			System.out.println(ans);
			return;
		}
		
		if(ans.length() != 0 &&  s.charAt(index) == ans.charAt(ans.length()-1)){
			ShortenString(s, ans + (s.charAt(index)), index+1, count+1);
		}else{
			ShortenString(s, ans + (s.charAt(index)), index+1, 1);
		}
	}

	public static void main(String args[]){
        String str = "azxxy";
        char input[] = str.toCharArray();
        RemoveConsecutiveDupicates rcd = new RemoveConsecutiveDupicates();
        
        int len = rcd.removeDuplicatesSlow(input);
        /*
        for(int i=0; i < len; i++){
            System.out.print(input[i] + " ");
        } */
        
        ShortenString("AZXXXZZY", "", 0, 0);
        
        
    }

}

