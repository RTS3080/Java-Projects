// troy davis

import java.util.*;
import java.io.*;

public class date {

    public static void main(String[] args) throws Exception {
        new date().run();
    }

    public void run() throws Exception {

        Scanner in = new Scanner(new File("date.dat"));
        int cases = in.nextInt(); in.nextLine();

        for(int i = 0 ; i < cases ; i++){

            int[] v1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            GregorianCalendar o =  new GregorianCalendar(v1[2], v1[0]-1, v1[1]);
            GregorianCalendar copy = new GregorianCalendar(v1[2], v1[0]-1,v1[1]+1);

            System.out.println(copy.get(Calendar.MONTH)!=o.get(Calendar.MONTH) && (o.get(Calendar.DAY_OF_WEEK)>=2 && o.get(Calendar.DAY_OF_WEEK)<=6) ? "TODAY IS THE DAY!" : "NO ROBBING!");


        }
    }
}