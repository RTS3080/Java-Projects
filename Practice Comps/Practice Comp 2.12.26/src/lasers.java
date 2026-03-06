import java.util.*;
import java.io.*;


public class lasers{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("lasers".toLowerCase()+".dat"));

        int[] rMove = new int[]{-1, 0, 0, 1};
        int[] cMove = new int[]{0, -1, 1, 0};

        int cases = f.nextInt();
        while (cases-- > 0){
            int rows = f.nextInt();
            int cols = f.nextInt();
            f.nextLine();

            int startR = 0;
            int startC = 0;

            int numPlayers = 0;

            char[][] maze = new char[rows][cols];
            for (int r = 0; r < rows; r++){
                char[] line = f.nextLine().trim().toCharArray();

                for (int c = 0; c < cols; c++){
                    maze[r][c] = line[c];
                    if (maze[r][c] == 'S'){
                        startR = r;
                        startC = c;
                    }
                    if (maze[r][c] == 'P'){
                        maze[r][c] = (char)('0'+numPlayers++);
                    }
                }
            }

//            for (char[] each:maze) System.out.println(each);

            int[][][] sMat = new int[1 << numPlayers][rows][cols];
            for (int i = 0; i < sMat.length; i++){
                for (int r = 0; r < sMat[i].length; r++){
                    Arrays.fill(sMat[i][r], Integer.MAX_VALUE);
                }
            }

            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            q.offer(startR);
            q.offer(startC);
            q.offer(0);

//            System.out.println(startR);
//            System.out.println(startC);

            boolean result = false;

            loop:
            while (!q.isEmpty()){
                int d = q.poll();
                int r = q.poll();
                int c = q.poll();
                int t = q.poll();

                if (!inBound(r, c, rows, cols)) continue;
                if (sMat[d][r][c] <= t) continue;
                if (maze[r][c] == '#') continue;

                for (int i = 0; i < 4; i++){
                    int tempR = r+rMove[i];
                    int tempC = c+cMove[i];
                    if (!inBound(tempR, tempC, rows, cols)) continue;
                    if (Character.isDigit(maze[tempR][tempC])) {
                        if ((d & (1 << maze[tempR][tempC]-'0')) == 0) continue loop;
                    }
                }



                if (maze[r][c] == 'E'){
                    result = true;
                    break;
                }

                sMat[d][r][c] = t;

                for (int i = 0; i < 4; i++){
                    int tempR = r+rMove[i];
                    int tempC = c+cMove[i];

                    while (inBound(tempR, tempC, rows, cols) && maze[tempR][tempC] != '#'){
                        if (Character.isDigit(maze[tempR][tempC])) {
                            if ( (d & (1 << maze[tempR][tempC]-'0')) == 0) {
                                int newD = d | (1 << maze[tempR][tempC]-'0');
                                q.offer(newD);
                                q.offer(r);
                                q.offer(c);
                                q.offer(t);
                            }
                        }

                        tempR += rMove[i];
                        tempC += cMove[i];
                    }
                }

                for (int i = 0; i < 4; i++){
                    q.offer(d);
                    q.offer(r+rMove[i]);
                    q.offer(c+cMove[i]);
                    q.offer(t+1);
                }


            }
//
//            for (int i = 0; i < sMat.length; i++){
//                for (int R = 0; R < sMat[i].length; R++){
//                    System.out.println(Arrays.toString(sMat[i][R]));
//                }
//                System.out.println("-".repeat(10));
//            }

            if (result){
                System.out.println("LASERS!");
            }
            else {
                System.out.println("It appears I've been shot");
            }

//            System.out.println(result);

        }

        f.close();
    }

    public boolean inBound(int r, int c, int rows, int cols){
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    public static void main(String[] args) throws FileNotFoundException{
        new lasers().run();
    }
}
