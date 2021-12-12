import java.util.*;
import java.io.*;
import java.lang.Math;
import java.net.*;

public class day11 {


    public static void main(String[] args) throws FileNotFoundException {


        File f = new File("2021/input11.txt");
        Scanner input = new Scanner(f);
        Scanner k = new Scanner(System.in);
        int lines = 0;
        ArrayList<String> in = new ArrayList<>();
        while (input.hasNextLine()) {
            in.add(input.nextLine());
            lines++;
        }

        int[][] arr = new int[10][10];
        for(int x =0 ; x<in.size(); x++){

            for(int i = 0; i<10; i++){
                arr[x][i] = in.get(x).charAt(i)-'0';
            }
        }
        long counter = 0;
        long sum = 0;
        long total = 0;
        ArrayList <Integer> results = new ArrayList <>();


        for(int x = 0; x<100000; x++){

            for(int r = 0; r<10; r++){
                for(int c = 0; c<10; c++){
                    arr[r][c]++;
                }
            }


            counter = -1;
            HashSet<String> used = new HashSet<>();
            while(counter!=0) {
                counter = 0;
                for (int r = 0; r < 10; r++) {
                    for (int c = 0; c < 10; c++) {
                        if(used.contains(r+" "+c)){
                            continue;
                        }
                        if(arr[r][c]>9){
                            used.add(r+" "+c);
                            counter++;
                            arr[r][c] = 1001;
                            for(int a = r-1; a<=r+1; a++){
                                for(int b = c-1; b<=c+1; b++){
                                    if(a<0 || a>=10){
                                        continue;
                                    }
                                    if(b<0 || b>=10){
                                        continue;
                                    }
                                    if(a==r && b==c){
                                        continue;
                                    }
                                    arr[a][b]++;
                                }
                            }


                        }
                    }
                }
                if(used.size()==100) {
                    System.out.println(x);
                    return;
                }
                sum+=counter;
            }

            for (int r = 0; r < 10; r++) {
                for (int c = 0; c < 10; c++) {
                    if(arr[r][c]>=1000){
                        arr[r][c] = 0;
                    }
                }
            }



        }

        System.out.println(sum);


    }
}