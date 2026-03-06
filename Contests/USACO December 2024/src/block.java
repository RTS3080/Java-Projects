import java.util.*;
import java.io.*;

public class block {

    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new File("block.out"));
        int N = f.nextInt();
        int Q = f.nextInt();

        boolean[][][] cheese = new boolean[N][N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(cheese[i][j], true);
            }
        }

        int[][] updates = new int[Q][3];
        for (int i = 0; i < Q; i++) {

            updates[i][0] = f.nextInt();
            updates[i][1] = f.nextInt();
            updates[i][2] = f.nextInt();
        }

        for (int i = 0; i < Q; i++) {
            int x = updates[i][0];
            int y = updates[i][1];
            int z = updates[i][2];

            cheese[x][y][z] = false;

            int configurations = countConfigurations(cheese, N);
            System.out.println(configurations);
            out.println(configurations);
            out.flush();
        }
    }

    private static int countConfigurations(boolean[][][] cheese, int N) {
        int count = 0;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                boolean validx = true;
                boolean validy = true;
                boolean validz = true;
                for (int z = 0; z < N; z++) {
                    if (cheese[x][y][z]) {
                        validx = false;
                    }
                    if(cheese[x][z][y]){
                        validy = false;
                    }
                    if(cheese[z][y][x]){
                        validz = false;
                    }
                    if(!validx && !validy && !validz){
                        break;
                    }
                }
                if (validx) count++;
                if (validy) count++;
                if (validz) count++;
            }
        }
        return count;
    }
}