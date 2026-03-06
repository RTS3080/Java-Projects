import java.util.*;
import java.io.*;

public class Priyanka{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Priyanka".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String orig = f.nextLine();
            String[] ln = orig.split("");
            ArrayList<String> vows = new ArrayList<>();
            ArrayList<String> cons = new ArrayList<>();
            String word = "";
//            System.out.println(Arrays.toString(ln));
            for(String s : ln){
                if(s.matches(".*[AEIOU].*"))
                    vows.add(s);
                else cons.add(s);
            }

            Collections.sort(vows);
            Collections.reverse(vows);
            Collections.sort(cons);
            for(String s : vows){
                word+=s;
            }
            for(String s : cons){
                word+=s;
            }
            if(word.equals(orig)){
                System.out.print("WOO-HOO ");
            }
            System.out.println(word );
        }
        f.close();
    }




    public static void main(String[] args) throws FileNotFoundException{
        new Priyanka().run();
    }
}
