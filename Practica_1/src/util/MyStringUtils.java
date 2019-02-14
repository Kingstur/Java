package util;
/**
 * 
 * @author Victor Ramos Fuentes y Vadym Batsula
 * La clase MyStringUtils (así como sus métodos) ha sido facilitada por el profesor mediante el campus virtual
 */
public class MyStringUtils {
	
	public static String repeat(String elmnt, int length) {
		String result = "";
		for (int i = 0; i < length; i++) {
			result += elmnt;
		}
		return result;
	}
	
	public static String centre(String text, int len){
		String out = String.format(" %"+len+"s %s %"+len+"s", "",text,"");
		float mid = (out.length()/2);
		float start = mid - (len/2);
		float end = start + len;
		return out.substring((int)start, (int)end);
	}
}
