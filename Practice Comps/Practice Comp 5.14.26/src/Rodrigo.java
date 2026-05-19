import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Rodrigo{
    class City implements Comparable<City> {
        String name;
        double trtg, price, crtg;
        int att;

        public City(String n, double t, double p, int a, double c) {
            name = n;
            trtg = t;
            price = p;
            att = a;
            crtg = c;
        }

        public int compareTo(City o) {
            if (att != o.att) return o.att - att;
            if (crtg != o.crtg) return Double.compare(o.crtg, crtg);
            if (price != o.price) return Double.compare(o.price, price);
            if (trtg != o.trtg) return Double.compare(o.trtg, trtg);
            return name.compareTo(o.name);
        }

        public String toString() {
            return name + " (" + trtg + ", " + price + ", " + att + ")";
        }
    }

    class Node {
        String city;
        double weight;

        public Node(String n, double w) {
            city = n;
            weight = w;
        }

        public String toString() {
            return city + " (" + weight + ")";
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Rodrigo".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int V = f.nextInt();
        int E = f.nextInt();

        HashMap<String, ArrayList<Node>> adj = new HashMap<>();
        HashMap<String, City> cityMap = new HashMap<>();
        ArrayList<String> vis = new ArrayList<>();

        double money = f.nextDouble();

        for (int i = 0; i < V; i++) {
            String name = f.next();
            cityMap.put(name, new City(name, f.nextDouble(), f.nextDouble(), f.nextInt(), f.nextDouble()));
        }

        for (int i = 0; i < E; i++) {
            String a = f.next();
            String b = f.next();
            double m = f.nextDouble();

            adj.putIfAbsent(a, new ArrayList<>());
            adj.putIfAbsent(b, new ArrayList<>());
            adj.get(a).add(new Node(b, m));
            adj.get(b).add(new Node(a, m));
        }

        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node("Dallas", 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            String cur = node.city;
            double w = node.weight;

            if (w > money) continue;
            if (vis.contains(cur)) continue;
            vis.add(cur);

            for (Node next : adj.getOrDefault(cur, new ArrayList<>())) {
                q.add(new Node(next.city, w + next.weight));
            }

        }

        vis.remove("Dallas");

        ArrayList<City> destinations = new ArrayList<>();

        for (String city : vis) {
            destinations.add(cityMap.get(city));
        }

        Collections.sort(destinations);
        int count = 0;

        for (City destination : destinations) {
            System.out.println(++count + ": " + destination.name);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Rodrigo().run();
    }
}
