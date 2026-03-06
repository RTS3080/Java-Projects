import java.util.*;
import java.io.*;
import java.awt.*;

public class miguel{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("miguel".toLowerCase()+".dat"));

        int cases = f.nextInt();
        f.nextLine();

        while (cases-- > 0){
            String line = f.nextLine();
            PriorityQueue<Character> pq = new PriorityQueue<>();
            for (char c : line.toCharArray()){
                if (Character.isAlphabetic(c)){
                    pq.add(Character.toLowerCase(c));
                }
            }

            String result = "";
            for (char each:line.toCharArray()){
                if (Character.isAlphabetic(each)){
                    char use = pq.poll();
                    if (Character.isUpperCase(each)){
                        result += ""+Character.toUpperCase(use);
                    }
                    else{
                        result += ""+use;
                    }
                }
                else{
                    result += ""+each;
                }
            }

            System.out.println(result);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new miguel().run();
    }
}
