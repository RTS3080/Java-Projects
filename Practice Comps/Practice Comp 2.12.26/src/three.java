import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class three{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("three".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        HashMap<String, Integer> notes = new HashMap<>();
        notes.put("A", 1);
        notes.put("A#", 2);
        notes.put("Bb", 2);
        notes.put("B", 3);
        notes.put("Cb", 3);
        notes.put("C", 4);
        notes.put("B#", 4);
        notes.put("C#", 5);
        notes.put("Db", 5);
        notes.put("D", 6);
        notes.put("D#", 7);
        notes.put("Eb", 7);
        notes.put("E", 8);
        notes.put("Fb", 8);
        notes.put("F", 9);
        notes.put("E#", 9);
        notes.put("F#", 10);
        notes.put("Gb", 10);
        notes.put("G", 11);
        notes.put("G#", 12);
        notes.put("Ab", 12);

        while(times-->0){
            int a = notes.get(f.next());
            int b = notes.get(f.next());
            int c = notes.get(f.next());

            int ab = Math.abs(a - b);
            int bc = Math.abs(b - c);
            int ac = Math.abs(a - c);


            if ((3 <= ab && ab <= 9 && ab != 6 || ab == 0) && (3 <= bc && bc <= 9 && bc != 6 || bc == 0) && (3 <= ac && ac <= 9 && ac != 6 || ac == 0)) {
                System.out.println("Great!");
            } else {
                System.out.println("AHHHHHHH");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new three().run();
    }
}
