import java.util.*;
public class advent2020day14{

    public static void main(String[] args){
        //part 2
        foo();

        //Part 1
        Scanner input = new Scanner(System.in);
        String s;
        String mask = "";
        Long loc;
        Long val;
        StringBuilder bin;
        HashMap<Long, Long> map = new HashMap<>();
        for(int p = 0; p < 592; p++){
            s = input.nextLine();
            if(s.charAt(1) == 'a'){
                //mask
                mask = s.substring(7);
            }
            else{
                //mem
                loc = Long.parseLong(s.substring(4, s.indexOf(']')));
                val = Long.parseLong(s.substring(s.indexOf('=')+2));
                bin = new StringBuilder(Long.toBinaryString(val));
                while(bin.length() < 36){
                    bin.insert(0, '0');
                }
                for(int x = 0; x < mask.length(); x++){
                    if(mask.charAt(x) != 'X'){
                        bin.setCharAt(x, mask.charAt(x));
                    }
                }
                map.put(loc, Long.parseLong(bin.toString(), 2));
            }
        }
        long sum = 0;
        for(long x : map.values()){
            sum += x;
        }
        System.out.println(sum);



    }

    public static void foo(){
        Scanner input = new Scanner(System.in);
        String s;
        String mask = "";
        Long loc;
        Long val;
        StringBuilder bin;
        HashMap<Long, Long> map = new HashMap<>();
        for(int p = 0; p < 592; p++) {
            s = input.nextLine();
            if(s.charAt(1) == 'a'){
                //mask
                mask = s.substring(7);
            }
            else{
                //mem

                loc = Long.parseLong(s.substring(4, s.indexOf(']')));
                val = Long.parseLong(s.substring(s.indexOf('=')+2));
                bin = new StringBuilder(Long.toBinaryString(loc));

                while(bin.length() < 36){
                    bin.insert(0, '0');
                }

                for(int x = 0; x < bin.length(); x++){
                    if(mask.charAt(x) == '1'){
                        bin.setCharAt(x, '1');
                    }
                    else if(mask.charAt(x) == 'X'){
                        bin.setCharAt(x, 'X');
                    }
                }

                putRecur(map, bin, val, 0);
            }
        }
        long sum = 0;
        for(long x : map.values()){
            sum += x;
        }
        System.out.println("foo");
        System.out.println(sum);
        System.out.println("bar");

    }

    public static void putRecur(HashMap<Long, Long> map, StringBuilder bin, long val, int index){
        if(!bin.substring(index).contains("X")){
            map.put(Long.parseLong(bin.toString(), 2), val);
            System.out.println("writing to "+Long.parseLong(bin.toString(), 2) + "which is "+bin);
            return;
        }
        if(bin.charAt(index) == 'X'){
            bin.setCharAt(index, '0');
            putRecur(map, bin, val, index+1);
            bin.setCharAt(index, '1');
            putRecur(map, bin, val, index+1);
            bin.setCharAt(index, 'X');
        }
        else {
            putRecur(map, bin, val, index + 1);
        }
    }


}