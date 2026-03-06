import java.util.*;
import java.io.*;

public class isha{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("isha".toLowerCase()+".dat"));
        int[][] fly =
                {{179,443,294},
                {59,185},
                {54,65,190,181},
                {83,70,89},
                {61,89}};
        String[][] destinations =
                {{"Denver", "Charlotte", "Houston"},
                {"San", "Houston"},
                {"San", "Denver", "Charlotte", "Orlando"},
                {"San", "Houston", "Orlando"},
                {"Houston", "Charlotte"}};
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String line = f.nextLine();
            Scanner ln = new Scanner(line);
            int row;
            switch (ln.next()){
                case "San" : row=0; f.next(); break;
                case "Denver" : row = 1; break;
                case "Houston" : row = 2; break;
                case "Carlotte" :row = 3; break;
                case "Orlando" : row = 3; break;
                default : row=-1; break;
            }
            int hourStart = f.nextInt();
            f.next();
            int minStart = f.nextInt();
            boolean AM = f.next().equals("A.M.");
            int col;
            if(!AM)
                hourStart+=12;
            String des=f.nextLine();
            for (int i = 0; i < destinations[row].length; i++) {
                if(destinations[row][i].equals(des))
                    col=i;
            }
            Calendar cal=new GregorianCalendar();
            Date t = new Date(hourStart*60+minStart);
            cal.setTime(t);
            System.out.println(cal.getTime());


        }
        f.close();
    }
    public class City{
        String name;
        int timezone;
        public City(String n, int t){
            name=n;
            timezone = 0;
        }
    }

    public class Flight{
        ArrayList<City> cities;
        int time;
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        new isha().run();
    }
}
