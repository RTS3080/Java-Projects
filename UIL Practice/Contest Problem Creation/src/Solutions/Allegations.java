package Solutions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Allegations {
    public void run() throws FileNotFoundException {
        Scanner file = new Scanner(new File("allegations.dat"));

        int times = file.nextInt();
        file.nextLine();

        while(times-- > 0) {
            String allegation = file.nextLine();

            if(allegation.contains("Empire")) System.out.println("The Empire did nothing wrong!");
            else System.out.println("It is peaceful in this galaxy.");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Allegations x = new Allegations();
        x.run();
    }
}