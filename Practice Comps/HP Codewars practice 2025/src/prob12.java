import java.util.*;
import java.io.*;

public class prob12{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob12".toLowerCase()+".in.txt"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            TreeMap<Integer, HashSet<Integer>> compositeSets = new TreeMap<>();
            boolean[] primes = new boolean[f.nextInt() + 1];
            Arrays.fill(primes, true);
            primes[0] = primes[1] = false;
            for (int i = 2; i < primes.length; i++) {
                if (!primes[i]) continue;
                compositeSets.put(i, new HashSet<>());
                for (int j = i * i; j < primes.length; j+=i) {
                    if (!primes[j]) continue;primes[j] = false;
                    compositeSets.get(i).add(j);
                }
            }

            for (int prime : compositeSets.keySet()) {
                if (compositeSets.get(prime).isEmpty()) continue;
                System.out.printf("Prime %d Composite Set Size: %d%n", prime, compositeSets.get(prime).size());
            }
            System.out.println("{" + compositeSets.keySet().toString().substring(1).replace("]", "}").replace(", ", ","));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob12().run();
    }
}
