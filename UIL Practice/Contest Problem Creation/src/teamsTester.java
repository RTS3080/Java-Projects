import java.util.*;
import java.io.*;
import java.awt.*;

public class teamsTester{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("teams".toLowerCase()+".dat"));
        ArrayList<String> teams = new ArrayList<>();
        while(f.hasNext()){
            String s= f.nextLine().trim();
            if(teams.contains(s)){
                System.out.println("you're an idiot");
                System.out.println(s);
            }
            teams.add(s);
        }
        Collections.sort(teams);
        System.out.println(teams);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new teamsTester().run();
    }
}
