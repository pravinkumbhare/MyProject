package Java_Programs.String_Collections_Program;

import org.apache.tools.ant.taskdefs.condition.Equals;

import java.util.Scanner;

/**
 * Created by pravin.kumbhare on 19-08-2018.
 */
public class Adding_2_String_Alternate_Character {

    static void addString(String str1, String str2){
        String thirdString = "";

        int length = getStringLength(str1, str2);

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for(int i=0; i<length; i++){

            thirdString = thirdString + ch1[i];
            thirdString = thirdString + ch2[i];
        }
        System.out.println("ThirdString : "+thirdString);
    }

    static protected int getStringLength(String str1, String str2){
        int length1 = str1.length();
        int length2 = str2.length();
        if(length1>length2){
            return length1;
        }else {
            return length2;
        }
    }

    public static void main(String s[]){

        /*Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner1.nextLine();*/

        addString("pravin", "pallav");
    }
}

