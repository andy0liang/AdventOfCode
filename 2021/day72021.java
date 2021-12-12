import java.util.*;
import java.io.*;
import java.lang.Math;
import java.net.*;

public class day72021 {
    public static HashSet<Integer> set;

    public static void main(String[] args) throws FileNotFoundException {


        File f = new File("2021/input7.txt");
        Scanner input = new Scanner(f);
        Scanner k = new Scanner(System.in);
        int lines = 0;
        ArrayList<String> in = new ArrayList<>();
        while (input.hasNextLine()) {
            in.add(input.nextLine());
            lines++;
        }

        ArrayList <Integer> arr = new ArrayList <>();
        //in.add(0, k.nextLine());
        String[] spl = in.get(0).split(",");
        for(String s : spl){
            arr.add(Integer.parseInt(s));
        }

        int sum = 0;
        for(int x : arr){
            sum+=x;
        }
        int cost = Integer.MAX_VALUE;
        for(int avg = 0; avg<2000; avg++) {
            int temp = 0;
            for (int x : arr) {
                temp += getCost(x, avg);
            }
            if(temp<cost){
                cost = temp;
            }
        }
        System.out.println(cost);

    }

    public static int getCost(int a, int b){

        int distance = Math.abs(a-b);
        int sum = 0;
        for(int x = 1; x<1+distance; x++){
            sum+=x;
        }
        return sum;

    }


}
