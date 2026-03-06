import java.util.*;
import java.io.*;

public class howard{
    class Player implements Comparable<Player>{
        int number;
        String name;
        String pos;
        double TS;
        double ratio;
        public Player(int number, String name, String pos, double TS, double APG, double TPG){
            this.number = number;
            this.name = name;
            this.pos = pos;
            this.TS = TS;
            ratio = APG/TPG;
        }
        public int compareTo(Player p){
            if(!pos.equals(p.pos)){
                return poss.indexOf(pos)-poss.indexOf(p.pos);
            }
            if(this.TS > p.TS){
                return -1;
            }
            else if(this.TS < p.TS){
                return 1;
            }
            if(this.ratio > p.ratio){
                return -1;
            }
            else if(this.ratio < p.ratio){
                return 1;
            }
            return 0;
        }
        public String toString(){
            return pos+": "+number+". "+name;
        }
    }
    ArrayList<String> poss;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("howard".toLowerCase()+".dat"));
        poss = new ArrayList<>();
        String[] strs = "PG SG SF PF C".split(" ");
        for(String s : strs){
            poss.add(s);
        }
        int times=f.nextInt(); f.nextLine();
        ArrayList<Player> players = new ArrayList<>();
        while(times-->0){
            int number = f.nextInt();
            String name = f.next();
            String pos = f.next();
            double[] nums = new double[5];
            for(int i = 0; i < 5; i++){
                nums[i] = f.nextDouble();
            }
            double TS = nums[0]/(2*(nums[2]+.44*nums[3]));
            players.add(new Player(number,name,pos,TS,nums[1],nums[4]));
        }
        Collections.sort(players);
        ArrayList<String> positions = new ArrayList<>();
        for(Player p : players){
            if(!positions.contains(p.pos)){
                System.out.println(p);
                positions.add(p.pos);
            }
        }


        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new howard().run();
    }
}
