import java.util.*;
import java.io.*;

public class balanced{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
//        Scanner f = new Scanner(new File("balanced".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double a = f.nextDouble();
            double b = f.nextDouble();
            double avg = (a+b)/2;
            if(avg <250){
                System.out.println("Weak");
            }
            else if(avg <=750){
                System.out.println("Balanced");
            }
            else{
                System.out.println("Overpowered");
            }

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new balanced().run();
    }
}
