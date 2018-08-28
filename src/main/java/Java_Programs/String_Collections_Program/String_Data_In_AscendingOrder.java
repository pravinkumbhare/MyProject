package Java_Programs.String_Collections_Program;

import java.util.Arrays;

/**
 * Created by pravin.kumbhare on 19-08-2018.
 */
public class String_Data_In_AscendingOrder {

    public static void main(String[] args) {

		/*String input = "hello";
		char[] charArray = input.toCharArray();
		Arrays.sort(charArray);
		String sortedString = new String(charArray);
		System.out.println(sortedString);  */

        String str = "pravin is software engineer";
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        String sortedString = new String(ch);
        System.out.println(sortedString);

		/*String input="hello";
		char[] charArray = input.toCharArray();


		for(int i=0;i<charArray.length;i++){
		   for(int j=i+1;j<charArray.length;j++){

		      if (charArray[j] < charArray[i]) {
		          char temp = charArray[i];
		          charArray[i]=arr[j];
		          charArray[j]=temp;
		      }
		   }
		}*/
    }
}
