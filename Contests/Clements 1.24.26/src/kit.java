import java.util.*;
import java.io.*;

public class kit{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
//        Scanner f = new Scanner(new File("kit1".toLowerCase()+".in"));

        int numBrawlers = f.nextInt();
        int initialJump = f.nextInt();
        int decreaseAmt = f.nextInt();

        int max = 0;

        TreeMap<Integer, Integer> brawlerLoc = new TreeMap<>();

        for (int i = 0; i < numBrawlers; i++) {
            int loc = f.nextInt();

            max = Math.max(max, loc);

            if (!brawlerLoc.containsKey(loc)) brawlerLoc.put(loc, 0);
            brawlerLoc.put(loc, brawlerLoc.get(loc) + 1);
        }

        int lastPos = 0;
        int curJump = initialJump;
        int result = 0;

        for (int each : brawlerLoc.keySet()) {
            if (curJump < 0) break;
            while (each - lastPos > curJump && curJump >= 0) {
                lastPos = lastPos + curJump;
                curJump -= decreaseAmt;
            }

            if (each - lastPos <= curJump && curJump >= 0) {
                int amt = brawlerLoc.get(each);
                int powerLeft = curJump - (each - lastPos);
                powerLeft = (powerLeft - 1) / decreaseAmt;
                result += Math.max(amt, powerLeft);
                curJump -= Math.max(amt, powerLeft) * decreaseAmt;
            }
            else{
                break;
            }
            lastPos = each;
//            curJump -= decreaseAmt;
        }

        System.out.println(result);

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new kit().run();
    }
}
