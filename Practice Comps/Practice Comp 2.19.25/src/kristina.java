import java.util.*;
import java.io.*;

public class kristina{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("kristina".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String order = f.next();
            String[] operation = f.nextLine().substring(1).split(" ");

            if(order.equals("PRE")){
                String[] temp = new String[operation.length];
                for (int i = 0; i < operation.length; i++) {
                    temp[i] = operation[operation.length-i-1];
                }
                operation = temp;
            }

            Stack<Integer> ints = new Stack<>();
            Stack<String> ops = new Stack<>();
            String s = "";
            for(String str : operation){
                s+=str+' ';
            }
//            System.out.println(s);
            Scanner p = new Scanner(s);
            while(p.hasNext() || !ops.empty()){
                if(!ops.empty() && ints.size()>=2) {
                    int first = ints.pop();
                    int second = ints.pop();

                    String op = ops.pop();
//                    System.out.println(first+" "+op+" "+second);
                    if (order.equals("PRE")) {
                        int temp = first;
                        first = second;
                        second = temp;
                    }
                    int add = 0;
                    switch (op) {
                        case "+" -> add = first + second;
                        case "-" -> add = second - first;
                        case "*" -> add = first * second;
                        case "/" -> add = second / first;
                        case "^" -> add =(int)Math.pow(second,first);
                    }
                    ints.push(add);
                }
                else {
                    String str = p.next();
                    if (str.matches(".*\\d.*"))
                        ints.push(Integer.parseInt(str));
                    else {
                        ops.push(str);
                    }
                }
            }
            System.out.println(ints.pop());


        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new kristina().run();
    }
}
