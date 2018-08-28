package Java_Programs.Arrays_Programs;

/**
 * Created by pravin.kumbhare on 19-08-2018.
 */
public class Adding_Two_Array_Alternate_Value {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] A = {1,2,3,4,5,6,7,8,9,10};
        int[] B = {11,12,13,14,15,16,17,18,19,20};

        int A_Size = A.length;
        int B_Size = B.length;

        int sumLength = A_Size + B_Size;
        int[] C = new int[sumLength];

        for(int i=0, j=0; i<=A_Size-1; i++){

            C[j] = A[i];
            C[j+1] = B[i];

		/*	System.out.println(C[j] );
			System.out.println(C[j+1] );*/

			/*if(i==9){
				break;
			}*/
            j = j + 2;
        }

        for(int count=0; count<sumLength; count++){

            System.out.print(C[count] +" ");
        }
    }
}
