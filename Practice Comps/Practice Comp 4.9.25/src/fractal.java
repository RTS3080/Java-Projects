import java.util.*;
import java.io.*;

public class fractal{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("fractal".toLowerCase()+".dat"));
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf<=times;asdf++){
            int r = f.nextInt(), t = f.nextInt();
            f.nextLine();
            Map<String,String> m = new HashMap<>();
            for (int i = 0; i < r; i++) {
                String[] ln = f.nextLine().trim().replaceAll("\\s+","").split("->");
                m.put(ln[0],ln[1]);
            }
            System.out.println("Fractal #" + asdf+":");
            for (int i = 0; i < t; i++) {
                int l = f.nextInt(), run = f.nextInt();
                f.nextLine();
                String ln = f.nextLine().replaceAll("\\s+","");
                for (int j = 0; j < run; j++) {
                    String res = "";
                    for (int k = 0; k < ln.length(); k++) {
                        if(m.containsKey(ln.substring(k,k+1))){
                            res += m.get(ln.substring(k,k+1));
                        }
                        else{
                            res+=ln.substring(k,k+1);
                        }
                    }
                    ln = res;
                }
                for (int j = 0; j < ln.length(); j++) {
                    System.out.print(ln.charAt(j) + " ");
                }
                System.out.println();
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new fractal().run();
    }
}
