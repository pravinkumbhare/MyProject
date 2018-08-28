package Java_Programs.Arrays_Programs;

/**
 * Created by pravin.kumbhare on 20-08-2018.
 */
public class LargestNo_SmallestNo_InArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int arr[] =  {3,4,2,1,8,5,6,20,75,37,97,0,38,48,83}; //{"2","6","3","5","8","0","4"};

        System.out.println("Length of array is : "+arr.length);

        int largestNumber = arr[0];
        for(int i=0; i<arr.length; i++ ){
            for(int j=i+1; j<arr.length; j++){

                if(arr[j]>largestNumber){
                    largestNumber = arr[j];
                }
            }
        }
        System.out.println("Largest no. in an array is : "+largestNumber);

        // Similarly to find smallest no. in an array
        int smallestNumber = arr[0];
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){

                if(arr[j]<smallestNumber){
                    smallestNumber = arr[j];
                }
            }
        }
        System.out.println("Smallest no. in an array is : "+smallestNumber);
    }
}
