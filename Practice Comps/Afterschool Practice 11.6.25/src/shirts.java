import java.util.*;
import java.io.*;
import java.awt.*;

public class shirts{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("shirts".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            ArrayList<shirt> shts = new ArrayList<>();
            int times2=f.nextInt(); f.nextLine();
            while(times2-->0){
                int id= f.nextInt();
                String color= f.next();
                String size = f.next();
                shts.add(new shirt(id, color, size));
            }
            Collections.sort(shts);
            String str = "";
            for(shirt s : shts){
                str+=s.toString()+" ";
            }
            System.out.println(str.trim());
        }
        f.close();
    }
    String sizeOrder = "SML";
    String colorOrder = "ROYGB";
    class shirt implements Comparable<shirt>{
        int id;
        String color;
        String size;
        public shirt(int id, String color, String size){
            this.id = id;
            this.color = color;
            this.size = size;
        }
        public int compareTo(shirt o){
            if(!o.color.equals(color)){
                return colorOrder.indexOf(color)-colorOrder.indexOf(o.color);
            }
            if(!o.size.equals(size)){
                return sizeOrder.indexOf(size)-sizeOrder.indexOf(o.size);
            }
            return id-o.id;
        }
        public String toString(){
            return id+"";
        }

    }


    public static void main(String[] args) throws FileNotFoundException{
        new shirts().run();
    }
}
