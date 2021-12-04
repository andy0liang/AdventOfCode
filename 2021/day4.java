import java.util.*;
import java.io.*;
import java.net.*;

public class day4 {
    public static HashSet<Integer> set;
    public static void main(String[] args) throws FileNotFoundException {


        File f = new File("2021/input4.txt");
        Scanner input = new Scanner(f);
        int lines = 0;
        ArrayList<String> in = new ArrayList<>();
        while (input.hasNextLine()) {
            in.add(input.nextLine());
            lines++;
        }

        ArrayList<Integer> nums = new ArrayList<>();

        for (String x : in.get(0).split(",")) {
            nums.add(Integer.parseInt(x));
        }

        int numBoards = (lines - 1) / 6;

        ArrayList<int[][]> boards = new ArrayList<>();

        for (int x = 0, a = 2; x < numBoards; x++, a += 6) {
            boards.add(new int[5][5]);

            for (int i = a; i < a + 5; i++) {
                in.set(i, in.get(i).replaceAll("  ", " ").trim());
                String[] spl = in.get(i).split(" ");

                for (int j = 0; j < 5; j++) {
                    boards.get(x)[i-a][j] = Integer.parseInt(spl[j]);
                }
            }
        }

        set = new HashSet<>();
        for(int x = 0; x<boards.size(); x++){
            set.add(x);
        }

        for(int lmao = 0; lmao<nums.size(); lmao++){
            int num = nums.get(lmao);

            for(int x = 0; x<boards.size(); x++){
                for(int y = 0; y<5; y++){
                    for(int z = 0; z<5; z++){
                        if(boards.get(x)[y][z] == num){
                            boards.get(x)[y][z] *= -1;
                            if(boards.get(x)[y][z]==0){
                                boards.get(x)[y][z] = -999;
                            }
                        }
                    }
                }


            }
            checkWinners(boards, num);

            if(set.size()==1){
                int goodboard = set.iterator().next();

                while(!set.isEmpty()){
                    for(int n = lmao+1; n<nums.size(); n++) {
                        System.out.println("testing "+nums.get(n));
                        for (int y = 0; y < 5; y++) {
                            for (int z = 0; z < 5; z++) {
                                if (boards.get(goodboard)[y][z] == nums.get(n)) {
                                    boards.get(goodboard)[y][z] *= -1;
                                }
                            }
                        }
                        checkWinners(boards, nums.get(n));
                        if(set.isEmpty()){
                            num = nums.get(n);
                            break;
                        }
                    }
                }

                System.out.println(goodboard);
                System.out.println(num);
                int sum = 0;
                for(int p = 0; p<5; p++){
                    for(int q = 0; q<5; q++){
                        if(boards.get(goodboard)[p][q]>0){
                            sum+=boards.get(goodboard)[p][q];
                        }

                    }
                }
                System.out.println(sum*num);
                return;

            }



        }





    }
    public static void checkWinners(ArrayList <int[][]> boards, int num){

        for(int x = 0; x<boards.size(); x++){

            for(int row = 0; row<5; row++){
                boolean flag = false;
                for(int col = 0; col<5; col++){
                    if(boards.get(x)[row][col]>=0){
                        flag = true;
                        break;
                    }
                }
                if(flag == false){

                    int sum = 0;
                    for(int a = 0; a<5; a++){
                        for(int b = 0; b<5; b++){
                            if(boards.get(x)[a][b]<0){

                                continue;
                            }

                            sum+=boards.get(x)[a][b];
                        }
                    }
                    //System.out.println(sum*num);
                    set.remove(x);


                }
            }

            for(int col = 0; col<5; col++){
                boolean flag = false;
                for(int row = 0; row<5; row++){
                    if(boards.get(x)[row][col]>=0){
                        flag = true;
                        break;
                    }
                }
                if(flag == false){

                    int sum = 0;
                    for(int a = 0; a<5; a++){
                        for(int b = 0; b<5; b++){
                            if(boards.get(x)[a][b]<0){

                                continue;
                            }

                            sum+=boards.get(x)[a][b];
                        }
                    }
                    //System.out.println(sum*num);
                    set.remove(x);
                }
            }


        }



    }
}
