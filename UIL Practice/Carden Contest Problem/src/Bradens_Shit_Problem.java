import java.util.*;
import java.io.*;
import java.math.*;

public class Bradens_Shit_Problem{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("wtf".toLowerCase()+".dat"));
        while(f.hasNext()){
            String a = f.next().trim();
            BigInteger num;
            if(!a.contains("^")){
                num = new BigInteger(a);
            }
            else{
                String[] ln = a.split("\\^");
                num = new BigInteger(ln[0]);
                num = num.pow(Integer.parseInt(ln[1]));
            }
            Queue<BigInteger> last3 = new LinkedList<>();
            last3.add(num);
            last3.add(num);
            last3.add(num);
            while(num.compareTo(new BigInteger("1"))>0){

                if(num.mod(BigInteger.TWO).equals(BigInteger.ZERO)){
                    num = num.divide(BigInteger.TWO);
                }
                else{
                    num = num.multiply(new BigInteger("3"));
                    num = num.add(BigInteger.ONE);
                }
                last3.poll();
                last3.add(num);
            }
            System.out.println(last3.poll()+" "+last3.poll()+" "+last3.poll());
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new Bradens_Shit_Problem().run();
    }
}
