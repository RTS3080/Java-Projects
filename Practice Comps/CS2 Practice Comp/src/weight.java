import java.util.*;
import java.io.*;

public class weight{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("weight".toLowerCase()+".dat"));
        double weight = f.nextDouble();
        f.nextLine();
        ArrayList<String> food = new ArrayList<>();
        int times=7;
        while(times-->0){
            String[] ln = f.nextLine().trim().split(" ");
            for(String s : ln){
                if(!s.equals("exercise")){
                    food.add(s);
                    weight *=2;
                }
                else {
                    weight /= 2;
                }
            }
        }
        Collections.sort(food);
        for(String s : food){
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.print("Carden's currently weighing in at ");
        if(weight%1 == 0){
            System.out.println((int)weight);
        }
        else System.out.printf("%.2f\n",weight);
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new weight().run();
    }
}
