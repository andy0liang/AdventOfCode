import java.util.*;
public class day7{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList <String> in = new ArrayList<>();
        for(int x =0 ; x<2000;x++){
            in.add(input.nextLine());
        }
        int counter = 0;
        for(int x = 0; x<2000;x++){
            System.out.println(x);
            String s = in.get(x);
            boolean flag = false;
            boolean found = false;
            while(!s.isEmpty()) {
                if(s.contains("[")){
                    if(s.charAt(0)=='['){
                        if(hasAbba(s.substring(0, s.indexOf(']')))){
                            break;
                        }
                        s = s.substring(s.indexOf(']')+1);
                    }
                    else{
                        if(hasAbba(s.substring(0, s.indexOf('[')))){
                            found = true;
                        }
                        s = s.substring(s.indexOf('['));
                    }
                }
                else{
                    if(hasAbba(s) || found){
                        counter++;

                    }
                    break;
                }

            }
        }

        System.out.println(counter);



    }

    public static boolean hasAbba(String s){
        for(int x = 0; x<s.length()-3; x++){
            if(s.charAt(x)==s.charAt(x+3) && s.charAt(x+1) == s.charAt(x+2) && s.charAt(x) != s.charAt(x+1)){
                return true;
            }
        }
        return false;
    }

}