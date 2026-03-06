import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class sentences {
    public static void main(String[] args) throws Exception {
        new sentences().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sentences").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int p = f.nextInt();
            f.nextLine();
            Map<String,Integer> m = new HashMap<>();
            String[] ln = f.nextLine().trim().split("\\s+");
            List<String[]> al = new ArrayList<>();
            for (int i = 0; i < p; i++) {
                String[] person = f.nextLine().trim().split("\\s+");
                long year = 0;
                for (int j = 1; j < person.length; j++) {
                    year += Long.parseLong(person[j]) * Long.parseLong(ln[j-1].split("-")[1]);
                }
                al.add(new String[]{person[0],year+""});
            }
            Collections.sort(al,(a,b)-> a[0].compareTo(b[0]));
            for (int i = 0; i < al.size(); i++) {
                long year = Long.parseLong(al.get(i)[1]);
                if(year==0){
                    out.println(al.get(i)[0] + " is innocent.");
                }
                else{
                    out.print(al.get(i)[0] + " will serve " + year + " year");
                    if(year==1){
                        out.println("!");
                    }
                    else{
                        out.println("s!");
                    }
                }
            }
            out.println();
        }
        f.close();
    }
}