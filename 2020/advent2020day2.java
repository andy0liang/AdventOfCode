import java.util.*;
public class advent2020day2 {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        ArrayList <String> in = new ArrayList<>();
        for(int x = 0; x<1000;x++){
            in.add(input.nextLine());
        }

        /*

        1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc

         */

        //Part 2

        int counter = 0;

        String[] spl;
        int min;
        int max;
        char letter;
        String str;

        for(String s : in) {
            spl = s.split(" ");
            min = Integer.parseInt(spl[0].split("-")[0]);
            max = Integer.parseInt(spl[0].split("-")[1]);
            letter = spl[1].charAt(0);
            str = spl[2];

            if((str.charAt(min-1)==letter || str.charAt(max-1)==letter) && str.charAt(min-1)!=str.charAt(max-1)){
                counter++;
            }

        }
        System.out.println(counter);

        /*
        PART 1
        int counter = 0;
        String[] spl;
        int min;
        int max;
        char letter;
        String str;
        for(String s : in){
            spl = s.split(" ");
            min = Integer.parseInt(spl[0].split("-")[0]);
            max = Integer.parseInt(spl[0].split("-")[1]);
            letter = spl[1].charAt(0);
            str = spl[2];

            int result = countChars(str,letter);
            if(result>=min && result<=max){
                counter++;
            }

        }
        System.out.println(counter);
*/

    }
    public static int countChars(String s, char c){
        int counter = 0;
        for(int x = 0; x<s.length();x++){
            if(s.charAt(x)==c){
                counter++;
            }
        }
        return counter;
    }


}
