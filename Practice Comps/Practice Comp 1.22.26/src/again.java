import java.util.*;
import java.io.*;
import java.awt.*;

public class again{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("again".toLowerCase()+".dat"));

        int cases = f.nextInt();
        f.nextLine();

        loop:
        while (cases-- > 0){
            String[] line = f.nextLine().trim().split("\\s+");
            dividedByZero = false;

            operators = new Stack<>();
            operands = new Stack<>();

            for (String each:line){
                while (shouldCalculate(each)) calculate();
                switch(each){
                    case "/":
                    case "+":
                    case "*":
                    case "-":
                        operators.push(each);
                        break;

                    default:
                        operands.push(Integer.parseInt(each));
                        break;
                }

                if (dividedByZero){
                    System.out.println("Division by 0");
                    continue loop;
                }
            }

            while (!operators.isEmpty()){
                calculate();
                if (dividedByZero){
                    System.out.println("Division by 0");
                    continue loop;
                }
            }

            System.out.println(operands.pop());
        }

        f.close();
    }

    Stack<String> operators;
    Stack<Integer> operands;

    boolean dividedByZero;

    public boolean shouldCalculate(String check){
        if (operators.empty() || operands.size() < 2) return false;
        String onTop = operators.peek();

        boolean shouldCalculate = false;

        if ("*/".contains(check)){
            if ("*/".contains(onTop)){
                shouldCalculate = true;
            }
        }

        if ("+-".contains(check)) shouldCalculate = true;

        return shouldCalculate;
    }

    public void calculate(){
        int two = operands.pop();
        int one = operands.pop();

        String op = operators.pop();
        switch (op){
            case "+":
                operands.push(one + two);
                break;
            case "-":
                operands.push(one - two);
                break;
            case "*":
                operands.push(one * two);
                break;
            case "/":
                if (two == 0) {
                    dividedByZero = true;
                    break;
                }
                operands.push(one / two);
                break;
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new again().run();
    }
}
