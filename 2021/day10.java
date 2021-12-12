import java.util.*;
import java.io.*;
import java.lang.Math;
import java.net.*;

public class day10 {
    public static HashSet<Integer> set;

    public static void main(String[] args) throws FileNotFoundException {


        File f = new File("2021/input10.txt");
        Scanner input = new Scanner(f);
        Scanner k = new Scanner(System.in);
        int lines = 0;
        ArrayList<String> in = new ArrayList<>();
        while (input.hasNextLine()) {
            in.add(input.nextLine());
            lines++;
        }

        HashMap<Character, Integer> score = new HashMap<>();
        score.put(')', 3);
        score.put(']', 57);
        score.put('}', 1197);
        score.put('>', 25137);
        HashMap<Character, Integer> score2 = new HashMap<>();
        score2.put(')', 1);
        score2.put(']', 2);
        score2.put('}', 3);
        score2.put('>', 4);
        int total = 0;

        String open = "([{<";
        String close = ")]}>";
        HashSet<Integer> corrupted = new HashSet<>();
        for(int x = 0; x<lines; x++){
            ArrayDeque<Character> q = new ArrayDeque<>();
            for(int i = 0; i<in.get(x).length(); i++){
                if(open.contains(in.get(x).charAt(i)+"")){
                    q.add(in.get(x).charAt(i));
                }
                else{
                    if(open.indexOf(q.removeLast()) != close.indexOf(in.get(x).charAt(i))){
                        total+=score.get(in.get(x).charAt(i));
                        corrupted.add(x);
                        break;
                    }
                }
            }



        }
        long total2 = 0;
        ArrayList<Long> results = new ArrayList<>();
        for(int x =0 ; x<lines; x++){
            total2 = 0;
            if(corrupted.contains(x)){
                continue;
            }
            ArrayDeque<Character> q = new ArrayDeque<>();
            for(int i = 0; i<in.get(x).length(); i++) {
                if (open.contains(in.get(x).charAt(i) + "")) {
                    q.add(in.get(x).charAt(i));
                } else {
                    q.removeLast();
                }



            }
            while(!q.isEmpty()) {
                total2 *= 5;

                total2 += score2.get(close.charAt(open.indexOf(q.removeLast())));

            }
            results.add(total2);

        }




        System.out.println(total);

        Collections.sort(results);
        int l = results.size();



        System.out.println(results.get(l/2));

    }
}