import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class dice{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dice".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int[] a1 = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] a2 = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] b1 = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] b2 = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            HashMap<Integer, Integer> frequencyA = new HashMap<>();
            HashMap<Integer, Integer> frequencyB = new HashMap<>();
            for (int i = 0; i < a1.length; i++) {
                for (int j = 0; j < a2.length; j++) {
                    frequencyA.put(a1[i] + a2[j], frequencyA.getOrDefault(a1[i] + a2[j], 0) + 1);
                    frequencyB.put(b1[i] + b2[j], frequencyB.getOrDefault(b1[i] + b2[j], 0) + 1);
                }
            }
//            System.out.println(frequencyA);
//            System.out.println(frequencyB);
            int wins = 0, ties = 0, losses = 0;
            for(Map.Entry a :frequencyA.entrySet()){
                for(Map.Entry b :frequencyB.entrySet()){
                    if((int)a.getKey() > (int)b.getKey()){
                        wins+=(int)a.getValue() * (int)b.getValue();
                    }
                    else if((int)a.getKey() < (int)b.getKey()){
                        losses+=(int)a.getValue() * (int)b.getValue();
                    }
                    else{
                        ties+=(int)a.getValue() * (int)b.getValue();
                    }
                }
            }
            int sum = wins + losses + ties;
            double a = (double) wins / (double) sum;
            double b = (double) losses / (double) sum;
            System.out.printf("%.3f%% %.3f%%\n", a*100, b*100);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new dice().run();
    }
}
