import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class backstory{
    int[] monthSums;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("backstory".toLowerCase()+".dat"));
        int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        monthSums = new int[12];
        for(int i = 1; i < 12; i++){
            monthSums[i] = monthSums[i-1] + monthDays[i-1];
        }
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] start = f.nextLine().trim().split("/");
            int startDate = Integer.parseInt(start[1]) + monthSums[Integer.parseInt(start[0])-1] + (int)(Integer.parseInt(start[2])*365.25);
            int times2=f.nextInt(); f.nextLine();
            ArrayList<String> dates = new ArrayList<>();
            while(times2-->0){
                String d = f.nextLine().trim();
                String[] st = d.split("/");
                int date = Integer.parseInt(st[1]) + monthSums[Integer.parseInt(st[0])-1] + (int)(Integer.parseInt(st[2])*365.25);
                if(date < startDate){
                    dates.add(d);
                }
            }
            Collections.sort(dates, (a, b) -> (calculateDate(a)- calculateDate(b)));
            for(String d : dates){
                System.out.println(d);
            }
            System.out.println();
        }
        f.close();
    }
    int calculateDate(String d){
        String[] st = d.split("/");
        return Integer.parseInt(st[1]) + monthSums[Integer.parseInt(st[0])-1] + (int)(Integer.parseInt(st[2])*365.25);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new backstory().run();
    }
}
