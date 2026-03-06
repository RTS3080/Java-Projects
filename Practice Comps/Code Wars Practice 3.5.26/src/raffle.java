import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class raffle{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("raffle".toLowerCase()+".dat"));

        int day = 1;
        while (f.hasNext()){
            f.next();
            int C = f.nextInt();
            int P = f.nextInt();

            f.nextLine();

            HashSet<String> prizes = new HashSet<>();
            HashMap<String, LinkedList<String>> contestants = new HashMap<>();

            for (int i = 0; i < P; i++) {
                prizes.add(f.nextLine());
            }

            for (int i = 0; i < C; i++) {
                LinkedList<String> q = new LinkedList<>();
                String c = f.nextLine().trim();
                for (int j = 0; j < P; j++) {
                    q.add(f.nextLine().trim());
                }

                contestants.put(c, q);
            }

            System.out.println("Raffle #" + day++ + ":");

            for (int i = 0; i < C; i++) {
                String c = f.nextLine().trim();
                LinkedList<String> q = contestants.get(c);
                while (!prizes.contains(q.peek())) {
                    q.poll();
                }

                String p = q.poll();
                prizes.remove(p);
                System.out.println(c + " Wins " + p + "!!");
            }

            f.next();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new raffle().run();
    }
}
