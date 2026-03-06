import java.util.*;
import java.io.*;

public class helen{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("helen".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            String t1 = f.next();
            String op = f.next();
            String t2 = f.next();
            f.next();
            String t3 = f.next();

            if (t1.contains("x")) {
                int div = t1.matches(".*\\d.*") ? Integer.parseInt(t1.substring(0, t1.length() - 1)) : t1.matches("[+-].*") ? Integer.parseInt(t1.substring(0, 1) + 1) : 1;

                double res = Integer.parseInt(t3);
                switch (op.charAt(0)) {
                    case '+' -> {
                        res -= Integer.parseInt(t2);
                    }

                    case '-' -> {
                        res += Integer.parseInt(t2);
                    }

                    case '*' -> {
                        res /= Integer.parseInt(t2);
                    }

                    case '/' -> {
                        res *= Integer.parseInt(t2);
                    }
                }

                res /= div;

                System.out.printf("x = %.3f%n", res);
            } else if (t2.contains("x")) {
                int div = t2.matches(".*\\d.*") ? Integer.parseInt(t2.substring(0, t2.length() - 1)) : t2.matches("[+-].*") ? Integer.parseInt(t2.substring(0, 1) + 1) : 1;

                double res = Integer.parseInt(t3);
                switch (op.charAt(0)) {
                    case '+' -> {
                        res -= Integer.parseInt(t1);
                    }

                    case '-' -> {
                        res -= Integer.parseInt(t1);
                        res *= -1;
                    }

                    case '*' -> {
                        res /= Integer.parseInt(t1);
                    }

                    case '/' -> {
                        res = Integer.parseInt(t1) / res;
                    }
                }

                res /= div;

                System.out.printf("x = %.3f%n", res);
            } else {
                int div = t3.matches(".*\\d.*") ? Integer.parseInt(t3.substring(0, t3.length() - 1)) : t3.matches("[+-].*") ? Integer.parseInt(t3.substring(0, 1) + 1) : 1;

                double res = Integer.parseInt(t1);
                switch (op.charAt(0)) {
                    case '+' -> {
                        res += Integer.parseInt(t2);
                    }

                    case '-' -> {
                        res -= Integer.parseInt(t2);
                    }

                    case '*' -> {
                        res *= Integer.parseInt(t2);
                    }

                    case '/' -> {
                        res /= Integer.parseInt(t2);
                    }
                }

                res /= div;

                System.out.printf("x = %.3f%n", res);
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new helen().run();
    }
}
