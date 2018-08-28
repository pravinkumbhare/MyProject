package Java_Programs.Arrays_Programs;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by pravin.kumbhare on 19-08-2018.
 */

public class Array_To_Find_Missing_Value {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Array arr[] = new Array[10];
        int a[] = {0,1,9,8,4,6,7,3,2,10};
        int count =0;

        Arrays.sort(a);
        for(int i=0; i<a.length; i++){

            if(a[i]==count){
                //System.out.println("This no is not missing in array : "+a[i]);

            }else{
                System.out.println("This no is missing in an array : "+count);
                break;
            }
            count++;
        }

	/*
		int count =0;
		int a[] = {0,1,9,8,4,6,7,3,2,10};
		List<Integer> list = new ArrayList<>();

		for(int i=0; i<a.length; i++){

			list.add(a[i]);
		}

		Collections.sort(list);

		for(int i=0; i<a.length; i++){

			System.out.println(list.get(i));
		}

		for(int i=0; i<a.length; i++){

			if(list.get(i)==count){
				//System.out.println("This no is not missing in array : "+a[i]);

			}else{
				System.out.println("This no is missing in an array : "+count);
				break;
			}
			count++;

	}*/
    }

}
