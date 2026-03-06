import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.awt.*;

public class days{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("days".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int[] date = Arrays.stream(f.next().split("/")).mapToInt(Integer::parseInt).toArray();
            double revs = f.nextDouble();
            GregorianCalendar gc = new GregorianCalendar(date[2], date[0] - 1, date[1]);
            gc.add(Calendar.DAY_OF_MONTH, (int) (revs * 60190));
//            System.out.println(gc.get(Calendar.MONTH ) + " " + gc.get(Calendar.DAY_OF_MONTH) + " " + gc.get(Calendar.YEAR));
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
            String[] week = "a Sunday Monday Tuesday Wednesday Thursday Friday Saturday".split(" ");
            System.out.print(week[gc.get(Calendar.DAY_OF_WEEK)]+" ");
            System.out.println(sdf.format(gc.getTime()));

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new days().run();
    }
}
