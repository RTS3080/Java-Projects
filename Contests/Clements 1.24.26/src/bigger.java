import java.util.*;
import java.io.*;

public class bigger{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("bigger".toLowerCase()+".in"));
        int n = f.nextInt();
        int[] team1 = new int[n];
        int[] team2 = new int[n];
        for (int i = 0; i < n; i++) {
            team1[i] = f.nextInt();
        }
        for (int i = 0; i < n; i++) {
            team2[i] = f.nextInt();
        }
        int p1 = 0;
        int p2 = 0;
        while(p1 < n && p2 < n){
            if(team1[p1] > team2[p2]){
                team1[p1] += team2[p2];
                p2++;
            }
            else if(team1[p1] < team2[p2]){
                team2[p2] += team1[p1];
                p1++;
            }
            else{
                p1++;
                p2++;
            }
        }
//        System.out.println(Arrays.toString(team1));
//        System.out.println(Arrays.toString(team2));
//        System.out.println(p1+" "+p2);
        if(p1 < n){
            System.out.println("RED IS VICTORIOUS!");
        }
        else if(p2 < n){
            System.out.println("BLUE IS VICTORIOUS!");
        }
        else System.out.println("WE'RE ALL VICTORIOUS!");
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bigger().run();
    }
}
