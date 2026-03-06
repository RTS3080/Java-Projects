import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.stream.StreamSupport;

import static java.lang.Math.*;


public class factor {

    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("factor".toLowerCase() + ".in"));

        int cases = f.nextInt();

        while (cases-- > 0) {
            int check = f.nextInt();

            int orig = check;

            TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
            int i = 2;
            while (i * i <= check) {
                if (check % i == 0) {
                    if (!map.containsKey(i)) map.put(i, 0);
                    map.put(i, map.get(i) + 1);
                    check /= i;
                } else i++;
            }

            if (!map.containsKey(check)) map.put(check, 0);
            map.put(check, map.get(check) + 1);

            if (map.size() == 1 && map.containsKey(orig)) {
                System.out.println(check + " is prime");
            } else {
                StringBuilder temp = new StringBuilder();
                temp.append(orig).append(" = ");

                for (Integer key : map.keySet()) {
                    if (key == 1) continue;

                    if (map.get(key) == 1) temp.append(key).append(" x ");
                    else temp.append(key).append("^").append(map.get(key)).append(" x ");
                }
                String result = temp.toString();
                System.out.println(result.substring(0, result.length() - 3));
            }
        }
        f.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        new factor().run();
    }
}
