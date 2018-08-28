package Java_Programs.Common_Programs;

/**
 * Created by pravin.kumbhare on 19-08-2018.
 */
public class Reverse_Number {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int originalNumber = 323, reminder, rev=0;

        int num = originalNumber;
        while(num>0){

            reminder = num%10;
            rev= (rev*10) + reminder;
            num=num/10;
        }
        System.out.println("Original No. is : "+ originalNumber);
        System.out.println("Reverse No. is : "+ rev);

        if(originalNumber == rev){
            System.out.println("Palindrom Number");
        }
        else{
            System.out.println("Not a Palindrom Number");
        }
    }
}
