import java.util.*;
import java.io.*;

public class claudius{
    int r, c, Fcost, startR, startC, endR, endC;
    int[][] shadow;
    char[][] world;

    public boolean within(int row, int col){
        return row >= 0 && row < world.length && col >= 0 && col < world[row].length;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("claudius".toLowerCase()+".dat"));

        int cases = f.nextInt();
        for(int p=0; p<cases; p++){
            r = f.nextInt();
            c = f.nextInt();
            Fcost = f.nextInt();
            f.nextLine();
            shadow = new int[r][c];
//            System.out.println(shadow.length+" "+shadow[0].length);
//            System.out.println(r+" "+c);
            for (int[] each:shadow){
                Arrays.fill(each, Integer.MAX_VALUE);
            }
            world = new char[r][c];
            for (char[] each:world){
                Arrays.fill(each, ' ');
            }
            for (int i = 0; i < r; i++){
                String line = f.nextLine();
                for (int j = 0; j < c; j++){
                    char ch = line.charAt(j);
                    if (world[i][j] != ' ' && ch != 'E') continue;
                    world[i][j] = ch;
                    if (ch == 'S'){
                        startR = i;
                        startC = j;
                    }
                    if (ch == 'E'){
                        endR = i;
                        endC = j;
                    }
                    if (ch == 'A'){
                        for (int inR = i-1; inR <= i+1; inR++)
                            for (int inC = j-1; inC <= j+1; inC++)
                                if (within(inR,inC))
                                    world[inR][inC] = 'R';
                    }
                    if (ch == 'B'   ) {
                        for (int inR = i - 2; inR <= i + 2; inR++)
                            for (int inC = j - 2; inC <= j + 2; inC++)
                                if (within(inR, inC))
                                    world[inR][inC] = 'R';
                    }
                }
            }
            Queue<Integer> q = new LinkedList<>();
            q.offer(startR); q.offer(startC); q.offer(0);

            int[] rMove = {-1, 0, 1, 0};
            int[] cMove = {0, 1, 0, -1};

            while(!q.isEmpty()){
                int checkR = q.poll();
                int checkC = q.poll();
                int cost = q.poll();
                for (int i = 0; i < 4; i++){
                    int tempR = checkR + rMove[i];
                    int tempC = checkC + cMove[i];
                    int tempCost = cost;
                    if (within(tempR, tempC)){
                        if (world[tempR][tempC] == 'Q'){
                            boolean isForest = false;
                            for (int j = 0; j < 4; j++){
                                if (within(tempR + rMove[j], tempC + cMove[j])){
                                    if (world[tempR+rMove[j]][tempC+cMove[j]] == 'T'){
                                        isForest = true;
                                    }
                                }
                            }
                            if (isForest){
                                tempCost+=3;
                            }
                            else{
                                continue;
                            }
                        }
                        if (world[tempR][tempC] == 'M') tempCost+=3;
                        if (world[tempR][tempC] == 'T') tempCost+=2;
                        if (world[tempR][tempC] == 'R' || world[tempR][tempC] == 'V') continue;
                        if (world[tempR][tempC] == '.' || world[tempR][tempC] == 'E') tempCost += 1;
                        if (shadow[tempR][tempC] > tempCost){
                            shadow[tempR][tempC] = tempCost;
                            q.offer(tempR); q.offer(tempC); q.offer(tempCost);
                        }

                    }
                }
            }

            int result = shadow[endR][endC];
            if (result <= Fcost){
                System.out.println("Free at last, Free at last. "+(Fcost-(result))+" hour(s) to spare.");
            }
            else{
                System.out.println("Smokey the Bear is en route.");
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new claudius().run();
    }
}
