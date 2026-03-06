import java.util.*;
import java.io.*;
import java.awt.*;

public class irina{
    HashMap<String, Double> profitPerKg;

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("irina".toLowerCase()+".dat"));

        profitPerKg = new HashMap<>();

        profitPerKg.put("PENNIES", (1000.0/2.5)*0.01);
        profitPerKg.put("NICKELS", (1000.0/5)*0.05);
        profitPerKg.put("DIMES", (1000.0/2.25)*0.1);
        profitPerKg.put("QUARTERS", (1000.0/5.6)*0.25);
        profitPerKg.put("DOLLARS", (1000.0/8.1)*1.0);


        int cases = f.nextInt();
        while (cases-- > 0){
            int numBags = f.nextInt();
            Bag[] bags = new Bag[numBags];

            for (int i = 0; i < numBags; i++){
                Bag temp = new Bag(f.nextInt(), f.next());
                bags[i] = temp;
            }

            ArrayList<Integer>[] chosen = new ArrayList[46];
            for (int i = 0; i < 46; i++){
                chosen[i] = new ArrayList<>();
            }

            double[] dp = new double[46];

            for (int i = 0; i < numBags; i++){
                for (int j = 45; j >= 0; j--){
                    if (j - bags[i].kg >= 0){
                        double check = dp[j-bags[i].kg];
                        double possibleMax = check + bags[i].kg * profitPerKg.get(bags[i].type);

                        if (possibleMax > dp[j]){
                            ArrayList<Integer> temp = new ArrayList<>(chosen[j-bags[i].kg]);
                            temp.add(i);
                            chosen[j] = temp;

                            dp[j] = possibleMax;
                        }
                    }
                }

            }

            ArrayList<Bag> result = new ArrayList<>();

            for (int each: chosen[45]){
                result.add(bags[each]);
            }

            Collections.sort(result);

            for (Bag b: result){
                System.out.println("GRAB THE "+b.kg+" KG BAG OF "+b.type);
            }
            System.out.println();

        }

        f.close();
    }

    class Bag implements Comparable<Bag>{
        int kg;
        String type;
        public Bag(int kg, String type){
            this.kg = kg;
            this.type = type;
        }

        public int compareTo(Bag check){
            if (kg != check.kg) return check.kg-kg;
            double thisP = profitPerKg.get(type);
            double checkP = profitPerKg.get(check.type);

            if (thisP == checkP) return 0;
            else if (thisP < checkP) return 1;
            else return -1;
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new irina().run();
    }
}
