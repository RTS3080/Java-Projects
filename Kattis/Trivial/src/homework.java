import java.util.*;
import java.io.*;

public class homework{

    public void run() throws FileNotFoundException{
//        Scanner f= new Scanner(new File("homework".toLowerCase()+".dat"));
        Scanner f = new Scanner(System.in);
        String[] ln = f.nextLine().split(";");
        int numProbs = 0;
        for(String s :ln){
            if(s.contains("-")){
                String[] a = s.split("-");
                int diff = Integer.parseInt(a[1])-Integer.parseInt(a[0])+1;
                numProbs+=diff;
            }
            else{
                numProbs+=1;
            }
        }
        System.out.println(numProbs);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new homework().run();
    }
}
