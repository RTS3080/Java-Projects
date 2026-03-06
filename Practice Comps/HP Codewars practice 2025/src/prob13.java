import java.util.*;
import java.io.*;

public class prob13{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob13".toLowerCase()+".in.txt"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int times2 = f.nextInt(); f.nextLine();
            String s = f.nextLine();
            s =s.substring(1,s.length()-1);
            String[] ln = s.split("],\\[");
            String[][] form = new String[ln.length][times2];
            for(int i=0;i<ln.length;i++){
                form[i] = ln[i].replaceAll("[\\[\\]]","").split(",");
            }

            String[] things = {"Age", "Instagram", "Twitter", "Phone", "Email"};

            HashMap<String, ArrayList<String>> ppl = new HashMap<>();
            for (int i = 0; i < times2; i++) {
                ppl.put(form[0][i], new ArrayList<>());
            }
            for (int i = 0; i < times2; i++) {
                for (int j = 1; j < ln.length; j++) {
                    ppl.get(form[0][i]).add(form[j][i]);
                }
            }
            for (int i = 0; i < times2; i++) {
                String person = f.nextLine().trim();
                ArrayList<String> atts = ppl.get(person);
                System.out.println("Name: " + person);
                for (int j = 0; j < atts.size(); j++) {
                    System.out.println(things[j]+": " + atts.get(j));
                }
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob13().run();
    }
}
