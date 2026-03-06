import java.util.*;
import java.io.*;

public class Dominik{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Dominik".toLowerCase()+".dat"));
        int times=f.nextInt();
        int tests = f.nextInt();
        f.nextLine();

        HashMap<String, Date> dates = new HashMap<>();
        timeloop:
        while(times-->0){
            String ln = f.nextLine();
            String[] d = ln.split("\\s+")[0].split("/");
            int year  = Integer.parseInt(d[0]);
            int month = Integer.parseInt(d[1]);
            int day = Integer.parseInt(d[2]);
            String[] arr = ln.split("\\s+");
            String s = "";
            for(int i=1; i<arr.length; i++){
                s += arr[i]+" ";
            }
            s = s.trim();
            dates.put(s, new Date(year,month,day));
        }
        while(tests-->0){
            String[] ln  = f.nextLine().split(":");
            Date a = dates.get(ln[0]);
            Date b = dates.get(ln[1]);
            GregorianCalendar gca = new GregorianCalendar();
            GregorianCalendar gcb = new GregorianCalendar();
            gca.setTime(a);
            long ad = gca.get(Calendar.DAY_OF_YEAR);
            gcb.setTime(b);
            long bd = gcb.get(Calendar.DAY_OF_YEAR);
            ad += (long)(a.getYear() * 365.25);
            bd += (long) (b.getYear() * 365.25);
            if(gca.isLeapYear(a.getYear()))
                ad++;
            if(gcb.isLeapYear(b.getYear()))
                bd++;
            System.out.printf("%,d\n",Math.max(Math.abs(bd-ad)-1,0));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Dominik().run();
    }
}
