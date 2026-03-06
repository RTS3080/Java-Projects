import java.util.*;
import java.io.*;

public class veda{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("veda".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        HashMap<Character, Double > costs = new HashMap<>();
        timeloop:
        while(times-->0){
            String[] ln = f.nextLine().split("[,:]");
            double c = Double.parseDouble(ln[ln.length-1]);
            for (int i = 0; i < ln.length-1; i++) {
                costs.put(ln[i].charAt(0), c);
            }
        }
        int times2=f.nextInt(); f.nextLine();
        timeloop2:
        while(times2-->0){
            String ln = f.nextLine();
            double sum = 0;
            for(Character c : ln.toCharArray()){
                if(costs.containsKey(c)){
                    sum+=costs.get(c);
                }
            }
            System.out.printf("$%.2f\n", sum);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new veda().run();
    }
}
