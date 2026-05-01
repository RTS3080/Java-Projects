import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Noah{
    class car implements Comparable<car>{
        String make;
        String model;
        int year;
        public car(String make, String model, int year){
            this.make = make;
            this.model = model;
            this.year = year;
        }
        public int compareTo(car car){
            if(!make.equals(car.make)) return make.compareTo(car.make);
            if(!model.equals(car.model)) return model.compareTo(car.model);
            return year - car.year;
        }
        public String toString(){
            return make + " " + model + " " + year;
        }
    }
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Noah".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();
        TreeMap<String, Integer> makes = new TreeMap<>();
        TreeMap<String, Integer> models = new TreeMap<>();
        TreeMap<Integer, Integer> years = new TreeMap<>();
        ArrayList<car> cars = new ArrayList<car>();
        for(int times = 0; times < numTimes; times++){
            String[] ln = f.next().split(",");
            makes.put(ln[0], makes.getOrDefault(ln[0], 0) + 1);
            models.put(ln[1], models.getOrDefault(ln[1], 0) + 1);
            years.put(Integer.parseInt(ln[2]), years.getOrDefault(Integer.parseInt(ln[2]), 0) + 1);
            cars.add(new car(ln[0], ln[1], Integer.parseInt(ln[2])));
        }
        Collections.sort(cars);
        System.out.println("---Data Sorted---");
        for(car car : cars){
            System.out.println(car);
        }
        System.out.println();
        System.out.println("---Make Breakdown---");
        for(String make : makes.keySet()){
            System.out.println(make+": "+makes.get(make));
        }
        System.out.println();
        System.out.println("---Model Breakdown---");
        for(String model : models.keySet()){
            System.out.println(model+": "+models.get(model));
        }
        System.out.println();
        System.out.println("---Year Breakdown---");
        for(Integer year : years.keySet()){
            System.out.println(year+": "+years.get(year));
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Noah().run();
    }
}
