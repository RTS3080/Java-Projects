import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Paaus{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Paaus".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            int n = f.nextInt();
            String bad = f.next();
            ArrayList<String> strs = new ArrayList<>();
            strs.add("a"+n);
            strs.add("b0b"+Integer.toString(n, 2));
            strs.add("c0"+Integer.toString(n, 8));
            strs.add("d0x"+Integer.toString(n, 16));
            Collections.sort(strs, (a, b) -> a.length()==b.length() ? a.compareTo(b): a.length()-b.length());
            System.out.print("Case #"+times+": ");
            boolean printed = false;
            for (int i = 0; i < strs.size(); i++) {
                if(!strs.get(i).substring(1).contains(bad+"")) {
                    System.out.println(strs.get(i).substring(1));
                    printed = true;
                    break;
                }
            }
            if(!printed){
                System.out.println("Impossible");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Paaus().run();
    }
}
