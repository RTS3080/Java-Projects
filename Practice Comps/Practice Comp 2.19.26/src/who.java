import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class who{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("who".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] characteristics = f.nextLine().toLowerCase().trim().split(" ");
            HashMap<String, String> hair = new HashMap<>();
            hair.put("white", "W".toLowerCase());
            hair.put("black", "BLK".toLowerCase());
            hair.put("red", "R".toLowerCase());
            hair.put("brown", "BR".toLowerCase());
            hair.put("blonde", "BL".toLowerCase());
            HashMap<String, String> eyes = new HashMap<>();
            eyes.put("blue", "BL".toLowerCase());
            eyes.put("brown", "BR".toLowerCase());
            eyes.put("green", "G".toLowerCase());
            int times2=f.nextInt(); f.nextLine();
            while(times2-->0){
                String question = f.nextLine().toLowerCase().trim();
                String[] q = question.split(" ");
//                System.out.println(question);
                if(question.matches("is your person \\w+\\?")){
                    System.out.println(q[3].equals(characteristics[0]+"?") ? "yes" : "no");
                }
                if(question.matches("is your person a \\w+\\?")){
                    System.out.println(q[4].charAt(0) == characteristics[1].charAt(0) ? "yes" : "no");
                }
                if(question.matches("does your person have \\w+ hair\\?")){
                    System.out.println(hair.get(q[4]).equals(characteristics[2]) ? "yes" : "no");
                }
                if(question.matches("does your person have \\w+ eyes\\?")){
                    System.out.println(eyes.get(q[4]).equals(characteristics[3]) ? "yes" : "no");
                }
                if(question.equals("does your person wear glasses?")){
                    System.out.println(characteristics[4].charAt(0)=='y' ? "yes" : "no");
                }
                if(question.equals("does your person wear a hat?")){
                    System.out.println(characteristics[5].charAt(0)=='y' ? "yes" : "no");
                }
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new who().run();
    }
}
