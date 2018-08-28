package Java_Programs.String_Collections_Program;

import java.util.Scanner;

/**
 * Created by pravin.kumbhare on 19-08-2018.
 */
public class String_Word_In_AscendingOrder {

    public static void stringInAscendingOrder(int number, String[] names) {

        System.out.println("String size is : "+names.length);

        String temp;
        for(int i=0; i<names.length; i++){
            for(int j=i+1; j<names.length; j++){

                if(names[i].compareTo(names[j])>0){			//if(str[i].compareTo(str[j])<0){ for descending order

                    temp=names[i];
                    names[i]=names[j];
                    names[j]=temp;
                }
            }
        }

        for(String st : names){

            System.out.println(st);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

//		String string = "Amit Vijay Rajesh Yogesh Denesh Ramesh Suresh";

        //Takes input from the keyboard
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any number");
        int number = scanner.nextInt();

        String names[] = new String[number];
        Scanner name = new Scanner(System.in);
        System.out.println("Enter names");

        for(int i=0; i<number; i++){

            names[i] = name.nextLine();
        }

        stringInAscendingOrder(number, names);
    }
}
