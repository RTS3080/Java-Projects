package appeals;

import java.util.*;
import java.io.*;

public class Chase {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("Judge Data\\chase.dat"));

        int T = in.nextInt();

        int[] dx = {-1, 1, 0,  0, 0, 0};
        int[] dy = { 0, 0, 1, -1, 0, 0};
        int[] dz = { 0, 0, 0,  0, 1, -1};

        for (int z = 0; z < T; z++) {
            int N = in.nextInt();
            int M = in.nextInt();
            int B = in.nextInt();

            boolean[][][] visited = new boolean[N][M][B];
            char[][][] grid = new char[N][M][B];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = in.next().toCharArray();
                    // System.out.println(grid[i][j]);
                }
            }


            int sx = 0;
            int sy = 0;
            int sz = 0;
            int ex = 0;
            int ey = 0;
            int ez = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    for (int k = 0; k < B; k++) {
                        if (grid[i][j][k] == 'O') {
                            sx = j;
                            sy = i;
                            sz = k;
                        } else if (grid[i][j][k] == 'J') {
                            ex = j;
                            ey = i;
                            ez = k;
                        }

                    }
                }
            }

            int nodes = 1;
            int nodes_next = 0;
            int dist = 0;
            boolean found = false;

            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.add(new int[]{sx, sy, sz});

            while (!q.isEmpty()) {
                int[] node = q.poll();
                visited[node[1]][node[0]][node[2]] = true;

                if (grid[node[1]][node[0]][node[2]] == 'J') {
                    found = true;
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int nx = node[0]+dx[i];
                    int ny = node[1]+dy[i];
                    int nz = node[2]+dz[i];

                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < B && !visited[ny][nx][nz] && grid[ny][nx][nz] != '#') {
                        q.add(new int[]{nx, ny, nz});
                        nodes_next++;
                    }
                }

                nodes--;
                if (nodes == 0) {
                    // for (int[] p : q) {
                    //     System.out.print(Arrays.toString(p) + " ");
                    // }
                    // System.out.println();
                    nodes = nodes_next;
                    nodes_next = 0;
                    dist++;
                }

            }

            if (found) {
                System.out.println("Let's get him R4, only " + dist + " seconds.");
            } else {
                System.out.println("He's gone.");
            }
        }
    }
}
