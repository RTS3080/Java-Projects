import java.util.*;
import java.io.*;

public class Jared{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Jared".toLowerCase()+".dat"));
        int k = f.nextInt();
        f.nextLine();
        for (int x = 0; x < k; x++) {
            String[] in = f.nextLine().split(",");
            int cnt = 0;
            for (int i = 0; i < in.length-1; i++) {
                for (int j = i+1; j < in.length; j++) {
                    if (in[i].startsWith(in[j])||in[j].startsWith(in[i])) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt==0?"Democracy Prevails!": "There are "+cnt+" misinputs...");
        }


        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Jared().run();
    }
}
