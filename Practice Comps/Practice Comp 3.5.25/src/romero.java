import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class romero{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("romero".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        System.out.println("Date"+" ".repeat(15)+"Attendance Gross      ATP   STP   Adults Stu/Child|");
        while(times-->0){
            String[] ln = f.nextLine().split("\\s+");
            String[] months = "January February March April May June July August September October November December".split(" ");
            String[] date = ln[0].split("/");
            String month = months[Integer.parseInt(date[0])-1];
            String day = date[1];
            String year = date[2];
            String d = month+" "+day+", "+year;
            int n = Integer.parseInt(ln[1]);
            double money = Double.parseDouble(ln[2]);
            double a = Double.parseDouble(ln[3]);
            double c = Double.parseDouble(ln[4]);
            //works
//            double numAdults = ((c*n-money)/(c-a));
//            double numChildren = n-numAdults;
            //works
//            double numChildren = (a * n - money) / (a - c);
//            double numAdults = n - numChildren;
            //works
            double numAdults = ((money-c*n)/(a-c));
            double numChildren = n-numAdults;
            //doesn't work
//            int numAdults = (int)((money-c*n)/(a-c));
//            int numChildren = n-numAdults;
//            System.out.println(((money-c*n)/(a-c)));
//            System.out.printf("%-18s %-10d $%,-9.2f $%-4.2f $%-4.2f %-6d%-10d|\n",d,n,money,a,c,numAdults,numChildren);

            System.out.printf("%-18s %-10d $%,-9.2f $%-4.2f $%-4.2f %-6.0f%-10.0f|\n",d,n,money,a,c,numAdults,numChildren);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new romero().run();
    }
}
