package Java_Programs.String_Collections_Program;

/**
 * Created by pravin.kumbhare on 19-08-2018.
 */
public class String_Length_Without_Using_Length_Function {

    static int stringLength(String string){
        int length=0;

        char[] chars = string.toCharArray();
        for(char ch : chars){
            length++;
        }

        return length;
    }

    public static void main(String a[]){

        int length = stringLength("My name is khan");
        System.out.println("Length of a string is : "+length);
    }
}
