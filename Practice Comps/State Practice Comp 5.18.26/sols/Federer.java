import java.io.File;
import java.util.*;

public class Federer {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Throwable {
        new Federer().run();
    }

    public void run() throws Throwable {
        Scanner scan = new Scanner(new File("federer.dat"));
        int n = Integer.parseInt(scan.nextLine().trim());

        for (int t = 0; t < n; t++) {
            String[] dims = scan.nextLine().trim().split(" ");
            int R = Integer.parseInt(dims[0]);
            int C = Integer.parseInt(dims[1]);

            char[][] grid = new char[R][C];
            int startR = 0, startC = 0;
            int endR = 0, endC = 0;
            List<int[]> balls = new ArrayList<>();

            for (int i = 0; i < R; i++) {
                String line = scan.nextLine();
                for (int j = 0; j < C; j++) {
                    grid[i][j] = line.charAt(j);
                    if (grid[i][j] == 'S') {
                        startR = i;
                        startC = j;
                    } else if (grid[i][j] == 'T') {
                        endR = i;
                        endC = j;
                    } else if (grid[i][j] >= '1' && grid[i][j] <= '9') {
                        // Add placeholder - we'll sort by digit
                        balls.add(new int[]{i, j, grid[i][j] - '0'});
                    }
                }
            }

            // Sort balls by their number
            balls.sort((a, b) -> a[2] - b[2]);

            // Build list of waypoints: S -> 1 -> 2 -> ... -> T
            List<int[]> waypoints = new ArrayList<>();
            waypoints.add(new int[]{startR, startC});
            for (int[] ball : balls) {
                waypoints.add(new int[]{ball[0], ball[1]});
            }
            waypoints.add(new int[]{endR, endC});

            // BFS from each waypoint to the next
            int totalDist = 0;
            boolean possible = true;

            for (int i = 0; i < waypoints.size() - 1 && possible; i++) {
                int dist = bfs(grid, R, C, waypoints.get(i), waypoints.get(i + 1));
                if (dist == -1) {
                    possible = false;
                } else {
                    totalDist += dist;
                }
            }

            System.out.println(possible ? totalDist : -1);
        }
        scan.close();
    }
    static int bfs(char[][] grid, int R, int C, int[] start, int[] end) {
        if (start[0] == end[0] && start[1] == end[1]) {
            return 0;
        }

        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], dist = curr[2];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C &&
                        !visited[nr][nc] && grid[nr][nc] != '#') {

                    if (nr == end[0] && nc == end[1]) {
                        return dist + 1;
                    }

                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }
}
