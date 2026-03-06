import java.util.*;
import java.io.*;

public class Perfection{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Perfect".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int i = f.nextInt();
//            ArrayList<Integer> factors = new ArrayList<>();
            int sum = 0;
            for(int j=1;j<i;j++){
                if(i%j==0){
                    sum+=j;
                }
            }
            System.out.println(sum==i?"PERFECT":sum<i?"DEFICIENT":"ABUNDANT");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Perfection().run();
    }
}
