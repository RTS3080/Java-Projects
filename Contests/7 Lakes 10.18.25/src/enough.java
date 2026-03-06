import java.util.*;
import java.io.*;

public class enough{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        long a = f.nextLong();
        long b = f.nextLong();
        if(a>=b){
            System.out.println("WE HAVE ENOUGH SIR!");
        }
        else{
            System.out.println("WE NEED "+(b-a)+" MORE OPERATIVES SIR!");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new enough().run();
    }
}
