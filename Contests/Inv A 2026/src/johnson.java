import java.util.*;
import java.io.*;
import java.awt.*;

public class johnson{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("johnson".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        HashMap<Character, Character> openingRegistry = new HashMap<>();
        openingRegistry.put(')', '(');
        openingRegistry.put(']', '[');
        openingRegistry.put('}', '{');
        while(times-->0){
            char[] ln = f.nextLine().trim().replaceAll("[^\\[{()}\\]]", "").toCharArray();
            Stack<Character> opening = new Stack<>();
            boolean good = true;
            for (int i = 0; i < ln.length; i++) {
                char c = ln[i];
//                System.out.println(c);
                if((c+"").matches("[\\[({]")){
                    opening.push(c);
                }
                else{
                    if(opening.isEmpty()){
                        good = false;
                        break;
                    }
                    char match = openingRegistry.get(c);

                    if(match != opening.pop()){
                        good = false;
                        break;
                    }
                }
            }
            good &= opening.isEmpty();
            if(good){
                System.out.println("Johnson and Johnson");
            }
            else{
                System.out.println("Invalid Johnsons");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new johnson().run();
    }
}
