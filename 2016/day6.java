import java.util.*;
public class day6{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        ArrayList <String> in = new ArrayList <>();

        for(int x = 0; x<572; x++){
            in.add(input.nextLine());
        }

        int[][] arr = new int[8][26];

        for(String s : in){

            for(int i = 0; i<8; i++){
                arr[i][s.charAt(i)-'a']++;
            }

        }
        String result = "";
        for(int x =0; x<8; x++){
            int min = Integer.MAX_VALUE;
            int mini = 0;

            for(int i = 0; i<26; i++){
                if(arr[x][i]<min && arr[x][i] > 0){
                    min = arr[x][i];
                    mini = i;
                }
            }

            result += (char)('a'+mini);



            /* PART 1
            int max = Integer.MIN_VALUE;
            int maxi = 0;


            for(int i = 0; i<26; i++){
                if(arr[x][i]>max){
                    max = arr[x][i];
                    maxi = i;
                }
            }


            result+=(char)('a'+maxi);
            ?8
             */
        }

        System.out.println(result);





    }
}