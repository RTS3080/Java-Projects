import java.util.*;
import java.io.*;

public class dice{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dice".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            HashMap<Integer, String> dice = new HashMap<>();
            dice.put(1,"-------\n" +
                    "|     |\n" +
                    "|  o  |\n" +
                    "|     |\n" +
                    "-------");
            dice.put(2, "-------\n" +
                    "| o   |\n" +
                    "|     |\n" +
                    "|   o |\n" +
                    "-------");
            dice.put(3, "-------\n" +
                    "| o   |\n" +
                    "|  o  |\n" +
                    "|   o |\n" +
                    "-------");
            dice.put(4, "-------\n" +
                    "| o o |\n" +
                    "|     |\n" +
                    "| o o |\n" +
                    "-------");
            dice.put(5, "-------\n" +
                    "| o o |\n" +
                    "|  o  |\n" +
                    "| o o |\n" +
                    "-------");
            dice.put(6, "-------\n" +
                    "| o o |\n" +
                    "| o o |\n" +
                    "| o o |\n" +
                    "-------");
            System.out.println(dice.get(f.nextInt()));
            System.out.println();
        }
        f.close();
    }
/*
      -------
      | o   |
      |  o  |
      |   o |
      -------
-------
| o o |
|  o  |
| o o |
-------   -------   -------   -------   -------   -------

-------
| o o |
| o o |
| o o |
-------

 */


    public static void main(String[] args) throws FileNotFoundException{
        new dice().run();
    }
}
