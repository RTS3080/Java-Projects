import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class shoes{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("shoes".toLowerCase()+".txt"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int count = 0;
            int[] numsInc = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] numsDec = new int[numsInc.length];
            int N = numsInc.length;
            System.arraycopy(numsInc, 0, numsDec, 0, numsInc.length);
            for (int i = 0; i < numsInc.length; i++) {
                int maxInd = i;
                int max = numsInc[i];
                for (int j = i + 1; j < numsInc.length; j++) {
                    if (numsInc[j] > max) {
                        max = numsInc[j];
                        maxInd = j;
                    }
                }
                if(i != maxInd){
                    count++;
                    int temp = numsInc[maxInd];
                    numsInc[maxInd] = numsInc[i];
                    numsInc[i] = temp;
                }
            }
            System.out.println(count);
            int minCount = count;
            count=0;
            for (int i = 0; i < N; i++) {
                int minInd = i;
                int min = numsDec[i];
                for (int j = i + 1; j < N; j++) {
                    if (numsDec[j] <= min) {
                        min = numsDec[j];
                        minInd = j;
                    }
                }
                if(i != minInd){
                    count++;
                    int temp = numsDec[minInd];
                    numsDec[minInd] = numsDec[i];
                    numsDec[i] = temp;
                }
                System.out.println(Arrays.toString(numsDec)+" "+count);

            }
            System.out.println(count);
            minCount = Math.min(minCount, count);
            System.out.println(Arrays.toString(numsInc));
            System.out.println(Arrays.toString(numsDec));
            System.out.println(minCount);
        }
        f.close();
    }




    public static void main(String[] args) throws FileNotFoundException{
        new shoes().run();
    }
}
