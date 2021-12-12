import java.util.*;
import java.io.*;
import java.net.*;

public class day62021 {
    public static HashSet<Integer> set;

    public static void main(String[] args) throws FileNotFoundException {


        File f = new File("2021/input6.txt");
        Scanner input = new Scanner(f);
        Scanner k = new Scanner(System.in);
        int lines = 0;
        ArrayList<String> in = new ArrayList<>();
        while (input.hasNextLine()) {
            in.add(input.nextLine());
            lines++;
        }





        ArrayList<Integer> arr = new ArrayList <>();


        String[] spl = in.get(0).split(",");

        for(int x = 0; x<spl.length;x++){
            arr.add(Integer.parseInt(spl[x]));
        }

        int num = arr.size();

        long[] ocean = new long[9];

        for(int x = 0; x<arr.size(); x++){
            ocean[arr.get(x)]++;
        }
        long[] temp = new long[9];

        for(int day = 0; day<256; day++){

            for(int x = 0; x<=8; x++){
                temp[x] = ocean[(x+1)%9];
            }
            temp[6]+=ocean[0];
            for(int x = 0; x<9; x++){
                ocean[x] = temp[x];
            }


            /* part 1
            int size = arr.size();
            for(int x = 0; x<size; x++){
                if(arr.get(x)==0){
                    arr.set(x, 6);
                    arr.add(8);
                }
                else{
                    arr.set(x, arr.get(x)-1);
                }
            }


             */



        }

        System.out.println(arr.size());
        long sum = 0;
        for(long x : ocean){
            sum+=x;
        }
        System.out.println(sum);







    }
}