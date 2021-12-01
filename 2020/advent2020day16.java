import java.util.*;
public class advent2020day16{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        ArrayList <Integer> lower = new ArrayList<>();
        ArrayList <Integer> higher = new ArrayList <>();

        for(int x = 0; x < 20; x++){

            String in = input.nextLine();
            String[] spl = in.split(" ");
            String[] first = spl[spl.length-3].split("-");
            String[] second = spl[spl.length-1].split("-");
            lower.add(Integer.parseInt(first[0]));
            higher.add(Integer.parseInt(first[1]));
            lower.add(Integer.parseInt(second[0]));
            higher.add(Integer.parseInt(second[1]));

        }








        boolean[] arr = new boolean[1000];


        for(int x = 0; x < lower.size(); x++){

            for(int i = lower.get(x); i <= higher.get(x); i++){
                arr[i] = true;
            }

        }

        System.out.println("Done");
        ArrayList <Integer> invalid = new ArrayList <>();
        String[] spll;
        HashSet<Integer> bad = new HashSet<>();
        ArrayList <int[]> t = new ArrayList <>();
        int a;
        for(int line = 0; line < 241; line++){
            spll = input.nextLine().split(",");
            t.add(new int[20]);
            for(int number = 0; number < 20; number++){
                a = Integer.parseInt(spll[number]);
                t.get(line)[number] = a;
                if(!arr[a]){
                    invalid.add(a);
                    bad.add(line);
                }
            }
        }





        int sum = 0;
        for(int x = 0; x < invalid.size(); x++){
            sum += invalid.get(x);
        }

        System.out.println(sum);


        t.add(new int[]{191,139,59,79,149,83,67,73,167,181,173,61,53,137,71,163,179,193,107,197});


        ArrayList <HashSet<Integer>> valid = new ArrayList <>();

        for(int x = 0; x<20;x++){
            valid.add(new HashSet<>());
            for(int y = 0; y<20; y++){
                valid.get(x).add(0);
            }
        }

        for(int x = 0; x<t.size(); x++){
            if(bad.contains(x)){
                continue;
            }
            for(int y = 0; y < t.get(x).length; y++){


                for(int z = 0; z < 20; z++) {
                    if (t.get(x)[y] < lower.get(z*2) || t.get(x)[y] > higher.get(z*2)) {
                        valid.get(y).remove(z);
                    }
                    if (t.get(x)[y] < lower.get((z*2)+1) || t.get(x)[y] > higher.get((z*2)+1)) {
                        valid.get(y).remove(z);
                    }
                }

            }


        }
        System.out.println("lmao");
        for(int x = 0; x<6; x++){
            for(int i : valid.get(x)){
                System.out.println(i);
            }
            System.out.println("next");
        }



    }
}