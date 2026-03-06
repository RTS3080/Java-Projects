import java.util.*;
import java.io.*;
import java.awt.*;

class Vendor implements Comparable<Vendor>{
    String name;
    double rating;
    double cost;
    public Vendor(String name, double rating, double cost) {
        this.name = name;
        this.rating = rating;
        this.cost = cost;
    }
    public int compareTo(Vendor o){
        if(rating!=o.rating){
            return -Double.compare(rating, o.rating);
        }
        if(cost!=o.cost){
            return Double.compare(cost, o.cost);
        }
        return name.compareTo(o.name);
    }
    public String toString(){
        return String.format("%s %.2f %.1f", name, cost, rating);
    }

}
public class vendors{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("vendors".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String event = f.next();
            int times2 = f.nextInt();
            String date = f.next();
            double maxCost = f.nextDouble();
            ArrayList<Vendor> vens = new ArrayList<>();
            loop:
            while(times2-->0){
                String name = f.next();
                double cost = f.nextDouble();
                double rating = f.nextDouble();
                String[] ln = f.nextLine().split(" ");
                for(String s : ln){
                    if(s.equals(date)){
                        continue loop;
                    }
                }
                if(cost>maxCost) continue loop;
                vens.add(new Vendor(name, rating, cost));
            }
            Collections.sort(vens);
            System.out.println(event+":");
            if(vens.size()==0){
                System.out.println("No Viable Options.");
            }
            else{
                int count =0;
                while(count<5 && count < vens.size()){
                    System.out.println((count+1)+": "+vens.get(count).toString());
                    count++;
                }
            }

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new vendors().run();
    }
}
