import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Lost {
    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("lost.dat"));
        int times = f.nextInt();
        f.nextLine();

        while (times-- > 0) {
            String line = f.nextLine().trim();
            Pattern pattern = Pattern.compile("(?<symbol>[\\W_])(?<name>[A-Za-z]+)\\k<symbol>:\\((?<x>-?\\d+),(?<y>-?\\d+)\\)");
            Matcher matcher = pattern.matcher(line);

            String closest = "";
            int closestX = Integer.MAX_VALUE;
            int closestY = Integer.MAX_VALUE;
            while (matcher.find()) {
                String name = matcher.group("name");
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));

                if (closestX == Integer.MAX_VALUE || Math.hypot(x, y) < Math.hypot(closestX, closestY)) {
                    closest = name;
                    closestX = x;
                    closestY = y;
                }
            }

            if (closest.isEmpty()) {
                System.out.println("Lost in the Stars.");
            } else {
                System.out.println(closest);
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        new Lost().run();
    }
}