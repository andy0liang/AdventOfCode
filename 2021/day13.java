import java.util.*;
import java.io.*;
import java.lang.Math;
import java.net.*;

public class day13 {


    public static void main(String[] args) throws FileNotFoundException {


        File f = new File("2021/input13.txt");
        Scanner input = new Scanner(f);
        Scanner k = new Scanner(System.in);
        int lines = 0;
        ArrayList<String> in = new ArrayList<>();
        while (input.hasNextLine()) {
            in.add(input.nextLine());
            lines++;
        }


        boolean[][] arr = new boolean[1500][1500];

        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[0].length; y++) {
                arr[x][y] = false;
            }
        }

        for (int x = 0; x < 750; x++) {
            String[] spl = in.get(x).split(",");

            arr[Integer.parseInt(spl[1])][Integer.parseInt(spl[0])] = true;


        }


        for(int i = 751; i<763; i++) {
            String instruction = in.get(i);

            String s = instruction.split(" ")[2];

            char dir = s.charAt(0);
            int val = Integer.parseInt(s.substring(2));


            if (dir == 'x') {
                for (int x = 0; x < arr.length; x++) {
                    for (int y = val + 1; y < arr[0].length; y++) {
                        if (arr[x][y]) {
                            arr[x][y] = false;
                            System.out.println(arr[x][val - (y - val)]);
                            arr[x][val - (y - val)] = true;
                            System.out.println("before: x: " + x + ", y: " + y);
                            System.out.println("x: " + x + ", y:" + (val - (y - val)));


                        }
                    }
                }


            } else {

                for (int x = val + 1; x < arr.length; x++) {
                    for (int y = 0; y < arr[0].length; y++) {
                        if (arr[x][y]) {
                            arr[x][y] = false;

                            arr[val - (x - val)][y] = true;


                        }
                    }
                }


            }
        }



        int counter = 0;
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[0].length; y++) {
                if (arr[x][y]) {
                    counter++;
                }
            }
        }



        for(int x = 0; x<100; x++){
            for(int y = 0; y<100; y++){
                if(arr[x][y]){
                    System.out.print("#");
                }
                else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }

        System.out.println(counter);


    }
}