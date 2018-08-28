package Java_Programs.Common_Programs;

/**
 * Created by pravin.kumbhare on 19-08-2018.
 */
public class ArmStrong_Number {

    public static void main(String[] args) {
        // 125= 1*1*1 + 2*2*2 +5*5*5
        int originalNum = 153, reminder, rev=0, cubeDigit=0, digit=0;

        int num=originalNum;
        while(num>0){
            reminder = num%10;
            cubeDigit = reminder*reminder*reminder;
            digit = digit+cubeDigit;
            num = num/10;

        }

        System.out.println(originalNum);
        System.out.println(digit);
        if(originalNum == digit){
            System.out.println("Armstrong Number");
        }
        else{
            System.out.println("Not a Armstrong Number");
        }
    }
}
