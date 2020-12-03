import java.util.*;
public class advent2020day3 {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

int p = 0;

        ArrayList <String> in = new ArrayList <>();
        int counter = 0;
        for(int x = 0; x< 323 ; x++){
            in.add(input.nextLine());



        }
        int pos = 0;
        for(int x = 0; x<in.size();x++, pos+=3){

            if(in.get(x).charAt(pos%31)=='#'){
                counter++;
            }


        }
        p = counter;
        counter = 0;
        pos = 0;
        for(int x = 0; x<in.size();x++, pos+=1){

            if(in.get(x).charAt(pos%31)=='#'){
                counter++;
            }


        }
        pos = 0;
        p*=counter;
        counter = 0;
        for(int x = 0; x<in.size();x++, pos+=5){

            if(in.get(x).charAt(pos%31)=='#'){
                counter++;
            }


        }

        p*=counter;
        counter = 0;
        pos = 0;
        for(int x = 0; x<in.size();x++, pos+=7){

            if(in.get(x).charAt(pos%31)=='#'){
                counter++;
            }


        }
        pos = 0;
        p*=counter;
        counter = 0;
        for(int x = 0; x<in.size();x+=2, pos+=1){

            if(in.get(x).charAt(pos%31)=='#'){
                counter++;
            }


        }
        p*=counter;
        counter = 0;



        System.out.println(p);






    }


}
