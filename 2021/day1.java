import java.util.*;

public class day1{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int counter = 0;

        ArrayList <Integer> arr = new ArrayList<>();
        for(int x = 0; x<2000;x++){
            arr.add(input.nextInt());

        }

        for(int x = 0; x<2000-3; x++){
            int prev = arr.get(x)+arr.get(x+1)+arr.get(x+2);
            int sum = prev-arr.get(x)+arr.get(x+3);
            if(sum>prev){
                counter++;
            }
        }

        System.out.println(counter);




    }
}