public class IndeedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] num = {1,2,4,5,6,7,9,11,13,14,15,16,17};
		int j;
		int start,end;
		//System.out.println(num.length-1);
		
		for(int i = 0; i<num.length-1; i++)	{
			j = i+1;
			
			start = num[i];
			
			while(num[j]-num[i] == 1) {
			
				//System.out.print(num[i]+" ");
				i++;
				j = i+1;
				if(j > num.length-1)
					break;
			}
			
			end = num[i];
				
			if(start == end)
				System.out.print(start+",");
			else if(start!= end && end!= num[num.length-1])
				System.out.print(start+"-"+end+",");
			else
				System.out.print(start+"-"+end);
		}
	}
}