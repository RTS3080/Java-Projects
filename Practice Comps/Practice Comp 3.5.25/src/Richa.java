import java.util.*;
import java.io.*;

public class Richa{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Richa".toLowerCase()+".dat"));
        HashMap<Character, Integer> credits = new HashMap<>();
        credits.put('Y', 4);
        credits.put('S', 2);
        credits.put('Q', 1);
        HashMap<Character, Double> letterVals = new HashMap<>();
        letterVals.put('A', 4.5);
        letterVals.put('B', 3.5);
        letterVals.put('C', 2.5);
        letterVals.put('D', 1.0);
        letterVals.put('F', 0.0);

        int classes = f.nextInt();
        HashMap<String, String> classProperties = new HashMap<>();
        for(int i = 0; i < classes; i++)
            classProperties.put(f.next(), f.next());

        while (f.hasNext()){
            String let1 = f.next()+" ", prop1 = classProperties.get(f.next());
            int cred1 = credits.get(prop1.charAt(1));
            double val1 = letterVals.get(let1.charAt(0));
            val1 = plusminusMod(val1,let1.charAt(1));
            val1 = honorsMod(val1, prop1.charAt(0));


            String let2 = f.next()+" ", prop2 = classProperties.get(f.next());
            int cred2 = credits.get(prop2.charAt(1));
            double val2 = letterVals.get(let2.charAt(0));
            val2 = plusminusMod(val2,let2.charAt(1));
            val2 = honorsMod(val2, prop2.charAt(0));
            System.out.printf("%.3f\n",(val1 * cred1 + val2 * cred2) / (cred1 + cred2));



        }

        f.close();
    }

    double honorsMod(double gpa, char prop){
        if (prop == 'Y' && gpa >= 2.25)
            return gpa + .5;
        return gpa;
    }
    double plusminusMod(double gpa, char prop){
        if (prop == '+')
            return gpa + .25;
        else if (prop == '-')
            return gpa - .25;
        return gpa;
    }

    public static void main(String[] args) throws FileNotFoundException{
        new Richa().run();
    }
}
