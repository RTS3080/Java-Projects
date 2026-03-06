import java.util.*;
import java.io.*;
import java.awt.*;

public class musicCD{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("music".toLowerCase()+".dat"));
        ArrayList<String> songs = new ArrayList<>();
        ArrayList<Double> time = new ArrayList<>();

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] ln = f.nextLine().trim().split(" ");
            String name = "";
            for (int i = 0; i < ln.length-2; i++) {
                name+=ln[i]+" ";
            }
            name = name.trim();
            double mins = Double.parseDouble(ln[ln.length-2]);
            double secs = Double.parseDouble(ln[ln.length-1]);
            double t = mins + secs/60;
            songs.add(name);
            time.add(t);
        }
        String start = songs.get(0);
        String last = "";
        double t = 0;
        int count = 1;
        int lastI = -1;
        for (int i = 0; i < songs.size(); i++) {
            if(t + time.get(i)>=20){
                System.out.println("CD #"+count++);
                System.out.println(start);
                System.out.println(last);
                int mins = (int) Math.floor(t);
                long secs = Math.round(t%1*60);
                System.out.printf("%02d:%02d\n",mins,secs);
                start = songs.get(i);
                t = 0;
                lastI = i;
                System.out.println();
            }
            t+=time.get(i);
            last = songs.get(i);
        }
        if(t!=0){
            System.out.println("CD #"+count);
            start = songs.get(lastI);
            System.out.println(start);
            System.out.println(last);
            int mins = (int) Math.floor(t);
            long secs = Math.round(t%1*60);
            System.out.printf("%02d:%02d\n",mins,secs);
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new musicCD().run();
    }
}
