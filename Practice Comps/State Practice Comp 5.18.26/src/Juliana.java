import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Juliana{
    class Employee {
        String name;
        int experience;
        String major;
        String field;

        public Employee(String name, int experience, String major, String field){
            this.name = name;
            this.experience = experience;
            this.major = major;
            this.field = field;
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Juliana".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

            int N = f.nextInt();
            int E = f.nextInt(); f.nextLine();

            HashMap<String, Employee> employees = new HashMap<>();
            HashMap<String, String[]> adj = new HashMap<>();

            for (int i = 0; i < E; i++) {
                String[] tokens = f.nextLine().trim().split(":");
                String name = tokens[0].trim();
                String[] data = tokens[1].trim().split(" +");

                String major = data[1];
                String field = data[2];
                int years = Integer.parseInt(data[0]);

                Employee emp = new Employee(name, years, major, field);

                employees.put(name, emp);

                String[] con = new String[(data.length - 3) / 2];

                for (int j = 0; j < (data.length - 3) / 2; j++) {
                    con[j] = data[j * 2 + 3] + " " + data[j * 2 + 4];
                }

                adj.put(name, con);
            }

        for (int i = 0; i < N; i++) {
            ArrayList<String> res = new ArrayList<>();

            LinkedList<String> q = new LinkedList<>();

            String start = f.nextLine().trim();
            int years = f.nextInt();
            String major = f.next();
            f.nextLine();

            q.add(start);

            HashSet<String> vis = new HashSet<>();

            while (!q.isEmpty()) {
                String cur = q.poll();
                Employee emp = employees.get(cur);

                if (!vis.add(cur)) continue;

                if (!cur.equals(start) && emp.experience >= years && (emp.major.equals(major) || emp.field.equals(major))) {
                    res.add(cur);
                }

                for (String next : adj.getOrDefault(cur, new String[0])) {
                    q.add(next);
                }
            }

            Collections.sort(res);

            System.out.println(res.toString().replaceAll("\\[|]", ""));
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Juliana().run();
    }
}
