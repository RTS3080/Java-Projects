import java.util.*;
import java.io.*;
import java.awt.*;

import static java.lang.Math.*;


public class math {

    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("math".toLowerCase() + ".in"));
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int[] nums = Arrays.stream(f.nextLine().replaceAll("[\\{\\}]", "").split(",")).mapToInt(Integer::parseInt).toArray();
            double sum = Arrays.stream(nums).sum();
            Arrays.sort(nums);
            HashMap<Integer, Integer> counts = new HashMap<>();
            for (int n : nums) {
                counts.put(n, counts.getOrDefault(n, 0) + 1);
            }
            double median;
            if (nums.length % 2 == 1) {
                median = nums[nums.length / 2];
            } else {
                median = (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.;
            }
            ArrayList<Integer> modes = new ArrayList<>();
            int maxCount = -1;
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                }
            }
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                if (entry.getValue() == maxCount) {
                    modes.add(entry.getKey());
                }
            }
            Collections.sort(modes);
            double meanode = 0;
            for (int n : modes) {
                meanode += n;
            }
            meanode /= modes.size();
            double mediode = 0;
//            System.out.println(modes);
            if (modes.size() % 2 == 1) {
                mediode = modes.get(modes.size() / 2);
            } else {
                mediode = (modes.get(modes.size() / 2) + modes.get(modes.size() / 2 - 1)) / 2.;
            }
            String modeOut = "{";
            for (int n : modes) {
                modeOut += n + ",";
            }
            modeOut = modeOut.substring(0, modeOut.length() - 1);
            modeOut += "}";
            String[] outs = new String[5];
            outs[0] = getOut(sum / nums.length);
            outs[1] = getOut(median);
            outs[2] = modeOut;
            outs[3] = getOut(meanode);
            outs[4] = getOut(mediode);
            String res = "";
            for (String s : outs) {
                res += s + " ";
            }
            System.out.println(res.trim());


        }
        f.close();
    }

    String getOut(double d) {
        d *= 100;
        d = (int) d;
        d /= 100;
        String s = d + "";
        d *= 100;
//        if(d%10==0){
//            s = s.substring(0,s.length()-1);
//        }
        if (d % 100 == 0) {
            s = s.substring(0, s.indexOf("."));
        }
        return s;
    }


    public static void main(String[] args) throws FileNotFoundException {
        new math().run();
    }
}
