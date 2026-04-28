import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Bongo{
    HashMap<String, Integer> spamCounts;
    HashMap<String, Integer> safeCounts;
    HashSet<String> vocab;

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("BongoJudge".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt(); int numTests = f.nextInt();
        f.nextLine();
        spamCounts = new HashMap<>();
        safeCounts = new HashMap<>();
        vocab = new HashSet<>();
        int totalSpamWords = 0;
        int totalSafeWords = 0;
        int totalSpamEmails = 0;
        int totalSafeEmails = 0;
        for(int times = 0; times < numTimes; times++){
            String[] ln = f.nextLine().split(" ");
            boolean isSpam = ln[0].equals("spam");

            if(isSpam){
                totalSpamEmails++;
                totalSpamWords+=ln.length-1;
            }
            else {
                totalSafeEmails++;
                totalSafeWords+=ln.length-1;
            }

            HashMap<String, Integer> curCounts = isSpam ? spamCounts : safeCounts;
            for (int i = 1; i < ln.length; i++) {
                curCounts.put(ln[i], curCounts.getOrDefault(ln[i], 0) + 1);
                vocab.add(ln[i]);
            }
        }
        for(int times = 0; times < numTests; times++){

            double totalEmails = totalSafeEmails+totalSpamEmails;

            double spamProb = log(totalSpamEmails/totalEmails);
            double safeProb = log(totalSafeEmails/totalEmails);

            String[] ln = f.nextLine().split(" ");

            for(String s : ln){
                double spamCount = spamCounts.getOrDefault(s, 0) + 1;
                double safeCount = safeCounts.getOrDefault(s, 0) + 1;

                spamProb += log(spamCount/(totalSpamWords + vocab.size()));
                safeProb += log(safeCount/(totalSafeWords + vocab.size()));

            }
            System.out.println(spamProb > safeProb ? "spam" : "ham");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Bongo().run();
    }
}
