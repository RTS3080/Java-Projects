import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class watchtower {
    public double[] getInput(String input) {
        Pattern pat = Pattern.compile("\\((.+),(.+),(.+)\\)");
        Matcher matcher = pat.matcher(input);

        double[] res = new double[3];
        matcher.find();
        res[0] = Double.parseDouble(matcher.group(1));
        res[1] = Double.parseDouble(matcher.group(2));
        res[2] = Double.parseDouble(matcher.group(3));
        return res;
    }

    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("watchtower".toLowerCase() + ".dat"));

        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            double[] speed = getInput(f.next());
            double[] tower = getInput(f.next());
            double[] person = getInput(f.next());

            int time = -f.nextInt();

            for (int i = 0; i < 3; i++) {
                tower[i] += speed[i] * time;
            }

            double dist = 0.0;
            for (int i = 0; i < 3; i++) {
                dist += (person[i] - tower[i]) * (person[i] - tower[i]);
            }

            System.out.printf("%.3f%n", Math.sqrt(dist));

        }
        f.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        new watchtower().run();
    }
}
