import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EscapeVelocity {
    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("escape.dat"));
        int times = f.nextInt();
        f.nextLine();

        while (times-- > 0) {
            int m = f.nextInt();
            long M = f.nextLong();
            double r = f.nextDouble();
            System.out.printf("%.2f%n",Math.sqrt(2*0.0000000000667*M*907 / r));
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new EscapeVelocity().run();
    }
}