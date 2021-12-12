import java.util.*;
import java.io.*;
import java.net.*;

public class day52021 {
    public static HashSet<Integer> set;

    public static void main(String[] args) throws FileNotFoundException {


        File f = new File("2021/input5.txt");
        Scanner input = new Scanner(f);
        int lines = 0;
        ArrayList<String> in = new ArrayList<>();
        while (input.hasNextLine()) {
            in.add(input.nextLine());
            lines++;
        }


        int[][] arr = new int[1000][1000];

        for(int x =0 ; x<in.size();x++){
            String[] spl = in.get(x).split(" -> ");

            String[] spl1 = spl[0].split(",");
            String[] spl2 = spl[1].split(",");

            int x1 = Integer.parseInt(spl1[0]);
            int y1 = Integer.parseInt(spl1[1]);

            int x2 = Integer.parseInt(spl2[0]);
            int y2 = Integer.parseInt(spl2[1]);


            if(x1 == x2){
                for(int y = min(y1, y2); y<=max(y2, y1); y++){
                    arr[x1][y]++;
                }
            }
            else if(y1==y2){
                for(int y = min(x1, x2); y<=max(x1, x2); y++){
                    arr[y][y1]++;
                }
            }
            else{
                if(x1 < x2 && y1 < y2){
                    for(int a = x1, b = y1; a<=x2; a++, b++){
                        arr[a][b]++;
                    }
                }
                else if(x1>x2 && y1 < y2){
                    for(int a = x1, b = y1; a>=x2; a--, b++){
                        arr[a][b]++;
                    }
                }
                else if(x1 < x2 && y1>y2){
                    for(int a = x1, b = y1; a<=x2; a++, b--){
                        arr[a][b]++;
                    }
                }
                else{
                    for(int a = x1, b = y1; a>=x2; a--, b--){
                        arr[a][b]++;
                    }
                }


            }


        }
        int counter = 0;

        for(int x = 0; x<1000;x++){
            for(int y = 0; y<1000; y++){
                if(arr[x][y]>=2){
                    counter++;
                }
            }

        }
        System.out.println(counter);





    }

    public static int min(int a, int b){
        if(a<b){
            return a;
        }
        return b;
    }
    public static int max(int a, int b){
        if(a>b){
            return a;
        }
        return b;
    }
}