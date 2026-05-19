/*
 * UIL Computer Science 2025
 * Invitational A Packet Solution
 */

import java.io.File;
import java.util.*;

public class Valery {
    public static void main(String[] args) throws Exception {
        new Valery().run();
    }

    public void run() throws Exception {
        Scanner input = new Scanner(new File("valery.dat"));

        int N = input.nextInt();

        HashMap<String, Vertex> DAG = new HashMap<>();

        while(N-->0) {
            String name = input.next();
            int M = input.nextInt();

            Vertex v = new Vertex(name);

            for(int times = 0; times < M; times++) {
                String s = input.next();
                v.addEdge(s);
            }
            DAG.put(name, v);
        }

        for(String s : DAG.keySet()) {
            Vertex v = DAG.get(s);
            for(String vertex: v.edges) {
                DAG.get(vertex).addDegree();
            }
        }

        StringBuilder output = new StringBuilder();

        while(!DAG.isEmpty()) {
            String key = "";
            Vertex next = null;
            for(String s : DAG.keySet()) {
                Vertex v = DAG.get(s);

                if(next == null) {
                    if(v.inDegree == 0) {
                        key = s;
                        next = v;
                    }
                }
                else if(v.inDegree == 0 && v.name.compareTo(next.name) < 0) {
                    key = s;
                    next = v;
                }
            }
            Vertex removed = DAG.remove(key);
            output.append(key);

            if(!DAG.isEmpty()) {
                output.append("->");
            }

            for(String s : removed.edges) {
                DAG.get(s).minusDegree();
            }
        }
        System.out.println(output);
        input.close();
    }
}

class Vertex {
    String name;
    Set<String> edges;
    int inDegree;

    public Vertex(String n) {
        edges = new HashSet<>();
        inDegree = 0;
        name = n;
    }

    public void addEdge(String s) {
        edges.add(s);
    }

    public void addDegree() {
        inDegree++;
    }

    public void minusDegree() {
        inDegree--;
    }
}