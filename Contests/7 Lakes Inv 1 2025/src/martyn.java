import java.util.*;
import java.io.*;

public class martyn{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("martyn".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int num = f.nextInt();
            ArrayList<Integer> pals = new ArrayList<>();
            char[] bases = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/".toCharArray();

            for (int i = 2; i < 37; i++) {
                String s = Integer.toString(num, i);
                StringBuilder rev = new StringBuilder();
                if (rev.reverse().toString().equals(s)) {
                    pals.add(i);
                }
            }

            for (int i = 37; i < 65; i++) {
                String s = "";
                int n = num;
                while (n / i > 0) {
                    s += bases[n % i];
                    n /= i;
                }

                s += n;

                StringBuilder rev = new StringBuilder(s);
                if (rev.reverse().toString().equals(s)) {
                    pals.add(i);
                }
            }

            if (pals.size() == 0) {
                System.out.println("None.");
            } else {
                System.out.println(pals.toString().replaceAll("[\\[\\]]", ""));
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new martyn().run();
    }
}
