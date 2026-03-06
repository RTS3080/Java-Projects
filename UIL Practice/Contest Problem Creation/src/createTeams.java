import java.util.*;
import java.io.*;
import java.awt.*;

public class createTeams{

    public void run() throws FileNotFoundException{
        String[] passwords = new String[101];

        Scanner f= new Scanner(new File("passwords.dat"));
        for (int i = 1; i < 101; i++) {
            passwords[i]=f.next();
        }
        f.close();
        f= new Scanner(new File("teamcreation.dat"));
        Random r = new Random();
        boolean[] filled = new boolean[100];
        ArrayList<String> teams = new ArrayList<>();
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<String> passes = new ArrayList<>();
        while(f.hasNext()){
            String[] ln = f.nextLine().split(" ");
//            System.out.println(Arrays.toString(ln));
            String team = "";
            for (int i = 0; i < ln.length-2; i++) {
                team += ln[i] + " ";
            }
            team = team.trim();
            int noviceTeams= Integer.parseInt(ln[ln.length-2]);
            int advTeams= Integer.parseInt(ln[ln.length-1]);
            for (int i = 1; i <= noviceTeams; i++) {
                int a = -1;
                while(a<0 || filled[a]){
                    a = r.nextInt(51, 90);
                }
                teams.add(team+" Novice Team #"+i);
                usernames.add("team"+a);
                passes.add(passwords[a]);
                filled[a]=true;
            }
            for (int i = 1; i <= advTeams; i++) {
                int a= -1;
                while(a<0 || filled[a]){
                    a = r.nextInt(1,51);
                }
                teams.add(team+" Advanced Team #"+i);
                usernames.add("team"+a);
                passes.add(passwords[a]);
                filled[a] = true;
            }
//            System.out.println("-".repeat(25));
        }

        for(String str : teams){
            System.out.println(str);
        }
        for(String str : usernames){
            System.out.println(str);
        }
        for (String str : passes){
            System.out.println(str);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new createTeams().run();
    }
}
