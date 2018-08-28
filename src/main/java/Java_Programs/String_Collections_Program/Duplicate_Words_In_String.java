package Java_Programs.String_Collections_Program;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pravin.kumbhare on 19-08-2018.
 */
/*
public class Duplicate_Words_In_String {

    static void duplicateWords(String inputString)
    {

        String[] words = inputString.toLowerCase().split(" ");

        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words)
        {
            if(!wordCount.containsKey(word)) {

                wordCount.put(word, 1);
            }
            else {

                wordCount.put(word, wordCount.get(word)+1);
            }
        }

        for(Map.Entry me : wordCount.entrySet()){

            if(!me.getValue().equals(1)){

                System.out.println(me.getKey() +" : "+me.getValue());
            }
        }

      */
/*  //Extracting all keys of wordCount

        Set<String> wordsInString = wordCount.keySet();

        //Iterating through all words in wordCount

        for (String word : wordsInString)
        {
            //if word count is greater than 1

            if(wordCount.get(word) > 1)
            {
                //Printing that word and it's count

                System.out.println(word+" : "+wordCount.get(word));
            }
        }*//*

    }

    public static void main(String[] args)
    {
        duplicateWords("Bread butter and bread");

        duplicateWords("Java is java again java");

        duplicateWords("Super Man Bat Man Spider Man");
    }
}
*/



public class Duplicate_Words_In_String {

    static void duplicateWords(String inputString){
        int count=0;

        Pattern p = Pattern.compile("pravin");
        Matcher m = p.matcher(inputString.toLowerCase());

        while (m.find() /*&& m.group().equalsIgnoreCase()*/){

            //System.out.println(m.group());
            count++;
        }
        System.out.println("count: "+count);
    }

    public static void main(String[] args)
    {
        duplicateWords("HelloPravinHelloPravinHelloPravinHelloPravinHelloPravin");
    }
}

