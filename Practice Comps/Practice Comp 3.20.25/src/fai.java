import java.util.*;
import java.io.*;

public class fai{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("fai".toLowerCase()+".dat"));
        int times = f.nextInt();
        f.nextLine();
        for (int i = 0; i < times; i++) {
            String[] names = f.nextLine().split(",");
            int edges =0 ;
            String start = f.nextLine();
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            String[] connect = f.nextLine().split(",");
            for(String e: names){
                map.put(e, new ArrayList<>());
            }
            for (int j = 0; j < connect.length; j++) {
                String[] pair = connect[j].split("<->");
//                System.out.println(Arrays.toString(pair));
                String node = pair[0];
                String c = pair[1];
                map.get(node).add(c);
                map.get(c).add(node);
                edges++;
            }
//            System.out.println(map);
            boolean possible = DFS(edges, map, start, start, new ArrayList<>(), null);
            if(possible){
                System.out.println("Test case "+(i+1)+": possible");
            }
            else{
                System.out.println("Test case "+(i+1)+": impossible");
            }
            f.nextLine();
        }
        f.close();
    }
    public boolean DFS(int ed, HashMap<String, ArrayList<String>> gr, String curr, String start, ArrayList<ArrayList<String>> visited, String prev){
        if(ed==0 && curr.equals(start)){
            return true;
        }
//        System.out.println(visited);
        if(ed<0 && curr.equals(start)){
            return false;
        }
        if(prev!=null){
            ArrayList<String> pair1 = new ArrayList<>();
            pair1.add(prev);
            pair1.add(curr);
            visited.add(pair1);
            ArrayList<String> pair2 = new ArrayList<>();
            pair2.add(curr);
            pair2.add(prev);
            visited.add(pair2);

        }
        for(String node: gr.get(curr)){
            ArrayList<String> pair1 = new ArrayList<>();
            ArrayList<String> pair2 = new ArrayList<>();
            pair1.add(node);
            pair1.add(curr);
            pair2.add(curr);
            pair2.add(node);
            System.out.println(pair1);
            if(!visited.contains(pair2) && !visited.contains(pair1)){
                if (DFS(ed - 1, gr, node, start, visited, curr)) {
                    return true;
                }
            }
        }
        return false;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new fai().run();
    }
}
