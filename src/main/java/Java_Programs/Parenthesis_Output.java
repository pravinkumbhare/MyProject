package Java_Programs;

/**
 * Created by pravin.kumbhare on 27-08-2018.
 */
public class Parenthesis_Output {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String str = "(((()()())))";
        int openPara = 0, closePara = 0, in=0, out=0;
        boolean isOpenPara = false;

        for(int i=0; i<str.length(); i++){

            char ch = str.charAt(i);
            if(ch=='('){
                isOpenPara = true;
                openPara++;
                System.out.print(openPara +" ");
                in++;

            }else if(ch==')'){

                if(isOpenPara){
                    closePara = openPara;
                    System.out.print(closePara +" ");
                    closePara--;
                    isOpenPara = false;
                    out++;

                }else{
                    System.out.print(in-out +" ");
                    if(ch=='('){
                        in++;
                    }else if(ch==')'){
                        out++;
                    }
                }


            }
        }

    }
}
