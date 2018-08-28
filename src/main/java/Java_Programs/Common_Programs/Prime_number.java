package Java_Programs.Common_Programs;

import java.util.Scanner;

/**
 * Created by pravin.kumbhare on 19-08-2018.
 */
public class Prime_number {

    static void isPrimeNumber(int num){
        boolean flag = true;

        for(int i=2; i<=num-1; i++){
            if(num%i==0){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println("Number is Prime : "+num);
        } else {
            System.out.println("Number is not a Prime : "+num);
        }
    }

    public static void main(String args[]){

        System.out.println("Enter number to find prime or not : ");
        int number = new Scanner(System.in).nextInt();
        isPrimeNumber(number);
    }
}
