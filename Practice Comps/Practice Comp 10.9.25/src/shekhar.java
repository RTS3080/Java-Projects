import java.util.*;
import java.io.*;
import java.awt.*;

public class shekhar{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("shekhar".toLowerCase()+".dat"));

        int cases = f.nextInt();
        f.nextLine();

        String start = "({[";
        String end = ")}]";

        while (cases-- > 0){
            String line = f.nextLine();

            Stack<Character> stack = new Stack<>();

            boolean valid = true;

            for (char each: line.toCharArray()){
                if (start.contains(""+each)){
                    stack.push(each);
                }
                if (end.contains(""+each)){
                    char check = stack.isEmpty() ? '?' : stack.pop();

                    int endInd = end.indexOf(each);
                    int startInd = start.indexOf(check);

                    if (endInd != startInd){
                        valid = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()){
                valid = false;
            }

            System.out.println(line+" is nested "+ (valid ? "correctly" : "incorrectly"));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new shekhar().run();
    }
}
