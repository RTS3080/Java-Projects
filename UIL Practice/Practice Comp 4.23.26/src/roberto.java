import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class roberto{
    ArrayList<Integer> factors;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("roberto".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int n = f.nextInt();
            factors=new ArrayList<>();
            getFactors(n);
            Collections.sort(factors);
            System.out.println(factors.toString().replaceAll("[\\[\\] ]", ""));
        }
        f.close();
    }
    void getFactors(int n){
        for (int i = 2; i <= n/2; i++) {
            if(n % i == 0){
                getFactors(n/i);
                getFactors(i);
                return;
            }
        }
        factors.add(0,n);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new roberto().run();
    }
}
