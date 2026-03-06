import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static class prob15 {

        public void run() throws FileNotFoundException {
            Scanner f= new Scanner(System.in);
            long n = f.nextLong();
            HashMap<Integer, Integer> counts = new HashMap<>();
            for (int i = 0; i < 10; i++) {
                counts.put(i, 0);
            }
            String s = n+"";
            for (int i = 0; i < s.length(); i++) {
                int a = Integer.parseInt(s.substring(i, i + 1));
                counts.put(a, counts.get(a)+1);
            }
            int max = -1;
            int maxCount = -1;
            for(Map.Entry<Integer, Integer> entry : counts.entrySet()){
                if(entry.getValue() > maxCount){
                    max = entry.getKey();
                    maxCount = entry.getValue();
                }
            }
            String finStr = (max+"").repeat(s.length());
            String sub = "";
            String add = "";
            int totabove = 0;
            int totbelow = 0;
    //        System.out.println(max);
            for(int i = 0; i < finStr.length(); i++){
                int a = Integer.parseInt(s.substring(i, i + 1));
    //            System.out.println(a);
                if(a>max){
                    sub+=a-max;
                    add+=0;
                    totabove+=a-max;
                }
                else if (a<max){
                    add+=max-a;
                    sub+=0;
                    totbelow+=max-a;
                }
                else{
                    sub+=0;
                    add+=0;
                }
            }
    //        System.out.println(totabove+" "+totbelow);
            if(totabove == totbelow) {
                System.out.println(n + " ORIGINAL");
                System.out.println(sub + " SUBTRACTED");
                System.out.println(add + " ADDED");
                System.out.println(finStr + " FINAL");
            }
            else{
                System.out.println(n + " ORIGINAL");
                System.out.println(sub + " AVAILABLE");
                System.out.println(add + " NEEDED");
                System.out.println(finStr + " IMPOSSIBLE");
            }

            f.close();
        }



        public static void main(String[] args) throws FileNotFoundException{
            new prob15().run();
        }
    }
}