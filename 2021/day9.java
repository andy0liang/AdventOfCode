import java.util.*;
import java.io.*;
import java.lang.Math;
import java.net.*;

public class day9 {
    public static HashSet<Integer> set;

    public static void main(String[] args) throws FileNotFoundException {


        File f = new File("2021/input9.txt");
        Scanner input = new Scanner(f);
        Scanner k = new Scanner(System.in);
        int lines = 0;
        ArrayList<String> in = new ArrayList<>();
        while (input.hasNextLine()) {
            in.add(input.nextLine());
            lines++;
        }
        int numrows = in.size();
        int numcols = in.get(0).length();

        int[][] board = new int[numrows][numcols];

        for (int x = 0; x < in.size(); x++) {
            for (int y = 0; y < in.get(x).length(); y++) {
                board[x][y] = in.get(x).charAt(y) - '0';
            }
        }

        boolean[][] visited = new boolean[numrows][numcols];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == 9) {
                    visited[x][y] = true;

                }
            }
        }
        ArrayList <Integer> sizes = new ArrayList <>();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {

                if(visited[x][y]){
                    continue;
                }
                sizes.add(recur(x, y, board, visited));
            }
        }

        Collections.sort(sizes);
        Collections.reverse(sizes);
        System.out.println(sizes.get(0)*sizes.get(1)*sizes.get(2));



        int total = 0;

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (x > 0 && board[x - 1][y] <= board[x][y]) {
                    continue;
                }
                if (x < board.length - 1 && board[x + 1][y] <= board[x][y]) {
                    continue;
                }
                if (y > 0 && board[x][y - 1] <= board[x][y]) {
                    continue;
                }
                if (y < board[0].length - 1 && board[x][y + 1] <= board[x][y]) {
                    continue;
                }
                total += 1 + board[x][y];
            }
        }

        System.out.println(total);


    }

    private static int recur(int x, int y, int[][] board, boolean[][] visited) {
        if(x < 0 || x >= board.length){
            return 0;
        }
        if(y < 9 || y >= board[0].length){
            return 0;
        }
        if(visited[x][y]){
            return 0;
        }
        visited[x][y] = true;
        int sum = 1;
        sum += recur(x+1, y, board, visited);
        sum += recur(x-1, y, board, visited);
        sum += recur(x, y+1, board, visited);
        sum += recur(x, y-1, board, visited);
        return sum;



    }
}