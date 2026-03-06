import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class ternary{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("ternary".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] ln = f.nextLine().trim().split(" ");
            String out  ="";
            for(String s : ln){
                int chunkSize = s.length()/3;
                int[] chunks = new int[3];
                Arrays.fill(chunks,chunkSize);
                for (int i = 0; i < s.length()%3; i++) {
                    chunks[i]++;
                }
                String str = "";
                int currLen = 0;
                for(int n : chunks){
                    String part = s.substring(currLen, currLen+n);
                    part = new StringBuilder(part).reverse().toString();
                    str += part;
                    currLen += n;
                }
                out+=str+" ";
            }
            System.out.println(out.trim());

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ternary().run();
    }
}
