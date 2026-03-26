import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class unique{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("unique".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        boolean[] notPrime = new boolean[2100];
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i < notPrime.length; i++) {
            if (notPrime[i]) continue;
            primes.add(i);

            for (int j = i * 2; j < notPrime.length; j += i) {
                notPrime[j] = true;
            }
        }

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int year = f.nextInt();

            int sum = 0;
            int sumLength = 0;
            int numSums = 0;

            int l = 0;
            for (int r = 0; r < primes.size(); r++) {
                sum += primes.get(r);

                while (year < sum) {
                    sum -= primes.get(l++);
                }

                if (year == sum) {
                    sumLength = Math.max(sumLength, r - l + 1);
                    numSums++;
                }
            }

            if (notPrime[year]) {
                System.out.println(year + " NOT A PRIME YEAR");
            } else if (sumLength == 1) {
                System.out.println(year + " PRIME YEAR");
            } else if (numSums == 2) {
                System.out.println(year + " PRIME YEAR AND THE SUM OF " + sumLength + " CONSECUTIVE PRIMES");
            } else {
                System.out.println(year + " PRIME YEAR AND THE SUM OF MORE THAN ONE SET OF CONSECUTIVE PRIMES");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new unique().run();
    }
}
