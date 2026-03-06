import java.util.*;
import java.io.*;
import java.awt.*;

public class fantasy{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("fantasy".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String p1 = f.next();
            String p2 = f.next();
            int ppt = f.nextInt();
            team[] teams = new team[2];
            for (int i = 0; i < 2; i++) {
                teams[i] = new team();
                for (int j = 0; j < ppt; j++) {
                    teams[i].fgm+=f.nextDouble();
                    teams[i].fga+=f.nextDouble();
                    teams[i].ftm+=f.nextDouble();
                    teams[i].fta+=f.nextDouble();
                    teams[i].threepm+=f.nextInt();
                    teams[i].pts+=f.nextInt();
                    teams[i].rb+=f.nextInt();
                    teams[i].ast+=f.nextInt();
                    teams[i].st+=f.nextInt();
                    teams[i].bl+=f.nextInt();
                    teams[i].tn+=f.nextInt();
                }
                teams[i].fgperc = teams[i].fga==0 ? 0 : teams[i].fgm / teams[i].fga;
                teams[i].ftperc = teams[i].fta==0 ? 0 : teams[i].ftm / teams[i].fta;
            }
            f.nextLine();
            int[] wins = new int[2];
            team t1 = teams[0];
            team t2 = teams[1];
//            System.out.println(t1);
//            System.out.println(t2);
            if(t1.fgperc>t2.fgperc){
                wins[0]++;
            }
            else if(t2.fgperc>t1.fgperc){
                wins[1]++;
            }
            if(t1.ftperc>t2.ftperc){
                wins[0]++;
            }
            else if(t2.ftperc>t1.ftperc){
                wins[1]++;
            }
            if(t1.threepm>t2.threepm){
                wins[0]++;
            }
            else if(t2.threepm>t1.threepm){
                wins[1]++;
            }
            if(t1.pts>t2.pts){
                wins[0]++;
            }
            else if(t2.pts>t1.pts){
                wins[1]++;
            }
            if(t1.rb>t2.rb){
                wins[0]++;
            }
            else if(t2.rb>t1.rb){
                wins[1]++;
            }
            if(t1.ast>t2.ast){
                wins[0]++;
            }
            else if(t2.ast>t1.ast){
                wins[1]++;
            }
            if(t1.st>t2.st){
                wins[0]++;
            }
            else if(t2.st>t1.st){
                wins[1]++;
            }
            if(t1.bl>t2.bl){
                wins[0]++;
            }
            else if(t2.bl>t1.bl){
                wins[1]++;
            }
            if(t1.tn<t2.tn){
                wins[0]++;
            }
            else if(t2.tn<t1.tn){
                wins[1]++;
            }
            if(wins[0]>wins[1]){
                System.out.println(p1+" wins!");
            }
            else if(wins[1]>wins[0]){
                System.out.println(p2+" wins!");
            }
            else{
                System.out.println("Tie.");
            }
        }
        f.close();
    }

    class team{
        double fgperc;
        double ftperc;
        double fgm;
        double fga;
        double ftm;
        double fta;
        int threepm;
        int pts;
        int rb;
        int ast;
        int st;
        int bl;
        int tn;
        public team(){
            fgm = 0;
            fga = 0;
            ftm = 0;
            fta = 0;
            threepm = 0;
            pts = 0;
            rb = 0;
            ast = 0;
            st = 0;
            bl = 0;
            tn = 0;
        }
        public String toString(){
            return fgperc+" "+ftperc+" "+" "+fgm+" "+fga+" "+ftm+" "+fta+" "+threepm+" "+pts+" "+rb+" "+ast+" "+st+" "+bl+" "+tn;
        }

    }


    public static void main(String[] args) throws FileNotFoundException{
        new fantasy().run();
    }
}
