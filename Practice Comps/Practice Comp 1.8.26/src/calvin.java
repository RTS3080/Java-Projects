import java.util.*;
import java.io.*;
import java.awt.*;

public class calvin{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("calvin".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int month = f.nextInt() - 1;
            int year = f.nextInt();
            GregorianCalendar gc = new GregorianCalendar(year, month, 1);
            int startDay = gc.get(Calendar.DAY_OF_WEEK) - 1;
            int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int daysInMonth = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
            int rows = Math.ceilDiv(startDay + daysInMonth, 7);
            int[][] mat = new int[rows][7];
            String[] months = "January February March April May June July August September October November December".split(" ");
            String monthName = months[month];
            System.out.println(" ".repeat(6)+monthName+" "+year);
            System.out.println("Su Mo Tu We Th Fr Sa");
            int count = 1;
            for (int i = startDay; i < 7; i++) {
                mat[0][i] = count++;
            }
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < 7; j++) {
                    if(count>daysInMonth){
                        break;
                    }
                    mat[i][j] = count++;
                }
            }
            for (int i = 0; i < rows; i++) {
                String s = "";
                for (int j = 0; j < 7; j++) {
                    if(mat[i][j] == 0)
                        s+="   ";
                    else
                        s+=String.format("%2d ", mat[i][j]);
                }
                System.out.println(s.substring(0, s.lastIndexOf(" ")));
            }
//            System.out.println(Arrays.deepToString(mat));
            System.out.println("-".repeat(20));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new calvin().run();
    }
}
