package leetCode;

class MakePalindrome {
	public static String makePlaindrom(String s){
		
		if(s.length()<=1) {
			return s;
		}
		
		StringBuilder pl=new StringBuilder(s);
		int len=s.length();

		for (int i = len-2; i >=0; i--) {
			pl.append(s.charAt(i));
		}
		return pl.toString();
	}
    
	
    public static void main (String[] args) {
        System.out.println("a>> "+makePlaindrom("a"));
        System.out.println("ab>> "+makePlaindrom("ab"));
        System.out.println("abc>> "+makePlaindrom("abc"));
        System.out.println("abcde>> "+makePlaindrom("abcde"));
    }
}