import java.util.*;
import java.io.*;

public class louis{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("louis".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            double a = f.nextDouble();
            double b = f.nextDouble();
            double c = f.nextDouble();

            double disc = Math.pow(b,2) -4*a*c;
            double m = -b/(a*2);
            double y = a*(Math.pow(m,2))+b*m+c;
            double x1 = (-b+Math.sqrt(disc))/(2*a);
            double x2 = (-b-Math.sqrt(disc))/(2*a);
            if(a==0){
                System.out.println("Function is not quadratic");
            }
            else{
                System.out.print("Function has ");
                if(disc==0){
                    System.out.printf("1 root at %.3f with ",x1);
                }
                else{
                    if(disc>0) System.out.printf("2 roots at %.3f and %.3f with ", Math.min(x1,x2),Math.max(x1,x2));
                    else System.out.print("no roots with ");
                }
                if(a>0) System.out.print("min of " );
                else System.out.print("max of ");
                System.out.printf("%.3f at %.3f\n",y,m);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new louis().run();
    }
}
