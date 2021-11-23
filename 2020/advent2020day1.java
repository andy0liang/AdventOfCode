
import java.util.*;
public class advent2020day1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        ArrayList <Integer> arr = new ArrayList <>();
        for(int x =0 ; x<200;x++){
            arr.add(input.nextInt());
        }

        //part 2
        for(int x = 0; x<arr.size();x++){
            for(int y = x+1; y<arr.size();y++){
                for(int z = y+1; z<arr.size();z++){
                    if(arr.get(x)+arr.get(y)+arr.get(z)==2020){
                        System.out.println(arr.get(x)*arr.get(y)*arr.get(z));
                        return;
                    }
                }
            }
        }


        //part 1
        for(int x = 0; x<arr.size();x++){
            for(int y = x+1; y<arr.size();y++){
                if(arr.get(x)+arr.get(y)==2020){
                    System.out.println(arr.get(x)*arr.get(y));
                    return;
                }
            }
        }

        



    }
}

