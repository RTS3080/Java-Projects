import java.util.*;
import java.io.*;

public class battlefield{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
//        Scanner f = new Scanner(new File("battlefield".toLowerCase()+".in"));
        int n = f.nextInt(); f.nextLine();
        String lns = "";
        while(f.hasNext()){
            String s = f.nextLine().trim()+"|";
//            if(s.equals("|") && lns.endsWith("|")){
//                n--;
//            }
            lns +=s;
        }
        String[] cases = lns.split("\\|\\|");
        for(String strs : cases) {
            String[] cs = strs.split("\\|");
            int r = cs.length;
            int c = 0;
            for (String s : cs) {
                c = Math.max(s.length(), c);
            }
//            System.out.println(r+" "+c);
            if (r < c) {
                System.out.println("BRAWL HAS ADVANTAGE");
            } else if (r > c) {
                System.out.println("CLASH HAS ADVANTAGE");
            } else System.out.println("EVEN BATTLEFIELD");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new battlefield().run();
    }
}
