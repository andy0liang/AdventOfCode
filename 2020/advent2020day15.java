import java.util.*;
public class advent2020day15{
    public static void main(String[] args){

        //int[] arr = new int[2021];
        int[] start = new int[]{9,19,1,6,0,5,4};
        //9,19,1,6,0,5,4

        for(int x = 0; x < start.length; x++){
            //arr[x] = start[x];
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x = 0; x < start.length-1; x++){
            map.put(start[x], x);
        }
        int prev = start[start.length-1];
        int temp;
        for(int x = start.length; x < 30000000; x++){
            if(map.containsKey(prev)){
                temp = prev;
                prev = (x-1)-map.get(prev);

                map.put(temp, x-1);


            }
            else{
                map.put(prev, x-1);
                prev = 0;

            }

        }
        System.out.println(prev);


    }
}
