import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Kristina{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Kristina".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            String type = f.next();

            String[] tokens = f.nextLine().trim().split(" +");
            Stack<Integer> stack = new Stack<>();

            if (type.equals("PRE")) {
                for (int i = tokens.length - 1; i >= 0; i--) {
                    stack.push(switch (tokens[i]) {
                        case "*" -> stack.pop() * stack.pop();
                        case "/" -> stack.pop() / stack.pop();
                        case "+" -> stack.pop() + stack.pop();
                        case "-" -> stack.pop() - stack.pop();
                        case "^" -> (int) Math.pow(stack.pop(), stack.pop());
                        default -> Integer.parseInt(tokens[i]);
                    });
                }
            } else {
                for (int i = 0; i < tokens.length; i++) {
                    stack.push(switch (tokens[i]) {
                        case "*" -> stack.pop() * stack.pop();
                        case "/" -> {
                            int a = stack.pop();
                            int b = stack.pop();
                            yield b / a;
                        }
                        case "+" -> stack.pop() + stack.pop();
                        case "-" -> {
                            int a = stack.pop();
                            int b = stack.pop();
                            yield b - a;
                        }
                        case "^" -> {
                            int a = stack.pop();
                            int b = stack.pop();
                            yield (int) Math.pow(b, a);
                        }
                        default -> Integer.parseInt(tokens[i]);
                    });
                }
            }

            System.out.println(stack.pop());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Kristina().run();
    }
}
