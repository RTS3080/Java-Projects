import java.util.*;
import java.io.*;

public class robbery{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);

        double bal = f.nextDouble();
        int k = f.nextInt();
        f.nextLine();

        while  (k-->0){
            int robbers = f.nextInt();
            String[] time = f.next().split(":");
            int hour = Integer.parseInt(time[0]);
            int min = Integer.parseInt(time[1]);
            String thing = f.next();
            double sum = (0.1*robbers)*bal;
            if (thing.equals("AM")){
                if ((hour==8&&min==0)||hour<8||(hour==12)){
                    sum+=0.05*bal;
                }
            }else if (thing.equals("PM")){
                if (hour>=8){
                    sum+=0.05*bal;
                }
            }
            System.out.printf("%.3f",sum);
            bal-=sum;
            System.out.println();
        }
        System.out.printf("%.3f",bal);

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new robbery().run();
    }
}
