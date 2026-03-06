import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.io.*;

public class Chocolate{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Choc".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0) {
            GregorianCalendar cal = new GregorianCalendar(2025, Calendar.JULY, 21);
            cal.add(Calendar.DAY_OF_YEAR,f.nextInt());
            SimpleDateFormat form = new SimpleDateFormat("M/d/YYYY");
            System.out.println(form.format(cal.getTime()));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Chocolate().run();
    }
}
