import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class jun{
    class city{
        String name;
        ArrayList<Double> temps;
        double precip;
        int maxWind;
        String windiestDay;
        double avgTemp;
        public city(String name){
            this.name = name;
            temps = new ArrayList<>();
            precip = 0;
            maxWind = 0;
            windiestDay = "";
        }
        void calculateAverage(){
            double sum = 0;
            for(double temp : temps){
                sum += temp;
            }
            avgTemp = sum / temps.size();
        }
    }
    public void run() throws FileNotFoundException{
        Scanner in= new Scanner(new File("jun".toLowerCase()+".dat"));
        String dat = "";
        while(in.hasNext()){
            dat+=in.next()+" ";
        }
        String[] data = dat.split(" ");
        Arrays.sort(data, (a, b) -> {
            return a.toString().split(",")[0].compareTo(b.toString().split(",")[0]);
        });
        String[] months = " Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec".split(" ");
        ArrayList<city> cities = new ArrayList<>();
        city coldest = new city("");
        double minTemp = Integer.MAX_VALUE;
        String coldDay = "";
        for(String str : data){
            String[] ln = str.split(",");
            String name = ln[1];
            String date = ln[0];
            double temp = Double.parseDouble(ln[2]);
            double precip = Double.parseDouble(ln[3]);
            int wind = Integer.parseInt(ln[4]);
            city curr = null;
            boolean found = false;
            for(city c : cities){
                if(c.name.equals(name)){
                    curr = c;
                    found = true;
                }
            }
            if(!found){
                curr = new city(name);
            }
            String[] dateArr = date.split("-");
            String month = months[Integer.parseInt(dateArr[1])];
            int dateDay = Integer.parseInt(dateArr[2]);
            String day = month +" "+dateDay;
            curr.temps.add(temp);
            curr.precip += precip;
            if(wind >= curr.maxWind){
                curr.maxWind = wind;
                curr.windiestDay = day;
            }
            if(!found){
                cities.add(curr);
            }
            if(temp <= minTemp){
                minTemp = temp;
                coldDay = day;
                coldest=curr;
            }
        }
        System.out.println("City Summaries\n");
        for(city c : cities){
            c.calculateAverage();
            System.out.println(c.name);
            System.out.printf(" Average Temp: %.1f F\n", c.avgTemp);
            System.out.printf(" Total Precip: %.2f in\n", c.precip);
            System.out.printf(" Windiest Day: %s (%d mph)\n", c.windiestDay, c.maxWind);
            System.out.println();
        }
        System.out.println("Coldest Reading Overall");
        System.out.printf(" %s on %s: %.1f F",  coldest.name,coldDay, minTemp);

    }



    public static void main(String[] args) throws FileNotFoundException{
        new jun().run();
    }

}
