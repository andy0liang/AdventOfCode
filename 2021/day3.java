import java.util.*;
import java.io.*;
import java.net.*;
public class day3 {
    public static void main(String[] args) throws FileNotFoundException {


        File f = new File("2021/input3.txt");
        Scanner input = new Scanner(f);
        int lines = 0;
        ArrayList <String> in = new ArrayList <>();
        while(input.hasNextLine()){
            in.add(input.nextLine());
            lines++;
        }




        ArrayList <String> l1 = new ArrayList <>();
        ArrayList <String> l2 = new ArrayList<>();
        int counter = 0;
        String result = "";
        int prev = 0;

        int max = Integer.MIN_VALUE;
        int maxi = 0;

        int min = Integer.MAX_VALUE;
        int mini = 0;

        for(int x = 0; x<  lines; x++){
            //String a = input.nextLine();
            l1.add(in.get(x));
            l2.add(in.get(x));


        }
/*
        while(l1.size()>1) {
            int[] arr = new int[12];


            for (int x = 0; x < l1.size(); x++) {
                for (int y = 0; y < l1.get(x).length(); y++) {
                    if (l1.get(x).charAt(y) == '1') {
                        arr[y]++;
                    } else {
                        arr[y]--;
                    }
                }
            }

            String most = "";
            String least = "";
            for (int x = 0; x < arr.length; x++) {
                if (arr[x] >= 0) {
                    most += '1';
                    least += '0';
                } else {
                    most += '0';
                    least += '1';
                }
            }

            for(int x = 0; x<l1.size();x++){
                for(int y = 0; y<l1.get(0).length(); y++){
                    if(l1.get(x).charAt(y)!=most.charAt(y)){
                        l1.remove(x);
                        x--;
                        break;
                    }
                }
            }


        }

        int first = Integer.parseInt(l1.get(0), 2);
        while(l2.size()>1) {
            int[] arr = new int[12];


            for (int x = 0; x < l2.size(); x++) {
                for (int y = 0; y < l2.get(x).length(); y++) {
                    if (l2.get(x).charAt(y) == '1') {
                        arr[y]++;
                    } else {
                        arr[y]--;
                    }
                }
            }

            String most = "";
            String least = "";
            for (int x = 0; x < arr.length; x++) {
                if (arr[x] >= 0) {
                    most += '1';
                    least += '0';
                } else {
                    most += '0';
                    least += '1';
                }
            }

            for(int x = 0; x<l2.size();x++){
                for(int y = 0; y<l2.get(0).length(); y++){
                    if(l2.get(x).charAt(y)!=least.charAt(y)){
                        l2.remove(x);
                        x--;
                        break;
                    }
                }
            }


        }

        int second = Integer.parseInt(l2.get(0), 2);
*/


        for(int i = 0; l1.size()>1; i = (i+1)%12){
            counter = 0;

            for(int x = 0; x<l1.size();x++){
                if(l1.get(x).charAt(i)=='1'){
                    counter++;
                }
                else{
                    counter--;
                }
            }

            if(counter>=0){
                counter = 1;
            }
            else{
                counter = 0;
            }

            for(int x = 0; x<l1.size();x++){
                if(l1.get(x).charAt(i)!=counter+'0'){
                    l1.remove(x);
                    x--;
                }
            }

        }

        int first = Integer.parseInt(l1.get(0), 2);

        for(int i = 0; l2.size()>1; i = (i+1)%12){
            counter = 0;

            for(int x = 0; x<l2.size();x++){
                if(l2.get(x).charAt(i)=='1'){
                    counter++;
                }
                else{
                    counter--;
                }
            }

            if(counter>=0){
                counter = 0;
            }
            else{
                counter = 1;
            }

            for(int x = 0; x<l2.size();x++){
                if(l2.get(x).charAt(i)!=counter+'0'){
                    l2.remove(x);
                    x--;
                }
            }

        }

        int second = Integer.parseInt(l2.get(0), 2);



        System.out.println(first*second);







    }
}