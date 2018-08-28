package Java_Programs.String_Collections_Program;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by pravin.kumbhare on 18-08-2018.
 */
/*
public class Anagram_Strings {

    //By Using sort() and equals() Methods
    static void isAnagramString(String s, String s1){

        String firstString = s.replaceAll("//s","");
        String secondString = s1.replaceAll("//s","");

        char[] firstCharArray = firstString.toLowerCase().toCharArray();
        char[] secondCharArray = secondString.toLowerCase() .toCharArray();

        Arrays.sort(firstCharArray);
        Arrays.sort(secondCharArray);
        if(Arrays.equals(firstCharArray, secondCharArray)){
            System.out.println("String"+firstString+" and "+secondString+" is Anagram_Strings");
        }else{
            System.out.println("String"+firstString+" and "+secondString+" Not a Anagram_Strings");
        }
    }

    public static void main(String []a){

        isAnagramString("School Master","The Classroom");
        isAnagramString("sdfsdfd","fghfghf");
    }
}
*/


public class Anagram_Strings {

    //By Using sort() and equals() Methods
    static void isAnagramString(String s, String s1){

       /* String firstString = s.toLowerCase().replaceAll("//s","");
        String secondString = s1.toLowerCase().replaceAll("//s",""*//*);*/

        HashMap<Character, Integer> characterCount1 = new HashMap<>();
        char[] first = s.toLowerCase().toCharArray();
        Arrays.sort(first);

        for(char c : first){
            if(!characterCount1.containsKey(c)){

                characterCount1.put(c,1);
            }else {

                characterCount1.put(c, characterCount1.get(c)+1);
            }
        }
        System.out.println(characterCount1);

        HashMap<Character, Integer> characterCount2 = new HashMap<>();
        char[] second = s1.toLowerCase().toCharArray();
        Arrays.sort(second);

        for(char c1 : second){
            if(!characterCount2.containsKey(c1)){

                characterCount2.put(c1,1);
            }else {

                characterCount2.put(c1, characterCount2.get(c1)+1);
            }
        }
        System.out.println(characterCount2);

        if(characterCount1.equals(characterCount2)){
            System.out.println("Anagram String");
        }else{
            System.out.println("Not a Anagram String");
        }
    }

    public static void main(String []a){

        isAnagramString("School Master","The Classroom");
        isAnagramString("sdfsdfd","fghfghf");
    }
}

