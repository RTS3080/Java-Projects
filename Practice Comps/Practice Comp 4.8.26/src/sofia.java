import java.util.*;
import java.io.*;


public class sofia{
    public static void main(String[] args) throws IOException {
        new sofia().run();
    }

    public void run() throws IOException {
        Scanner f = new Scanner(new File("sofia.dat"));

        int cases = f.nextInt();
        while (cases-- > 0) {
            int N = f.nextInt();
            f.nextLine();

            HashMap<String, Integer> map = new HashMap<>();
            String[] line = f.nextLine().trim().split(",");

            int count = 0;

            for (String each : line) {
                String[] split = each.split("-");
                String str1 = split[0];
                String str2 = split[1];

                if (!map.containsKey(str1)) map.put(str1, count++);
                if (!map.containsKey(str2)) map.put(str2, count++);
            }


            DSU dsu = new DSU(map.size());

            for (String each : line) {
                String[] split = each.split("-");
                String str1 = split[0];
                String str2 = split[1];

                dsu.union(map.get(str1), map.get(str2));
            }

            HashSet<Integer> origs = new HashSet<>();
            for (String each : line) {
                String[] split = each.split("-");
                String str1 = split[0];
                String str2 = split[1];

                origs.add(dsu.find(map.get(str1)));
                origs.add(dsu.find(map.get(str2)));
            }

//            System.out.println(origs.size());
            if (origs.size() > 1) {
                System.out.println("disconnected");
            }
            else System.out.println("connected");
        }
    }

    class DSU{
        int[] store;
        public DSU(int size){
            store = new int[size+100];
            Arrays.fill(store, -1);
        }

        public int find(int ind){
            if (store[ind] == -1) return ind;
            return store[ind] = find(store[ind]);
        }

        public void union(int one, int two){
            int pOne = find(one);
            int pTwo = find(two);
            if(pOne == pTwo) return;

            store[pOne] = pTwo;
        }
    }
}

//
//public class sofia{
//
//    public void run() throws FileNotFoundException{
//        Scanner f= new Scanner(new File("sofia".toLowerCase()+".dat"));
//        //Scanner f = new Scanner(new File("input.txt"));
//        int numTimes=f.nextInt();f.nextLine();
//        for(int times = 0; times < numTimes; times++){
//            int size=f.nextInt();
//            HashMap<String, Integer> map = new HashMap<>();
//            int count = 0;
//            String[] edges = f.next().split(",");
//            for(String edge : edges){
//                String[] s = edge.split("-");
//                if(!map.containsKey(s[0])){
//                    map.put(s[0], count++);
//                }
//                if(!map.containsKey(s[1])){
//                    map.put(s[1], count++);
//                }
//            }
//            DSU dsu = new DSU(map.size());
//            for(String edge : edges){
//                String[] s = edge.split("-");
//                dsu.union(map.get(s[0]), map.get(s[1]));
//            }
//            int base = dsu.find(0);
//            boolean connected = true;
//            for (int i = 0; i < map.size(); i++) {
//                if(dsu.find(i) != base){
//                    connected = false;
//                }
//            }
//            System.out.println(connected?"connected":"disconnected");
//
//        }
//        f.close();
//    }
//    class DSU{
//        int[] parent;
//
//        public DSU(int n){
//            parent = new int[n];
//            for (int i = 0; i < n; i++) {
//                parent[i] = i;
//            }
//        }
//        public void union(int a, int b){
//            int parentA = find(a);
//            int parentB = find(b);
//            if(parentA == parentB) {
//                return;
//            }
//            parent[parentA] = parentB;
//        }
//        public int find(int a){
//            if(parent[a] == a){
//                return a;
//            }
//            return parent[a] = find(parent[a]);
//        }
//    }
//
//
//    public static void main(String[] args) throws FileNotFoundException{
//        new sofia().run();
//    }
//}
