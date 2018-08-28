package Java_Programs.String_Collections_Program;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by pravin.kumbhare on 18-08-2018.
 */
public class Duplicate_Characters_In_String {

    static void duplicateCharCount(String inputString)
    {
        //Creating a HashMap containing char as key and it's occurrences as value

        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

        //Converting given string to char array

        char[] strArray = inputString.toCharArray();

        //checking each char of strArray

        for (char c : strArray)
        {
            if(charCountMap.containsKey(c))
            {
                //If char is present in charCountMap, incrementing it's count by 1

                charCountMap.put(c, charCountMap.get(c)+1);
            }
            else
            {
                //If char is not present in charCountMap,
                //putting this char to charCountMap with 1 as it's value

                charCountMap.put(c, 1);
            }
        }

        for(Map.Entry me : charCountMap.entrySet()){

            //1st way
         /*   int count = Integer.parseInt(me.getValue().toString());
            if(count>1){
                System.out.println("Key "+me.getKey()+" Count : "+count);
            }*/

         //2nd Way
            if(!me.getValue().equals(1)){
                System.out.println("Key "+me.getKey() +" Count"+me.getValue());
            }
        }

        //3rd Way
 /*       //Getting a Set containing all keys of charCountMap

        Set<Character> charsInString = charCountMap.keySet();

        System.out.println("Duplicate Characters In "+inputString);

        //Iterating through Set 'charsInString'

        for (Character ch : charsInString)
        {
            if(charCountMap.get(ch) > 1)
            {
                //If any char has a count of more than 1, printing it's count

                System.out.println(ch +" : "+ charCountMap.get(ch));
            }
        }*/

    }

    public static void main(String[] args)
    {
        duplicateCharCount("JavaJ2EE");

        duplicateCharCount("Fresh Fish");

        duplicateCharCount("Better Butter AAAAAAAAAA");
    }

}
