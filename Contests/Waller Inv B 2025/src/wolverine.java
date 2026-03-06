import org.w3c.dom.html.HTMLIsIndexElement;

import java.util.*;
import java.io.*;

public class wolverine{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("wolverine".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] date= f.nextLine().split("/");
            int mon=Integer.parseInt(date[0])-1;
            int day=Integer.parseInt(date[1]);
            int year=Integer.parseInt(date[2]);

            char change= f.next().charAt(0);
            int add = f.nextInt(); f.nextLine();
            GregorianCalendar gc = new GregorianCalendar(year, mon, day);
            System.out.println(day);
            if(change == 'D'){
                gc = new GregorianCalendar(year, mon, day+add);
            }
            else if(change == 'M'){
                gc = new GregorianCalendar(year, mon+add, day);
            }
            else if(change == 'Y'){
                gc = new GregorianCalendar(year+add, mon, day);
            }
            String[] months = "January February March April May June July August September October November December".split(" ");
            System.out.printf("%s %02d, %04d\n",months[gc.get(Calendar.MONTH)],gc.get(Calendar.DAY_OF_MONTH),gc.get(Calendar.YEAR));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new wolverine().run();
    }
}
