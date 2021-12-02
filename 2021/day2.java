import java.util.*;
public class day2{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        ArrayList <Integer> arr = new ArrayList<>();

        ArrayList <String> in = new ArrayList <>();

        for(int x = 0; x<  1000; x++){
            in.add(input.nextLine());
        }
        int hor = 0;
        int depth = 0;
        int aim = 0;
        int a = 0;

        for(int x = 0; x<in.size(); x++){
            String[] spl = in.get(x).split(" ");

            if(spl[0].equals("forward")){
                hor+=Integer.parseInt(spl[1]);
                depth += Integer.parseInt(spl[1])*aim;
            }
            else if(spl[0].equals("down")){
                aim+=Integer.parseInt(spl[1]);
            }
            else{
                aim-=Integer.parseInt(spl[1]);
            }

        }

        System.out.println(depth*hor);







    }
}