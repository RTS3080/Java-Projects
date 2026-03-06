import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class War {
    public void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("war.dat"));
        int times = scanner.nextInt();

        while(times-- > 0) {
            long a = scanner.nextLong(), b = scanner.nextLong();
            if(a > b) System.out.println("The Rebels are victorious!");
            else System.out.println("The Empire prevails!");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        War x = new War();
        x.run();
    }
}