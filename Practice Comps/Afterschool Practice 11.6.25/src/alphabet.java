import java.util.*;
import java.io.*;
import java.awt.*;

public class alphabet{
    public int getNum(char ch) {
        if (ch <= 'M') {
            return ch - 'A' + 1;
        } return -('Z' - ch) - 1;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("alphabet".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String str = f.next().trim();
            Stack<Integer> stack = new Stack<>();
            for (char ch : str.toCharArray()) {
                if (!stack.isEmpty() && stack.peek().equals(-getNum(ch))) {
                    stack.pop();
                } else stack.push(getNum(ch));
            }

            System.out.println(stack.isEmpty() ? "YES" : "NO");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new alphabet().run();
    }
}
