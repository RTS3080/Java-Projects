import java.util.*;
import java.io.*;
import java.awt.*;

public class around{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("around".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        int[] zones = {17, 16, 15, 14};
        while(times-->0){
            int[] arr = Arrays.stream(f.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
            int[] hours = new int[4];
            for (int i = 0; i < zones.length; i++) {
                hours[i] = (zones[i] + arr[0]) % 24;
            }
            String out = "";
            for (int i = 0; i < hours.length; i++) {
                String morn = "AM";
//                System.out.println(hours[i]);
                if(hours[i] >= 12){
                    hours[i] %=12;
                    morn = "PM";
                }
                if(hours[i] == 0){
                    hours[i] = 12;
                }
                out+=String.format("%02d:%02d %s|",hours[i],arr[1],morn);
            }
            System.out.println(out.substring(0, out.length()-1));

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new around().run();
    }
}
