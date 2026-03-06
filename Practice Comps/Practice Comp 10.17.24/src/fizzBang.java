import java.util.*;
import java.io.*;

public class fizzBang{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("fizz".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        for(int abcd = 1;abcd<=times;abcd++){
            long start = f.nextLong();
            long end = f.nextLong();
            System.out.println("Data Set "+abcd);
            for(long i = start;i<=end;i++){
                if(i%3==0 && i%5==0){
                    System.out.println("FizzBang");
                }
                else if(i%5==0){
                    System.out.println("Bang");
                }
                else if(i%3==0){
                    System.out.println("Fizz");
                }
                else{
                    System.out.println(i);
                }
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new fizzBang().run();
    }
}
