import java.util.*;
import java.io.*;

public class postfix{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("postfix".toLowerCase()+".dat"));
        while(f.hasNext()){
            Stack<Integer> nums = new Stack<>();
            Stack<String> ops = new Stack<>();
            String[] ln = f.nextLine().split(" ");
            for(String s : ln){
                if(s.matches("\\d+")){
                    nums.push(Integer.parseInt(s));
                }
                else{
                    ops.push(s);
                }
                if(nums.size()>=2 && !ops.isEmpty()){
                    int num2 = nums.pop();
                    int num1 = nums.pop();
                    String op = ops.pop();
                    switch (op) {
                        case "+" -> nums.push(num1 + num2);
                        case "-" -> nums.push(num1 - num2);
                        case "*" -> nums.push(num1 * num2);
                        case "/" -> nums.push(num1 / num2);
                    }
                }
            }
            System.out.println(nums.pop());
        }

        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new postfix().run();
    }
}
