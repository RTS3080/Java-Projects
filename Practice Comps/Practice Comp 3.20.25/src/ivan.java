import java.util.*;
import java.io.*;

public class ivan{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ivan".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        String key = f.nextLine().trim();
        for(int a = 1; a<=times; a++){
            String s = f.nextLine().trim();
            double corr = 0;
            double wrong = 0;
            double skipped = 0;
            for (int i = 0; i < 40; i++) {
                if(s.charAt(i)=='_'){
                    skipped++;
                }
                else if(s.charAt(i) == key.charAt(i)){
                    corr++;
                }
                else wrong++;
            }
//            System.out.println(corr+" "+wrong+" "+skipped);
            double score = corr *6 - wrong * 2;
            int attempted = (int)(40-skipped);
            double perc = (100 * corr) / attempted;
            if(attempted==0){
                perc = 0;
            }
            System.out.printf("Exam #%d: %.0f %.1f\n", a, score, perc);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ivan().run();
    }
}
