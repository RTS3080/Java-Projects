import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class yana{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("yana".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        String wtf1 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz.";
        String wtf2 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-abcdefghijklmnopqrstuvwxyz.";

        ArrayList<ArrayList<Character>> normal = new ArrayList<>();
        ArrayList<ArrayList<Character>> abnormal = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            normal.add(new ArrayList<>());
            abnormal.add(new ArrayList<>());
        }

        for (int i = 0; i < wtf1.length(); i++){
            int ind = i / 8;
            normal.get(ind).add(wtf1.charAt(i));
            abnormal.get(ind).add(wtf2.charAt(i));
        }

//        System.out.println(normal);
//        System.out.println(abnormal);

        int cases = f.nextInt();
        f.nextLine();

        for (int BIGCASE = 1; BIGCASE <= cases; BIGCASE++){
            String[] line = f.nextLine().trim().split(",");
            int[] shifts = new int[line.length];
            for (int i = 0; i < line.length; i++) shifts[i] = Integer.parseInt(line[i]);

            int numCases = shifts[8];

            for (int SMALLCASE = 1; SMALLCASE <= numCases; SMALLCASE++){
                String use = f.nextLine().trim();

                ArrayList<ArrayList<Character>> orig = use.contains("-") ? abnormal : normal;
                ArrayList<ArrayList<Character>> shifted = new ArrayList<>();

                for (ArrayList<Character> each : orig) shifted.add(new ArrayList<>(each));

                for (int i = 0; i < 8; i++) Collections.rotate(shifted.get(i), shifts[i]);

                String result = "";
                for (char each : use.toCharArray()) {
                    for (int i = 0; i < orig.size(); i++){
                        int ind = orig.get(i).indexOf(each);
                        if (ind != -1) result += shifted.get(i).get(ind);
                    }
                }
                System.out.printf("[%d:%d]--\"%s\"\n", BIGCASE, SMALLCASE, result);
            }
            System.out.println("=".repeat(10));


        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new yana().run();
    }
}
