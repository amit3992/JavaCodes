import java.util.regex.*;

public class testReplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String myString = "Samsung Galaxy J7";
		myString = myString.replaceAll("[^a-zA-Z_]", " ");
		
		System.out.println("MyString: "+myString);
	
        String itemCode = "HO";

        String[] familyNameWords = myString.split("-|\\ ");
        
        for (String familyNameWord : familyNameWords)
        {
            String value;
            if ((familyNameWord.length() < 4))
            {
                value = familyNameWord;
            }
            else
            {
            	int length = familyNameWord.length();
                value = familyNameWord.substring(0, 2) + familyNameWord.substring(length - 2, length);
            }
            itemCode += value;
        }
        
        System.out.println("itemCode: "+itemCode);

	}

}
