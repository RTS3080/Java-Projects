import java.util.*;
import java.io.*;

public class wantedList{
    List<String> rankOrder = Arrays.asList("Kingpin Underboss Captain Operative Affiliate".split(" "));
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("wanted".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            ArrayList<criminal> criminals = new ArrayList<>();
            int times2=f.nextInt(); f.nextLine();
            while(times2-->0){
                String name = f.next();
                String rank = f.next();
                int crimes = f.nextInt();
                double strength = f.nextDouble();
                int caught = f.nextInt();
                String date = f.nextLine().substring(1);
                Scanner a = new Scanner(date);
                a.useDelimiter("/");

                Date bday = new Date(a.nextInt(),a.nextInt(),a.nextInt());

                criminals.add(new criminal(name,rank,crimes,caught,strength,bday));
            }
            Collections.sort(criminals);
            System.out.println("Most WANTED:");
            int count = 1;
            for (int i = 0; i < criminals.size(); i++) {
                System.out.println(i+1+". "+criminals.get(i));
//                System.out.println(criminals.get(i).compareTo(criminals.get(0)));
            }
            System.out.println("-".repeat(10));
        }
        f.close();
    }
    

    class criminal implements Comparable<criminal>{
        String name;
        int rankSpot;
        int numCrimes;
        double strength;
        int caughtCount;
        Date bday;
        public criminal(String name, String rank,int crimes, int caughtCount, double strength, Date bday){
            this.name = name;
            this.rankSpot = rankOrder.indexOf(rank);
            this.numCrimes = crimes;
            this.caughtCount = caughtCount;
            this.strength = strength;
            this.bday = bday;
        }
        public int compareTo(criminal o){
            if(name.equals("Steven")) return -1;
            if(name.equals("Nikhil")) return 1;

            if(rankSpot < o.rankSpot) return -1;
            if(rankSpot > o.rankSpot) return 1;

            if(numCrimes>o.numCrimes) return -1;
            if(numCrimes<o.numCrimes) return 1;

            if(strength>o.strength) return -1;
            if(strength<o.strength) return 1;

            if(caughtCount<o.caughtCount) return -1;
            if(caughtCount>o.caughtCount) return 1;

            if(!bday.equals(o.bday)) return bday.compareTo(o.bday);
            return -name.compareTo(o.name);
        }
        public String toString(){
            return name;
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        new wantedList().run();
    }
}
