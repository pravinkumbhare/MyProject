package Java_Programs.Common_Programs;

/**
 * Created by pravin.kumbhare on 19-08-2018.
 */
public class Fibonacci_series {

    static void febonacciUpTo(int count){
        int x = 1, y = 1, z = 0;
        System.out.print(x +" ");
        System.out.print(y +" ");

        for(int febo=0; febo<count; febo++){

            z = x + y;
            System.out.print(z +" ");
            x = y;
            y = z;
        }
    }

    //first 10 Fibonacci numbers are 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    public static void main(String args[]){

        febonacciUpTo(10);
    }
}
