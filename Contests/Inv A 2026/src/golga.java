import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.io.*;
import java.awt.*;

public class golga{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("golga".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while(cases-->0){
            int numGears = f.nextInt();
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

            for (int i = 0; i < numGears; i++){
                int teethSize = f.nextInt();
                int teethNum = f.nextInt();

                if (!map.containsKey(teethSize)) map.put(teethSize, new ArrayList<>());
                map.get(teethSize).add(teethNum);
            }

            double ratio = 1;

            for (int each : map.keySet()){
                Collections.sort(map.get(each));

                ArrayList<Integer> check = map.get(each);

                int smallestInd = 0;
                int biggestInd = check.size()-1;

                double lastLargest = 0.0;

                while (smallestInd < biggestInd){
                    ratio *= (double) check.get(biggestInd) / check.get(smallestInd);
                    lastLargest = check.get(biggestInd);

                    smallestInd++;
                    biggestInd--;
                }

//                if (smallestInd == biggestInd){
//                    ratio *= lastLargest / check.get(smallestInd);
//                }
            }


            String res = String.format("%.8f", Math.log(ratio));
            res = res.replaceAll("0+$", "");
            if (res.endsWith(".")) res += "0";
            System.out.println(res);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new golga().run();
    }
}
