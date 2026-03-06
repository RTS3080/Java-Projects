import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class computer{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("computer".toLowerCase()+".dat"));

        int day = 1;
        while (f.hasNext()){
            TreeSet<Integer> lineSet = new TreeSet<>();
            TreeMap<Integer, String[]> lines = new TreeMap<>();

            int lineNum = 0;
            String line = " ";

            System.out.println("START " + day++);

            do {
                lineNum = f.nextInt();
                line = f.nextLine().trim();
                lineSet.add(lineNum);
                lines.put(lineNum, line.split(" +"));
            } while (!line.equals("END"));

            HashMap<String, Integer> vars = new HashMap<>();

            int l = lineSet.ceiling(0);
            while (!lines.get(l)[0].equals("END")) {
                String[] tokens = lines.get(l);

                switch (tokens[0]) {
                    case "LOAD" -> {
                        vars.put(tokens[1], Integer.parseInt(tokens[2]));
                    }

                    case "ADD" -> {
                        vars.put(tokens[1], vars.getOrDefault(tokens[1], 0) + Integer.parseInt(tokens[2]));
                    }

                    case "PRINT" -> {
                        System.out.println(vars.getOrDefault(tokens[1], 0));
                    }

                    case "IF" -> {
                        int val = vars.getOrDefault(tokens[1], 0);
                        if (val == Integer.parseInt(tokens[3])) {
                            l = Integer.parseInt(tokens[5]) - 1;
                        }
                    }
                }

                l = lineSet.ceiling(l + 1);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new computer().run();
    }
}
