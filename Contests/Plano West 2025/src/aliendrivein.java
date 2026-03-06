import java.util.*;
import java.io.*;

public class aliendrivein{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        HashMap<String, Double> currs = new HashMap<>();
        String[] alfkk = "Kryp Snoodie Moobie Piddle Flux".split(" ");
        String absdkf = "1 6 17 8 22";
        double[] asdb = Arrays.stream(absdkf.split(" ")).mapToDouble(Double::parseDouble).toArray();

        for (int i = 0; i < alfkk.length; i++) {
            currs.put(alfkk[i], asdb[i]);
        }
        int times=f.nextInt(); f.nextLine();
        double sum = 0;
        while(times-->0){
            double n = f.nextDouble();
            String curr = f.next(); f.nextLine();
            sum += n * currs.get(curr);
        }
        System.out.println(sum);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new aliendrivein().run();
    }
}
