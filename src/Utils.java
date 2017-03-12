
public class Utils {
	
	public static String generateCode(String itemcode) {
		String suffix = "SKUB";
		String subString = itemcode.substring(2);
		
		String code = suffix + subString;
		
		if(code.length() > 32) {
			subString = subString.replaceAll("[AEIOUaeiou]", "");
			code = suffix + subString;
		}
		
		return code;
	}
	
	public static int getCharCount(String item) {
		return item.length();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String code_1 = "HOAple129inchiPadPro";
		String code_2 = "HOLGGPadF80";
		String code_3 = "HOSamsungGalaxyTab4_8_0";
		String code_4 = "HOALELONCHPOP7LTE";
		String code_5 = "HONoiaLuia2520Z";
		
		String code_6 = "HOPUARAPLEWACH42MMBLCKMISELOOPBA";
		String code_7 = "HOSangGaxyS6edgeCateNaedToghC395";
		String code_8 = "HOSangGaxyS6edgeCateSherGlamC396";
		
		//System.out.println("Char length of-> " + code_6 + " = " + getCharCount(code_6));
		//System.out.println("Char length of-> " + code_7 + " = " + getCharCount(code_7));
		System.out.println("Family itemcode_1: " + code_1 + " | Generated sku family code: " + generateCode(code_1));
		System.out.println("Family itemcode_2: " + code_2 + " | Generated sku family code: " + generateCode(code_2));
		System.out.println("Family itemcode_3: " + code_3 + " | Generated sku family code: " + generateCode(code_3));
		System.out.println("Family itemcode_4: " + code_4 + " | Generated sku family code: " + generateCode(code_4));
		System.out.println("Family itemcode_6: " + code_6 + " | Generated sku family code: " + generateCode(code_6) + " Count: " + getCharCount(generateCode(code_6)));
		System.out.println("Family itemcode_7: " + code_7 + " | Generated sku family code: " + generateCode(code_7) + " Count: " + getCharCount(generateCode(code_7)));
		System.out.println("Family itemcode_8: " + code_8 + " | Generated sku family code: " + generateCode(code_8) + " Count: " + getCharCount(generateCode(code_8)));
		

	}

}
