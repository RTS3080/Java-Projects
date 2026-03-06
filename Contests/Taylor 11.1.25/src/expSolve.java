import java.util.*;
import java.io.*;

public class expSolve{

    Stack<String> operators;
    Stack<Integer> operands;

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("expSolve".toLowerCase()+".in"));

        int cases = f.nextInt();
        f.nextLine();
        while (cases-- > 0){
            String[] test = f.nextLine().split("(?=[-*/+()])|(?<=[-*/+()])");

            operators = new Stack<>();
            operands = new Stack<>();

            for (String check :test){
                //If it is an operation, not ()
                if ("+-/*".contains(check)){
                    if (!operators.empty()){
                        String onStack = operators.peek();

                        //While the operator we are performing has
                        //a lower precedence than the one on the stack
                        while ("+-".contains(check) && "*/".contains(onStack)) {
                            solve();

                            //If there is no more operators, then kill yourself
                            if (operators.empty()) break;

                            onStack = operators.peek();
                        }
                    }
                    operators.push(check);
                }

                //If the operators are ()
                else if ("()".contains(check)){
                    if (check.equals("(")) operators.push(check);
                    else {
                        //If it's a closing parenthesis, evaluate
                        //until the opening parenthesis is seen again
                        while (!operators.peek().equals("(")) {
                            solve();
                        }

                        //Make sure to get rid of that starting parenthesis
                        operators.pop();
                    }
                }

                //When it gets here, it is guaranteed to be a number, an operand
                else{
                    operands.push(Integer.parseInt(check));
                }
            }

            while (!operators.empty()){
                solve();
            }

            System.out.println(operands.pop());

        }

        f.close();
    }

    public void solve(){
        String operation = operators.pop();
        int operand1 = operands.pop();
        int operand2 = operands.pop();

        switch (operation){
            case "+":
                operands.push(operand2 + operand1);
                break;
            case "-":
                operands.push(operand2 - operand1);
                break;
            case "*":
                operands.push(operand2 * operand1);
                break;
            case "/":
                operands.push(operand2 / operand1);
                break;
        }

    }



    public static void main(String[] args) throws FileNotFoundException{
        new expSolve().run();
    }
}
