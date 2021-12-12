import java.util.*;
import java.io.*;
import java.lang.Math;
import java.net.*;

public class day8 {
    public static HashSet<Integer> set;

    public static void main(String[] args) throws FileNotFoundException {


        File f = new File("2021/input8.txt");
        Scanner input = new Scanner(f);
        Scanner k = new Scanner(System.in);
        int lines = 0;
        ArrayList<String> in = new ArrayList<>();
        while (input.hasNextLine()) {
            in.add(input.nextLine());
            lines++;
        }

        int counter = 0;
        ArrayList<Integer> arr = new ArrayList <>();
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(7);









        for(int x = 0; x<in.size(); x++){
            ArrayList<HashSet<Character>> nums = new ArrayList <>();
            String[] spl = in.get(x).split(" \\| ");
            String[] first = spl[0].split(" ");
            String[] second = spl[1].split(" ");

            char ru;
            char rd;
            char u;
            char d;
            char m;
            char lu;
            char ld;
            HashSet<Character> zero = new HashSet<>();
            HashSet<Character> one = new HashSet<>();
            HashSet<Character> two = new HashSet<>();
            HashSet<Character> three = new HashSet<>();
            HashSet<Character> four = new HashSet<>();
            HashSet<Character> five = new HashSet<>();
            HashSet<Character> six = new HashSet<>();
            HashSet<Character> seven = new HashSet<>();
            HashSet<Character> eight = new HashSet<>();
            HashSet<Character> nine = new HashSet<>();

            for(String s : first){
                if(s.length() == 2){
                    for(int i = 0; i<2; i++){
                        one.add(s.charAt(i));
                    }
                }
                if(s.length() == 3){
                    for(int i = 0; i<3; i++){
                        seven.add(s.charAt(i));
                    }
                }
                if(s.length() == 4){
                    for(int i = 0; i<4; i++){
                        four.add(s.charAt(i));
                    }
                }
                if(s.length() == 7){
                    for(int i = 0; i<7; i++){
                        eight.add(s.charAt(i));
                    }
                }
            }

            for(String s : first){
                if(s.length() == 6){
                    //6, 9, 0
                    HashSet<Character> temp = new HashSet<>();
                    for(int i = 0; i<s.length(); i++){
                        temp.add(s.charAt(i));
                    }

                    if(!temp.containsAll(one)){
                        //6
                        six = temp;
                    }
                    else{
                        if(temp.containsAll(four)){
                            //9
                            nine = temp;
                        }
                        else{
                            //0
                            zero = temp;
                        }
                    }

                }
            }


            for(String s : first){
                if(s.length() == 5){
                    //2, 3, 5

                    HashSet<Character> temp = new HashSet<>();
                    for(int i = 0; i<s.length(); i++){
                        temp.add(s.charAt(i));
                    }
                    if(temp.containsAll(one)){
                        //3
                        three = temp;
                    }
                    else{
                        //2, 5
                        if(six.containsAll(temp)){
                            //5
                            five = temp;
                        }
                        else{
                            //2
                            two = temp;
                        }


                    }


                }
            }

            nums.add(zero);
            nums.add(one);
            nums.add(two);
            nums.add(three);
            nums.add(four);
            nums.add(five);
            nums.add(six);
            nums.add(seven);
            nums.add(eight);
            nums.add(nine);

            String result = "";
            for(String s : second){
                HashSet<Character> temp = new HashSet<>();
                for(int i = 0; i<s.length(); i++){
                    temp.add(s.charAt(i));
                }

                for(int i = 0; i<nums.size(); i++) {
                    if (nums.get(i).equals(temp)) {
                        result += i;
                        break;
                    }
                }


            }

            counter += Integer.parseInt(result);






            /*
            for(int a = 0; a<second.length; a++){
                if(arr.contains(second[a].length())){
                    counter++;
                }
            }
            */


        }


        System.out.println(counter);
    }

    public static HashSet<Character> diff(HashSet<Character> a, HashSet<Character> b){
        HashSet<Character> temp = new HashSet<>(a);
        temp.removeAll(b);

        return temp;

    }

}