import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.io.*;
import java.awt.*;

public class knockout{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("knockout".toLowerCase()+".dat"));

        int cases = f.nextInt();
        f.nextLine();

        while (cases-- > 0){
            int[] me = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] ceph = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            long[] meDp = new long[me.length];
            Arrays.fill(meDp, Integer.MAX_VALUE);

            meDp[0] = 0;

            for (int i = 0; i < me.length; i++){
                for (int j = 1; j <= me[i] && i+j < meDp.length; j++){
                    meDp[i+j] = Math.min(meDp[i+j], meDp[i]+1);
                }
            }

            long[] cephDp = new long[ceph.length];
            Arrays.fill(cephDp, Integer.MAX_VALUE);

            cephDp[0] = 0;

            for (int i = 0; i < ceph.length; i++){
                for (int j = 1; j <= ceph[i] && i+j < cephDp.length; j++){
                    cephDp[i+j] = Math.min(cephDp[i+j], cephDp[i]+1);
                }
            }

            long meScore = meDp[meDp.length-1];
            long cephScore = cephDp[cephDp.length-1];

            if (meScore < cephScore){
                System.out.println(format(meScore, cephScore));
                System.out.println("See you in Cancun");
            }
            else if (cephScore < meScore) {
                System.out.println(format(meScore, cephScore));
                System.out.println("He makes it look Cephortless");
            }
            else {
                System.out.println(format(meScore, cephScore));
                System.out.println("Overtime");
            }
        }

        f.close();
    }

    public String format(long meScore, long cephScore){
        return (meScore == Integer.MAX_VALUE ? "-1" : meScore + "") + ":"+ (cephScore == Integer.MAX_VALUE ? "-1" : cephScore + "");
    }



    public static void main(String[] args) throws FileNotFoundException{
        new knockout().run();
    }
}
