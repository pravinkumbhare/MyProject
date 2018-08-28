package Java_Programs.Common_Programs;

import java.util.Scanner;

/**
 * Created by pravin.kumbhare on 19-08-2018.
 */
/*public class Palindrom_String {

    static void isPalindrom(String string){
        String revString = "";

        char[] ch = string.toCharArray();
        for(int i=ch.length-1; i>=0 ; i--){

            revString = revString + ch[i];
        }

        System.out.println(revString);
        if(string.equalsIgnoreCase(revString)){
            System.out.println("It is a Palindrom_String : "+string);
        }else {
            System.out.println("It is not a Palindrom_String : "+string);
        }
    }

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to find Palindrom");
        String string = scanner.next();
        isPalindrom(string);
    }
}*/


//Without using String revString variable and StringBuffer
public class Palindrom_String {

    static boolean isPalindrom(String string){
        //String revString = "";

        char[] ch = string.toCharArray();
        for(int i=ch.length-1; i>=0 ; i--){

            System.out.println(ch[i]);
        }

        System.out.println(String.valueOf(ch));
        if(string.equalsIgnoreCase(String.valueOf(ch))){
            System.out.println("It is a Palindrom_String : "+string);
            return true;
        }else {
            System.out.println("It is not a Palindrom_String : "+string);
            return false;
        }
    }

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to find Palindrom");
        String string = scanner.next();
        isPalindrom(string);
    }
}
