import java.util.*;
import java.io.*;

public class graph_BFS {

    boolean[][] adj;
    int[][] shadow;
    int bmoves;
    int goal;
    HashSet<String> visited;
    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("graph".toLowerCase() + ".dat"));
        adj = new boolean[26][26];
        shadow = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                shadow[i][j] = Integer.MAX_VALUE;
            }
        }
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String[] ln = f.nextLine().split(" ");
            adj[ln[0].charAt(0) - 'A'][ln[1].charAt(0) - 'A'] = true;
            adj[ln[1].charAt(0) - 'A'][ln[0].charAt(0) - 'A'] = true;
        }

        int times2=f.nextInt(); f.nextLine();
        while(times2-->0){
            Queue<Node> q = new LinkedList<>();
            String start = f.next();
            String end = f.next();
            q.add(new Node(start,0));
            visited = new HashSet<>();
            bmoves = Integer.MAX_VALUE;

            while (!q.isEmpty()) {
                Node n = q.poll();
                String str = n.str;
                int moves = n.moves;
                if(!visited.contains(str)) {
                    if (str.equals(end)) {
                        bmoves = moves;
                        break;
                    }

                    visited.add(str);

                    int idx = str.charAt(0) - 'A';
                    for (int i = 1; i < 26; i++) {
                        if (adj[idx][i]) {
                            q.add(new Node(""+(char)('A'+i),moves+1));
                        }
                    }
                }
            }
            System.out.print("Does a match exist? "+start+" and "+end+": ");
            System.out.println(bmoves!=Integer.MAX_VALUE?"MATCH "+bmoves : "NO MATCH");
        }

    }

    class Node{
        String str;
        int moves;
        public Node(String str, int moves){
            this.str = str;
            this.moves = moves;
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new graph_BFS().run();
    }
}
