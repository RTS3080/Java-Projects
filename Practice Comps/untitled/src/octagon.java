import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class octagon {

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("octagon".toLowerCase()+".dat"));

        while (f.hasNext()){
            int s = f.nextInt();
            System.out.println(" ".repeat(s - 1) + "x".repeat(s));
            for (int i = 0; i < s - 2; i++) {
                System.out.println(" ".repeat(s - 2 - i) + "x" + " ".repeat(s + i * 2) + "x");
            }

            for (int i = 0; i < s; i++) {
                System.out.println("x" + " ".repeat(s * 3 - 4) + "x");
            }
            for (int i = s - 3; i >= 0; i--) {
                System.out.println(" ".repeat(s-2-i) + "x" + " ".repeat(s+i*2) + "x");
            }

            System.out.println(" ".repeat(s - 1) + "x".repeat(s));
            System.out.println();
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new octagon().run();
    }
}
