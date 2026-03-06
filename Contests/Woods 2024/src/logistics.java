import java.io.*;
import java.util.*;

public class logistics {
    HashMap<String,String> people;
    HashMap<String,ArrayList<String>> sites;
    HashMap<String,Double> shadow;
    double mincost;
    public void run() throws Exception {
        Scanner f = new Scanner(new File("logistics.dat"));
        int testCases = f.nextInt(); f.nextLine();
        for (int asdf = 0; asdf < testCases; asdf++) {
            int numMobs=f.nextInt(); int numSites=f.nextInt(); int numJobs=f.nextInt();
            people=new HashMap<>();
            sites=new HashMap<>();
            for (int i = 0; i < numMobs; i++) {
                String mob= f.next(); String[] members = f.nextLine().trim().split(" ");
                for(String x: members){
                    people.put(x,mob);
                }
            }
            for (int i = 0; i < numSites; i++) {
                String site= f.next(); String[] members = f.nextLine().trim().split(" ");
                ArrayList<String> x = new ArrayList<>(Arrays.asList(members));
                sites.put(site,x);
            }
            for (int i = 0; i < numJobs; i++) {
                mincost=Double.MAX_VALUE;
                String startPerson=f.next();
                String startSite=f.next(); f.next();
                String endPerson=f.next();
                String endSite=f.next();
                shadow= new HashMap<>();
                recur(startSite,startPerson,endSite,endPerson,0);
                System.out.printf(startSite+" "+startPerson+" -> "+endSite+" "+endPerson+" $%.2f\n",mincost);
            }
        }
    }
    public void recur (String hs,String hp,String es,String ep, double cost){
        if((!shadow.containsKey(hs+" "+hp)||cost<shadow.get(hs+" "+hp))&&cost<mincost){
            shadow.put(hs+" "+hp,cost);
            if(hs.equals(es)&&hp.equals(ep)){
                mincost=cost;
            }
            else{
                ArrayList<String> present=sites.get(hs);
                for (int i = 0; i < present.size(); i++) {
                    if(people.get(present.get(i)).equals(people.get(hp))){
                        recur(hs,present.get(i),es,ep,cost+12.5);

                    }
                    else{
                        recur(hs,present.get(i),es,ep,cost+19.75);
                    }
                }
                for(String key: sites.keySet()){
                    if(!key.equals(hs)){
                        if(sites.get(key).contains(hp)){
                            recur(key,hp,es,ep,cost+7.5);

                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        logistics a = new logistics();
        a.run();
    }
}