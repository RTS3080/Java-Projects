package Solutions;

import java.security.KeyPair;
import java.util.*;
import java.io.*;

public class grocery {
    public static void main(String[] args) throws Exception {
        new grocery().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("grocery.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        for(int asdf = 1;asdf<=times;asdf++){
            f.nextLine();
            String[] list = f.nextLine().trim().split("\\s+");
            List<Store> al = new ArrayList<>();
            int M = f.nextInt();
            for (int i = 0; i < M; i++) {
                String name = f.next();
                int K = f.nextInt();
                Map<String, Double> m = new HashMap<>();
                for (int j = 0; j < K; j++) {
                    m.put(f.next(), f.nextDouble());
                }
                al.add(new Store(name, m));
            }
            for (int i = 0; i < list.length; i++) {
                String itemName = list[i];
                Collections.sort(al, (a, b) -> a.compareTo(itemName, b));
                al.get(0).best++;
            }
            Collections.sort(al, (a,b) -> b.best - a.best);
            System.out.println(al.get(0).name + "'s prices are top G!!!");
        }
        f.close();
    }
    class Store{
        String name;
        Map<String,Double> items;
        int best;
        public Store(String name, Map<String, Double> items){
            this.name = name;
            this.items = items;
            best = 0;
        }
        public int compareTo(String itemName, Store o){
            if(!items.containsKey(itemName) && o.items.containsKey(itemName)){
                return 1;
            }
            if (items.containsKey(itemName) &&  !o.items.containsKey(itemName)) {
                return -1;
            }
            if (items.containsKey(itemName) && o.items.containsKey(itemName)) {
                return Double.compare(items.get(itemName), o.items.get(itemName));
            }
            return 0;
        }
    }
}