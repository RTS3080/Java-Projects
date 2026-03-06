import java.util.*;
import java.io.*;
import java.awt.*;

public class ishita{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ishita".toLowerCase()+".dat"));
        int cases = f.nextInt();
        f.nextLine();

        while (cases-- > 0) {
            String line = f.nextLine();
            Stack<Character> parenthesis = new Stack<>();
            int splits = 0;

            for (char each:line.toCharArray()){
                if (each == '('){
                    parenthesis.push(each);
                }
                else{
                    if (parenthesis.isEmpty()){
                        splits = 0;
                        break;
                    }
                    parenthesis.pop();
                }

                if (parenthesis.isEmpty()) splits++;
            }

            if (!parenthesis.isEmpty()){
                splits = 0;
            }

            if (splits > 0){
                splits--;
            }

            System.out.println(splits == 0 ? 0 : (1 << splits) - 1);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ishita().run();
    }
}
