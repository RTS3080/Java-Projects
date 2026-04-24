import java.util.*;
import java.io.*;

import static java.lang.Math.*;


public class Ali{
    class Boxer{
        String name;
        int ranking;
        int lastFightDay;
        public Boxer(String name, int ranking){
            this.name = name;
            this.ranking = ranking;
            lastFightDay = Integer.MIN_VALUE/2;
        }
    }
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Ali".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int numBoxers = f.nextInt();
            int maxRankingDiff = f.nextInt();
            int recoveryDays = f.nextInt();
            int numMatches = f.nextInt();
            HashMap<String, Boxer> boxers = new HashMap<>();
            for (int i = 0; i < numBoxers; i++) {
                String name = f.next();
                int ranking = f.nextInt();
                boxers.put(name, new Boxer(name, ranking));
            }
            ArrayList<String> matches = new ArrayList<>();
            while(numMatches-- > 0){
                Boxer boxer1 = boxers.get(f.next());
                Boxer boxer2 = boxers.get(f.next());
                if(boxer1.ranking > boxer2.ranking){
                    Boxer temp = boxer1;
                    boxer1 = boxer2;
                    boxer2 = temp;
                }
                String date = f.next();
                int dateDay = getDayOfYear(date);
                int daysSinceLastFight1 = dateDay - boxer1.lastFightDay;
                int daysSinceLastFight2 = dateDay - boxer2.lastFightDay;
                if(abs(boxer1.ranking - boxer2.ranking) <= maxRankingDiff && daysSinceLastFight1 > recoveryDays && daysSinceLastFight2 > recoveryDays){
                    matches.add(date+": "+boxer1.name+" vs "+boxer2.name);
                    boxer1.lastFightDay=dateDay;
                    boxer2.lastFightDay=dateDay;
                }
            }
            System.out.println(matches.size());
            for(String s : matches){
                System.out.println(s);
            }
            System.out.println();
        }
        f.close();
    }
    int getDayOfYear(String s){
        String[] date = s.split("/");
        int month = Integer.parseInt(date[0]);
        int day = Integer.parseInt(date[1]);
        int[] daysPerMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        for (int i = 0; i < month-1; i++) {
            day+=daysPerMonth[i];
        }
        return day;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new Ali().run();
    }
}
