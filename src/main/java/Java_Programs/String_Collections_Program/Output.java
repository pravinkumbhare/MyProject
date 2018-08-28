package Java_Programs.String_Collections_Program;

/**
 * Created by pravin.kumbhare on 12-08-2018.
 * 1
 * 23
 * 456
 * 78910
 */
/*public class Output {

    public static void main(String args[]){
        int count = 1, num=1;

        for(int i=1; i<=4; i++){
            for(int j=1; j<=i; j++){

                System.out.print(num);
                num++;
            }
            System.out.println();
        }
    }
}*/

/**
 * Output
 * 1
 * 23
 * 456
 * 78910
 */


/**
 * 1
 * 121
 * 12321
 * 1234321
 * 123454321
 */
/*
public class Output {
    public static void main(String args[]){
        int i,j;

        System.out.println(1);
        for( i=1; i<=4; i++){
           for( j=1; j<=i; j++){

               System.out.print(j);
           }
           for(;j>=1;--j){
               System.out.print(j);
           }
           System.out.println();
        }
    }
}*/


/**

 *
 * *
 * * *
 * * * *
 * * * * *

 */
/*
public class Output{
    public static void main(String[] args){

        for(int i=1; i<=5; i++){
            for(int j=1; j<=i; j++){

                System.out.print("* ");
            }
            System.out.println();
        }
    }
}*/



/**

 * * * * *
 * * * *
 * * *
 * *
 *

 */
/*public class Output{
    public static void main(String[] args){

        for(int i=5; i>=1; i--){
            for(int j=i; j>=1; j--){

                System.out.print("* ");
            }
            System.out.println();
        }
    }
}*/




/**

 * * * * *
   * * * *
     * * *
       * *
         *

 */
/*
public class Output{
    public static void main(String[] args){
        int count=1;

        for(int i=5; i>=1; i--){
            for(int j=i; j>=1; j--){

                System.out.print("* ");
            }
            System.out.println();

            for(int k=count; k<=5; k++){
                for(int l=k; l>=1; l--){

                    System.out.print("  ");
                }
                count++;
                break;
            }
        }
    }
}*/



/**
         *
       * *
     * * *
   * * * *
 * * * * *

 */
/*public class Output{
    public static void main(String a[]){

        for(int i=5; i>=1; i--){
            for(int j=1; j<=5; j++){

                if(j>=i){

                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}*/



/**
         *
       * * *
     * * * * *
   * * * * * * *
 * * * * * * * * *

 */
public class Output{
    public static void main(String []a){
        String [] count = new String[10];

        for(int i=5; i>=1; i--){
            for(int j=1; j<=5; j++){

                if(j>=i){

                    System.out.print("* ");

                    if(j<5){
                        count[i] = "*";
                    }

                }else {
                    System.out.print("  ");
                }

                if(j>5){
                    for(int rip=1; rip<=count.length; rip++){
                        System.out.print("* ");
                    }
                }
            }
            System.out.println();
        }

    }
}