import java.util.*;
import java.io.*;
import java.awt.*;

import static java.lang.Math.*;


public class rock {

    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("rock".toLowerCase() + ".in"));

        HashMap<String, String> map = new HashMap<>();
        map.put("cone", "starting");
        map.put("waffle", "starting");
        map.put("scup", "starting");
        map.put("cup", "starting");
        map.put("bcup", "starting");

        map.put("dip", "dip");
        map.put("scoop", "scoop");

        map.put("sprinkles", "topping");
        map.put("wc", "topping");
        map.put("cherry", "topping");

        map.put("cash", "cash");

        HashMap<String, Integer> scoopCounts = new HashMap<>();
        scoopCounts.put("cone", 2);
        scoopCounts.put("waffle", 4);
        scoopCounts.put("scup", 2);
        scoopCounts.put("cup", 3);
        scoopCounts.put("bcup", 4);

        int times = f.nextInt();
        f.nextLine();
        timesloop:
        while (times-- > 0) {
            String[] actions = f.nextLine().trim().toLowerCase().split(" +");

            if (!map.get(actions[0]).equals("starting")) {
                System.out.println("Your prospects for promotion are looking grim");
                continue;
            }

            int scoops = scoopCounts.get(actions[0]);
            boolean hasTopping = false;
            boolean wc = false;

            for (int i = 1; i < actions.length - 1; i++) {
                if (map.get(actions[i]).matches("starting|cash")) {
                    System.out.println("Your prospects for promotion are looking grim");
                    continue timesloop;
                }

                if (actions[i].equals("dip")) {
                    if (!actions[i - 1].matches("waffle|cone")) {
                        System.out.println("Your prospects for promotion are looking grim");
                        continue timesloop;
                    }
                }

                if (map.get(actions[i]).equals("topping")) {
                    hasTopping = true;
                }

                if (actions[i].equals("wc")) {
                    if (wc) {
                        System.out.println("Your prospects for promotion are looking grim");
                        continue timesloop;
                    }
                    wc = true;
                }

                if (actions[i].equals("cherry") && !actions[i - 1].equals("wc")) {
                    System.out.println("Your prospects for promotion are looking grim");
                    continue timesloop;
                }

                if (actions[i].equals("scoop")) {
                    if (hasTopping) {
                        System.out.println("Your prospects for promotion are looking grim");
                        continue timesloop;
                    }
                    scoops--;
                }
            }

            if (scoops >= scoopCounts.get(actions[0]) || scoops < 0) {
                System.out.println("Your prospects for promotion are looking grim");
                continue;
            }

            if (actions[actions.length - 1].equals("cash")) {
                System.out.println("You created a dessert with " + (scoopCounts.get(actions[0]) - scoops) + " scoop(s)");
            } else {
                System.out.println("Your prospects for promotion are looking grim");
            }
        }
        f.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        new rock().run();
    }
}
