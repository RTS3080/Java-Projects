import java.util.*;
import java.io.*;

public class que{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("que".toLowerCase()+".dat"));
        TreeMap<String, String> translate = new TreeMap<>();
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            translate.put(f.next(), f.next());
        }
        f.nextLine();
        while(f.hasNext()){
            String[] ln = f.nextLine().split(" ");
            for(String s : ln){
                System.out.print(translate.get(s)+" ");
            }
            System.out.println();
//            System.out.println(Arrays.toString(ln));
        }

        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new que().run();
    }
}
