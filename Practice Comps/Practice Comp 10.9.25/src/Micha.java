import java.util.*;
import java.io.*;
import java.awt.*;

public class Micha{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Micha".toLowerCase()+".dat"));
        HashMap<String, Integer> counts = new HashMap<>();
        ArrayList<String> tests = new ArrayList<>();
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String s = f.next();
            tests.add(s);
            counts.put(s,0);
        }
        String str = "";
        while(f.hasNext()){
            str+=f.nextLine().trim()+" ";
        }
        for(String s : counts.keySet()){
            for (int i = 0; i < str.length()-s.length(); i++) {
                if(str.substring(i,i+s.length()).toLowerCase().equals(s.toLowerCase())){
                    counts.put(s,counts.get(s)+1);
                }
            }
        }
        for(String s : tests){
            System.out.println("\""+s+"\" "+counts.get(s));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Micha().run();
    }
}
