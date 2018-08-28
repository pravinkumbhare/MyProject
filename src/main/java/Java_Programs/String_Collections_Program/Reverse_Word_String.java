package Java_Programs.String_Collections_Program;

/**
 * Created by pravin.kumbhare on 12-08-2018.
 */
public class Reverse_Word_String {

    public static void main(String args[]){
        String revWord = "";

        String str = "This is a java program";
        String [] splittedArray = str.split(" ");
        for (int i=0; i<splittedArray.length; i++){

            String word = splittedArray[i];
            for (int j=word.length()-1; j>=0; j--){

                revWord = revWord + word.charAt(j);
            }
            revWord = revWord + " ";
        }
        System.out.println(revWord);
    }
}
