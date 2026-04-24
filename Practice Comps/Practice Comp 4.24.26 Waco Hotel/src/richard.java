import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class richard{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("richard".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        long[] factorial = new long[51];
        factorial[1] = 1;
        for (int i = 2; i <= 50; i++){
            factorial[i] = Math.min(Long.MAX_VALUE, factorial[i-1]*i);
        }

//        System.out.println(Arrays.toString(factorial));

        int cases = f.nextInt();
        for (int CASE = 1; CASE <= cases; CASE++){
            int permNum = f.nextInt()-1;
            f.nextLine();
            ArrayList<Character> chars = new ArrayList<>();
            String check = f.nextLine().trim();
            for (char each : check.toCharArray()) chars.add(each);

            Collections.sort(chars);
//            System.out.println(chars);

            String res = "";
            while (chars.size() > 1){
                long fact = factorial[chars.size()-1];

                int chooseInd = (int) (permNum / fact);
                res += chars.remove(chooseInd);
                permNum = (int) (permNum % fact);


//                System.out.println();
//                System.out.println(fact);
//                System.out.println(chooseInd+" "+permNum);
//                System.out.println(res);
//                System.out.println(chars);
//                System.out.println("-".repeat(10));
            }
            res += chars.get(0);
            System.out.printf("Password #%d: %s\n", CASE, res);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new richard().run();
    }
}
