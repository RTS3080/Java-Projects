import java.util.*;
import java.io.*;

public class oklahomadrills{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("oklahomadrills".toLowerCase()+".in"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int len = f.nextInt();
            LinkedList<Integer> off = new LinkedList<>();
            LinkedList<Integer> def = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                off.add(f.nextInt());
            }

            for (int i = 0; i < len; i++) {
                def.add(f.nextInt());
            }

            while (!off.isEmpty() && !def.isEmpty()) {
                if (off.peek() > def.peek()) {
                    off.add(off.pop());
                    def.pop();
                } else if (off.peek() < def.peek()) {
                    off.pop();
                    def.add(def.pop());
                } else {
                    off.pop();
                    def.pop();
                }
            }

            if (off.isEmpty() && !def.isEmpty()) {
                System.out.println("Defense will win");
            } else if (def.isEmpty() && !off.isEmpty()) {
                System.out.println("Offense will win");
            } else {
                System.out.println("There is no winner");
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new oklahomadrills().run();
    }
}
