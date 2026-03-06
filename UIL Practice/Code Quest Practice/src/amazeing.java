import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class amazeing{

    public void run() throws FileNotFoundException{
//        Scanner f = new Scanner(System.in);
        Scanner f= new Scanner(new File("1".toLowerCase()+".in"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt();
            int b = f.nextInt(); f.nextLine();
            int wallPieces = 1 + (b - 1)/3;
            int otherPieces = (b - wallPieces)/2;
            int cols = wallPieces + otherPieces;
            int startR = -1, startC = -1, endR = -1, endC = -1;

            char[][] mat = new char[rows][cols];
            int[][] shadow = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                Arrays.fill(shadow[i], Integer.MAX_VALUE);
                String ln = f.nextLine();
                int p = 0;
                int ind =0;
                while(p < ln.length()){
                    if(p%3 == 0){
                        mat[i][ind] = ln.charAt(p);
                        p++;
                    }
                    else{
                        mat[i][ind] = ln.charAt(p);
                        p +=2;
                    }
                    char curr = mat[i][ind];
                    if((curr+"").matches("[\\^<>v]")){
                        switch(curr){
                            case 'v' ->{
                                if(i==0){
                                    startR = i;
                                    startC = ind;
                                }
                                else{
                                    endR = i;
                                    endC = ind;
                                }
                            }
                            case '^' ->{
                                if(i==rows - 1){
                                    startR = i;
                                    startC = ind;
                                }
                                else{
                                    endR = i;
                                    endC = ind;
                                }
                            }
                            case '>' ->{
                                if(ind == 0){
                                    startR = i;
                                    startC = ind;
                                }
                                else{
                                    endR = i;
                                    endC = ind;
                                }
                            }
                            case '<'->{
                                if(ind == rows - 1){
                                    startR = i;
                                    startC = ind;
                                }
                                else{
                                    endR = i;
                                    endC = ind;
                                }
                            }
                        }
                    }
                    if(curr == '+' || curr == '|' || curr == '-'){
                        mat[i][ind] = '#';
                    }
                    ind++;

                }
            }
            for(char[] ch : mat){
                System.out.println(ch);
            }
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{startR, startC, 2});
            while(!q.isEmpty()){
                int[] arr = q.poll();
                int r= arr[0];
                int c= arr[1];
                int moves = arr[2];
                if( r < 0 || r>=rows || c<0 || c>=cols || shadow[r][c] <= moves || mat[r][c] == '#'){
                    continue;
                }
                shadow[r][c] = moves++;
                int[] dr = {1, -1, 0, 0};
                int[] dc = {0, 0, 1, -1};
                for (int i = 0; i < 4; i++) {
                    q.offer(new int[]{r+dr[i], c+dc[i], moves});
                }
            }
//            System.out.println(startR+" : "+startC+" | "+endR+" : "+endC);
            System.out.println(shadow[endR][endC]);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new amazeing().run();
    }
}
