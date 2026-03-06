import java.util.*;
import java.io.*;
import java.awt.*;

public class daiki{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("daiki".toLowerCase()+".dat"));
        ArrayList<sort> arr = new ArrayList<>();
        while(f.hasNext()){
            String[] ln = f.nextLine().split(",");
            arr.add(new sort(ln[0], ln[1], Integer.parseInt(ln[2]), Integer.parseInt(ln[3])));
        }
        Collections.sort(arr);
        for(sort s : arr){
            System.out.println(s);
        }
        f.close();
    }

    class sort implements Comparable<sort>{
        String name;
        String color;
        int weight;
        int weird;
        public sort(String name, String color, int weight, int w){
            this.name = name;
            this.color = color;
            this.weight = weight;
            this.weird = w;
        }
        public int compareTo(sort o){
            if(weight!=o.weight){
                return o.weight-weight;
            }
            if(!color.equals(o.color)){
                return color.compareTo(o.color);
            }
            if(weird!=o.weird){
                return o.weird-weird;
            }
            return name.compareTo(o.name);
        }
        public String toString(){
            return name;
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new daiki().run();
    }
}
