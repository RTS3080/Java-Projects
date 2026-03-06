import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class battlePlanet {
    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("Judge Data\\battleplanet.dat"));
        int times = f.nextInt();
        f.nextLine();

        while (times-- > 0) {
            int[] clones = Arrays.stream(f.nextLine().trim().split(" +")).mapToInt(Integer::parseInt).toArray();
            int[] clankers = Arrays.stream(f.nextLine().trim().split(" +")).mapToInt(Integer::parseInt).toArray();

            int[] forces = new int[clones.length];
            for (int i = 0; i < clones.length; i++) {
                forces[i] += clones[i] + clankers[i];
            }

            int max = forces[0];
            for (int i = 0; i < forces.length; i++) {
                max = Math.max(max, forces[i]);
            }
            ArrayList<Integer> res = new ArrayList<>();

            for (int i = 0; i < forces.length; i++) {
                if (forces[i] == max) {
                    res.add(i);
                }
            }

            System.out.println(res);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        new battlePlanet().run();
    }
}