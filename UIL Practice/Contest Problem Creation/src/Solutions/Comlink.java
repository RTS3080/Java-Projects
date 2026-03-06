import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Comlink {
    public void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("comlink.dat"));
        int times = scanner.nextInt();

        while(times-- > 0) {
            int messages = scanner.nextInt(), cipher = scanner.nextInt() % 26;
            scanner.nextLine();

            String[] codes = scanner.nextLine().split(" ");

            StringBuilder words = new StringBuilder();
            while(messages-- > 0) words.append(scanner.nextLine()).append(" ");

            int tot = 0;

            for (String s : codes) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    int x = s.charAt(i) - 97 + 26 + cipher;
                    builder.append((char) (x % 26 + 97));
                }

                if (words.toString().contains(builder.toString())) tot++;
            }

            System.out.println(
                    tot == codes.length ? "The dark side of the Force is strong with this one."
                    : tot == 0 ? "I’ve got a bad feeling about this..."
                    : "All systems nominal."
            );
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Comlink comlink = new Comlink();
        comlink.run();
    }
}