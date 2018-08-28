package Java_Programs.Arrays_Programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by pravin.kumbhare on 20-08-2018.
 */
public class To_Find_Duplicate_Element_In_Array {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] arr = {2, 4, 6, 1, 7, 4, 8, 1, 2, 1};

       /* 1st Way
       Set<Integer> mySet = new HashSet<>();

        for (int ar : arr) {

            if (!mySet.add(ar)) {

                System.out.println("Duplicate Element is : " + ar);
            }
        }*/

       // 2nd Way
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else {
                map.put(i,map.get(i)+1);
            }
        }

        for(Map.Entry me : map.entrySet()){
            if(!me.getValue().equals(1)){
                System.out.println("Element : "+me.getKey() +"  Duplication Count is : "+me.getValue());
            }
        }



		/*String str = "Java is a programming language but python is a better option now";

		String[] splittedString = str.split("");
		Set<String> mySet = new HashSet<>();

		for(String s : splittedString){

			if(!mySet.add(s)){

				System.out.println("Duplicate element is : "+s);
			}
		}*/
    }
}
