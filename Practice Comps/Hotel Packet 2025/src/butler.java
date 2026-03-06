import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
import java.awt.*;

public class butler{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("butler".toLowerCase()+".dat"));
        while(true){
            String s = f.next();
            if(s.equals("ENDOFINPUT")) break;
            else if(s.equals("START")){
                int m = f.nextInt();
                int n = f.nextInt();
                f.nextLine();
                ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    String[] line = f.nextLine().trim().split(" ");
                    adj.add(i, new ArrayList<>());
                    for (int j = 0; j < line.length; j++) {
                        String e = line[j];
                        if(!e.isBlank()){
                            int node = Integer.parseInt(e);
                            adj.get(i).add(node);
                        }
                    }

                }
                System.out.println(adj);
                String end = f.nextLine();
                Queue<int[]> q = new LinkedList<>();
                int[] start = {m, 0};
                boolean[] vis = new boolean[n];
                q.offer(start);
                while(!q.isEmpty()){
                    int[] poll = q.poll();
                    System.out.println(Arrays.toString(poll));
                    int curr = poll[0];
                    int edges = poll[1];
                    vis[curr]=true;
                    if(curr==0 && edges!=0){
                        System.out.println("YES "+edges);
                        break;
                    }
                    ArrayList<Integer> neighbors = adj.get(curr);
                    for(int i : neighbors){
                        if(!vis[i]){
                            int news = edges+1;
                            int[] add = {i, news};
                            q.offer(add);
                        }
                    }
                }
                System.out.println(Arrays.toString(vis));
                System.out.println("NO");
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new butler().run();
    }
}

