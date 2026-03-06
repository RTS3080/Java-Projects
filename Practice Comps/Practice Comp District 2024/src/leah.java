import java.util.*;
import java.io.*;

public class leah{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("leah".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while(cases-- > 0){
            int w = f.nextInt();
            ArrayList<Integer> result = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            for (int i = 0; i <= w; i++){
                int origin = (int) Math.pow(2, i-1);
                if (i == 0) origin = 0;
                while(!stack.isEmpty()){
                    int use = stack.pop();
                    result.add(origin+use);
                }
                for (int each:result){
                    stack.push(each);
                }
            }
            for (int each:result){
                System.out.print(each+" ");
            }
            System.out.println();
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new leah().run();
    }
}
